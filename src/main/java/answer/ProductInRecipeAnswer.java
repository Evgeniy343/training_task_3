package answer;

import model.Product;

public class ProductInRecipeAnswer implements Answer<Product> {
    private final Product product;

    public ProductInRecipeAnswer(Product product) {
        this.product = product;
    }

    @Override
    public Product takeParam() {
        return product;
    }
}
