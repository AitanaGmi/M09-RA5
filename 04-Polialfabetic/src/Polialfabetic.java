import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Polialfabetic {
    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] alfabeto = letras.toCharArray();

    static char[] alfabetoPermutado =  new char[alfabeto.length];

    /*
        como quiero q sea general la creo static la cal despues se  modificara en aquel metodo q se use esta avriable
        entonces antes de nada a este char hay q darle su tamaño y ps queremos q tenga el mismo tamaño q nustro alfabeto normal,
        ps le digo new char[la longitud d e mi alfabeto].
    */

    public static void permutaAlfabet() {
        List<Character> lista = new ArrayList<>(); //creo una lista
        for (int i = 0; i < alfabeto.length; i++) {
            lista.add(alfabeto[i]); //x cada posicion lo añado en mi lista
        }

        Collections.shuffle(lista); //aqui la mezcla

        for (int i = 0; i < lista.size(); i++) {
            alfabetoPermutado[i] = lista.get(i); //aqui modifico alfabeto permutado y lo añad global
            //x cada posiicon de alfP será igual a la lista shufeleada.
        }
        
    }
    public static String xifraPoliAlfa(String msg){
        String resultado = "";
        for (int i = 0; i < msg.length(); i++) { //hola es mi msg i= 0 -> h

            char letra =msg.charAt(i); //la letra en la q se encuentra i en esa posicion

            for (int j = 0; j < alfabeto.length; j++) {
                if(letra == alfabeto[j]){
                    
                }
            }
            /*
            -   que quiero hacer con mi mnsg?
                quiero recorrerlo para saber en que letra estoy y esa letra cambairla por una de mi
                alfabeto permutado. A excepcion de qu esta vez cada letra debe tener su propio alfabeto permutado
            
            */
        }
        return

    }
    public static String desxifraPoliAlfa(String msgXifrat){

    }
}
