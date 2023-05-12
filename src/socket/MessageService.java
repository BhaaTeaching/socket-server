package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MessageService {

    public static void sendMessage(Socket clientSocket, String message) throws IOException {
        // Send a response back to the client
        OutputStream outputStream = clientSocket.getOutputStream();
        String response = "Hello, " + message;
        outputStream.write(response.getBytes());
    }

    public static String receiveMessage(Socket clientSocket) throws IOException {
        // Wait for a client connection
        System.out.println("Client connected: " + clientSocket.getInetAddress());

        // Do something with the client socket here...
        // Get the input stream of the client socket
        InputStream inputStream = clientSocket.getInputStream();
        // Receive a message from the client
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String message = new String(buffer, 0, bytesRead);
        if (message.contains("close")) {
            clientSocket.close(); // Close the client socket when done
            return message;
        }
        System.out.println("Client message: " + message);
        return message;
    }
}
