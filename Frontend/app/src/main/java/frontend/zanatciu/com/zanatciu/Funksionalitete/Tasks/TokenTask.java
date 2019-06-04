package frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.net.URL;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.TokenResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.TokenRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Utilities.LoginUtility;



public class TokenTask extends AsyncTask<LoginUtility, String, String> {


    public TokenResponse<String> delegate;

    private String username;
    private String password;

    public TokenTask(TokenResponse<String> delegate) {
        this.delegate = delegate;
    }



    public TokenTask() {

    }


    protected String doInBackground(LoginUtility... params) {

        String ret =null;

        try {



            HttpClient client = new DefaultHttpClient();
            String urlPost ="http://192.168.0.205:8080/auth/login?username="+params[0].getUsername()+"&password="+params[0].getPassword();
            URI website = new URI(urlPost);
            HttpGet request = new HttpGet(website);

            //StringEntity se = new StringEntity(params[0]);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");

            HttpResponse response = null;

            try {

                response= client.execute(request);

            }

            catch (Exception e)
            {
                /*ret.setResult(false);
                ret.setTokenValid(true);
                String strMsg = e.getMessage();
                ret.setResultMessage(strMsg);
                ret.setDescription(strMsg);
                ret.setMessageT("Error in Web Server Network");*/

                System.out.println(e.getMessage());

                return ret;
            }

            HttpEntity resEntity = response.getEntity();

            String _response = EntityUtils.toString(resEntity);
            Log.i("Response is", "" + _response);


            //Gson gson= new GsonBuilder().registerTypeAdapter(TokenRes.class, new TokenRes.TokenResDeSerializer()).create() ;
            //gson.fromJson(_response, TokenRes.class);
            ret =_response;


        }
        catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return ret;

    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskToken(result);
    }
}
