
package model.query.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EsMatchRequest {

    @SerializedName("ssn")
    @Expose
    private String ssn;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("address")
    @Expose
    private Address address;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
