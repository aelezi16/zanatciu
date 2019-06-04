package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;

import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikoRes;
import frontend.zanatciu.com.zanatciu.Utilities.BaseResponses.BaseRes;

public class TokenRes extends BaseRes implements Serializable {


    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public static class TokenResDeSerializer implements JsonDeserializer<TokenRes> {

        public TokenRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


            JsonObject jobject = json.getAsJsonObject();


            TokenRes ret = new TokenRes();



            if (jobject.get("token").isJsonNull()) {
                ret.setToken("");

            } else {

                ret.setToken(jobject.get("token").getAsString());
            }

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
