package org.example;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class OutputDevice {

    private OutputStream outputStream ;

    public OutputDevice(OutputStream outputStream){
        this.outputStream = outputStream;
    }


    //generic function for printing a message
    public <T> void printMessage(T message){

        try{
            outputStream.write(message.toString().getBytes());

        }catch (Exception writeExeption){writeExeption.printStackTrace();}
    }

    //function that writes the list of objects json in a file
    public void listToFile(ArrayList<JSONObject> objectsList) throws IOException {
        try (FileWriter fileWriter = new FileWriter("catalog.json")) {
            for (JSONObject jsonObject : objectsList) {
                fileWriter.write(jsonObject.toString(4));
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            Files.createFile(Path.of("C:\\Users\\andre\\IdeaProjects\\mid_term_maven\\catalog.json"));
            e.printStackTrace();

        }

    }


    //function that takes file info and returns an array list of json objects
    public static ArrayList<JSONObject> readFromFile() throws IOException {
        ArrayList<JSONObject> objectList = new ArrayList<JSONObject>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("catalog.json"))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line.trim());
                if (line.trim().endsWith("}")) {
                    objectList.add(new JSONObject(content.toString()));
                    content.setLength(0);
                }
            }
        } catch (IOException e) {
            Files.createFile(Path.of("C:\\Users\\andre\\IdeaProjects\\mid_term_maven\\catalog.json"));
            e.printStackTrace();
        }
        return objectList;

    }



}
