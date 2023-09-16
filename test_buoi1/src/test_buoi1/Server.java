/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_buoi1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("Server đã sẵn sàng");
        Socket client = server.accept();
        System.out.println("client đã kết nối đến server");
        Scanner in = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());
        String s = in.nextLine();
        String [] sp = s.split("/");
        int thang = Integer.parseInt(sp[0]);
        int nam = Integer.parseInt(sp[1]);
        Server sv = new Server();
        int ngay = sv.ngay(thang, nam);
        String r ="tháng: " + thang + " năm " + nam + " có: " + ngay + " ngày";
        System.out.println(r);
        out.print(r);
        server.close();
    }
    public int ngay(int thang,int nam)
    {
      int ngay =0;
      switch(thang)
      {
          case 1:
          case 3:
          case 5:
          case 7:
          case 8:
          case 10:
          case 12:
              ngay = 31;
              break;
          case 4:
          case 9:
          case 11:
              ngay = 30;
              break;
          case 2:
              if(nam%4==0 || nam % 100 !=0 || nam %400 ==0){
                  ngay=29;
              }
              else 
                  ngay = 28;
              break;
      }
      return ngay;
    } 
}
