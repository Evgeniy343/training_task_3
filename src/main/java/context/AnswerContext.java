package context;

import answer.EatingType;
import model.Product;

public class AnswerContext {
    private Product product;
    private final EatingType eatingType;

    public AnswerContext(Product product, EatingType eatingType) {
        this.product = product;
        this.eatingType = eatingType;
    }

    public EatingType getEatingType() {
        return eatingType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
