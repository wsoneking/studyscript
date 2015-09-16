package cc.megamind.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpPostExample {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://int-piapi-internal.stg-openclass.com/tokens");
		StringEntity userInfo = new StringEntity("{\"userName\":\"tusha9.educator\",\"password\":\"Password27\"}");
		userInfo.setContentType("application/json"); 
		post.setEntity(userInfo);
		HttpResponse response = client.execute(post);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
	}
}