
package model.query.ESApp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConsumerIdentity {

    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    @SerializedName("ssn")
    @Expose
    private String ssn;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses = null;

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}
