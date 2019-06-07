package frontend.zanatciu.com.zanatciu.Funksionalitete.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.RifitoFjalekalimResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces.TokenResponse;
import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.RifitoFjalekalimRes;
import frontend.zanatciu.com.zanatciu.Funksionalitete.Utilities.LoginUtility;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;

public class RifitoFjalekalimTask extends AsyncTask<String,String,Integer> {


    public RifitoFjalekalimResponse<Integer> delegate;

    private String username;
    private String password;



    public RifitoFjalekalimTask(RifitoFjalekalimResponse <Integer> delegate) {
        this.delegate = delegate;
    }



    public RifitoFjalekalimTask() {

    }


    protected Integer doInBackground(String... params) {

        Integer result =null;

        try {



            HttpClient client = new DefaultHttpClient();
            String urlPost = UrlUtil.BaseUrl+"auth/reset?email="+params[0];
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


            }



            HttpEntity resEntity = response.getEntity();

            int code=response.getStatusLine().getStatusCode();

            result=code;

            String _response = EntityUtils.toString(resEntity);

            Log.i("Response is", "" + _response);


            //Gson gson= new GsonBuilder().registerTypeAdapter(TokenRes.class, new TokenRes.TokenResDeSerializer()).create() ;
            //gson.fromJson(_response, TokenRes.class);



        }
        catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

       return result;

    }

    @Override
    protected void onPostExecute(Integer result) {

        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskRifitoFjalekalim(result);

    }


}
