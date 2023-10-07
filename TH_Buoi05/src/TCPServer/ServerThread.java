/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCPServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kimdo
 */
public class ServerThread implements Runnable{
    
    
    private Scanner in = null;
    private PrintWriter out = null;
    private Socket socket;
    private String name;
    
    public ServerThread(Socket socket, String name) {
        try {
            this.socket = socket;
            this.name = name;
            this.in = new Scanner(this.socket.getInputStream());
            this.out = new PrintWriter(this.socket.getOutputStream(),true);
            new Thread(this).start();
        } catch (IOException ex) {
           
        }
        
    }
    
    public void run(){
        try {
            while (true) {               
                String chuoi = in.nextLine().trim();
                System.out.println("Dang xu ly chuoi");
                chuoi = chuoi.toUpperCase();
                out.println(chuoi);
            }
        } catch (Exception e) {
            System.out.print(name +"has departed");
        }finally{
            try{socket.close();
        }catch(IOException e){}
        }
    }

}
