package strategy;

public class DHL implements FreteServico{
    @Override
    public float calcular(float value) {
        float valueTotal = value * 3;
        return valueTotal;
    }
}
