package iticbcn.xifratge;

public interface Xifrador {
    TextXifrat xifra(String missatge, String clau) throws ClauNoSuportada;
    String desxifra(TextXifrat textXifrat, String clau) throws ClauNoSuportada;
}