


import java.net.*;
import java.io.*;

class TwoClientServer {

    public static void main(String args[]) throws IOException {
       try{ 
           String cli1="",cli2="";
           ServerSocket ss1 = new ServerSocket (1234);
           ServerSocket ss2 =new ServerSocket (1236);
        Socket s1 = ss1.accept();
        Socket s2 = ss2.accept();
        /*BufferedReader br1=new BufferedReader ( new InputStreamReader(s1.getInputStream())  );
        BufferedReader br2=new BufferedReader ( new InputStreamReader(s2.getInputStream())  );
              
       OutputStreamWriter os1=new OutputStreamWriter(s1.getOutputStream());
       OutputStreamWriter os2=new OutputStreamWriter(s2.getOutputStream());
       BufferedWriter bw1 = new BufferedWriter(os1);
       BufferedWriter bw2 = new BufferedWriter(os2);*/
        
            DataInputStream din1 = new DataInputStream(s1.getInputStream());
            DataOutputStream dout1 = new DataOutputStream(s1.getOutputStream());
            DataInputStream din2 = new DataInputStream(s2.getInputStream());
            DataOutputStream dout2 = new DataOutputStream(s2.getOutputStream());
            
           // BufferedReader br = new BufferedReader();// getInputSrtream is method of ss obj 
       
        while (true){
        System.out.println("Server Initialized");
        
        cli1=din1.readUTF();
        System.out.println("cli1 says "+ cli1);        
        if (cli1.equals("stop")) {break;}
        dout2.writeUTF(cli1);//send cli1 msg to cli2
        dout2.flush();
        cli2=din2.readUTF();
            System.out.println("cli2 says "+cli2);
        if (cli2.equals("stop")) {
            break;}
        dout1.writeUTF(cli2);//send cli2msg to cli1
        dout1.flush();
        }
        
        
    }catch (IOException i)
    {System.out.println("IOExceprion :"+i);}

}
}
