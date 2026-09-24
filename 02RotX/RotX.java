public class RotX {
    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] minus = letras.toCharArray();
    private static char[] mayus = letras.toUpperCase().toCharArray();

    public static void main(String[] args) {
        String[] msg = {"ABC", "XYZ", "Hola, Mr. calçot", "Perdó, per tu què és?"};
        String[] msgCifrado = new String[msg.length];

        System.out.println("\nXifrat\n---------");

        for (int i = 0; i < msg.length; i++) {
            msgCifrado[i] = xifraRotX(msg[i],4);
            System.out.printf("%-23s => %s%n", msg[i], msgCifrado[i]);
        }

        System.out.println("\nDesxifrat\n---------");

        for (String mensaje : msgCifrado) {
            System.out.printf("%-23s => %s%n", mensaje, desxifraRotX(mensaje, 4));
        }

        forcaBrutaRotX(msgCifrado[msg.length - 1]);


        /*lo unico nuevo aqui es cambiar los 13 por cualquier numero diferente el cual se quiera probar y
          en la funcion nueva le pasamos en mensaje cifrado [la longitud de msg -1 para q siempre coja la ultima]
          frase como en el ejemplo del prf.
        */

    }
    /*
        Aqui hago 2 for, uno para recorrer la frase q me llega y el otro para recorrer el abc. sea mayus o 
        minus, entonces lo comparo la letra q está en i de mi frase, a la letra q está en i de el abc, una vez 
        la encuentro hago q deje de buscar con el bool (si la encuentra la añade al string de resultado, el cual
        es el q se devuelve).
    */
    public static String xifraRotX(String cadena, int desplazamiento) { 
        String resultado = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < mayus.length; j++) {
                if (letra == mayus[j]) {
                    int posicionNueva = (j + desplazamiento) % mayus.length;
                    char nuevaLetraMay = mayus[posicionNueva];
                    resultado += nuevaLetraMay;
                    encontrada = true;
                }
            }

            for (int j = 0; j < minus.length; j++) {
                if (letra == minus[j]) {
                    int posicionNueva = (j + desplazamiento) % minus.length;
                    char nuevaLetraMin = minus[posicionNueva];
                    resultado += nuevaLetraMin;
                    encontrada = true;
                }
            }

            if (!encontrada) {
                resultado += letra;
            }
        }

        return resultado;
    }


    public static String desxifraRotX(String cadena, int desplazamiento) {
        String resultado = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < mayus.length; j++) {
                if (letra == mayus[j]) {
                    int posicionNueva = (j - desplazamiento + mayus.length) % mayus.length;
                    char nuevaLetraMay = mayus[posicionNueva];
                    resultado += nuevaLetraMay;
                    encontrada = true;
                }
            }

            for (int j = 0; j < minus.length; j++) {
                if (letra == minus[j]) {
                    int posicionNueva = (j - desplazamiento + minus.length) % minus.length;
                    char nuevaLetraMin = minus[posicionNueva];
                    resultado += nuevaLetraMin;
                    encontrada = true;
                }
            }

            if (!encontrada) {
                resultado += letra;
            }
        }

        return resultado;
    }

    /*
        Aqui un for sobre desplazamiento el cual empieza en 0 ya que queremos ir incrementado
        el numero de desplazamientos q se hacen en la misma frase para ver en que numero de desplazamientos
        la frase cifrada se descifra.

    */
    public static void forcaBrutaRotX(String cadena){
        String result = "";
        for(int desplazamiento = 0; desplazamiento <minus.length; desplazamiento++){
            System.out.println("(" + desplazamiento + ")->" +  desxifraRotX(cadena, desplazamiento));
        }
    }
}