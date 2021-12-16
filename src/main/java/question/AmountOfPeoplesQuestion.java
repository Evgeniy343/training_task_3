package question;

import answer.Answer;
import answer.EatingType;

public class AmountOfPeoplesQuestion implements Question{
    private final static String QUESTION_TEXT = "How many people to cook?";
    private Answer<EatingType> answer;

    @Override
    public void fillAnswer(Answer answer) {
        this.answer = answer;
    }
}
