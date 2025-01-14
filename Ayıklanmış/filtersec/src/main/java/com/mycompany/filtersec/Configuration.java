package com.mycompany.filtersec;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateful;

@DataSourceDefinition(
        name = "java:global/JsfCrudDemoDataSource2",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:mem:jsfcruddemo;DB_CLOSE_DELAY=-1",
        minPoolSize = 1,
        initialPoolSize = 1,
        user = "sa",
        password = ""
)
@Stateful
public class Configuration {
}
