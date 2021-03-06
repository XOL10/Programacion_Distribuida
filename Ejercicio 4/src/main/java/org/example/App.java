package org.example;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App
{
    public static void main( String[] args )
    {
        File myFile;
        myFile = new File("file.txt");
        createFile(myFile);
        writeContent(myFile,"Mira mamá, hice un archivo .txt");
        System.out.println("Contenido: " + readContent(myFile));

        try{
            System.out.println("Path absoluto: " + getAbsolutePath(myFile));
        }catch(SecurityException e){
            System.out.println("Oops, ocurrió un error: " + e.getMessage());
        }
    }

    public static void createFile(File myFile){
        try{
            if(myFile.createNewFile()){
                System.out.println("Archivo creado: "+ myFile.getName());
            }else
                System.out.println(myFile.getName() + " ya existe.");
        }catch (IOException e){
            System.out.println("Oops, ocurrió un error: " + e.getMessage());
        }
    }

    public static void writeContent(File myFile, String contents){
        try{
            FileWriter writer = new FileWriter(myFile);
            writer.write(contents);
            writer.close();
        }catch (IOException e){
            System.out.println("Oops, ocurrió un error: " + e.getMessage());
        }
    }

    public static String readContent(File myFile){
        try{
            String data = new String(Files.readAllBytes(Paths.get(myFile.getAbsolutePath())));
            return data;
        }catch(IOException e){
            System.out.println("Oops, ocurrió un error: " + e.getMessage());
            return "";
        }
    }

    public static String getAbsolutePath(File myFile){
        return myFile.getAbsolutePath();
    }
}