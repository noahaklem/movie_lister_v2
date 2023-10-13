import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.message.BasicHeader;
import io.github.cdimascio.dotenv.Dotenv;

public class API {
    private static Dotenv dotenv = Dotenv.load();
    public static String SECRET_KEY = "Bearer " + dotenv.get("SECRET_KEY");
    private static final String BASE_URL = "https://api.themoviedb.org/3/trending/movie/day?language=en-US";
    private static Header headers = new BasicHeader("Authorization", "Bearer " + SECRET_KEY);

    public static Movie fetchMovieData() throws Exception {
        System.out.print(headers);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_URL);
        request.setHeader(headers);
        HttpResponse response = httpClient.execute(request);

        if (response.getStatusLine().getStatusCode() == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, Movie.class);
        } else {
            throw new Exception("Failed to fetch movie data. HTTP status code " + response.getStatusLine().getStatusCode());
        }

    }
    
}
