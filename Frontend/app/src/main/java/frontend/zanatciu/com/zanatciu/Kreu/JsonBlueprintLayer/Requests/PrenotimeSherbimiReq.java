package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Requests;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PrenotimeSherbimiReq {


    private String serviceId;


    public String getJobId() {
        return serviceId;
    }


    public void setJobId(String jobId) {
        this.serviceId = jobId;
    }




    public static class AplikimePuneReqSerializer implements JsonSerializer<AplikimePuneReq> {

        public JsonElement serialize(final AplikimePuneReq obj, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();


            if (obj.getJobId() == null )
            {
                result.add("serviceId", new JsonPrimitive(""));
            }
            else {

                result.add("serviceId", new JsonPrimitive(obj.getJobId()));
            }




            return result;
        }
    }

}
