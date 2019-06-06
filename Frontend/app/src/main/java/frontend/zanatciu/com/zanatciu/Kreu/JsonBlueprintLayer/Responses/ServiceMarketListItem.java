package frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceMarketListItem {


    private String id;
    private String username;
    private String title;
    private String description;
    private String type;
    private Integer rate;
    private Integer ratingCount;
    private Date timestamp;

    private String ratingsUri;
    private String applicationsUri;

    private String image;
    private Double price;



    public ServiceMarketListItem() {
    }

    public ServiceMarketListItem(String id, String username, String title, String description, String type, Integer rate, Integer ratingCount, Date timestamp, String ratingsUri, String applicationsUri, String image, Double price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.type = type;
        this.rate = rate;
        this.ratingCount = ratingCount;
        this.timestamp = timestamp;
        this.ratingsUri = ratingsUri;
        this.applicationsUri = applicationsUri;
        this.image = image;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRatingsUri() {
        return ratingsUri;
    }

    public void setRatingsUri(String ratingsUri) {
        this.ratingsUri = ratingsUri;
    }

    public String getApplicationsUri() {
        return applicationsUri;
    }

    public void setApplicationsUri(String applicationsUri) {
        this.applicationsUri = applicationsUri;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static class ServiceMarketListItemDeSerializer implements JsonDeserializer<ServiceMarketListItem> {

        public ServiceMarketListItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonObject jobject = json.getAsJsonObject();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


            ServiceMarketListItem ret = new ServiceMarketListItem();


            if (jobject.get("id").isJsonNull()) {
                ret.setId("");

            } else {

                ret.setId(jobject.get("id").getAsString());
            }


            if (jobject.get("username").isJsonNull()) {
                ret.setUsername("");

            } else {

                ret.setUsername(jobject.get("username").getAsString());
            }

            if (jobject.get("title").isJsonNull()) {
                ret.setTitle("");
            } else {

                ret.setTitle(jobject.get("title").getAsString());
            }

            if (jobject.get("description").isJsonNull()) {
                ret.setDescription("");
            } else {

                ret.setDescription(jobject.get("description").getAsString());
            }

            if (jobject.get("type").isJsonNull()) {
                ret.setType("");
            } else {

                ret.setType(jobject.get("type").getAsString());
            }

            if (jobject.get("rate").isJsonNull()) {
                ret.setRate(0);
            } else {

                ret.setRate(jobject.get("rate").getAsInt());
            }

            if (jobject.get("ratingCount").isJsonNull()) {
                ret.setRatingCount(0);
            } else {

                ret.setRatingCount(jobject.get("ratingCount").getAsInt());
            }


            if (jobject.get("timestamp").isJsonNull()) {

                ret.setTimestamp(null);

            } else {

                try {

                    ret.setTimestamp(format.parse(jobject.get("timestamp").getAsString()));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            if (jobject.get("applicationsUri").isJsonNull()) {
                ret.setApplicationsUri("");
            } else {

                ret.setApplicationsUri(jobject.get("applicationsUri").getAsString());
            }

            if (jobject.get("ratingsUri").isJsonNull()) {
                ret.setRatingsUri("");
            } else {

                ret.setRatingsUri(jobject.get("ratingsUri").getAsString());
            }

            if (jobject.get("image").isJsonNull()) {
                ret.setImage("");
            } else {

                ret.setImage(jobject.get("image").getAsString());
            }

            if (jobject.get("price").isJsonNull()) {
                ret.setPrice(0.0);
            } else {

                ret.setPrice(jobject.get("price").getAsDouble());
            }



            return ret;

        }
    }

}
