package pl.urman;

import com.google.inject.servlet.ServletModule;
import pl.urman.endpoint.ApiEntranceEndpoint;
import pl.urman.endpoint.UserEndpoint;

public class WebAppModule extends ServletModule {

    @Override
    protected void configureServlets() {
        bind(UserEndpoint.class);
        bind(ApiEntranceEndpoint.class);
        bind(ApiUriBuilder.class);
    }
}
