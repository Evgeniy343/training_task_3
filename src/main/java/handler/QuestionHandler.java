package handler;

import answer.Answer;
import question.Question;

public interface QuestionHandler<T> {

    void handle(Question<T> question, Answer<T> answer);
}
