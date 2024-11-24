package oop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CarLoader {
    public static List<Car> loadCars(String folderPath) throws IOException {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            String filePath = folderPath + "/Car" + i + ".json";
            String content = new String(Files.readAllBytes(new File(filePath).toPath()));
            cars.add(Car.fromJSONString(content));
        }

        return cars;
    }
}

