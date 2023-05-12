import socket.Configurations;
import socket.MessageService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = Configurations.openSocket();
        Socket clientSocket = serverSocket.accept();
        while (!clientSocket.isClosed()) {
            try {
                String receiveMessage = MessageService.receiveMessage(clientSocket);
                MessageService.sendMessage(clientSocket, receiveMessage);
            } catch (IOException ioException) {
                System.out.println("Error while getting message from client: " + ioException.getMessage());
            }
        }
    }
}