/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.net.*;
import java.io.*;


public class Sensor {
    public static void main(String args[]) throws IOException {
     String current_location;
    String destination;
    String request;
  
       ServerSocket sensor = new ServerSocket(7592);
        Socket computer = sensor.accept();
        BufferedReader sensor_in_from_computer = new BufferedReader(new InputStreamReader(computer.getInputStream()));
        PrintWriter   sensor_out_to_computer = new PrintWriter(new OutputStreamWriter(computer.getOutputStream()),true);
        
        while (true){
            request=sensor_in_from_computer.readLine();
            if(request.equals("close")) break;
            current_location=sensor_in_from_computer.readLine();
            destination=sensor_in_from_computer.readLine();
            sensor_out_to_computer.println(current_location);
              sensor_out_to_computer.println(destination);
            

        }
  }
 public static String readings (String liveLocation , String destination){
        //dummy data 
        return "10.5N,20.511S,7.592W,99.99E";
    }

    
}
