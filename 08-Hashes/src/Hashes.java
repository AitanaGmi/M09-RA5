import java.security.MessageDigest;
import java.util.HexFormat;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;

public class Hashes {

    int npass = 0;

    public String getSHA512AmbSalt(String pw, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes());
        byte[] bytes = md.digest(pw.getBytes());

        HexFormat hex = HexFormat.of();
        String hash = hex.formatHex(bytes);

        return hash;
    }

    public String getPBKDF2AmbSalt(String pw, String salt) throws Exception {

    PBEKeySpec spec = new PBEKeySpec(pw.toCharArray(), salt.getBytes(), 1000, 512);
        SecretKeyFactory skf =
            SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

        byte[] bytes = skf.generateSecret(spec).getEncoded();

        HexFormat hex = HexFormat.of();
        String hash = hex.formatHex(bytes);

        spec.clearPassword();

        return hash;
    }

    public String forcaBruta(String alg, String hash, String salt) throws Exception {
        String charset = "abcdefABCDEF1234567890!";

        npass = 0;

        for (int longitud = 1; longitud <= 6; longitud++) {

            char[] intento = new char[6];

            for (int a = 0; a < (longitud >= 1 ? charset.length() : 1); a++) {
                intento[0] = charset.charAt(a);

                for (int b = 0; b < (longitud >= 2 ? charset.length() : 1); b++) {
                    intento[1] = charset.charAt(b);

                    for (int c = 0; c < (longitud >= 3 ? charset.length() : 1); c++) {
                        intento[2] = charset.charAt(c);

                        for (int d = 0; d < (longitud >= 4 ? charset.length() : 1); d++) {
                            intento[3] = charset.charAt(d);

                            for (int e = 0; e < (longitud >= 5 ? charset.length() : 1); e++) {
                                intento[4] = charset.charAt(e);

                                for (int f = 0; f < (longitud >= 6 ? charset.length() : 1); f++) {
                                    intento[5] = charset.charAt(f);

                                    String candidato = new String(intento, 0, longitud);
                                    npass++;

                                    String hashCandidato;

                                    if (alg.equals("SHA-512")) {
                                        hashCandidato = getSHA512AmbSalt(candidato, salt);
                                    } else {
                                        hashCandidato = getPBKDF2AmbSalt(candidato, salt);
                                    }

                                    if (hashCandidato.equals(hash)) {
                                        return candidato;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    public String getInterval(long t1, long t2) {
        long intervalo = t2 - t1;

        long millis = intervalo % 1000;
        long segonsTotal = intervalo / 1000;

        long segons = segonsTotal % 60;
        long minutsTotal = segonsTotal / 60;

        long minuts = minutsTotal % 60;
        long horesTotal = minutsTotal / 60;

        long hores = horesTotal % 24;
        long dies = horesTotal / 24;

        return dies + " dies / " + hores + " hores / " + minuts
                + " minuts / " + segons + " segons / " + millis + " millis";
    }

    public static void main(String[] args) throws Exception {

        String salt = "qpoweiruañslkdfjz";
        String pw = "aaabF!";

        Hashes h = new Hashes();

        String[] aHashes = {
            h.getSHA512AmbSalt(pw, salt),
            h.getPBKDF2AmbSalt(pw, salt)
        };

        String pwTrobat = null;

        String[] algorismes = {"SHA-512", "PBKDF2"};

        for (int i = 0; i < aHashes.length; i++) {

            System.out.printf("======================================\n");
            System.out.printf("Algorisme: %s\n", algorismes[i]);
            System.out.printf("Hash: %s\n", aHashes[i]);
            System.out.printf("------------------------------\n");
            System.out.printf("-- Inici de força bruta --\n");

            long t1 = System.currentTimeMillis();
            pwTrobat = h.forcaBruta(algorismes[i], aHashes[i], salt);
            long t2 = System.currentTimeMillis();

            System.out.printf("Pass : %s\n", pwTrobat);
            System.out.printf("Provats: %d\n", h.npass);
            System.out.printf("Temps : %s\n", h.getInterval(t1, t2));
            System.out.printf("------------------------------\n\n");
        }
    }
}
