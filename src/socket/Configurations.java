package socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Configurations {


    public static ServerSocket openSocket() throws IOException {
        try {
            // Create a new server socket on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");
            return serverSocket;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
