import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class Test {

    public static void main(String[] args) throws Throwable {
        HttpClient httpClient = HttpClients.createDefault();

        HttpResponse response = httpClient.execute(new HttpGet("http://localhost:8123"));
        System.out.println(response);
    }
}
