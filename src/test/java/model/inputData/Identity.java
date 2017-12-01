
package model.inputData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identity {

    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("ssn")
    @Expose
    private String ssn;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

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

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

}
