

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientOne {

    private static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;
    private static BufferedReader br;

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String cli = "", ser = "";
            //  Scanner sc=new Scanner (System.in);//user iput
            s = new Socket("localhost", 1234);
           if (s.getKeepAlive()){
               System.exit(0);
            }
            din = new DataInputStream(s.getInputStream());
            //  Scanner sc1=new Scanner(s.getInputStream());//to get a stream 
            dout = new DataOutputStream(s.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Client1 Initialized");
                System.out.println("Enter Message for cli2");
                cli = br.readLine();
                dout.writeUTF(cli);
                dout.flush();
                if (cli.equals("stop")) {
                    break;
                }
                ser = din.readUTF();
                System.out.println(" says: " + ser);
                if (ser.equals("stop")) {
                    break;
                }
            }
            s.close();
        } catch (IOException i) {
            System.out.println("IO Exception "+i);
        }
    }
}
