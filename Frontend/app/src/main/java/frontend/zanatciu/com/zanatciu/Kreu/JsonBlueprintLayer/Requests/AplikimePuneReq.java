package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.Serializable;
import java.lang.reflect.Type;

import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests.LoginReq;
import frontend.zanatciu.com.zanatciu.Utilities.BaseRequests.BaseReq;


public class AplikimePuneReq extends BaseReq implements Serializable {


    private String jobId;


    public String getJobId() {
        return jobId;
    }


    public void setJobId(String jobId) {
        this.jobId = jobId;
    }


    public static class AplikimePuneReqSerializer implements JsonSerializer<AplikimePuneReq> {

        public JsonElement serialize(final AplikimePuneReq obj, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();


            if (obj.getJobId() == null) {
                result.add("jobId", new JsonPrimitive(""));
            } else {

                result.add("jobId", new JsonPrimitive(obj.getJobId()));
            }


            return result;
        }
    }
}
