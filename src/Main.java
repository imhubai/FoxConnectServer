public class Main {
    public static void main(String[] args) {
        WindowManager.MakeMainWindow();
        ConfigurationUtils.init();
        DeviceManager.readList();
        QRcodeManager.makeQRcode();
        ServerManager.startserver(Integer.parseInt(ConfigurationUtils.getcfg("port")));
        //ClipboardManager.makeClipboardHandler();
    }
}
