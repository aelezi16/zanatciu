package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Settings {

    private String username;
    private String color;
    private String theme;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public static class SettingsDeSerializer implements JsonDeserializer<Settings> {

        public Settings deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


            JsonObject jobject = json.getAsJsonObject();


            Settings ret = new Settings();



            if (jobject.get("username").isJsonNull()) {
                ret.setUsername("");

            } else {

                ret.setUsername(jobject.get("username").getAsString());
            }

            if (jobject.get("color").isJsonNull()) {
                ret.setColor("");
            } else {

                ret.setColor(jobject.get("color").getAsString());
            }


            if (jobject.get("theme").isJsonNull()) {
                ret.setTheme("");
            } else {

                ret.setTheme(jobject.get("theme").getAsString());
            }


            return ret;
        }
    }

}
