package Kuba;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class KursyWalut {

    HashMap<String, String> kursyWalut = new LinkedHashMap<>();

    HashMap<String, String> kodyWalut = new LinkedHashMap<>();

    String date;

    public HashMap<String, String> getKursyWalut() {
        return kursyWalut;
    }

    public KursyWalut() throws IOException {

    final String url = "https://www.nbp.pl/Kursy/KursyA.html";

    final Document document = Jsoup.connect(url).get();

        date = document.select("h3.center").text();
        date = date.substring(date.length() - 8);

            for (
    Element row : document.select(" table.nbptable tr")){
        if (!row.select("td.left").text().equals("")){
            final String nazwaWaluty = row.select("td.left").text();
            final String originalKurs = row.select("td.right").text();

            final String kurs = originalKurs.substring(originalKurs.length() - 6);
            kursyWalut.put(nazwaWaluty,kurs);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <originalKurs.length() ; i++) {
                if (Character.isLetter(originalKurs.charAt(i))){
                    stringBuilder.append(originalKurs.charAt(i));
                }
            }
            final String kodWaluty = " " + stringBuilder.toString();
            kodyWalut.put(nazwaWaluty,kodWaluty);
        }
    }
    }

    public HashMap<String, String> getKodyWalut() {
        return kodyWalut;
    }

    public String getDate() {
        return date;
    }
}
