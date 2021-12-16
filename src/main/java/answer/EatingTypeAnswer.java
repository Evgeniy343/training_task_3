package answer;

public class EatingTypeAnswer implements Answer<EatingType> {
    private final EatingType type;

    public EatingTypeAnswer(EatingType type) {
        this.type = type;
    }

    @Override
    public EatingType takeParam() {
        return type;
    }
}
