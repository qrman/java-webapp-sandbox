package pl.urman.sandbox.db;

import java.util.Properties;

import javax.inject.Provider;

public class PropertiesProvider implements Provider<Properties> {

    @Override
    public Properties get() {
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
        props.setProperty("dataSource.user", "sandbox");
        props.setProperty("dataSource.password", "sandbox");
        props.setProperty("dataSource.databaseName", "sandbox");
        return props;
    }
}
