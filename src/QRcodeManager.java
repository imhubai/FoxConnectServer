import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class QRcodeManager {
    static String hostAddress;
    static String port;
    static String hostName;

    public static void makeQRcode() {
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
            port = ConfigurationUtils.getcfg("port");
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        File directory = new File("cache/");
        if (!directory.exists()) {
            directory.mkdir();
        }
        String imgMSG = "qrcode:pc<ip>" + hostAddress + "</ip><port>" + port + "</port><hostname>" + hostName + "</hostname>";
        WindowManager.addCommandLine("生成新二维码..");
        QRcode.createImage(200, 200, "png", imgMSG, directory.getPath() + "/temp.png");
        WindowManager.setMainWindowQRcode("cache/temp.png");
    }
}
