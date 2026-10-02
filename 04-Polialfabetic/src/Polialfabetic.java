import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Polialfabetic {
    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] alfabeto = letras.toCharArray();
    private static Random random;

    static char[] alfabetoPermutado =  new char[alfabeto.length];

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

    public static void initRandom(int clauSecreta){

        random = new random(clauSecreta); //creo mi variable random q usa mi clavesecreta
    }
    

    public static String xifraPoliAlfa(String msg){
        String resultado = "";
        for (int i = 0; i < msg.length(); i++) { //hola es mi msg i= 0 -> h
            char letra =msg.charAt(i); //la letra en la q se encuentra i en esa posicion
            permutaAlfabet(); //hago q cada q cambie i de poicion ps permuto un nuevo alfabeto.
            boolean esLetra = false;
            if(Character.isUpperCase(letra)){
                letra = Character.toLowerCase(letra);
                for (int j = 0; j < alfabeto.length; j++) {
                    if(letra == alfabeto[j]){
                        letra = Character.toUpperCase(alfabetoPermutado[j]);
                        resultado +=letra;
                        esLetra = true;
                    }
                }
            }else{
                for (int j = 0; j < alfabeto.length; j++) {
                    if(letra == alfabeto[j]){
                        letra = alfabetoPermutado[j];
                        resultado +=letra;
                        esLetra = true;
                    }
                }
            }

        if(!esLetra){
            resultado+=letra;
        }

        }
        return resultado;
    }

    public static String desxifraPoliAlfa(String msgXifrat){

        String resultado = "";
        return resultado;
    }

    public static void main(String[] args) {
        int clauSecreta =49; //mi llave será este numero
        String msgs[] = {"Test 01 àrbritre, coixí, Perímetre",
        "Test 02 Taüll, DÍA, año",
        "Test 03 Peça, Òrrius, Bòvila"};
        String msgsXifrats[] = new String[msgs.length];

        System.out.println("Xifratge:\n---------");
        for (int i = 0; i < msgs.length; i++) {
            initRandom(clauSecreta); //se lo apso a mi funcion para q me genere un patron
            msgsXifrats[i] = xifraPoliAlfa(msgs[i]);
            System.out.printf("%-34s -> %s%n", msgs[i], msgsXifrats[i]);
        }
    }
}