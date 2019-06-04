package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Settings;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.AplikoRes;
import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.JobMarketListItem;
import frontend.zanatciu.com.zanatciu.Utilities.BaseResponses.BaseRes;

public class LoginRes extends BaseRes implements Serializable {



    private String id;
    private String username;
    private String password;
    private boolean status;
    private List<String> roles;
    private String firstName;
    private String lastName;
    private String gender;
    private String personalNo;
    private String phoneNo;
    private String description;
    private Date birthday;
    private Double rating; //
    private String email;
    private Settings settings;//
    private String image;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static class LoginResDeSerializer implements JsonDeserializer<LoginRes> {

        public LoginRes deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {



            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            JsonObject jobject = json.getAsJsonObject();


            LoginRes ret = new LoginRes();

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

            if (jobject.get("password").isJsonNull()) {
                ret.setPassword("");

            } else {

                ret.setPassword(jobject.get("password").getAsString());
            }

            if (jobject.get("status").isJsonNull()) {
                ret.setResult(false);
            } else {

                ret.setResult(jobject.get("status").getAsBoolean());
            }

            if (jobject.get("roles").isJsonNull()) {
                ret.setRoles(null);
            } else {

                JsonArray jsonArrayObject = jobject.get("roles").getAsJsonArray();
                List<String> rolesInner=new ArrayList<>();

                for (int i = 0; i < jsonArrayObject.size(); i++) {

                    final JsonElement jItem = jsonArrayObject.get(i);
                    //authors[i] = jsonAuthor.getAsString();
                    Gson gson = new Gson();
                    String objItem = gson.fromJson(jItem, String.class);


                    rolesInner.add(objItem);
                }

                ret.setRoles(rolesInner);
            }

            if (jobject.get("firstName").isJsonNull()) {
                ret.setFirstName("");
            } else {

                ret.setFirstName(jobject.get("firstName").getAsString());
            }


            if (jobject.get("lastName").isJsonNull()) {
                ret.setLastName("");

            } else {

                ret.setLastName(jobject.get("lastName").getAsString());
            }

            if (jobject.get("gender").isJsonNull()) {
                ret.setGender("");

            } else {

                ret.setGender(jobject.get("gender").getAsString());
            }

            if (jobject.get("personalNo").isJsonNull()) {
                ret.setPersonalNo("");

            } else {

                ret.setPersonalNo(jobject.get("personalNo").getAsString());
            }

            if (jobject.get("phoneNo").isJsonNull()) {
                ret.setPhoneNo("");

            } else {

                ret.setPhoneNo(jobject.get("phoneNo").getAsString());
            }

            if (jobject.get("description").isJsonNull()) {
                ret.setDescription("");

            } else {

                ret.setDescription(jobject.get("description").getAsString());
            }

            if (jobject.get("birthday").isJsonNull()) {
                ret.setBirthday(null);

            } else {

                try {

                    ret.setBirthday(format.parse(jobject.get("birthday").getAsString()));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            if (jobject.get("rating").isJsonNull()) {
                ret.setRating(0.0);

            } else {

                ret.setRating(jobject.get("rating").getAsDouble());
            }


            if (jobject.get("email").isJsonNull()) {
                ret.setEmail("");

            } else {

                ret.setEmail(jobject.get("email").getAsString());
            }

            if (jobject.get("settings").isJsonNull()) {
                ret.setSettings(null);

            } else {

                Gson gson = new GsonBuilder().registerTypeAdapter(Settings.class, new Settings.SettingsDeSerializer()).create();
                Settings objItem = gson.fromJson(jobject.get("settings").getAsString(), Settings.class);
                ret.setSettings(objItem);
            }

            if (jobject.get("image").isJsonNull()) {
                ret.setImage("");

            } else {

                ret.setImage(jobject.get("image").getAsString());
            }


            return ret;
        }
    }

}
