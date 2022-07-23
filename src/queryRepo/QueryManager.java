package queryRepo;

import Repository.DataRepo;
import org.json.JSONObject;

public class QueryManager {

    private static QueryFactory operationFactory = new QueryFactory();

    synchronized public static void operate(JSONObject cmd){
        boolean isValidOp = false;
        for(QueryType qType: operationFactory.getQueryTypes()){

            if(qType.isMatch(cmd)){
                System.out.println("Match for Query Type : "+qType.getType());
                isValidOp = qType.execute(DataRepo.INSTANCE);
                if(!isValidOp){
                    System.out.println(qType.getType() + " Operation Failed !!! ");
                }
                return;
            }
        }

        System.out.println("Invalid Command - Please Try Again !!!");
    }

}
