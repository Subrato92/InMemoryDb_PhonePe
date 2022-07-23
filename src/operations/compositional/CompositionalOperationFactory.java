package operations.compositional;

import org.json.JSONArray;

public enum CompositionalOperationFactory {
    and{
        @Override
        public Operator getOperator(JSONArray conditions) {
            return new AndOperation(conditions);
        }
    }, or{
        @Override
        public Operator getOperator(JSONArray conditions) {
            return new OROperation(conditions);
        }
    };

    public abstract Operator getOperator(JSONArray conditions);
}
