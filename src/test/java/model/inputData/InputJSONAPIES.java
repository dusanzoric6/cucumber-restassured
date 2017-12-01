
package model.inputData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InputJSONAPIES {

    @SerializedName("identity")
    @Expose
    private Identity identity;

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

}
