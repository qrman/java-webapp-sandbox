package pl.urman.sandbox.db.guice;

import lombok.Getter;

public enum Environmet {

    DEV("dev"),
    TEST("test");

    Environmet(String env) {
        this.env = env;
    }

    @Getter
    private final String env;
}
