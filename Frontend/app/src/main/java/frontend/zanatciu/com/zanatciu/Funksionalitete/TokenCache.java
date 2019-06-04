package frontend.zanatciu.com.zanatciu.Funksionalitete;

public class TokenCache {



    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    private static TokenCache myObj;
    /**
     * Create private constructor
     */
    private TokenCache(){

    }
    /**
     * Create a static method to get instance.
     */
    public static TokenCache getInstance(){
        if(myObj == null){
            myObj = new TokenCache();
        }
        return myObj;
    }
}
