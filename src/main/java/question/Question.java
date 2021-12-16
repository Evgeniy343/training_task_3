package question;

import answer.Answer;
import type.QuestionOrAnswerType;

public interface Question<T> {
    static Question newInstance(QuestionOrAnswerType type) {
        return switch (type){
            case EATING_TIME -> new EatingTypeQuestion();
            case PRODUCT_IN_RECIPE -> new ProductInRecipeQuestion();
        };
    }

    void fillAnswer(Answer<T> answer);
}
