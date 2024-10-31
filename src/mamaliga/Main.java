package mamaliga;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://fear-and-greed-index.p.rapidapi.com/v1/fgi"))
                .header("x-rapidapi-key", "cfc4ec6f9bmsh5875edf65f903b7p17871fjsn36243be4a36a")
                .header("x-rapidapi-host", "fear-and-greed-index.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}

