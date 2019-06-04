package frontend.zanatciu.com.zanatciu.Funksionalitete.JsonBlueprintLayer;

public enum Role {

    JOB_PROVIDER,
    SERVICE_PROVIDER,
    JOB_SEEKER,
    SERVICE_SEEKER;

    private String getName(){
        return this.name();
    }
}
