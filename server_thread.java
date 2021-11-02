/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author DELL
 */
/*
public class server_thread {
    
}*/


class server_thread implements Runnable
{

    Socket s;

    public server_thread(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        try
        {
            //3.create I/O streams
            DataInputStream server_in = new DataInputStream(s.getInputStream());
            DataOutputStream server_out = new DataOutputStream(s.getOutputStream());

            //4.perform IO with client
            while (true)
            {
                //request 
                server_out.writeUTF("Hello,how can i help you?");
                server_out.flush();
                String acc_num = server_in.readUTF();
                    
                
                //----------------------
                // if correct 
                server_out.writeUTF("send your location ");
                server_out.flush();
                String password = server_in.readUTF();
                   
                //----------------------
              
               server_out.writeUTF("what is your destination");
                server_out.flush();
                String payment = server_in.readUTF();
                  
                //----------------------
                
                
               server_out.writeUTF(" you can go straight for  5 km then turn right and go forward 3 km then turn left");
                
              
                String usr_choice = server_in.readUTF();
                if (usr_choice.equals("close"))
                {
                    
                    server_out.flush();
                    break;
                }
            }

            //close 
         server_in.close();
           server_out.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

} 
