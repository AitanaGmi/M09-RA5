public class AES {
    
    public static byte[] xifraAES(String msg, String clau) throws Exception {
        //Obtenir els bytes de l'String

        // Genera IvParameterSpec

        // Genera hash

        // Encrypt.

        // Combinar IV i part xifrada.

        // return iv+msgxifrat


    }
    public static String desxifraAES(byte[] bIvMsgXifrat, String clau) throws Exception {

        // Extreure l'IV.

        // Extreure la part xifrada.

        // Fer hash de la clau

        // Desxifrar.

        // return String desxifrat


    }
    

    public static void  generaIV(byte[] bytmsg){

    }

    public static void main(String[] args) {
    String msgs[] = {"Lorem ipsum dicet",
    "Hola Andrés cómo está tu cuñado",
    "Àgora ïlla Ôtto"};

    for (int i = 0; i < msgs.length; i++) {
        String msg = msgs[i];

        byte[] bXifrats = null;
        String desxifrat = "";
        try {
            bXifrats = xifraAES(msg, CLAU);
            desxifrat = desxifrasAES(bXifrats, CLAU);
        } catch (Exception e) {
            System.err.println("Error de xifrat: " 
                + e.getLocalizedMessage());
        }

        System.out.println("--------------------");
        System.out.println("Msg: " + msg);
        System.out.println("Enc: " + new String(bXifrats));
        System.out.println("DEC: " + desxifrat);
    }


    }
}
