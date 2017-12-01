
package model.response.ESApp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("geoLocation")
    @Expose
    private Object geoLocation;
    @SerializedName("localAddress")
    @Expose
    private Object localAddress;
    @SerializedName("association")
    @Expose
    private Object association;
    @SerializedName("addressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("addressLine2")
    @Expose
    private Object addressLine2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Object getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(Object geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Object getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(Object localAddress) {
        this.localAddress = localAddress;
    }

    public Object getAssociation() {
        return association;
    }

    public void setAssociation(Object association) {
        this.association = association;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Object getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(Object addressLine2) {
        this.addressLine2 = addressLine2;
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

}
