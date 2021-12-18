import answer.EatingType;
import context.AnswerContext;
import first_extended_path.ExtendedAnswerContext;
import first_extended_path.FirstExtendedCookingAssistantSystem;
import model.*;
import second_extended_path.Allergy;
import second_extended_path.AllergyException;
import second_extended_path.SecondExtendedCookingAssistantSystem;
import third_extended_path.ThirdExtendedCookingAssistantSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String choice;

        List<Recipe> recipes = new ArrayList<>();
        Map<Product,Integer> products = new HashMap<>();
        Recipe currentRecipe = new Recipe(products, EatingType.BREAKFAST);
        CookingAssistantSystem cookingAssistantSystem = new CookingAssistantSystem(recipes,products,currentRecipe);

        Scanner scanner1 = new Scanner(System.in);
        choice = scanner1.nextLine();

        AnswerContext context = new AnswerContext(new Product("tomato", ProductType.VEGETABLES),EatingType.DINNER);

        cookingAssistantSystem.addProducts(products);
        switch (choice){
            case "continue to cook":
                cookingAssistantSystem.continueCooking();
            case "find a new recipe":
                cookingAssistantSystem.viewRecipeCatalog();
                try {
                    List<Recipe> suggestedRecipes = cookingAssistantSystem.findNewRecipe(context);
                } catch (AllergyException e) {
                    e.printStackTrace();
                }
        }


        FirstExtendedCookingAssistantSystem firstExtendedCookingAssistantSystem =
                new FirstExtendedCookingAssistantSystem(recipes,products,currentRecipe);

        Scanner scanner2 = new Scanner(System.in);
        choice = scanner2.nextLine();

        AnswerContext firstExtendedContext = new ExtendedAnswerContext(new Product("tomato"
                , ProductType.VEGETABLES),EatingType.DINNER,10);

        firstExtendedCookingAssistantSystem.addProducts(products);
        switch (choice){
            case "continue to cook":
                firstExtendedCookingAssistantSystem.continueCooking();
            case "find a new recipe":
                firstExtendedCookingAssistantSystem.viewRecipeCatalog();
                try {
                    List<Recipe> suggestedRecipes = firstExtendedCookingAssistantSystem
                            .findNewRecipe(firstExtendedContext);
                } catch (AllergyException e) {
                    e.printStackTrace();
                }
        }

        SecondExtendedCookingAssistantSystem secondExtendedCookingAssistantSystem =
                new SecondExtendedCookingAssistantSystem(recipes,products,currentRecipe,new Allergy("tomato"));

        Scanner scanner3 = new Scanner(System.in);
        choice = scanner3.nextLine();

        secondExtendedCookingAssistantSystem.addProducts(products);
        switch (choice){
            case "continue to cook":
                secondExtendedCookingAssistantSystem.continueCooking();
            case "find a new recipe":
                secondExtendedCookingAssistantSystem.viewRecipeCatalog();
                try {
                    List<Recipe> suggestedRecipes = secondExtendedCookingAssistantSystem.findNewRecipe(context);
                } catch (AllergyException e) {
                    e.printStackTrace();
                }
        }

        ThirdExtendedCookingAssistantSystem thirdExtendedCookingAssistantSystem =
                new ThirdExtendedCookingAssistantSystem(recipes,products,currentRecipe);

        Scanner scanner4 = new Scanner(System.in);
        choice = scanner4.nextLine();

        thirdExtendedCookingAssistantSystem.addProducts(products);
        switch (choice){
            case "continue to cook":
                thirdExtendedCookingAssistantSystem.continueCooking();
            case "find a new recipe":
                thirdExtendedCookingAssistantSystem.viewRecipeCatalog();
                try {
                    thirdExtendedCookingAssistantSystem.changeProduct(context
                            ,new Product("banana",ProductType.FRUITS));
                } catch (AllergyException e) {
                    e.printStackTrace();
                }
        }
    }
}
