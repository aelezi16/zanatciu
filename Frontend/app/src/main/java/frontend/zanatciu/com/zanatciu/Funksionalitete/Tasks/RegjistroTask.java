package frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.RegjistroResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.TokenResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Utilities.LoginUtility;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;

public class RegjistroTask extends AsyncTask<String, String, String> {


    public RegjistroResponse<String> delegate;



    public RegjistroTask(RegjistroResponse<String> delegate) {
        this.delegate = delegate;
    }



    public RegjistroTask() {

    }


    protected String doInBackground(String... params) {

        String ret =null;

        try {



            HttpClient client = new DefaultHttpClient();
            String urlPost = UrlUtil.BaseUrl+"auth/signup";
            URI website = new URI(urlPost);
            HttpPost request = new HttpPost(website);

            StringEntity se = new StringEntity(params[0]);

            request.setEntity(se);


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
            delegate.onPostTaskRegjistro(result);
    }
}
