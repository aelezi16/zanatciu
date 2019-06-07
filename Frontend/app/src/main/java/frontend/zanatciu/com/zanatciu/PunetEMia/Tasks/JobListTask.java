package frontend.zanatciu.com.zanatciu.PunetEMia.Tasks;

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

import frontend.zanatciu.com.zanatciu.Kreu.Interfaces.JobListResponse;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListRes;
import frontend.zanatciu.com.zanatciu.Kreu.Utilities.UrlUtil;


public class JobListTask extends AsyncTask<String, String, JobMarketListRes> {

    public JobListResponse<JobMarketListRes> delegate;


    public JobListTask(JobListResponse<JobMarketListRes> jobMarketListResJobListResponse) {
        this.delegate = jobMarketListResJobListResponse;
    }

    public JobListTask() {
    }

    protected JobMarketListRes doInBackground(String... params) {

        JobMarketListRes ret = new JobMarketListRes();

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


            com.google.gson.Gson gson = new GsonBuilder().registerTypeAdapter(JobMarketListRes.class, new JobMarketListRes.JobMarketListResDeSerializer()).create();
            ret = gson.fromJson(_response, JobMarketListRes.class);


        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return ret;

    }

    @Override
    protected void onPostExecute(JobMarketListRes result) {
        super.onPostExecute(result);

        if (result != null && delegate != null)
            delegate.onPostTaskJobs(result);
    }
}
