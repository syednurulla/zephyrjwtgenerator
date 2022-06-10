import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class SampleJwtGeneratorGDPR {


    public static void main(String[] args) throws URISyntaxException, IllegalStateException, IOException {
        // Replace Zephyr BaseUrl with the <ZAPI_CLOUD_URL> shared with ZAPI
         String zephyrBaseUrl = "<ZAPI_CLOUD_URL>";
        // zephyr accessKey , we can get from Addons >> zapi section
        String accessKey = "<accessKey>";
        String secretKey = "<secretKey>";
        String accountId = "<accountId>";
         ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(zephyrBaseUrl, accessKey, secretKey, accountId)
                .build();
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String api = zephyrBaseUrl + "/public/rest/api/1.0/zql/fields";
        URI uri = new URI(api);
        int expirationInSec = 3000000;
        String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);

        // Print the URL and JWT token to be used for making the REST call
        System.out.println("FINAL API : " + uri.toString());
        System.out.println("JWT Token : " + jwt);

    }

}