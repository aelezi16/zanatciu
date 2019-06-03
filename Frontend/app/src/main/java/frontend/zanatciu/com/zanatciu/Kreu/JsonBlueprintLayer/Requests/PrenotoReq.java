package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import frontend.zanatciu.com.zanatciu.Utilities.BaseRequests.BaseReq;

public class PrenotoReq extends BaseReq {

    //fields which are from userprfoli to identify the client

    private String Perdoruesi;

    public String getPerdoruesi() {
        return Perdoruesi;
    }

    public void setPerdoruesi(String perdoruesi) {
        Perdoruesi = perdoruesi;
    }



    public static class PrenotoReqSerializer implements JsonSerializer<PrenotoReq> {

        public JsonElement serialize(final PrenotoReq obj, final Type type, final JsonSerializationContext context) {

            JsonObject result = new JsonObject();


            if (obj.getPerdoruesi() == null )
            {
                result.add("perdoruesi", new JsonPrimitive(""));
            }
            else {

                result.add("perdoruesi", new JsonPrimitive(obj.getPerdoruesi()));
            }



            return result;
        }
    }
}
