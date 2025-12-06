public class McDonalds {
    //Constructors
    private String storeID;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    //Lat and Lon are coordinates for latitude and longitude
    private String lat;
    private String lon;
    public McDonalds(String storeID, String address, String city, String state, String zip, String phoneNumber, String lat, String lon){
        this.storeID = storeID;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.lat = lat;
        this.lon = lon;
    }
    //Getters and setters
    public String getStoreID() {
        return storeID;
    }
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLon() {
        return lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
    public void Display(){
        System.out.println("/////////////////////");
        System.out.println("Store ID: " + this.storeID);
        System.out.println("Address: " + this.address);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip Code: " + this.zip);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("Coordinates: " + this.lat + "," + this.lon);
        System.out.println("/////////////////////");
        
    }
    
}
