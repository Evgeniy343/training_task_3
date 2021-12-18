package question;

import answer.Answer;

public interface Question<T> {

    void fillAnswer(Answer<T> answer);
    Answer<T> takeAnswer();
}
