package pl.urman.sandbox;

import com.google.inject.Provider;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

public class ApiUriBuilder {

    @Inject
    private Provider<HttpServletRequest> requestProvider;

    @Inject
    @Named("apiPath")
    private String apiPath;


    public UriBuilder get() {
        String host = requestProvider.get().getHeader("host");
        return UriBuilder.fromUri("http://" + host).path(apiPath);
    }

}
