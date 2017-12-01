
package model.singleIdentity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleIdentity {

    @SerializedName("keyResponse")
    @Expose
    private KeyResponse keyResponse;

    public KeyResponse getKeyResponse() {
        return keyResponse;
    }

    public void setKeyResponse(KeyResponse keyResponse) {
        this.keyResponse = keyResponse;
    }

}
