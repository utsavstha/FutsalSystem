package Utils;

/**
 * Created by utsav on 8/24/2015.
 */
public class InformationData {
    private String futsalName;
    private String futsalAddress;
    private String futsalDescription;
    private String longitude;
    private String latitude;
    private String contactNumber;
    private int rating;

    public String getContactNumber() {
        return contactNumber;
    }

    public int getRating() {
        return rating;
    }

    public String getFutsalName() {
        return futsalName;
    }

    public String getFutsalAddress() {
        return futsalAddress;
    }

    public String getFutsalDescription() {
        return futsalDescription;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public InformationData(String futsalName, String futsalAddress, String futsalDescription, String longitude, String latitude, int rating, String contactNumber) {
        this.futsalName = futsalName;
        this.futsalAddress = futsalAddress;
        this.futsalDescription = futsalDescription;
        this.longitude = longitude;
        this.latitude = latitude;
        this.rating = rating;
        this.contactNumber = contactNumber;
    }
}
