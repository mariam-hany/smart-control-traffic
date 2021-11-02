/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.net.*;
import java.io.*;

/**
 *
 * @author DELL
 */
public class Server {
    public static void main(String args[]) throws IOException {
    String current_location;
    String destination;
    String request;
        Socket server= new Socket("localHost",9699);

        BufferedReader userKeyboard = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader server_in_from_computer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter  server_out_to_computer = new PrintWriter(new OutputStreamWriter(server.getOutputStream()),true);
        
        ////
       
        while (true){

            request = userKeyboard.readLine();
            server_out_to_computer .println(request);
            if (request.equals("close")) break;

            server_out_to_computer .println(request);
            if(request.equals("send me the best recommendation for my destination")) {
                System.out.println("Send your location");
                 current_location = userKeyboard.readLine();
                 server_out_to_computer .println(current_location);
                System.out.println("what is your destination ");
                destination =userKeyboard.readLine();
                server_out_to_computer .println(destination);
                System.out.println(server_in_from_computer.readLine());

            }
          
            }
    }

}
