package question;

import answer.Answer;
import answer.EatingType;

public class EatingTypeQuestion implements Question<EatingType> {
    private final static String QUESTION_TEXT = "Cooking breakfast, lunch or dinner?";
    private Answer<EatingType> answer;

    public EatingTypeQuestion() {
        System.out.println(QUESTION_TEXT);
    }

    @Override
    public void fillAnswer(Answer<EatingType> answer) {
        this.answer = answer;
    }

    @Override
    public Answer<EatingType> takeAnswer() {
        return answer;
    }
}
