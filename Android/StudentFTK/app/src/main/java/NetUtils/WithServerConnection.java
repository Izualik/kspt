package NetUtils; /**
 * Created by Izual on 06.12.2014.
 */

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;


public class WithServerConnection {
    private static String Token = "";
    public static void GetToken()
    {

        String Query = "https://oauth.vk.com/authorize?client_id=4601196&redirect_uri=https://studentspbstu.tk/vk/oauth&v=5.25&response_type=code";
        try {
            URLConnection con = new URL(Query).openConnection();
            NetworkUtils.setAllTrusted(con);
            InputStream is = con.getInputStream();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject)parser.parse(new InputStreamReader(is));
            Token = json.toString();
        }
        catch(MalformedURLException ex)
        {
            throw new RuntimeException(ex);
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
        catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
