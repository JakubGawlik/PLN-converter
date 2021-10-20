package Kuba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Converter implements ActionListener {

    HashMap<String, String> kursyWalut;
    HashMap<String, String> kodyWalut;

    String date;

    String combobox1selected;
    String combobox2selected;

    JFrame frame = new JFrame();
    JLabel labelAmount1 = new JLabel("Amount");
    JLabel labelAmount2 = new JLabel("Amount");
    JLabel labelFrom1 = new JLabel("From");
    JLabel labelFrom2 = new JLabel("From");
    JLabel labelTo1 = new JLabel("To");
    JLabel labelTo2 = new JLabel("To");
    JLabel result1 = new JLabel();
    JLabel result2 = new JLabel();
    JLabel labelDate = new JLabel("Data aktualizacji:");
    JTextField textDate = new JTextField();

    JTextField textAmount1 = new JTextField();
    JTextField textAmount2 = new JTextField();
    JTextField textFrom1 = new JTextField("złoty");
    JTextField textTo2 = new JTextField("złoty");

    JButton convert1 = new JButton("Convert");
    JButton convert2 = new JButton("Convert");

    JComboBox<String> comboBox1 = new JComboBox();
    JComboBox<String> comboBox2 = new JComboBox();

    public JTextField getTextAmount1() {
        return textAmount1;
    }

    public JTextField getTextAmount2() {
        return textAmount2;
    }

    private JTextField getTextTo2() {
        return textTo2;
    }

    private JTextField getTextFrom1() {
        return textFrom1;
    }

    public Converter(HashMap<String, String> kursyWalut, String date, HashMap<String, String> kodyWalut) {

        this.kodyWalut = kodyWalut;
        this.kursyWalut = kursyWalut;
        this.date = date;

        labelAmount1.setBounds(25,10,80,25);
        textAmount1.setBounds(10,35,80,25);
        labelAmount2.setBounds(25,75,80,25);
        textAmount2.setBounds(10,100,80,25 );

        labelFrom1.setBounds(170,10,80,25);
        textFrom1.setHorizontalAlignment(JLabel.CENTER);
        textFrom1.setBounds(120,35,150,25);
        labelFrom2.setBounds(170,75,80,25);
        comboBox2.setBounds(120,100,150,25 );

        labelTo1.setBounds(381,10,80,25);
        comboBox1.setBounds(300,35,180,25);
        labelTo2.setBounds(381,75,80,25);
        textTo2.setHorizontalAlignment(JLabel.CENTER);
        textTo2.setBounds(300,100,180,25 );

        convert1.setBounds(500,35,80,25);
        convert2.setBounds(500,100,80,25);

        result1.setBounds(600,35,150,25);
        result2.setBounds(600,100,250,25);

        labelDate.setBounds(21,160,150,25);
        textDate.setBounds(150,160,100,25);

        textDate.setText(date);

        for (String s: kursyWalut.keySet()
             ) {comboBox1.addItem(s);
        }

        for (String s: kursyWalut.keySet()
             ) {comboBox2.addItem(s);
        }

        frame.setLayout(null);
        frame.setSize(750,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(labelAmount1);
        frame.add(labelAmount2);
        frame.add(labelFrom1);
        frame.add(labelFrom2);
        frame.add(labelTo1);
        frame.add(labelTo2);
        frame.add(textAmount1);
        frame.add(textAmount2);
        frame.add(textFrom1);
        frame.add(textTo2);
        frame.add(comboBox1);
        frame.add(comboBox2);
        frame.add(convert1);
        frame.add(convert2);
        frame.add(result1);
        frame.add(result2);
        frame.add(labelDate);
        frame.add(textDate);

        convert1.addActionListener(this);
        convert2.addActionListener(this);

        frame.setVisible(true);
    }

    public boolean is1Valid(JTextField textAmount) {

        String amount1 = textAmount.getText();

        for (int i = 0; i <amount1.length() ; i++) {
            if (!Character.isDigit(amount1.charAt(i))){
                return false;
            }
        }return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==convert1) {
            combobox1selected = comboBox1.getSelectedItem().toString();
            Calculations calculations1 = new Calculations(kodyWalut, kursyWalut, getTextAmount1(), getTextAmount2(), getTextFrom1(), getTextTo2(), combobox1selected, combobox2selected);
            result1.setText("");
            if (is1Valid(textAmount1)){
            result1.setText(Double.toString(calculations1.convert1()) + calculations1.currencyCode1());}
            else {result1.setText("enter correct value");}
        }
        if (e.getSource()==convert2) {
            combobox2selected = comboBox2.getSelectedItem().toString();
            Calculations calculations2 = new Calculations(kodyWalut, kursyWalut, getTextAmount1(), getTextAmount2(), getTextFrom1(), getTextTo2(), combobox1selected, combobox2selected);
            if (is1Valid(textAmount2)){
            result2.setText(Double.toString(calculations2.convert2()) + " PLN");}
            else {result2.setText("enter correct value");}
        }
    }


}
