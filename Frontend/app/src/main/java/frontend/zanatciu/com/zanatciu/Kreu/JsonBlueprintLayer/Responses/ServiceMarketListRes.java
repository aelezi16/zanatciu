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


    private ArrayList<ServiceMarketListItem> serviceMarketList;

    public ArrayList<ServiceMarketListItem> getServiceMarketListItem() {
        return serviceMarketList;
    }

    public void setServiceMarketListItem(ArrayList<ServiceMarketListItem> serviceMarketListItem) {
        this.serviceMarketList = serviceMarketListItem;
    }

    public static class ServiceMarketListResDeSerializer implements JsonDeserializer<ServiceMarketListRes>
    {

        public ServiceMarketListRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {




            ServiceMarketListRes ret = new ServiceMarketListRes();

            // OsheeBillResItems[] arr = null;
            ArrayList<ServiceMarketListItem> serviceMarketListInner = new ArrayList<>();

            if (json.isJsonNull()) {
                ret.setServiceMarketListItem(serviceMarketListInner);
            } else {

                JsonArray jsonArrayObject = json.getAsJsonArray();

                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
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
