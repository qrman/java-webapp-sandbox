package pl.urman.sandbox.db;

import java.util.Properties;

import javax.inject.Provider;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceProvider implements Provider<DataSource> {

    public DataSource get() {
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "sandbox");
        props.setProperty("dataSource.password", "sandbox");
        props.setProperty("dataSource.databaseName", "sandbox");

        HikariConfig config = new HikariConfig(props);
        return new HikariDataSource(config);
    }
}
