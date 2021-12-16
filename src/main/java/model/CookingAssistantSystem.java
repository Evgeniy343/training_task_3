package model;

import answer.Answer;
import answer.EatingType;
import context.AnswerContext;
import handler.AnswerHandler;
import handler.EatingHandler;
import question.Question;
import handler.QuestionHandler;
import type.QuestionOrAnswerType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CookingAssistantSystem {
    private final List<Recipe> recipes;
    private final Map<Product,Integer> products;
    private final Recipe currentRecipe;

    public CookingAssistantSystem(List<Recipe> recipes, Map<Product, Integer> products, Recipe currentRecipe) {
        this.recipes = recipes;
        this.products = products;
        this.currentRecipe = currentRecipe;
    }

    public List<Recipe> findNewRecipe(AnswerContext context){

        Question<EatingType> firstQuestion = Question.newInstance(QuestionOrAnswerType.EATING_TIME);
        Question<Product> secondQuestion = Question.newInstance(QuestionOrAnswerType.PRODUCT_IN_RECIPE);

        Answer<EatingType> firstAnswer = Answer.newInstance(QuestionOrAnswerType.EATING_TIME, context);
        Answer<Product> secondAnswer = Answer.newInstance(QuestionOrAnswerType.PRODUCT_IN_RECIPE,context);

        QuestionHandler handler = new QuestionHandler();
        handler.handle(firstQuestion, QuestionOrAnswerType.EATING_TIME, firstAnswer);
        handler.handle(secondQuestion, QuestionOrAnswerType.PRODUCT_IN_RECIPE, secondAnswer);

        AnswerHandler answerHandler = new AnswerHandler(recipes);
        List<Recipe> suggestedRecipes = answerHandler.handle(firstAnswer, secondAnswer);
        return suggestedRecipes;
    }

    public void continueCooking(){
        EatingHandler eatingHandler = new EatingHandler();
        eatingHandler.handle(currentRecipe);
    }

    public void viewRecipeCatalog(){
        for (Recipe recipe : recipes) {
            System.out.println(recipe.toString());
        }
    }

    public void addProducts(Map<Product,Integer> products){
        Set<Product> productNames = products.keySet();
        List<Product> productNamesList = productNames.stream().toList();
        for (Product product : productNamesList) {
            this.products.put(product,products.get(product));
        }
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Recipe getCurrentRecipe() {
        return currentRecipe;
    }
}
