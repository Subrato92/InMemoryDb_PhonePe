package operations.conditional;

import org.json.JSONObject;

public enum ConditionFactory {
    $eq{
        @Override
        public Conditions getCondition(JSONObject element) {
            return new EqualsTo(element);
        }
    },$gt{
        @Override
        public Conditions getCondition(JSONObject element) {
            return new GreaterThan(element);
        }
    },$lt{
        @Override
        public Conditions getCondition(JSONObject element) {
            return new LessThan(element);
        }
    };

    public abstract Conditions getCondition(JSONObject element);
}
