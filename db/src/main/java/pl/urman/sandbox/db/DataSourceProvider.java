package pl.urman.sandbox.db;

import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceProvider implements Provider<DataSource> {

    @Inject
    private Properties props;

    @Override
    public DataSource get() {
        HikariConfig config = new HikariConfig(props);
        return new HikariDataSource(config);
    }
}
