package iticbcn.xifratge;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
public class ClauPublica {
    public KeyPair generaParellClausRSA()throws Exception{
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA"); //Para hacer uso del generador hay q usar el get instance 
        //el cual llama a un metodo estatico el cual recibe rsa q es el algoritmo q quiero usar yme da un generador preaprado apra ese algoritmo.
        //en esta linea solicito un generador apra el argoritmo RSA y GUARDO un generador!
        KeyPair parDeKeys = generador.generateKeyPair(); //usando el generador genero el par de keys
        return  parDeKeys;
    }
    public byte[] xifraRSA(String msg, PublicKey clauPublica)throws Exception{ //en el main se ha hecho .getPublic() q eso te da la keyPublica generada.
        byte[] msgBytes = msg.getBytes();
        Cipher cifrado = Cipher.getInstance("RSA"); //un obejto apra usar el algoritmo RSA
        cifrado.init(Cipher.ENCRYPT_MODE, clauPublica);// mi obketo con el init  configuro el objeto apra cifrar y le doy una key.
        byte[] msgbyteCifardo = cifrado.doFinal(msgBytes); // como el cipher trabaja con bytes le hago una nueva variable y uso el do FINAL para encriptar.
        return msgbyteCifardo;
    }
    
    public String desxifraRSA(byte[]msgXifrat,PrivateKey clauPrivada)throws Exception{
        Cipher descifrador = Cipher.getInstance("RSA");
        descifrador.init(Cipher.DECRYPT_MODE, clauPrivada);
        byte[] msgbytesDes = descifrador.doFinal(msgXifrat);
        String  msgDescifrado= new String(msgbytesDes,StandardCharsets.UTF_8);
        return  msgDescifrado;
    }
}