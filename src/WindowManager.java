import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static java.awt.Frame.NORMAL;

public class WindowManager {
    static MainWindow mainWindow;
    static CodeWindow codeWindow;
    static boolean mainWindow_isconnected;
    static String connectedDeviceid;
    static String connectedDeviceip;

    //mainwindow
    public static void MakeMainWindow() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.bt_changedevicename.addActionListener(e -> {
            if (mainWindow_isconnected) {
                MakeChangeNameWindow(DeviceManager.getDeviceName(connectedDeviceid), connectedDeviceid);
            }
        });
        mainWindow.bt_changedir.addActionListener(e -> MakeChangeDirWindow(ConfigurationUtils.getcfg("downloadDIR")));
        TrayIcon trayIcon = new TrayIcon((new ImageIcon(Objects.requireNonNull(WindowManager.class.getResource("/drawable/logo.png"))).getImage()));
        SystemTray systemTray = SystemTray.getSystemTray();
        trayIcon.setImageAutoSize(true);
        mainWindow.addWindowListener(new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                try {
                    systemTray.add(trayIcon);
                } catch (AWTException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                mainWindow.setVisible(false);
            }
        });
        mainWindow.button1.addActionListener(e -> System.exit(0));
        trayIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clt = e.getClickCount();
                if (clt == 1) {
                    mainWindow.setExtendedState(NORMAL);
                }
                systemTray.remove(trayIcon);
                mainWindow.setVisible(true);
            }
        });
        mainWindow.bt_sendfile.addActionListener(e -> {
            FileSystemView fsv = FileSystemView.getFileSystemView();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
            fileChooser.setDialogTitle("请选择要上传的文件...");
            fileChooser.setApproveButtonText("确定");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (JFileChooser.APPROVE_OPTION == result) {
                String filepath = fileChooser.getSelectedFile().getPath();
                startSendFileServer(filepath);
            }
        });
        mainWindow.bt_sendfile.setTransferHandler(new TransferHandler() {
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    Object o = t.getTransferData(DataFlavor.javaFileListFlavor);

                    String filepath = o.toString();
                    if (filepath.startsWith("[")) {
                        filepath = filepath.substring(1);
                    }
                    if (filepath.endsWith("]")) {
                        filepath = filepath.substring(0, filepath.length() - 1);
                    }
                    startSendFileServer(filepath);
                    return true;
                } catch (Exception e) {

                }
                return false;
            }

            @Override
            public boolean canImport(JComponent comp, DataFlavor[] flavors) {
                for (DataFlavor flavor : flavors) {
                    if (DataFlavor.javaFileListFlavor.equals(flavor)) {
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public static void startSendFileServer(String filepath) {
        File f = new File(filepath);
        ServerManager.ch.sendcmd("pcsendfile<port>" + 37700 + "</port>" + "<filename>" + f.getName() + "</filename>");
        new sendFileServer(37700, filepath).start();
    }

    public static void addCommandLine(String s) {
        mainWindow.ta_commandline.append(s + "\n");

    }

    public static void setMainWindow_isconnected(boolean c, String devicename, String deviceid) {
        mainWindow_isconnected = c;
        connectedDeviceid = deviceid;
        mainWindow.tv_WaittingConnect.setText("设备连接成功 - " + DeviceManager.getDeviceName(deviceid));
    }
    public static void setMainWindow_isconnected(String deviceid) {
        mainWindow_isconnected = true;
        connectedDeviceid = deviceid;
        mainWindow.tv_WaittingConnect.setText("设备连接成功 - " + DeviceManager.getDeviceName(deviceid));
    }

    public static void setMainWindowQRcode(String file) {
        mainWindow.QRcodePic.setIcon(new ImageIcon(file));
    }

    //codewindow
    public static void MakeCodeWindow(String code) {
        codeWindow = new CodeWindow(mainWindow);
        codeWindow.label2.setText(code);
        codeWindow.setVisible(true);
        codeWindow.okButton.addActionListener(e -> codeWindow.dispose());
    }

    //changenamewindow
    public static void MakeChangeNameWindow(String lastname, String deviceid) {
        changenameWindow changenameWindow = new changenameWindow(mainWindow);
        changenameWindow.textField1.setText(lastname);
        changenameWindow.setVisible(true);
        changenameWindow.okButton.addActionListener(e -> {
            DeviceManager.changeDeviceName(deviceid, changenameWindow.textField1.getText());
            changenameWindow.dispose();
        });
        changenameWindow.cancelButton.addActionListener(e -> changenameWindow.dispose());
    }

    //changedirwindow
    public static void MakeChangeDirWindow(String lastdir) {
        changedirWindow changedirWindow = new changedirWindow(mainWindow);
        changedirWindow.textField1.setText(lastdir);
        changedirWindow.setVisible(true);
        changedirWindow.okButton.addActionListener(e -> {
            ConfigurationUtils.setcfg("downloadDIR", changedirWindow.textField1.getText());
            changedirWindow.dispose();
        });
        changedirWindow.cancelButton.addActionListener(e -> changedirWindow.dispose());
    }
}
