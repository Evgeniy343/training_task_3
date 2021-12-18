package first_extended_path;

import answer.Answer;
import context.AnswerContext;
import handler.QuestionHandler;
import model.CookingAssistantSystem;
import model.Product;
import model.Recipe;
import question.Question;
import second_extended_path.AllergyException;

import java.util.List;
import java.util.Map;

public class FirstExtendedCookingAssistantSystem extends CookingAssistantSystem {
    private Question<Integer> thirdQuestion;

    public FirstExtendedCookingAssistantSystem(List<Recipe> recipes, Map<Product, Integer> products
            , Recipe currentRecipe) {
        super(recipes, products, currentRecipe);
    }

    @Override
    public List<Recipe> findNewRecipe(AnswerContext context) throws AllergyException {
        List<Recipe> suggestedRecipes = super.findNewRecipe(context);
        ExtendedAnswerContext extendedContext = (ExtendedAnswerContext) context;

        Answer<Integer> thirdAnswer = new AmountPeoplesAnswer(extendedContext.getAmountOfPeoples());
        thirdQuestion = new AmountOfPeoplesQuestion(thirdAnswer);

        QuestionHandler<Integer> amountOfPeopleQuestionHandler = Question::fillAnswer;
        amountOfPeopleQuestionHandler.handle(thirdQuestion, thirdAnswer);

        return suggestedRecipes;
    }

    @Override
    public void continueCooking() {
        for (int i = 0; i < thirdQuestion.takeAnswer().takeParam(); i++) {
            super.continueCooking();
        }
    }

    public Question<Integer> getThirdQuestion() {
        return thirdQuestion;
    }
}
