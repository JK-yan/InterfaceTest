import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Administrator on 2016/8/4.
 */
public class SimpleDemo {

    public static void main(String[] args) throws URISyntaxException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder().setScheme("http").setHost("www.imobile.com.cn")
                .setPath("/simcard.php").setParameter("simcard" , "1862517" ).setPort(80).build();
        HttpPost post = new HttpPost(uri);
        System.out.println(post.getURI());
        CloseableHttpResponse response=client.execute(post);
        HttpResponse response1 = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");

        System.out.println(response1.getProtocolVersion());
        System.out.println(response1.getStatusLine().getStatusCode());
        System.out.println(response1.getStatusLine().getReasonPhrase());
        System.out.println(response1.getStatusLine().toString());
    }

}
