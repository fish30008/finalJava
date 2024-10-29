package oop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
