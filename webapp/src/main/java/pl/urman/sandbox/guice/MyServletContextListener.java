package pl.urman.sandbox.guice;

import com.google.inject.Injector;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class MyServletContextListener extends GuiceResteasyBootstrapServletContextListener{

    public static Injector injector;

    @Override
    protected void withInjector(Injector injector) {
        this.injector = injector;
        super.withInjector(injector);
    }


}
