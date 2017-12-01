
package model.singleIdentity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("searchBucket")
    @Expose
    private List<SearchBucket> searchBucket = null;

    public List<SearchBucket> getSearchBucket() {
        return searchBucket;
    }

    public void setSearchBucket(List<SearchBucket> searchBucket) {
        this.searchBucket = searchBucket;
    }

}
