package operations.compositional;

import operations.conditional.ConditionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class OROperation implements Operator {
    protected JSONArray conditions = null;
    public OROperation(JSONArray conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean operate(JSONObject doc) {
        boolean sol = false;
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

                if(sol)
                    return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public String getOperationType() {
        return "OR";
    }
}
