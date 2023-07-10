import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer extends Thread {
    public ServerSocket server;
    public Socket socket;
    public int port;
    public String dir;

    public FileServer(int port, String dir) {
        this.port = port;
        this.dir = dir;
    }

    private String getFileName(String fn) {
        String[] files = fn.split("/");
        return files[files.length - 1];
    }

    public void run() {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                InputStream in = socket.getInputStream();
                bis = new BufferedInputStream(in);
                int length = bis.read();
                byte[] b = new byte[length];
                bis.read(b);
                String fileName = this.getFileName(new String(b));
                File f = new File(dir + "/" + fileName);
                if (!f.getParentFile().exists()) {
                    f.getParentFile().mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(f);
                bos = new BufferedOutputStream(fos);
                int data = 0;
                while ((data = bis.read()) != -1) {
                    bos.write(data);
                }
                WindowManager.addCommandLine("接收文件" + fileName);
                WindowManager.addCommandLine("已保存到:" + f.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}