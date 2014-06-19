package pl.urman.sandbox.ex;

import com.google.inject.AbstractModule;

/**
 *
 * @author Krzysztof Urman <krzysztof.urman at espeo.pl>
 */
public class ExceptionMapperModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserNotInRoleExceptionMapper.class);
    }
}
