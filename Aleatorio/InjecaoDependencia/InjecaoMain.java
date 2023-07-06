package InjecaoDependencia;

import java.math.BigDecimal;

public class InjecaoMain {
    public static void main(String[] args) {
        //A injeção de dependências é uma técnica de aplicar o princípio da inversão.
        Produto produto = new Produto ();
        CalculadoraImposto calcular = new CalculadoraimportoSimplesNacional();
        PrecificacaoServiceCorreto value = new PrecificacaoServiceCorreto(calcular);
        BigDecimal valueT = value.calcularPreco(produto);
    }
}
