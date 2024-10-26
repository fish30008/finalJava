package oop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//
//import java.io.*;
//
//public class FileReader {
//    final String path = System.getProperty("user.dir");
//    String filename;
//    public void ReadFile(String filename) {
//        this.filename = filename;
//        try{
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
//            writer.write("\n Writing to a file");
//            writer.write("\n Writing to a file");
//
//            writer.close();
//        }catch(
//                IOException e){
//            e.printStackTrace();
//        }
//        try{
//            BufferedReader reader = new BufferedReader(
//                    new java.io.FileReader(path+ "//" + filename));
//            reader.lines().forEach(line -> System.out.println(line));
//            reader.close();
//        }catch(
//                IOException e){
//            e.printStackTrace();
//        }
//    }
//
//}
public class FileReaderUtils {
    public String readFileIntoString(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
