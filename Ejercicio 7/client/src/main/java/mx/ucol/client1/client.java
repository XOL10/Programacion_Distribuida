package mx.ucol.client1;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

class client {
    public static void main(String[] args){
        try{
            Socket s = new Socket("127.0.0.1", 3000);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin = "", msgout = "", source = "[Server]: ";
            while(!msgin.equals("end")){
                msgout = br.readLine();
                dout.writeUTF(msgout);
                msgin = din.readUTF();
                System.out.println(source + msgin);
            }
        }catch(Exception e){

        }
    }    
}
