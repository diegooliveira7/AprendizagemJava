package strategy;

public class StrategyMain {
    public static void main(String[] args) {
        FreteServico metodo = new DHL(); //Quando eu quiser mudar, somente vou ter que mudar o o DHL
        Frete frete = new Frete(metodo);
        System.out.println(frete.calcula(10));
    }
}
