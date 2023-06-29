import java.util.Arrays;
import java.util.List;

public class Stream_Reduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 9, 6, 3, 7, 12, 5, 7, 9, 1);

        //O reduce vai trasnformar tds os elementos da sua lista em um único elemento

        int value1 = list.stream().reduce((n1, n2) -> n1 + n2).get();
        //Na primeira iteração o n1 = 3 e o n2 = 9, vai ser feito uma soma e o resultado vai se tornar o n1
        //na próxima iteração e vai somando todos os elementos da lista
        System.out.println(value1);
    }
    
}
