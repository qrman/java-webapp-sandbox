package pl.urman.sandbox;

import pl.urman.sandbox.db.DbModule;

import com.google.inject.servlet.ServletModule;

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
