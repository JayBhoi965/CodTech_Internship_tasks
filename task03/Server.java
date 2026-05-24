package task03;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int PORT = 1234;

    // List to store all connected clients
    static Vector<ClientHandler> clientList = new Vector<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected: " + socket);

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                dos.writeUTF("Enter your name:");
                String name = dis.readUTF();

                ClientHandler client = new ClientHandler(socket, name, dis, dos);

                Thread thread = new Thread(client);

                clientList.add(client);

                thread.start();

                broadcast("🔔 " + name + " joined the chat.", client);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients
    public static void broadcast(String message, ClientHandler sender) {

        for (ClientHandler client : clientList) {

            try {
                client.dos.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}