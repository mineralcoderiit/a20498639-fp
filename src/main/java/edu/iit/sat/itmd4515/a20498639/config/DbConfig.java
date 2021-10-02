package edu.iit.sat.itmd4515.a20498639.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@DataSourceDefinition(
        name = "jdbc:mysql://localhost:3306/test",
        className = "com.mysql.jdbc.Driver",
        serverName = "localhost",
        portNumber = 3306,
        databaseName = "sakila",
        user = "itmd4515",
        password = "itmd4515",
        properties = {
                "useSSL=false"
        }
)
public class DbConfig {
}
