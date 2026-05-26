package ServiceCentre.config.entity;

public class Customer {
    private int ID;
    private String USER_NAME;
    private String CONTACT ;

    public Customer(int ID, String USER_NAME, String CONTACT) {
        this.ID = ID;
        this.USER_NAME = USER_NAME;
        this.CONTACT = CONTACT;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    @Override
    public String toString() {
        return "[ CUSTOMER ID: "+ID+", NAME:"+USER_NAME+",CONTACT: "+CONTACT+" ]";
    }


}
