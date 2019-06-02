package frontend.zanatciu.com.zanatciu.Kreu.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.JobListResponse;
import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.MerrAplikimeResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikimePuneRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListRes;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;

public class MerrAplikimeTask extends AsyncTask<String, String, AplikimePuneRes> {


    public MerrAplikimeResponse<AplikimePuneRes> delegate;

    public MerrAplikimeResponse<AplikimePuneRes> getDelegate() {
        return delegate;
    }

    public void setDelegate(MerrAplikimeResponse<AplikimePuneRes> delegate) {
        this.delegate = delegate;
    }


    public MerrAplikimeTask(MerrAplikimeResponse<AplikimePuneRes> delegate) {
        this.delegate = delegate;
    }

    public MerrAplikimeTask() {
    }

    protected AplikimePuneRes doInBackground(String... params) {

        AplikimePuneRes ret =new AplikimePuneRes();

        try {

            HttpClient client = new DefaultHttpClient();
            String urlPost = UrlUtil.BaseUrl + UrlUtil.BaseUrlJob;
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


            Gson gson= new GsonBuilder().registerTypeAdapter(AplikimePuneRes.class, new AplikimePuneRes.AplikimePuneResDeSerializer()).create() ;
            ret = gson.fromJson(_response, AplikimePuneRes.class);


        }
        catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return ret;

    }

    @Override
    protected void onPostExecute(AplikimePuneRes result) {
        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskMerrAplikime(result);


    }
}
