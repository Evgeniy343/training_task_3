package second_extended_path;

import context.AnswerContext;
import model.CookingAssistantSystem;
import model.Product;
import model.Recipe;

import java.util.List;
import java.util.Map;

public class SecondExtendedCookingAssistantSystem extends CookingAssistantSystem {
    private final Allergy allergy;

    public SecondExtendedCookingAssistantSystem(List<Recipe> recipes, Map<Product, Integer> products
            , Recipe currentRecipe, Allergy allergy) {
        super(recipes, products, currentRecipe);
        this.allergy = allergy;
    }

    @Override
    public List<Recipe> findNewRecipe(AnswerContext context) throws AllergyException {
        if(allergy.getAllergyName().equals(context.getProduct().getName())){
            throw new AllergyException(String.format("The user is allergic to %s",allergy.getAllergyName()));
        }
        return super.findNewRecipe(context);
    }

    public Allergy getAllergy() {
        return allergy;
    }
}
