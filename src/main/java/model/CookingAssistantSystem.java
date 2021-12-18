package model;

import answer.Answer;
import answer.EatingType;
import answer.EatingTypeAnswer;
import answer.ProductInRecipeAnswer;
import context.AnswerContext;
import handler.AnswerHandler;
import handler.EatingHandler;
import handler.QuestionHandler;
import question.EatingTypeQuestion;
import question.ProductInRecipeQuestion;
import question.Question;
import second_extended_path.AllergyException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CookingAssistantSystem {
    private final List<Recipe> recipes;
    private final Map<Product,Integer> products;
    private final Recipe currentRecipe;
    private Question<EatingType> firstQuestion;
    private Question<Product> secondQuestion;

    public CookingAssistantSystem(List<Recipe> recipes, Map<Product, Integer> products, Recipe currentRecipe) {
        this.recipes = recipes;
        this.products = products;
        this.currentRecipe = currentRecipe;
    }

    public List<Recipe> findNewRecipe(AnswerContext context) throws AllergyException {

        firstQuestion = new EatingTypeQuestion();
        secondQuestion = new ProductInRecipeQuestion();

        Answer<EatingType> firstAnswer = new EatingTypeAnswer(context.getEatingType());
        Answer<Product> secondAnswer = new ProductInRecipeAnswer(context.getProduct());

        QuestionHandler<EatingType> eatingTypeQuestionHandler = Question::fillAnswer;
        eatingTypeQuestionHandler.handle(firstQuestion,firstAnswer);

        QuestionHandler<Product> productRecipeQuestionHandler = Question::fillAnswer;
        productRecipeQuestionHandler.handle(secondQuestion,secondAnswer);



        AnswerHandler answerHandler = new AnswerHandler(recipes);

        List<Recipe> suggestedRecipes = answerHandler.handle(firstQuestion.takeAnswer(),secondQuestion.takeAnswer());
        return suggestedRecipes;
    }

    public void continueCooking(){
        EatingHandler eatingHandler = new EatingHandler();
        eatingHandler.handle(currentRecipe);
    }

    public void showRecipes(List<Recipe> recipes){
        for (Recipe recipe : recipes) {
            System.out.println(recipe.toString());
        }
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

    public Question<EatingType> getFirstQuestion() {
        return firstQuestion;
    }

    public Question<Product> getSecondQuestion() {
        return secondQuestion;
    }
}
