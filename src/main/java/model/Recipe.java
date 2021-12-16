package model;

import answer.EatingType;

import java.io.Serializable;
import java.util.Map;

public class Recipe implements Serializable {
    private final Map<Product,Integer> ingredients;
    private final EatingType type;

    public Recipe(Map<Product, Integer> ingredients, EatingType type) {
        this.ingredients = ingredients;
        this.type = type;
    }

    public EatingType getType() {
        return type;
    }

    public Map<Product, Integer> getIngredients() {
        return ingredients;
    }
}
