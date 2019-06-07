package frontend.zanatciu.com.zanatciu.Kreu.Utilities;

public class PageNumberHolder {

    private int counterPageJobs=0;
    private int counterPageServices=0;


    public int getCounterPageJobs() {
        return counterPageJobs;
    }

    public void setCounterPageJobs(int counterPageJobs) {
        this.counterPageJobs = counterPageJobs;
    }

    public int getCounterPageServices() {
        return counterPageServices;
    }

    public void setCounterPageServices(int counterPageServices) {
        this.counterPageServices = counterPageServices;
    }

    public void incrementJobPageCounter(){
        counterPageJobs++;
    }

    public void decrementJobPageCounter(){
        counterPageJobs--;
    }


    public void incrementServicePageCounter(){
        counterPageServices++;
    }

    public void decrementServicePageCounter(){
        counterPageServices--;
    }



    private static PageNumberHolder myObj;
    /**
     * Create private constructor
     */
    private PageNumberHolder(){

    }
    /**
     * Create a static method to get instance.
     */
    public static PageNumberHolder getInstance(){
        if(myObj == null){
            myObj = new PageNumberHolder();
        }
        return myObj;
    }


}
