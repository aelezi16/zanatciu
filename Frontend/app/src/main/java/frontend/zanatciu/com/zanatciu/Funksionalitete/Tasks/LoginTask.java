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

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.LoginResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.TokenResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.LoginRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.TokenRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.TokenCache;
import frontend.zanatciu.com.zanatciu.Funksionalitete.UserProfile;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;

public class LoginTask extends AsyncTask<String, String, LoginRes> {


    public LoginResponse<LoginRes> delegate;


    public LoginTask(LoginResponse<LoginRes> delegate) {
        this.delegate = delegate;
    }



    public LoginTask() {
    }


    protected LoginRes doInBackground(String... params) {

        LoginRes ret =new LoginRes();

        try {

            HttpClient client = new DefaultHttpClient();
            String urlPost = "http://192.168.0.205:8080/user/username/"+ UserProfile.getInstance().getUsername();

            URI website = new URI(urlPost);
            HttpGet request = new HttpGet(website);

            //StringEntity se = new StringEntity(params[0]);

            //request.setEntity(se);
            request.setHeader("Authorization", TokenCache.getInstance().getToken());
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


            Gson gson= new GsonBuilder().registerTypeAdapter(LoginRes.class, new LoginRes.LoginResDeSerializer()).create() ;
            ret = gson.fromJson(_response, LoginRes.class);


        }
        catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return ret;

    }

    @Override
    protected void onPostExecute(LoginRes result) {

        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskLogin(result);
    }
}
