package frontend.zanatciu.com.zanatciu.Funksionalitete.Interfaces;

import frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer.Responses.TokenRes;

public interface LoginResponse <LoginRes>{

    void onPostTaskLogin(LoginRes loginRes);
}
