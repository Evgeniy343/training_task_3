package question;

import answer.Answer;
import answer.EatingType;

public class EatingTypeQuestion implements Question<EatingType> {
    private final static String QUESTION_TEXT = "Cooking breakfast, lunch or dinner?";
    private Answer<EatingType> answer;

    public EatingTypeQuestion() {
        System.out.println(QUESTION_TEXT);
    }

    public Answer<EatingType> getAnswer() {
        return answer;
    }

    @Override
    public void fillAnswer(Answer<EatingType> answer) {
        this.answer = answer;
    }
}
