package pl.urman.sandbox;

import com.google.inject.Provider;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

public class ApiUriBuilder {

    @Inject
    private Provider<HttpServletRequest> requestProvider;


    public UriBuilder get() {
        String host = requestProvider.get().getHeader("host");
        return UriBuilder.fromUri("http://" + host).path("webapp").path("api");
    }

}
