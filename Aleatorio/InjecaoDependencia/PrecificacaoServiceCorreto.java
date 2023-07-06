package InjecaoDependencia;

import java.math.BigDecimal;

public class PrecificacaoServiceCorreto {
    CalculadoraImposto calculadoraImposto;

    //Ele não vai depender de uma classe e sim da interface de um contrato
    public PrecificacaoServiceCorreto(CalculadoraImposto calcular) {
        this.calculadoraImposto = calcular;
    }

    public BigDecimal calcularPreco(Produto produto) {
        return this.calculadoraImposto.calcular(produto);
    }
}
