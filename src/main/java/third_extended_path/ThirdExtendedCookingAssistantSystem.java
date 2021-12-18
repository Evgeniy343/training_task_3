package third_extended_path;

import context.AnswerContext;
import model.CookingAssistantSystem;
import model.Product;
import model.Recipe;
import second_extended_path.AllergyException;

import java.util.List;
import java.util.Map;

public class ThirdExtendedCookingAssistantSystem extends CookingAssistantSystem {

    public ThirdExtendedCookingAssistantSystem(List<Recipe> recipes, Map<Product, Integer> products, Recipe currentRecipe) {
        super(recipes, products, currentRecipe);
    }

    @Override
    public List<Recipe> findNewRecipe(AnswerContext context) throws AllergyException {
        return super.findNewRecipe(context);
    }

    public void changeProduct(AnswerContext context, Product newProduct) throws AllergyException {
        showRecipes(this.findNewRecipe(context));
        context.setProduct(newProduct);
        showRecipes(this.findNewRecipe(context));
    }
}
