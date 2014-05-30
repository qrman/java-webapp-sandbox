package pl.urman.sandbox;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import com.google.inject.Provider;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class WSUriBuilder {

    @Inject
    private Provider<HttpServletRequest> requestProvider;

    @Inject
    @Named("wsPath")
    private String wsPath;

    public UriBuilder get() {
        String host = requestProvider.get().getHeader("host");
        return UriBuilder.fromUri("ws://" + host).path(wsPath);
    }

}
