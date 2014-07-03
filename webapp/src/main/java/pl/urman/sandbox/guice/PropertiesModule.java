package pl.urman.sandbox.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import pl.urman.sandbox.db.guice.Environmet;

class PropertiesModule extends AbstractModule {

    private final Environmet env;

    PropertiesModule(Environmet env) {
        this.env = env;
    }

    PropertiesModule() {
        this.env = Environmet.DEV;
    }

    @Override
    protected void configure() {
        Names.bindProperties(binder(), PropertiesReader.read(env));
    }

}
