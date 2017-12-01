
package model.singleIdentity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyResponse {

    @SerializedName("requestType")
    @Expose
    private String requestType;
    @SerializedName("corelationID")
    @Expose
    private String corelationID;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("recordFound")
    @Expose
    private Integer recordFound;
    @SerializedName("searchResult")
    @Expose
    private SearchResult searchResult;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCorelationID() {
        return corelationID;
    }

    public void setCorelationID(String corelationID) {
        this.corelationID = corelationID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRecordFound() {
        return recordFound;
    }

    public void setRecordFound(Integer recordFound) {
        this.recordFound = recordFound;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

}
