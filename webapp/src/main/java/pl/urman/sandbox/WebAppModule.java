package pl.urman.sandbox;

import com.google.inject.servlet.ServletModule;

import pl.urman.sandbox.endpoint.ApiEntranceEndpoint;
import pl.urman.sandbox.endpoint.UserEndpoint;

public class WebAppModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(UserEndpoint.class);
        bind(ApiEntranceEndpoint.class);
        bind(ApiUriBuilder.class);
    }
}
