import java.io.*;
import java.util.Objects;

public class DeviceManager {
    static String deviceslocation = "Devices/";
    static File[] devices;
    static String[] devicesID;

    public static void readList() {
        File devicesfile = new File(deviceslocation);
        if (!devicesfile.exists()) {
            devicesfile.mkdir();
        }
        devices = devicesfile.listFiles();
        int devicelength = Objects.requireNonNull(devicesfile.listFiles()).length;
        devicesID = new String[devicelength];
        for (int i = 0; i < devicelength; i++) {
            devicesID[i] = devices[i].getName();
        }
    }

    public static void addNewDevice(String deviceid) {
        File devicesfile = new File(deviceslocation + deviceid);
        try {
            devicesfile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DeviceManager.readList();
    }

    public static void changeDeviceName(String deviceid, String devicename) {
        File devicesfile = new File(deviceslocation + deviceid);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(devicesfile));
            bw.write(devicename);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDeviceName(String deviceid) {
        String devicename;
        File devicesfile = new File(deviceslocation + deviceid);
        try {
            BufferedReader br = new BufferedReader(new FileReader(devicesfile));
            devicename = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return devicename;
    }
}
