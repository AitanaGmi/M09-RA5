import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monoalfabetic {
    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] alfabeto = letras.toUpperCase().toCharArray();
    private static char[] alfabetoPermutado = permutaAlfabet(alfabeto); //aqui esta shuffeleado para poder usarlo.



    public static char[] permutaAlfabet(char[] alfabeto){//como no s epuede crear otro array distinto hay q clonarlo
        List<Character> lista = new ArrayList<>();

        for(int i = 0; i<alfabeto.length; i++){ //recorro el array q me pasan 
            lista.add(alfabeto[i]); //lo añado a mi nueva luista para poder hacer el shuffle
        }

        Collections.shuffle(lista); //aqui la mezcla 
        char[] resultado = new char [alfabeto.length];//lugarndnd guardar ese nuevo shuffeled

        for (int i = 0; i < lista.size(); i++) {
            resultado[i] = lista.get(i);  //aqui pues en posicion i guardo lo q recorre de mi lista en i.
        }

        
        return resultado;
    }
    public static  String xifraMonoAlfa(String cadena){//hola
        String res = "";

        for (int i = 0; i < cadena.length(); i++) { //h
            char letra = cadena.charAt(i);
            char letraMayuscula = Character.toUpperCase(letra);

            boolean encontrada = false;

            if(Character.isUpperCase(letra)){
                for (int j = 0; j < alfabeto.length; j++) { //recorro el alfabeto normal
                    if(letra == alfabeto[j]){ //si letra es igual a la de alfabeto
                        res = res + alfabetoPermutado[j]; //pues cambiamela x la letra del permutado
                        encontrada = true;
                    }
                }

            }else{

                for (int j = 0; j < alfabeto.length; j++) { //recorro el alfabeto normal
                    if(letraMayuscula == alfabeto[j]){ //si letraMayus es igual a la de alfabeto
                        res = res + Character.toLowerCase(alfabetoPermutado[j]); //pues cambiamela x la letra en minuscula
                        encontrada = true;
                    }
                }
            }

            if (!encontrada) {
                res = res + letra;
            }
        }

        return res;
    }

    public static String desxifraMonoAlfa(String cadena){
        String resultado = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            char letraMayuscula = Character.toUpperCase(letra);

            boolean encontrada = false;

            if (Character.isUpperCase(letra)) {

                for (int j = 0; j < alfabetoPermutado.length; j++) {
                    if (letra == alfabetoPermutado[j]) {
                        resultado = resultado + alfabeto[j];
                        encontrada = true;
                    }
                }

            } else {

                for (int j = 0; j < alfabetoPermutado.length; j++) {
                    if (letraMayuscula == alfabetoPermutado[j]) {
                        resultado = resultado + Character.toLowerCase(alfabeto[j]);
                        encontrada = true;
                    }
                }
            }

            if (!encontrada) {
                resultado += letra;
            }
        }

        return resultado;
    }


    public static void main(String[] args) {
        String[] msg = {"Test 01 àrbritre, coixí, Perímetre","Test 02 Taüll, DÍA, año","Test 03 Peça, Òrrius, Bòvila" };
        String[] msgCifrado = new String[msg.length];

        for (int i = 0; i < alfabeto.length; i++) {
            System.out.print(alfabeto[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < alfabeto.length; i++) {
            System.out.print(alfabetoPermutado[i]+" ");
        }

        System.out.println("\nXifrat\n---------");
        for (int i = 0; i < msg.length; i++) {
            msgCifrado[i] = xifraMonoAlfa(msg[i]);
            System.out.printf("%-23s => %s%n", msg[i], msgCifrado[i]); 
        }

        System.out.println("\nDesxifrat\n---------");

        for(String mensaje : msgCifrado){
            System.out.printf("%-23s => %s%n", mensaje, desxifraMonoAlfa(mensaje));

        }
        
    }
}
//collectons.shufle<Lista>