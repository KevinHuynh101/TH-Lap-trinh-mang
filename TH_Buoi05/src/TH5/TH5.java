/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH5;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kimdo
 */
public class TH5 {
    public static void main(String [] arg){
        try{
            Socket theSocket = new Socket("127.20.0.4",80);
            System.out.println("Connected to" + theSocket.getInetAddress()
            + "on port "+ theSocket.getPort()+ "form port"
            + theSocket.getLocalPort() +"of" + theSocket.getLocalAddress());
        
    
}catch(IOException e)
{
    System.out.println(e);
}
}
}
