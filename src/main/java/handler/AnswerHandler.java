package handler;

import answer.Answer;
import answer.EatingType;
import model.Product;
import model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class AnswerHandler {
    private final List<Recipe> recipes;

    public AnswerHandler(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> handle(Answer<EatingType> firstAnswer, Answer<Product> secondAnswer){
        List<Recipe> suggestedRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if(recipe.getType().equals(firstAnswer.takeParam())){
                if(recipe.getIngredients().containsKey(secondAnswer.takeParam())){
                    suggestedRecipes.add(recipe);
                }
            }
        }
        return suggestedRecipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
