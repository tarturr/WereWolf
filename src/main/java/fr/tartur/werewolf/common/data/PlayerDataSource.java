package fr.tartur.werewolf.common.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class PlayerDataSource {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;

    static {
        config.setJdbcUrl("jdbc:sqlite://plugins/WereWolf/");

        dataSource = new HikariDataSource();
    }

}
