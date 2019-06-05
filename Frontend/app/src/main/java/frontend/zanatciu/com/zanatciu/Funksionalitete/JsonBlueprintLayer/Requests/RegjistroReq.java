package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.Serializable;
import java.lang.reflect.Type;

public class RegjistroReq implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String personalNo;
    private String email;
    private String phoneNo;



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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class RegjistroReqSerializer implements JsonSerializer<RegjistroReq> {

        public JsonElement serialize(final RegjistroReq obj, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();


            if (obj.getFirstName() == null )
            {
                result.add("firstName", new JsonPrimitive(""));
            }
            else {

                result.add("firstName", new JsonPrimitive(obj.getFirstName()));
            }


            if (obj.getLastName() == null ) {
                result.add("lastName", new JsonPrimitive(""));
            }
            else
            {
                result.add("lastName", new JsonPrimitive(obj.getLastName()));
            }

            if (obj.getUsername() == null ) {
                result.add("username", new JsonPrimitive(""));
            }
            else
            {
                result.add("username", new JsonPrimitive(obj.getUsername()));
            }

            if (obj.getPassword() == null ) {
                result.add("password", new JsonPrimitive(""));
            }
            else
            {
                result.add("password", new JsonPrimitive(obj.getPassword()));
            }

            if (obj.getPersonalNo() == null ) {
                result.add("personalNo", new JsonPrimitive(""));
            }
            else
            {
                result.add("personalNo", new JsonPrimitive(obj.getPersonalNo()));
            }

            if (obj.getEmail() == null ) {
                result.add("email", new JsonPrimitive(""));
            }
            else
            {
                result.add("email", new JsonPrimitive(obj.getEmail()));
            }

            if (obj.getEmail() == null ) {
                result.add("phoneNo", new JsonPrimitive(""));
            }
            else
            {
                result.add("phoneNo", new JsonPrimitive(obj.getEmail()));
            }



            return result;
        }
    }
}
