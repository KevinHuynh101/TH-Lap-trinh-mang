/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTthem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kimdo
 */
public class ServerTest {
  public static void main(String[] args) {
        int port = 12345;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server đang lắng nghe trên cổng " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Kết nối mới từ " + clientSocket.getInetAddress().getHostAddress());

                Thread clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = in.readLine();

            if (request != null && request.startsWith("LIST ")) {
                String directoryName = request.substring(5);
                File directory = new File(directoryName);

                if (directory.exists() && directory.isDirectory()) {
                    File[] files = directory.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (file.isFile()) {
                                out.println("File: " + file.toURI().toURL());
                            } else if (file.isDirectory()) {
                                out.println("Thư mục: " + file.toURI().toURL());
                            }
                        }
                    }
                } else {
                    out.println("Thư mục không tồn tại.");
                }
            } else {
                out.println("Yêu cầu không hợp lệ.");
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
