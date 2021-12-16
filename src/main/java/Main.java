import answer.EatingType;
import context.AnswerContext;
import model.CookingAssistantSystem;
import model.Product;
import model.ProductType;
import model.Recipe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String choice;

        List<Recipe> recipes = new ArrayList<>();
        Map<Product,Integer> products = new HashMap<>();
        Recipe currentRecipe = new Recipe(products, EatingType.BREAKFAST);
        CookingAssistantSystem cookingAssistantSystem = new CookingAssistantSystem(recipes,products,currentRecipe);

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextLine();

        AnswerContext context = new AnswerContext(new Product("tomato", ProductType.VEGETABLES),EatingType.DINNER);

        cookingAssistantSystem.addProducts(products);
        switch (choice){
            case "continue to cook":
                cookingAssistantSystem.continueCooking();
            case "find a new recipe":
                cookingAssistantSystem.viewRecipeCatalog();
                cookingAssistantSystem.findNewRecipe(context);
        }
    }
}
