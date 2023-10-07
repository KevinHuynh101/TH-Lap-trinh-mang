
package BTthem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dell Inspiron 14
 */
public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        
        try {
            serverSocket = new ServerSocket(12345); // Mở cổng kết nối ở cổng 12345
            System.out.println("Server đang chờ kết nối từ Client...");
            
            while (true) {
                clientSocket = serverSocket.accept(); // Chấp nhận kết nối từ client
                System.out.println("Client đã kết nối.");
                
                // Xử lý dữ liệu từ client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (inputLine.equalsIgnoreCase("exit")) {
                        break;
                    }
                    
                    try {
                        int num = Integer.parseInt(inputLine);
                        String binaryNum = Integer.toBinaryString(num);
                        out.println(binaryNum);
                    } catch (NumberFormatException e) {
                        out.println("Không phải là số nguyên");
                    }
                }
                
                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Client đã ngắt kết nối.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
