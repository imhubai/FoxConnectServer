import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerManager {
    static boolean isconnected = false;
    static ServerSocket serverSocket;
    static ClientHandler ch;

    public static void startserver(int port) {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                isconnected = true;
                ch = new ClientHandler(clientSocket);
                ch.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isIsconnected() {
        return isconnected;
    }

    public static void stop() {
        try {
            serverSocket.close();
            ClientHandler.interrupted();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
