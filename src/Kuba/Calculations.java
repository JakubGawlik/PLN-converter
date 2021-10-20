package Kuba;

import javax.swing.*;
import java.util.HashMap;

public class Calculations {

    JTextField textAmount1;
    JTextField textAmount2;
    JTextField textFrom1;
    JTextField textTo2;
    String comboBox1selected;
    String comboBox2selected;
    HashMap<String, String> kursyWalut;
    HashMap<String, String> kodyWalut;

    public Calculations(HashMap<String, String> kodyWalut, HashMap<String, String> kursyWalut, JTextField textAmount1, JTextField textAmount2, JTextField textFrom1, JTextField textTo2, String comboBox1selected, String comboBox2selected) {
       this.textAmount1=textAmount1;
       this.textAmount2=textAmount2;
       this.textFrom1=textFrom1;
       this.textTo2=textTo2;
       this.comboBox1selected=comboBox1selected;
       this.comboBox2selected=comboBox2selected;
       this.kursyWalut=kursyWalut;
       this.kodyWalut = kodyWalut;
    }

    public double convert1(){

        String originalKurs = kursyWalut.get(comboBox1selected);

        originalKurs = kursyWalut.get(comboBox1selected).replace(',', '.');

        double kurs = Double.parseDouble(originalKurs);

        int amount = Integer.parseInt(textAmount1.getText());

        double result = amount/kurs;

        result = Math.round(result*100.0)/100.0;

        return result;

    }
    public String currencyCode1(){
        String code = kodyWalut.get(comboBox1selected);
        return code;
    }

    public double convert2(){

        String originalKurs = kursyWalut.get(comboBox2selected);

        originalKurs = kursyWalut.get(comboBox2selected).replace(',', '.');

        double kurs = Double.parseDouble(originalKurs);

        int amount = Integer.parseInt(textAmount2.getText());

        double result = amount*kurs;

        result = Math.round(result*100.0)/100.0;

        return result;
    }
}
