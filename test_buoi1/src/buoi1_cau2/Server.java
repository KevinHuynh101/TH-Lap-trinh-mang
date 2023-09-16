/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2;
import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(7777);
        System.out.println("Server đã sẵn sàng");
        Socket client = server.accept();
        System.out.println("client đã kết nối đến server");
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        
        int a = dis.readInt();
        int b = dis.readInt();
        Server sv = new Server();
        int c = (a*b)/sv.ucln(a, b);
        dos.writeInt(c);
    }
    
    public int ucln(int a,int b)
    {
        while(a!=b)
        {
            if(a>b)
            {
                a =a -b;
            }
            else
                b = b -a;
        }
    
      return a;
    } 

}
