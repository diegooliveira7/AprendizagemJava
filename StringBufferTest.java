public class StringBufferTest {
    public static void main(String[] arg) {

        String[] letras = {"A", "B", "C", "D", "E"};

        String alfabeto = "";

        //Forma padrão de concatenar

        for (String letra : letras){
            alfabeto += letra;
        }

        System.out.println(alfabeto);

        //O StringBuffer é uma forma sofisticada de concatenar
        StringBuffer sb = new StringBuffer();
        for (String letra : letras){
            sb.append(letra);
        }

        System.out.println(sb.toString());

        //Fazer o reverso da string

        System.out.println(sb.reverse());
    }

}
