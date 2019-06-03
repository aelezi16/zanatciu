package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;

public class PrenotimeSherbimiItem implements Serializable {

    private String imageString;
    private String emriAplikantit;
    private String timeUntilExpiration;




    public PrenotimeSherbimiItem() {
    }

    public PrenotimeSherbimiItem(String imageString, String emriAplikantit, String timeUntilExpiration) {
        this.imageString = imageString;
        this.emriAplikantit = emriAplikantit;
        this.timeUntilExpiration = timeUntilExpiration;
    }



    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public String getEmriAplikantit() {
        return emriAplikantit;
    }

    public void setEmriAplikantit(String emriAplikantit) {
        this.emriAplikantit = emriAplikantit;
    }

    public String getTimeUntilExpiration() {
        return timeUntilExpiration;
    }

    public void setTimeUntilExpiration(String timeUntilExpiration) {
        this.timeUntilExpiration = timeUntilExpiration;
    }









    public static class PrenotimeSherbimiItemDeSerializer implements JsonDeserializer<PrenotimeSherbimiItem> {

        public PrenotimeSherbimiItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


            JsonObject jobject = json.getAsJsonObject();


            PrenotimeSherbimiItem ret = new PrenotimeSherbimiItem();



            if (jobject.get("imageString").isJsonNull()) {
                ret.setImageString("");

            } else {

                ret.setImageString(jobject.get("imageString").getAsString());
            }

            if (jobject.get("emriAplikantit").isJsonNull()) {
                ret.setEmriAplikantit("");
            } else {

                ret.setEmriAplikantit(jobject.get("emriAplikantit").getAsString());
            }

            if (jobject.get("timeUntilExpiration").isJsonNull()) {
                ret.setTimeUntilExpiration("");
            } else {

                ret.setTimeUntilExpiration(jobject.get("timeUntilExpiration").getAsString());
            }


            return ret;
        }
    }

}
