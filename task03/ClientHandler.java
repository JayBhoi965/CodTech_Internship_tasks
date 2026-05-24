package task03;
import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {

    String name;
    DataInputStream dis;
    DataOutputStream dos;
    Socket socket;
    boolean isLoggedIn;

    public ClientHandler(Socket socket, String name,
                         DataInputStream dis,
                         DataOutputStream dos) {

        this.socket = socket;
        this.name = name;
        this.dis = dis;
        this.dos = dos;
        this.isLoggedIn = true;
    }

    @Override
    public void run() {

        String received;

        while (true) {

            try {

                received = dis.readUTF();

                if (received.equalsIgnoreCase("exit")) {

                    this.isLoggedIn = false;
                    this.socket.close();

                    System.out.println(this.name + " disconnected.");

                    Server.broadcast("❌ " + name + " left the chat.", this);

                    break;
                }

                String message = this.name + ": " + received;

                System.out.println(message);

                Server.broadcast(message, this);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}