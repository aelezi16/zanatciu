package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;

import frontend.zanatciu.com.zanatciu.Utilities.BaseResponses.BaseRes;

public class AplikoRes extends BaseRes implements Serializable {







    public static class AplikoResDeSerializer implements JsonDeserializer<AplikoRes> {

        public AplikoRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


            JsonObject jobject = json.getAsJsonObject();


            AplikoRes ret = new AplikoRes();



            if (jobject.get("message").isJsonNull()) {
                ret.setMessage("");

            } else {

                ret.setMessage(jobject.get("message").getAsString());
            }

            if (jobject.get("result").isJsonNull()) {
                ret.setResult(false);
            } else {

                ret.setResult(jobject.get("result").getAsBoolean());
            }


            return ret;
        }
    }



}
