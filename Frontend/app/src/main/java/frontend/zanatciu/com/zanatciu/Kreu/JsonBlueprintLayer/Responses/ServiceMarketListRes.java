package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ServiceMarketListRes {


    private ArrayList<ServiceMarketListItem> serviceMarketListItem;

    public ArrayList<ServiceMarketListItem> getServiceMarketListItem() {
        return serviceMarketListItem;
    }

    public void setServiceMarketListItem(ArrayList<ServiceMarketListItem> serviceMarketListItem) {
        this.serviceMarketListItem = serviceMarketListItem;
    }

    public static class ServiceMarketListResDeSerializer implements JsonDeserializer<ServiceMarketListRes>
    {

        public ServiceMarketListRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {


            JsonObject jobject = json.getAsJsonObject();

            ServiceMarketListRes ret = new ServiceMarketListRes();

            // OsheeBillResItems[] arr = null;
            ArrayList<ServiceMarketListItem> serviceMarketListInner = null;

            if (jobject.get("jobMarketList").isJsonNull()) {
                ret.setServiceMarketListItem(serviceMarketListInner);
            } else {

                JsonArray jsonArrayObject = jobject.get("jobMarketList").getAsJsonArray();


                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
                    //authors[i] = jsonAuthor.getAsString();
                    Gson gson = new GsonBuilder().registerTypeAdapter(ServiceMarketListItem.class, new ServiceMarketListItem.ServiceMarketListItemDeSerializer()).create();
                    ServiceMarketListItem objItem = gson.fromJson(jItem, ServiceMarketListItem.class);

                    serviceMarketListInner.add(objItem);
                }

                ret.setServiceMarketListItem(serviceMarketListInner);
            }

            return ret;
        }

    }

}
