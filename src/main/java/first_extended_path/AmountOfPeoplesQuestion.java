package first_extended_path;

import answer.Answer;
import question.Question;

public class AmountOfPeoplesQuestion implements Question<Integer> {
    private final static String QUESTION_TEXT = "How many people to cook?";
    private Answer<Integer> answer;

    public AmountOfPeoplesQuestion(Answer<Integer> answer) {
        System.out.println(QUESTION_TEXT);
        this.answer = answer;
    }

    @Override
    public void fillAnswer(Answer<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public Answer<Integer> takeAnswer() {
        return answer;
    }


}
