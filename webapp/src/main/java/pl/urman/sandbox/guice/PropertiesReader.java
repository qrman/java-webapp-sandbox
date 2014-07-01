package pl.urman.sandbox.guice;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static Properties read() {
        try (InputStream is = PropertiesReader.class.getResourceAsStream("dev.properties")) {
            Properties p = new Properties();
            p.load(is);
            return p;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
