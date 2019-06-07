package frontend.zanatciu.com.zanatciu.SherbimetEMia.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.ServiceListResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.ServiceMarketListRes;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;

public class ServiceListTask extends AsyncTask<String, String, ServiceMarketListRes> {

    public ServiceListResponse<ServiceMarketListRes> delegate;

    public ServiceListTask(ServiceListResponse<ServiceMarketListRes> delegate) {
        this.delegate = delegate;
    }

    public ServiceListTask() {
    }

    protected ServiceMarketListRes doInBackground(String... params) {

        ServiceMarketListRes ret = new ServiceMarketListRes();

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

                response = client.execute(request);

            } catch (Exception e) {
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


            com.google.gson.Gson gson = new GsonBuilder().registerTypeAdapter(ServiceMarketListRes.class, new ServiceMarketListRes.ServiceMarketListResDeSerializer()).create();
            ret = gson.fromJson(_response, ServiceMarketListRes.class);


        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return ret;

    }

    @Override
    protected void onPostExecute(ServiceMarketListRes result) {
        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskServices(result);
    }
}
