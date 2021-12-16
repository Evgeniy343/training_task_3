package context;

import answer.EatingType;
import model.Product;

public class ExtendedAnswerContext extends AnswerContext{
    private final Integer amountOfPeoples;

    public ExtendedAnswerContext(Product product, EatingType eatingType, Integer amountOfPeoples) {
        super(product, eatingType);
        this.amountOfPeoples = amountOfPeoples;
    }

    public Integer getAmountOfPeoples() {
        return amountOfPeoples;
    }
}
