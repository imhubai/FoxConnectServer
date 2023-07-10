import java.io.*;
import java.util.Properties;

public class ConfigurationUtils {
    static String cfglocation = "config.cfg";
    static File cfg;
    static Properties properties;
    static InputStream in;

    public static void init() {
        boolean first = false;
        properties = new Properties();
        cfg = new File(cfglocation);
        if (!cfg.exists()) {
            first = true;
            try {
                cfg.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            in = new FileInputStream(cfg);
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (first) {
            setcfg("downloadDIR", "D:/Download");
            setcfg("port", "37699");
        }
    }

    public static String getcfg(String key) {
        if (!properties.isEmpty()) {
            return properties.getProperty(key);
        } else {
            return "数据为空";
        }
    }

    public static void setcfg(String key, String value) {
        try {
            OutputStream outputStream = new FileOutputStream(cfg);
            properties.setProperty(key, value);
            properties.store(outputStream, "foxconnect");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
