package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

import frontend.zanatciu.com.zanatciu.Utilities.BaseResponses.BaseRes;

public class AplikimePuneRes extends BaseRes implements Serializable {


    private ArrayList<AplikimePuneItem> aplikimePuneList;


    public ArrayList<AplikimePuneItem> getAplikimePuneList() {
        return aplikimePuneList;
    }

    public void setAplikimePuneList(ArrayList<AplikimePuneItem> aplikimePuneList) {
        this.aplikimePuneList = aplikimePuneList;
    }


    public static class AplikimePuneResDeSerializer implements JsonDeserializer<AplikimePuneRes> {

        public AplikimePuneRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {


            //Mund te kete edhe ndonje atribut tjeter shtese suportues per security

            JsonObject jobject = json.getAsJsonObject();

            AplikimePuneRes ret = new AplikimePuneRes();

            // OsheeBillResItems[] arr = null;
            ArrayList<AplikimePuneItem> aplikimePuneItemArrayList = null;

            if (jobject.get("aplikimePuneList").isJsonNull()) {
                ret.setAplikimePuneList(aplikimePuneItemArrayList);
            } else {

                JsonArray jsonArrayObject = jobject.get("aplikimePuneList").getAsJsonArray();


                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
                    //authors[i] = jsonAuthor.getAsString();
                    Gson gson = new GsonBuilder().registerTypeAdapter(AplikimePuneItem.class, new AplikimePuneItem.AplikimePuneItemDeSerializer()).create();
                    AplikimePuneItem objItem = gson.fromJson(jItem, AplikimePuneItem.class);

                    aplikimePuneItemArrayList.add(objItem);
                }

                ret.setAplikimePuneList(aplikimePuneItemArrayList);
            }

            return ret;
        }

    }

}
