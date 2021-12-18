package first_extended_path;

import answer.Answer;

public class AmountPeoplesAnswer implements Answer<Integer> {
    private final Integer amount;

    public AmountPeoplesAnswer(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Integer takeParam() {
        return amount;
    }
}
