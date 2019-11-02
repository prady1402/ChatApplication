/*,,,
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author parth
 */
//accept input from client process it and return it to the client
public class server {

    public static void main(String args[]) {
        try {
            String cli = "", ser = "";
            ServerSocket s1 = new ServerSocket(1234);
            Socket ss = s1.accept();//accepts incomming requests
            DataInputStream din = new DataInputStream(ss.getInputStream());
            DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// getInputSrtream is method of ss obj 

            while (true) {
                System.out.println("Server Initialized");
                
                cli = din.readUTF();
                System.out.println("Client says:" + cli);
                if (cli.equals("stop")) {
                    break;
                }
                ser = br.readLine();
                dout.writeUTF(ser);
                dout.flush();
                System.out.println("Server says: " + ser);
                if (ser.equals("stop")) {
                    break;
                }
            }

            s1.close();
            ss.close();
        } catch (IOException i) {
            System.out.println("IO Exception " + i);
        }

    }
}

