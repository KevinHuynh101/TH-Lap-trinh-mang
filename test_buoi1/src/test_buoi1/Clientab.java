

//Câu 1: Viết chương trình TCP Client/Server trong đó:
//Client gửi lên server một chuỗi gồm tháng và năm (ví dụ: “4/2019”) 
//Servẻ nhận giá trị và trả về cho client thông báo số ngày của tháng đó
//(ví dụ: “tháng 4 năm 2019 có 30 ngày”)

package test_buoi1;
import java.io.IOException;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Clientab {
        public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 7777);
        Scanner in = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        Scanner nhap = new Scanner(System.in);
        System.out.println("Nhập tháng: ");
        int thang = nhap.nextInt();
        if(thang<=0||thang >12)
        {
            System.out.println("Nhập sai. Nhập lại.");
            thang = nhap.nextInt();
        }
        System.out.println("Nhập năm: ");
        int nam = nhap.nextInt();
        if(nam<1)
        {
            System.out.println("Nhập sai. Nhập lại.");
            nam = nhap.nextInt();
        }
        String s = thang + "/" + nam;
        System.out.println(s);
        out.println(s);
        String r = in.nextLine();
        System.out.println(r);
        client.close();
    }
}
