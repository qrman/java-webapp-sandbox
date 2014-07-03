package pl.urman.sandbox.guice;

import javax.inject.Named;

import pl.urman.sandbox.ApiUriBuilder;
import pl.urman.sandbox.auth.AuthModule;
import pl.urman.sandbox.db.guice.DbModule;
import pl.urman.sandbox.endpoint.ApiEntranceEndpoint;
import pl.urman.sandbox.endpoint.AuthEndpoint;
import pl.urman.sandbox.endpoint.UserEndpoint;
import pl.urman.sandbox.ex.ExceptionMapperModule;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

public class WebAppModule extends ServletModule {

    @Override
    protected void configureServlets() {
        install(new PropertiesModule());
        install(new DbModule());
        install(new AuthModule());
        install(new ExceptionMapperModule());
        bind(UserEndpoint.class);
        bind(AuthEndpoint.class);
        bind(ApiEntranceEndpoint.class);
        bind(ApiUriBuilder.class);
    }


    @Provides
    @Named("apiPath")
    public String getApiPath() {
        return "sandbox/api";
    }

    @Provides
    @Named("wsPath")
    public String getWSPath() {
        return "sandbox/ws";
    }
}
