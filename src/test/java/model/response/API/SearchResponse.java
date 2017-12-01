
package model.response.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("matchFound")
    @Expose
    private Integer matchFound;
    @SerializedName("cidlist")
    @Expose
    private List<String> cidlist = null;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Integer getMatchFound() {
        return matchFound;
    }

    public void setMatchFound(Integer matchFound) {
        this.matchFound = matchFound;
    }

    public List<String> getCidlist() {
        return cidlist;
    }

    public void setCidlist(List<String> cidlist) {
        this.cidlist = cidlist;
    }

}
