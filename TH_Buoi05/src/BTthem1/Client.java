
package BTthem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Dell Inspiron 14
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            socket = new Socket("localhost", 12345); // Kết nối đến địa chỉ và cổng của server
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            
            while (true) {
                System.out.print("Nhập một số nguyên hoặc 'exit' để thoát: ");
                userInput = consoleInput.readLine();
                out.println(userInput); // Gửi dữ liệu đến server
                
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                
                String serverResponse = in.readLine(); // Nhận phản hồi từ server
                System.out.println("Kết quả từ server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
