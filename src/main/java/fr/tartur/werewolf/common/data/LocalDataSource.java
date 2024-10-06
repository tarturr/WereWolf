package fr.tartur.werewolf.common.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class LocalDataSource {

    private final HikariDataSource source;

    public LocalDataSource(String filePath) {
        final HikariConfig conf = new HikariConfig();
        conf.setJdbcUrl("jdbc:sqlite:" + filePath);

        this.source = new HikariDataSource(conf);
    }

    public Connection getConnection() {
        try {
            return this.source.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Could not get the connection to the local database: " + e);
        }
    }

}
