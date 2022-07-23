package queryRepo.profiles;

import Models.Collections;
import Models.DataBase;
import Repository.DataRepo;
import operations.compositional.CompositionalOperationFactory;
import operations.compositional.Operator;
import org.json.JSONObject;
import queryRepo.QueryType;

import java.util.List;

public class SearchDoc extends QueryType {

    JSONObject qParams = null;
    String dbName = null;
    String collectionName = null;

    @Override
    public String getType() {
        return "SEARCH_DOC";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {

        try {
            qParams = cmd.getJSONObject("query");
            dbName = cmd.getString("dB");
            collectionName = cmd.getString("collection");
        }catch(Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean execute(DataRepo repo) {

        try{
            DataBase db = repo.getDb(dbName);
            if(db == null){
                System.out.println("Invalid dB ...");
                return false;
            }
            Collections collections = db.getCollection(collectionName);
            if(collections==null){
                System.out.println("Invalid Collections ...");
                return false;
            }

            List<JSONObject> docList = collections.getAllDocs();
            String compositionalOp = qParams.names().getString(0);
            Operator operator = CompositionalOperationFactory.valueOf(compositionalOp).getOperator(qParams.getJSONArray(compositionalOp));
            for(JSONObject doc: docList){
                if(operator.operate(doc))
                    System.out.println(doc.toString());
            }

        }catch(Exception e){
            return false;
        }
        return true;
    }
}
