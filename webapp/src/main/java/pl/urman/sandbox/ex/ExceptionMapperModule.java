package pl.urman.sandbox.ex;

import com.google.inject.AbstractModule;

public class ExceptionMapperModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserNotInRoleExceptionMapper.class);
    }
}
