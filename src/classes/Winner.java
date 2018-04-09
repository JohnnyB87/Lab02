package classes;

import java.io.Serializable;

public class Winner implements Serializable{

    private String fName;
    private String lName;
    private int prizeValue;

    public Winner(int prizeValue){
        this.prizeValue = prizeValue;
    }

    public Winner(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public Winner(String fName, String lName, int prizeValue){
        this.fName = fName;
        this.lName = lName;
        this.prizeValue = prizeValue;
    }

    //---------------------------
    //          GETTERS
    //---------------------------
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    //---------------------------
    //          SETTERS
    //---------------------------
    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPrizeValue(int prizeValue) {
        this.prizeValue = prizeValue;
    }
}
