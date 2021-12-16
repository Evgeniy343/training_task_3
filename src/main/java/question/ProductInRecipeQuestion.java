package question;

import answer.Answer;
import model.Product;

public class ProductInRecipeQuestion implements Question<Product> {
    private final static String QUESTION_TEXT = "Which one product must be included in the recipe?";
    private Answer<Product> answer;

    public ProductInRecipeQuestion() {
    }

    public Answer<Product> getAnswer() {
        return answer;
    }

    @Override
    public void fillAnswer(Answer<Product> answer) {
        this.answer = answer;
    }
}
