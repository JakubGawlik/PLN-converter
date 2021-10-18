package Kuba;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        KursyWalut kursyWalut = new KursyWalut();

        Converter converter = new Converter(kursyWalut.getKursyWalut());

    }
}
