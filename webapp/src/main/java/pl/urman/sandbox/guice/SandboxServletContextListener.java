package pl.urman.sandbox.guice;

import com.google.inject.Injector;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

public class SandboxServletContextListener extends GuiceResteasyBootstrapServletContextListener {

    public static Injector injector;

    @Override
    protected void withInjector(Injector injector) {
        SandboxServletContextListener.injector = injector;
        super.withInjector(injector);
    }

}
