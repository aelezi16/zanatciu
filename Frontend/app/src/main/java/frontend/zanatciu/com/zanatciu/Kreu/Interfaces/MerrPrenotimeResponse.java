package frontend.zanatciu.com.zanatciu.Kreu.Interfaces;


import frontend.zanatciu.com.zanatciu.Kreu.JsonBlueprintLayer.Responses.PrenotimeSherbimiRes;

public interface MerrPrenotimeResponse<PrenotimeSherbimiRes> {

    void onPostTaskPrenotime(PrenotimeSherbimiRes prenotimeSherbimiRes);

}
