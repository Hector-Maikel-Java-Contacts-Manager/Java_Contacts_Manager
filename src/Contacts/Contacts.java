package Contacts;


import java.io.Serializable;

public class Contacts implements Serializable {
    private String name;
    private String callSign;
    private String number;


    // Constructor
    public Contacts(String name, String callSign, String number) {
        this.name = name;
        this.callSign = callSign;
        this.number = number;
    }

    // Name Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Call-Sign Getter & Setter
    public String getCallSign() {
        return callSign;
    }
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    // Number Getter & Setter
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
