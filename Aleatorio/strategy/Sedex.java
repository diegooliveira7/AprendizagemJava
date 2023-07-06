package strategy;

public class Sedex implements FreteServico{
    @Override
    public float calcular(float value) {
        float valueTotal = value * 2;
        return valueTotal;
    }
}
