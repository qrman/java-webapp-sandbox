package pl.urman.sandbox.guice;

import pl.urman.sandbox.db.guice.DbModule;

import com.google.inject.servlet.ServletModule;

import pl.urman.sandbox.ApiUriBuilder;
import pl.urman.sandbox.endpoint.ApiEntranceEndpoint;
import pl.urman.sandbox.endpoint.UserEndpoint;

public class WebAppModule extends ServletModule {

    @Override
    protected void configureServlets() {
        install(new DbModule());
        bind(UserEndpoint.class);
        bind(ApiEntranceEndpoint.class);
        bind(ApiUriBuilder.class);
    }
}
