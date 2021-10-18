package Kuba;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class KursyWalut {

    HashMap<String, String> kursyWalut = new LinkedHashMap<>();

    public HashMap<String, String> getKursyWalut() {
        return kursyWalut;
    }

    public KursyWalut() throws IOException {

    final String url = "https://www.nbp.pl/Kursy/KursyA.html";

    final Document document = Jsoup.connect(url).get();

            for (
    Element row : document.select(" table.nbptable tr")){
        if (!row.select("td.left").text().equals("")){
            final String nazwaWaluty = row.select("td.left").text();
            final String originalKurs = row.select("td.right").text();
            final String kurs = originalKurs.substring(originalKurs.length() - 6);
            kursyWalut.put(nazwaWaluty,kurs);
        }
    }
    }
}
