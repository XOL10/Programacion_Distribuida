package mx.ucol.httpserver;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClientHandler implements Runnable {
    final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        DataOutputStream output = null;
        BufferedReader input = null;

        try {
            // output = new PrintWriter(socket.getOutputStream(), true);
            output = new DataOutputStream(socket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String received;
            while ((received = input.readLine()) != null) {
                String requestArray[] = received.split(" ");

                if (requestArray[0].equals("GET")) {
                    // Get the resource name and read its contents in the /www folder
                    // If the resource equals "/" it should open index.html
                    System.out.println(requestArray[1]);

                    String resourceName = requestArray[1].equals("/") ? "/index.html" : requestArray[1];
                    String resourcePath = "./www" + resourceName;
                    Path filePath = Paths.get(resourcePath);

                    boolean fileExists = Files.exists(filePath, LinkOption.NOFOLLOW_LINKS);
                    String response = null;
                    byte[] fileContent = null;
                    int contentLength = 0;
                    //Reading file contents
                    if (fileExists){
                    fileContent = Files.readAllBytes(filePath);
                    contentLength = fileContent.length;
                    String mimeType = Files.probeContentType(filePath);
                    
                    
                    System.out.println("MIME type: " + mimeType);

                    response = "HTTP/1.1/ 200 OK\r\n";
                    response += "Content-Type: " + mimeType + "\r\n";
                    response += "Content-Length: " + String.valueOf(contentLength) + "\r\n\r\n";
                    }else{
                        response = "HTTP/1.1 404\r\n\r\n";
                        response += "Not Found";
                    }
                    output.writeBytes(response);
                    if(fileExists) output.write(fileContent, 0, contentLength);
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                input.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String readContent(File myFile){
        try{
            String data = new String(Files.readAllBytes(Paths.get(myFile.getAbsolutePath())));
            return data;
        }catch(IOException e){
            System.out.println("An error ocurred: " + e.getMessage());
            return "";
        }
    }
} 