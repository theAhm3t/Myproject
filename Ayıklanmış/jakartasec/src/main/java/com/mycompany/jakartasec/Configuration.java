package com.mycompany.jakartasec;

import com.mycompany.jakartasec.dao.UserCredentialsDao;
import com.mycompany.jakartasec.model.UserCredentials;
import com.mycompany.jakartasec.model.UserGroup;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.HashMap;
import java.util.Map;

@DataSourceDefinition(
        name = "java:global/JsfCrudDemoDataSource",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:mem:jsfcruddemo;DB_CLOSE_DELAY=-1",
        minPoolSize = 1,
        initialPoolSize = 1,
        user = "sa",
        password = ""
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:global/JsfCrudDemoDataSource",
        callerQuery = "SELECT password FROM \"USERCREDENTIALS\" WHERE username = ?",
        groupsQuery = "SELECT ug.groupname FROM \"USERCREDENTIALS\" u JOIN USERGROUP ug ON u.id=ug.usercredentials_id WHERE u.username = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        hashAlgorithmParameters = {
                "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
                "Pbkdf2PasswordHash.Iterations=3072",
                "Pbkdf2PasswordHash.SaltSizeBytes=64",
        }
)
@Singleton
@Startup
public class Configuration {
    @Inject
    private Pbkdf2PasswordHash pbkdf;

    @EJB
    private UserCredentialsDao userCredentialsDao;

    @PostConstruct
    private void init() {
        Map<String,String> map = new HashMap<>();
        map.put("Pbkdf2PasswordHash.Algorithm","PBKDF2WithHmacSHA512");
        map.put("Pbkdf2PasswordHash.Iterations","3072");
        map.put("Pbkdf2PasswordHash.SaltSizeBytes","64");
        pbkdf.initialize(map);

        initDatabase();
    }

    private void initDatabase() {
        UserCredentials u = new UserCredentials();
        u.setUsername("test");
        u.setPassword(pbkdf.generate("test".toCharArray()));
        UserGroup ug =  new UserGroup();
        ug.setGroupname("ROLE_USER");
        u.add(ug);
        userCredentialsDao.save(u);
    }
}
