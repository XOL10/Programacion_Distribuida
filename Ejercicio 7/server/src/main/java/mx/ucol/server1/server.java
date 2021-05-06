package mx.ucol.server1;

import java.net.*;
import java.io.*;

public class server{
    public static void main(String[] args){
        try{
            ServerSocket ss = new ServerSocket(3000);
            Socket s = ss.accept();
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "", msgout = "", source = "¨[Client]: ";

            while(!msgin.equals("end")){
                msgin = din.readUTF();
                System.out.println(source + msgin);
                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            s.close();
        }catch(Exception e){
            
        }
    }
}