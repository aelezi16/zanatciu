package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.io.Serializable;
import java.lang.reflect.Type;

import frontend.zanatciu.com.zanatciu.Utilities.BaseRequests.BaseReq;




public class LoginReq extends BaseReq implements Serializable {

    private String userName;
    private String passWord;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }




    public static class LoginSerializer implements JsonSerializer<LoginReq> {
        public JsonElement serialize(final LoginReq obj, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();


            if (obj.getUserName() == null )
            {
                result.add("userName", new JsonPrimitive(""));
            }
            else {

                result.add("userName", new JsonPrimitive(obj.getUserName()));
            }


            if (obj.getPassWord() == null ) {
                result.add("passWord", new JsonPrimitive(""));
            }
            else
            {
                result.add("passWord", new JsonPrimitive(obj.getPassWord()));
            }



            return result;
        }
    }
}
