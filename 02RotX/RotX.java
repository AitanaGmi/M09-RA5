public class RotX {

    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] minus = letras.toCharArray();
    private static char[] mayus = letras.toUpperCase().toCharArray();

    
    public static void main(String[] args) {

        String[] msg = {
            "ABC",
            "XYZ",
            "Hola, Mr. calçot",
            "Perdó, per tu què és?"
        };

        int desplazamiento = 3;

        System.out.println("\nXifrat\n---------");

        for (int i = 0; i < msg.length; i++) {

            // Aquí llamaremos a xifraRotX
            // msg[i] es el mensaje
            // desplazamiento es el número de posiciones

        }

        System.out.println("\nDesxifrat\n---------");

        // Aquí probaremos desxifraRotX

        System.out.println("\nForça bruta\n---------");

        // Aquí probaremos forcaBrutaRotX
    }


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


    public static void forcaBrutaRotX(String cadenaXifrada) {
        
        for (int desplazamiento = 1; desplazamiento <= minus.length; desplazamiento++) {

        String result = desxifraRotX(cadenaXifrada, desplazamiento);

        System.out.println("Desplaçament " + desplazamiento + ": " + result);
    }

    }
}