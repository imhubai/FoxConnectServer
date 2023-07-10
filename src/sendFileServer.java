import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sendFileServer extends Thread{
    int port;
    Socket socket;
    ServerSocket serverSocket;
    String filePath;
    public sendFileServer(int port,String filePath) {
        this.filePath=filePath;
        this.port = port;

    }

            @Override
            public void run() {
                try {
                        serverSocket = new ServerSocket(port);
                        socket = serverSocket.accept();
                        WindowManager.addCommandLine("正在发送文件到:" + socket.getInetAddress().getHostAddress());
                    File file = new File(filePath);
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    OutputStream os = socket.getOutputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    WindowManager.addCommandLine("文件发送完成");
                    os.close();
                    bis.close();
                    fis.close();
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}
