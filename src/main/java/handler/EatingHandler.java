package handler;

import model.Product;
import model.Recipe;

import java.util.Map;

public class EatingHandler {
    public void handle(Recipe recipe){
        preliminaryProcessing(recipe.getIngredients());
        basicProcessing(recipe.getIngredients());
        finalProcessing(recipe.getIngredients());
    }


    private void preliminaryProcessing(Map<Product,Integer> ingredients){

    }

    private void basicProcessing(Map<Product,Integer> ingredients){

    }

    private void finalProcessing(Map<Product,Integer> ingredients){

    }
}
