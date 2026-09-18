public class Rot13 {
    private static String letras = "aáàbcçdeéèfghiíìïjklmnñoóòpqrstuúùüvwxyz";
    private static char[] minus = letras.toCharArray();
    private static char[] mayus = letras.toUpperCase().toCharArray();

    public static void main(String[] args) {
        String[] msg = {"ABC", "XYZ", "Hola, Mr. calçot", "Perdó, per tu què és?"};
        String[] msgCifrado = new String[msg.length];

        System.out.println("\nXifrat\n---------");

        for (int i = 0; i < msg.length; i++) {
            msgCifrado[i] = xifraRot13(msg[i]);
            System.out.printf("%-23s => %s%n", msg[i], msgCifrado[i]);
        }

        System.out.println("\nDesxifrat\n---------");

        for (String mensaje : msgCifrado) {
            System.out.printf("%-23s => %s%n", mensaje, desxifraRot13(mensaje));
        }
    }

    public static String xifraRot13(String cadena) {
        String resultado = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < mayus.length; j++) {
                if (letra == mayus[j]) {
                    int posicionNueva = (j + 13) % mayus.length;
                    char nuevaLetraMay = mayus[posicionNueva];
                    resultado += nuevaLetraMay;
                    encontrada = true;
                }
            }

            for (int j = 0; j < minus.length; j++) {
                if (letra == minus[j]) {
                    int posicionNueva = (j + 13) % minus.length;
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

    public static String desxifraRot13(String cadena) {
        String resultado = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < mayus.length; j++) {
                if (letra == mayus[j]) {
                    int posicionNueva = (j - 13 + mayus.length) % mayus.length;
                    char nuevaLetraMay = mayus[posicionNueva];
                    resultado += nuevaLetraMay;
                    encontrada = true;
                }
            }

            for (int j = 0; j < minus.length; j++) {
                if (letra == minus[j]) {
                    int posicionNueva = (j - 13 + minus.length) % minus.length;
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
}