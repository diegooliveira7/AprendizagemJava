package strategy;

public class Frete {
    private FreteServico servico;

    public Frete(FreteServico servico) {
        this.servico = servico;
    }

    public float calcula(float peso) {
        float valueTotal = this.servico.calcular(peso);
        return valueTotal;
    }
}
