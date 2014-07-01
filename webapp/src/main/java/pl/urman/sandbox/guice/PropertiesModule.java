package pl.urman.sandbox.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import pl.urman.sandbox.db.guice.DbMode;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
class PropertiesModule extends AbstractModule {

    private final DbMode DbMode;

    PropertiesModule(DbMode dbMode) {
        this.DbMode = dbMode;
    }

    @Override
    protected void configure() {
        Names.bindProperties(binder(), PropertiesReader.read());
    }

}
