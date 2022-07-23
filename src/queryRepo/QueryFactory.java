package queryRepo;

import queryRepo.profiles.*;

import java.util.ArrayList;
import java.util.List;

public class QueryFactory {

    private List<QueryType> queryTypes = null;

    public QueryFactory(){
        queryTypes = new ArrayList<>();
        queryTypes.add(new CreateDb());
        queryTypes.add(new CreateCollection());
        queryTypes.add(new InsertDoc());
        queryTypes.add(new GetAllDocs());
        queryTypes.add(new ShowCollections());
        queryTypes.add(new ShowDB());
        queryTypes.add(new SearchDoc());
    }

    public List<QueryType> getQueryTypes(){
        return queryTypes;
    }

}
