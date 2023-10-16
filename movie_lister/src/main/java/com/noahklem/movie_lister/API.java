

public class API {
    // dotenv is not working so you need to program regular environment variables.
    // for some reason maven is not recognizing these dependencies and not loading them
    // need to import all the seperate packages then the code below will most likely work
    // look in pom.xml for dependencies

    // also you were able to generate a jar and run it with maven but that was before you added the api class

    private static Dotenv dotenv = dotenv.configure().load();
    public static String SECRET_KEY = "Bearer " + dotenv.get("SECRET_KEY");
    private static final String BASE_URL = "https://api.themoviedb.org/3/trending/movie/day?language=en-US";
    private static Header headers;
    
    public static Movie fetchMovieData() throws Exception {
        headers = new BasicHeader("Authorization", SECRET_KEY);
        System.out.print(headers);
    
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(BASE_URL);
        request.setHeader(headers);
        HttpResponse response = httpClient.execute(request);

        if(response.getStatusLine().getStatusCode() == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.print(jsonResponse);
            ObjectMapper ObjectMapper = new ObjectMapper();
            return ObjectMapper.readValue(jsonResponse, Movie.class);
        } else {
            throw new Exception("Failed ot fectch movie data. HTTP status code " + response.getStatusLine().getStatusCode());
        }

    }
}
