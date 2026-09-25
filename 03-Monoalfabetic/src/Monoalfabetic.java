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
    public String xifraMonoAlfa(String cadena){//hola
    String res = "";
    
    for (int i = 0; i < cadena.length(); i++) { //h
        char letra = cadena.charAt(i);
        char letraMayuscula = Character.toUpperCase(letra);

        boolean encontrada = false;
        for (int j = 0; j < alfabeto.length; j++) { //recorro el alfabeto normal
            if(letraMayuscula == alfabeto[j]){  //si letra es igual a la de alfabeto
                res = res +  alfabetoPermutado[j]; //pues cambiamela x la letra del permutado
                encontrada = true;


            }                
        }
        if (!encontrada) {
            res = res + letra;
        }
    }

    return res;
}

    public void desxifraMonoAlfa(String cadena){

    }
}
//collectons.shufle<Lista>