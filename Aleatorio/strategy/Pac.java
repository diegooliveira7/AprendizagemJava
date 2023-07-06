package strategy;

public class Pac implements FreteServico{
    @Override
    public float calcular(float value) {
        float valueTotal = value * 5;
        return valueTotal;
    }
}
