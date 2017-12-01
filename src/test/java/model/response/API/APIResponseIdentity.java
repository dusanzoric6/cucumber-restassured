
package model.response.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class APIResponseIdentity {

    @SerializedName("searchResponse")
    @Expose
    private SearchResponse searchResponse;

    public SearchResponse getSearchResponse() {
        return searchResponse;
    }

    public void setSearchResponse(SearchResponse searchResponse) {
        this.searchResponse = searchResponse;
    }

}
