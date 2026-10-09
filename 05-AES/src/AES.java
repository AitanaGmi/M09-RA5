import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    
    public static final String ALGORISME_XIFRAT = "AES"; 
    public static final String ALGORISME_HASH = "SHA-256"; 
    public static final String FORMAT_AES = "AES/CBC/PKCS5Padding"; 
    private static final int MIDA_IV = 16; 
    private static byte[] iv = new byte[MIDA_IV]; 
    private static final String CLAU = "LaClauSecretaQueVulguis";


    public static void generaIv(){
        SecureRandom generador = new SecureRandom();
        generador.nextBytes(iv);
    }

    public static SecretKeySpec generaHash(String password)throws Exception{
        MessageDigest md = MessageDigest.getInstance(ALGORISME_HASH); //msgDig es la clase q permite calcular hashes, el getInstance es una herramienta para calcualr  y leugo meto mi valor de algoritmo q quiero usar.
        byte[] bytContra = password.getBytes(StandardCharsets.UTF_8);
        byte[] tira = md.digest(bytContra);
        return new SecretKeySpec(tira, ALGORISME_XIFRAT);
        
    }

    public static byte[] xifraAES(String msg, String clau) throws Exception {
        //Obtenir els bytes de l'String
        byte[] bytmsg = msg.getBytes(StandardCharsets.UTF_8);
       
        // Genera IvParameterSpec
        generaIv();

        IvParameterSpec ivSpec = new IvParameterSpec(iv);
         // Genera hash
        SecretKeySpec llave = generaHash(clau);
        // Encrypt.
        Cipher cipher = Cipher.getInstance(FORMAT_AES); //Lo q hace esto es indicar la forma en la q se va a cifrar
        cipher.init(Cipher.ENCRYPT_MODE, llave, ivSpec); //Indicarle lo q voy encpriptar, con la llave y los 16 byts randoms
        byte[] msgCifrado = cipher.doFinal(bytmsg); 

        // Combinar IV i part xifrada.
        byte[] resultado = new byte[iv.length + msgCifrado.length];

        for (int i = 0; i < iv.length; i++) {
            resultado[i] = iv[i];
        }

        for (int i = 0; i < msgCifrado.length; i++) {
            resultado[iv.length + i] = msgCifrado[i];
        }

        // return iv+msgxifrat
        return resultado;

    }
    public static String desxifraAES(byte[] bIvMsgXifrat, String clau) throws Exception {

        // Extreure l'IV.
        byte[] ivExtret = new byte[MIDA_IV];
        for (int i = 0; i < MIDA_IV; i++) {
            ivExtret[i] = bIvMsgXifrat[i];
        }
        IvParameterSpec ivSpec = new IvParameterSpec(ivExtret);

        // Extreure la part xifrada.
        byte[] msgXifrat = new byte[bIvMsgXifrat.length - MIDA_IV];
        for (int i = 0; i < msgXifrat.length; i++) {
            msgXifrat[i] = bIvMsgXifrat[MIDA_IV + i];
        }

        // Fer hash de la clau

        SecretKeySpec llave = generaHash(clau);

        // Desxifrar.
        Cipher cipher = Cipher.getInstance(FORMAT_AES);
        cipher.init(Cipher.DECRYPT_MODE, llave, ivSpec);
        byte[] bytsDesxifrats = cipher.doFinal(msgXifrat);

        // return String desxifrat
        return new String(bytsDesxifrats, StandardCharsets.UTF_8);

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
            desxifrat = desxifraAES(bXifrats, CLAU);
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