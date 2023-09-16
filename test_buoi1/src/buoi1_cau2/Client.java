
//Câu 2: Viết chương trình TCP client/server trong đó:
//Client gửi lên server 2 số nguyên a và b.
//Server nhận giá trị và trả về giá trị Bội số chung nhỏ nhất của 2 số đó


package Cau2;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 7777);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập a: ");
        int a = Integer.parseInt(nhap.nextLine());
        dos.writeInt(a);
        
        System.out.println("Nhập b: ");
        int b = Integer.parseInt(nhap.nextLine());
        dos.writeInt(b);
        
        int c = dis.readInt();
        System.out.println("Bội chung nhỏ nhất của hai số a và b là : " + c);
        
    }
}
