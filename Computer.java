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
public class Computer {
   
    public static void main(String[] args)  throws IOException {
        
    String request;
     String current_location ;
     String destination;
      String sensor_reading;
        Socket computer_client = new Socket("localHost",7592);
      
        
        ServerSocket server = new ServerSocket(9699);
       
        Socket computer_server = server.accept();
      

       //input and output for computer as server
        BufferedReader computer_in_from_server = new BufferedReader(new InputStreamReader(computer_server.getInputStream()));
        PrintWriter    computer_out_to_server = new PrintWriter(new OutputStreamWriter(computer_server.getOutputStream()),true);

        // input and output for computer as client
        BufferedReader computer_in_from_sensor = new BufferedReader(new InputStreamReader(computer_client.getInputStream()));
        PrintWriter computer_out_to_sensor= new PrintWriter(new OutputStreamWriter(computer_client.getOutputStream()),true);
        
         while (true){
             // recive from server and send to sensor 
            request = computer_in_from_server.readLine();
             if(request.equals("close")) break;
            computer_out_to_sensor.println(request);
            
            
           
            current_location = computer_in_from_sensor.readLine();
            computer_out_to_server.println(current_location);
            
            destination= computer_in_from_sensor.readLine();
            computer_out_to_server.println(destination);
            
            sensor_reading=computer_in_from_server.readLine();
          computer_out_to_sensor.println(recomendations(sensor_reading));
          
     
          
           
        }
    }
     public static String recomendations(String reading)
    {   //dummy data

        return  "you can go straight for 5 km then turn right and go forward for 3 km then turn left" ;

    }
    
}
