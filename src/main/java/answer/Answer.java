package answer;

import context.AnswerContext;
import type.QuestionOrAnswerType;

public interface Answer<T> {
    static Answer newInstance(QuestionOrAnswerType answerType, AnswerContext context) {
        return switch (answerType) {
            case EATING_TIME -> new EatingTypeAnswer(context.getEatingType());
            case PRODUCT_IN_RECIPE -> new ProductInRecipeAnswer(context.getProduct());
        };
    }

    T takeParam();
}
