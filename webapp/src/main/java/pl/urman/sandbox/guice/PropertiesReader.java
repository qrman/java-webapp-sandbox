package pl.urman.sandbox.guice;

import java.io.InputStream;
import java.util.Properties;
import pl.urman.sandbox.db.guice.Environmet;

public class PropertiesReader {

    public static Properties read(Environmet env) {
        String propertiesFileName = env.getEnv() + ".properties";
        try (InputStream is = PropertiesReader.class.getResourceAsStream(propertiesFileName)) {
            Properties p = new Properties();
            p.load(is);
            return p;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
