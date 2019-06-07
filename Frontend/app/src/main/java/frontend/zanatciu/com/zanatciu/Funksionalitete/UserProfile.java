package frontend.zanatciu.com.zanatciu.Funksionalitete;

public class UserProfile {

    private String Username;
    private String Emri;
    private String Mbiemri;
    private String Profesioni;
    private String Perdouresi;
    private String Email;
    private String NrTelefoni;
    private String SecretKey;
    private int IDStatus;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmri() {
        return Emri;
    }

    public void setEmri(String emri) {
        Emri = emri;
    }

    public String getMbiemri() {
        return Mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        Mbiemri = mbiemri;
    }

    public String getProfesioni() {
        return Profesioni;
    }

    public void setProfesioni(String profesioni) {
        Profesioni = profesioni;
    }

    public String getPerdouresi() {
        return Perdouresi;
    }

    public void setPerdouresi(String perdouresi) {
        Perdouresi = perdouresi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNrTelefoni() {
        return NrTelefoni;
    }

    public void setNrTelefoni(String nrTelefoni) {
        NrTelefoni = nrTelefoni;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public int getIDStatus() {
        return IDStatus;
    }

    public void setIDStatus(int IDStatus) {
        this.IDStatus = IDStatus;
    }

    public static UserProfile getMyObj() {
        return myObj;
    }

    public static void setMyObj(UserProfile myObj) {
        UserProfile.myObj = myObj;
    }

    private static UserProfile myObj;
    /**
     * Create private constructor
     */
    private UserProfile(){

    }
    /**
     * Create a static method to get instance.
     */
    public static UserProfile getInstance(){
        if(myObj == null){
            myObj = new UserProfile();
        }
        return myObj;
    }

    public void getSomeThing(){
        // do something here
        System.out.println("I am here....");
    }

    public static void main(String a[]){
        UserProfile st = UserProfile.getInstance();
        st.getSomeThing();
    }

}
