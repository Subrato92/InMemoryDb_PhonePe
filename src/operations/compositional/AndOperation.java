package operations.compositional;

import operations.conditional.ConditionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class AndOperation implements Operator {
    protected JSONArray conditions = null;
    public AndOperation(JSONArray conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean operate(JSONObject doc) {
        boolean sol = true;
        try {
            for (int i=0; i<conditions.length(); i++) {
                JSONObject ele = conditions.getJSONObject(i);
                if (ele.names().length() == 1) {
                    String compositionalOp = ele.names().getString(0);

                    sol = CompositionalOperationFactory.valueOf(compositionalOp)
                            .getOperator(ele.getJSONArray(compositionalOp))
                            .operate(doc);
                } else {
                    String op = ele.getString("op");
                    sol = ConditionFactory.valueOf(op).getCondition(ele).validate(doc);
                }

                if(!sol)
                    return false;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String getOperationType() {
        return "AND";
    }

}
