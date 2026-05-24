package task03;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    final static String SERVER_IP = "localhost";
    final static int SERVER_PORT = 1234;

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read server message
            System.out.println(dis.readUTF());

            String name = scanner.nextLine();

            dos.writeUTF(name);

            // Thread for receiving messages
            Thread receiveThread = new Thread(() -> {

                while (true) {

                    try {
                        String msg = dis.readUTF();
                        System.out.println(msg);

                    } catch (IOException e) {
                        break;
                    }
                }
            });

            receiveThread.start();

            // Sending messages
            while (true) {

                String msg = scanner.nextLine();

                dos.writeUTF(msg);

                if (msg.equalsIgnoreCase("exit")) {
                    socket.close();
                    // continue;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
