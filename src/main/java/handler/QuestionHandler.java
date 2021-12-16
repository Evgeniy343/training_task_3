package handler;

import answer.Answer;
import question.Question;
import type.QuestionOrAnswerType;

public class QuestionHandler {
    public void handle(Question question, QuestionOrAnswerType type, Answer answer){
        switch (type){
            case EATING_TIME:
                question.fillAnswer(answer);
            case PRODUCT_IN_RECIPE:
                question.fillAnswer(answer);
        }
    }
}
