package iticbcn.xifratge;

import java.nio.charset.StandardCharsets;

public class TextXifrat{

    byte[] conjunto;  //atributo  de txtXif

    public TextXifrat(byte[] conjunto){ //Constructor de la clase, q ledigo el atributo q entre será su atributo fijo.
        this.conjunto = conjunto;
    }


    @Override
    public String toString(){ //to string es para sout sin q nos salga la referencia del objeto, asi nos sale lo q hay dentro de este.
        String texto = new String(conjunto, StandardCharsets.UTF_8);
        return texto.replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
                    //pq al pasarlo a utf8 algunos byts cifrados representan tabs o saltos de linea y ara q no apse lo remplazo

    }

    public byte[] getBytes(){ //get bytes es apra obtener el contenido q guarda  el atributo "conjunto".
        return conjunto;
    }

    /*
        Si creamos un objeto ej:

        byte[] misBytes = {10, 20, 30};
        TextXifrat texto = new TextXifrat(misBytes);

        yo le estoy diciendo a mi objeto q su contenido sera ese array de bytes
    
     */
    
}