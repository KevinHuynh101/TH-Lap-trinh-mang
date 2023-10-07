
package BTthem2;

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
            socket = new Socket("localhost", 12345); 
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            while (true) {
                System.out.print("NHap cau lenh : ");
                userInput = consoleInput.readLine();
                out.println(userInput); 

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                String serverResponse;
                while ((serverResponse = in.readLine()) != null) {
                    if (serverResponse.isEmpty()) {
                        break;
                    }
                    System.out.println(serverResponse); 
                }
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
