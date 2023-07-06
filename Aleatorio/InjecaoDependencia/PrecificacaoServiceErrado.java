package InjecaoDependencia;

import java.math.BigDecimal;

public class PrecificacaoServiceErrado {
    private CalculadoraimportoSimplesNacional calcImposto = new CalculadoraimportoSimplesNacional();

    public BigDecimal calcularPreco(Produto produto) {
        return this.calcImposto.calcular(produto);
    }
}
