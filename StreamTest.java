import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] arg) {
        List<Integer> list = Arrays.asList(2,5,4,2,7,5,2,12);

        //O stream serve para fazer interações dentro de uma lista
        //Com o stream n se modifica a lista original

        list.stream()
                .skip(2)//aqui ele vai definir onde vai começar a lista
                .limit(3)//aqui ele vai definir quantos itens vão ser mostrados
                .distinct()//aqui vai mostrar os distintos e não os repetidos, mesma ideia do equals
                .forEach(e -> System.out.println(e));

        System.out.println("----------------------");
        list.stream().forEach(e -> {
            if (e % 2 == 0) {
                System.out.println(e + ": É par");
            } else {
                System.out.println(e + ": É impar");
            }
        });

        System.out.println("----------------------");
        list.stream().filter(e -> e% 2 == 0)// o filter é uma forma mais avançada de filtrar os dados
                .forEach(e -> System.out.println(e));


        System.out.println("----------------------");
        list.stream().map(e -> e * 3)//Ele vai fazer transformações na lista
                .forEach(e -> System.out.println(e));

        System.out.println("----------------------");
        //O foreach não retorna nd
        int value = (int) list.stream().count();
        System.out.println(value);

        System.out.println("----------------------");
        //O foreach não retorna nd
        int value1 = list.stream().min(Comparator.naturalOrder()).get();//Aqui ele retornou um objeto, por isso coloquei o .get()
        System.out.println(value1);

        System.out.println("----------------------");
        List<Integer> novaList = list.stream()
                .filter(e -> e% 2 == 0)//Condição da nova lista
                .collect(Collectors.toList());//Esse collect ele é mais sofisticado e com esse param ele vai retornar uma nova lista fomardo pelo filter
        System.out.println(novaList);

        System.out.println("----------------------");//Esse retorno do tipo do Map depende do que vai ser retornado do group by
        Map<Integer, List<Integer>> mapa = list.stream().collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(mapa);//Esse groupby é super util e é a mesma ideia do sql

    }
}
