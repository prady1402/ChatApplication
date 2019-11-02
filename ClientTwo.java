package clientserver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTwo {

    private static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;
    private static BufferedReader br;

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String cli1 = "",cli2="",ser="";
            //  Scanner sc=new Scanner (System.in);//user iput
            s = new Socket("localhost", 1236);// socket created
            if (s.getKeepAlive() ){           //connection purpose
                System.exit(0);           
            }
            din = new DataInputStream(s.getInputStream());
            //  Scanner sc1=new Scanner(s.getInputStream());//to get a stream 
            dout = new DataOutputStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Client2 Initialized");
                System.out.println("Enter Message for cli1");
                ser = din.readUTF();
                System.out.println("cli1 says: " + ser);
                if (ser.equals("stop")) {
                    break;
                }
                cli2 = br.readLine();
                dout.writeUTF(cli2);
                dout.flush();
                if (cli2.equals("stop")) {
                    break;
                }
            }
            s.close();
        } catch (IOException i) {
            System.out.println("IO Exception " + i);
        }
    }
}
