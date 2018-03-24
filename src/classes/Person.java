package classes;

import java.io.Serializable;

public class Person implements Serializable{

    private String fName;
    private String lName;
    private int prizeValue;

    public Person(){}

    public Person(String fName, String lName, int prizeValue){
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

    public int getPrizeValue() {
        return prizeValue;
    }

    public String getlName() {
        return lName;
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
