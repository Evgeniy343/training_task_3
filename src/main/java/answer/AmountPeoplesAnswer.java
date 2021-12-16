package answer;

public class AmountPeoplesAnswer implements Answer{
    private final Integer amount;

    public AmountPeoplesAnswer(Integer amount) {
        this.amount = amount;
    }

    @Override
    public Object takeParam() {
        return amount;
    }
}
