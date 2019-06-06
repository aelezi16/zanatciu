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

public class JobMarketListRes extends BaseRes implements Serializable {

    private ArrayList<JobMarketListItem> jobMarketList;

    public  ArrayList<JobMarketListItem> getJobMarketList() {
        return jobMarketList;
    }

    public void setJobMarketList(ArrayList<JobMarketListItem> jobMarketList) {
        this.jobMarketList = jobMarketList;
    }


    public static class JobMarketListResDeSerializer implements JsonDeserializer<JobMarketListRes>
    {

        public JobMarketListRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {



            //Mund te kete edhe ndonje atribut tjeter shtese suportues per security ose per requests monitoring


            JobMarketListRes ret = new JobMarketListRes();

            // OsheeBillResItems[] arr = null;
            ArrayList<JobMarketListItem> jobMarketListInner = new ArrayList<>();

            if (json.isJsonNull()) {
                ret.setJobMarketList(jobMarketListInner);
            } else {

                JsonArray jsonArrayObject = json.getAsJsonArray();


                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
                    //authors[i] = jsonAuthor.getAsString();
                    Gson gson = new GsonBuilder().registerTypeAdapter(JobMarketListItem.class, new JobMarketListItem.JobMarketListItemDeSerializer()).create();
                    JobMarketListItem objItem = gson.fromJson(jItem, JobMarketListItem.class);

                    jobMarketListInner.add(objItem);
                }

                ret.setJobMarketList(jobMarketListInner);
            }

            return ret;
        }

    }


}
