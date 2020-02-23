public class Contact implements Comparable<Contact> {
    private String firstN;
    private String lastN;
    private String phoneN;
    private String streetAddress;
    private String cityN;
    private String stateN;

    //initial constructor for another to compare
    public Contact() {
        this("Neo","Chen","1", "Henry", "New York", "NY");
    }

    //Constructor to initial all the field
    public Contact(String firstN, String lastN, String phoneN, String streetAddress, String cityN, String stateN) {
        this.firstN = firstN;
        this.lastN = lastN;
        this.phoneN = phoneN;
        this.streetAddress = streetAddress;
        this.cityN = cityN;
        this.stateN = stateN;
    }

    public int compareTo(Contact t1)
    {
        if(this.firstN == t1.firstN && this.lastN == t1.lastN &&
                this.phoneN==t1.phoneN && this.streetAddress == t1.streetAddress &&
                this.cityN==t1.cityN && this.stateN == t1.stateN)
        {
            return 1;
        }
        return -1;
    }


    //Constructor only initial Name and Phone Num;
    public Contact(String firstN, String lastN, String phoneN) {
        this(firstN, lastN, phoneN, "", "", "");
    }

    //Getter
    public String getFirstN() {
        return this.firstN;
    }

    public String getLastN() {
        return this.lastN;
    }

    public String getPhoneN() {
        return this.phoneN;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getCityN() {
        return this.cityN;
    }

    public String getStateN() {
        return this.stateN;
    }

    //Setter
    public void setFirstN(String x) {
        this.firstN = x;
    }

    public void setLastN(String x) {
        this.lastN = x;
    }

    public void setPhoneN(String x) {
        this.phoneN = x;
    }

    public void setStreetAddress(String x) {
        this.streetAddress = x;
    }

    public void setCityN(String x) {
        this.cityN = x;
    }

    public void setStateN(String x) {
        this.stateN = x;
    }

    //Override the toString method
    public String toString ()
    {
        return "Name: "+ firstN + " " + lastN + "  Phone#: " + phoneN + " \nStreet: " + streetAddress +
                    " \nCity: " + cityN + ", State: " + stateN + "\n";
    }
}

