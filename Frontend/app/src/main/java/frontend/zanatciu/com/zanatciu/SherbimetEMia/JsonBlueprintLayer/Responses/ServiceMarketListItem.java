package frontend.zanatciu.com.zanatciu.SherbimetEMia.JsonBlueprintLayer.Responses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ServiceMarketListItem {

    private String imageString;
    private String title;
    private String emriSherbimOfruesi;

    private String pershkrimi;
    private String price_wage;


    public ServiceMarketListItem() {
    }

    public ServiceMarketListItem(String imageString, String title, String price_wage,String emriSherbimOfruesi,String pershkrimi) {
        this.imageString = imageString;
        this.title = title;
        this.emriSherbimOfruesi=emriSherbimOfruesi;
        this.pershkrimi=pershkrimi;
        this.price_wage = price_wage;
    }


    public String getEmriSherbimOfruesi() {
        return emriSherbimOfruesi;
    }

    public void setEmriSherbimOfruesi(String emriSherbimOfruesi) {
        this.emriSherbimOfruesi = emriSherbimOfruesi;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice_wage() {
        return price_wage;
    }

    public void setPrice_wage(String price_wage) {
        this.price_wage = price_wage;
    }


    public static class ServiceMarketListItemDeSerializer implements JsonDeserializer<ServiceMarketListItem> {

        public ServiceMarketListItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonObject jobject = json.getAsJsonObject();

            ServiceMarketListItem ret = new ServiceMarketListItem();




            if (jobject.get("imageString").isJsonNull()) {
                ret.setImageString("");

            } else {

                ret.setImageString(jobject.get("imageString").getAsString());
            }

            if (jobject.get("title").isJsonNull()) {
                ret.setTitle("");
            } else {

                ret.setTitle(jobject.get("title").getAsString());
            }

            if (jobject.get("emriSherbimOfruesi").isJsonNull()) {
                ret.setEmriSherbimOfruesi("");
            } else {

                ret.setEmriSherbimOfruesi(jobject.get("emriSherbimOfruesi").getAsString());
            }

            if (jobject.get("pershkrimi").isJsonNull()) {
                ret.setPershkrimi("");
            } else {

                ret.setPershkrimi(jobject.get("pershkrimi").getAsString());
            }

            if (jobject.get("price_wage").isJsonNull()) {
                ret.setPrice_wage("");
            } else {

                ret.setPrice_wage(jobject.get("price_wage").getAsString());
            }


            return ret;

        }
    }

}
