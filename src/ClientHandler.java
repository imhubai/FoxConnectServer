import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler extends Thread {
    private final Socket clientsocket;
    String code;
    String deviceid;
    String hostname;
    String devicename;
    PrintWriter out;

    public ClientHandler(Socket socket) {
        this.clientsocket = socket;
    }

    @Override
    public void run() {
        try {
            WindowManager.connectedDeviceip = clientsocket.getLocalAddress().getHostAddress();
            WindowManager.addCommandLine("已连接" + clientsocket.getLocalSocketAddress());
            BufferedReader br = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
            out = new PrintWriter(clientsocket.getOutputStream(), true);
            String input;
            while ((input = br.readLine()) != null) {
                String msg = input.substring(0, input.indexOf("<"));
                switch (msg) {
                    case "Alive" -> {
                        deviceid = input.substring(input.indexOf("<deviceid>") + 10, input.indexOf("</deviceid>"));
                        devicename = input.substring(input.indexOf("<devicename>") + 12, input.indexOf("</devicename>"));
                        boolean deviceVal = false;
                        for (String stored_id :
                                DeviceManager.devicesID) {
                            if (Objects.equals(stored_id, deviceid)) {
                                deviceVal = true;
                                break;
                            }
                        }
                        if (deviceVal) {
                            out.println("true");
                            this.devicename = devicename;
                            WindowManager.setMainWindow_isconnected(true, devicename, deviceid);
                        } else {
                            code = deviceid.substring(0, 4);
                            out.println("device is not vailed. msg:<requirecode>" + code + "</requirecode>");
                            WindowManager.MakeCodeWindow(code);
                            WindowManager.addCommandLine("是新设备哦 配对码"+code);
                        }
                    }
                    case "RequireCode" -> {
                        deviceid = input.substring(input.indexOf("<deviceid>") + 10, input.indexOf("</deviceid>"));
                        String verifycode = input.substring(input.indexOf("<verifycode>") + 12, input.indexOf("</verifycode>"));
                        if (verifycode.equals(code)) {
                            DeviceManager.addNewDevice(deviceid);
                            DeviceManager.changeDeviceName(deviceid, devicename);
                            out.println("true");
                        } else {
                            out.println("deviceid is not vailed. msg:<requirecode>" + code + "</requirecode>");
                        }
                    }
                    case "File" -> {
                        int port = Integer.parseInt(input.substring(input.indexOf("<port>") + 6, input.indexOf("</port>")));
                        new FileServer(port, ConfigurationUtils.getcfg("downloadDIR")).start();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendcmd(String s) {
        out.println(s);
    }
}