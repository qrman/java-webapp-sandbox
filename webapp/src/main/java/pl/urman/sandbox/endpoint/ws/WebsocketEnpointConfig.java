package pl.urman.sandbox.endpoint.ws;

import javax.websocket.server.ServerEndpointConfig;

import pl.urman.sandbox.guice.MyServletContextListener;

import com.google.inject.Injector;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class WebsocketEnpointConfig extends ServerEndpointConfig.Configurator {

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        T instance = super.getEndpointInstance(endpointClass);
        Injector injector = MyServletContextListener.injector;
        injector.injectMembers(instance);
        return instance;
    }
}
