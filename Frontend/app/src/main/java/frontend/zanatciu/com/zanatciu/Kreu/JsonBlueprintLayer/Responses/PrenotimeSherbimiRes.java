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

public class PrenotimeSherbimiRes extends BaseRes implements Serializable {


    private ArrayList<PrenotimeSherbimiItem> prenotimeSherbimiArrayList;


    public ArrayList<PrenotimeSherbimiItem> getPrenotimeSherbimiArrayList() {
        return prenotimeSherbimiArrayList;
    }

    public void setPrenotimeSherbimiArrayList(ArrayList<PrenotimeSherbimiItem> prenotimeSherbimiArrayList) {
        this.prenotimeSherbimiArrayList = prenotimeSherbimiArrayList;
    }

    public static class PrenotimeSherbimiResDeSerializer implements JsonDeserializer<PrenotimeSherbimiRes>
    {

        public PrenotimeSherbimiRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {



            //Mund te kete edhe ndonje atribut tjeter shtese suportues per security

            JsonObject jobject = json.getAsJsonObject();

            PrenotimeSherbimiRes ret = new PrenotimeSherbimiRes();

            // OsheeBillResItems[] arr = null;
            ArrayList<PrenotimeSherbimiItem> prenotoSherbimArrayList = null;

            if (jobject.get("prenotimeSherbimiArrayList").isJsonNull()) {
                ret.setPrenotimeSherbimiArrayList(prenotoSherbimArrayList);
            } else {

                JsonArray jsonArrayObject = jobject.get("prenotimeSherbimiArrayList").getAsJsonArray();


                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
                    //authors[i] = jsonAuthor.getAsString();
                    Gson gson = new GsonBuilder().registerTypeAdapter(PrenotimeSherbimiItem.class, new PrenotimeSherbimiItem.PrenotimeSherbimiItemDeSerializer()).create();
                    PrenotimeSherbimiItem objItem = gson.fromJson(jItem, PrenotimeSherbimiItem.class);

                    prenotoSherbimArrayList.add(objItem);
                }

                ret.setPrenotimeSherbimiArrayList(prenotoSherbimArrayList);
            }

            return ret;
        }

    }
}
