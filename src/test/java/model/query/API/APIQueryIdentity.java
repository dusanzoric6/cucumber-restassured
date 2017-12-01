
package model.query.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIQueryIdentity {

    @SerializedName("txID")
    @Expose
    private String txID;
    @SerializedName("cidcancount")
    @Expose
    private String cidcancount;
    @SerializedName("esMatchRequest")
    @Expose
    private EsMatchRequest esMatchRequest;

    public String getTxID() {
        return txID;
    }

    public void setTxID(String txID) {
        this.txID = txID;
    }

    public String getCidcancount() {
        return cidcancount;
    }

    public void setCidcancount(String cidcancount) {
        this.cidcancount = cidcancount;
    }

    public EsMatchRequest getEsMatchRequest() {
        return esMatchRequest;
    }

    public void setEsMatchRequest(EsMatchRequest esMatchRequest) {
        this.esMatchRequest = esMatchRequest;
    }

}
