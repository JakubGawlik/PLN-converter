package Kuba;

import javax.swing.*;
import java.util.HashMap;

public class Converter {

    JFrame frame = new JFrame();
    JLabel labelAmount1 = new JLabel("Amount");
    JLabel labelAmount2 = new JLabel("Amount");
    JLabel labelFrom1 = new JLabel("From");
    JLabel labelFrom2 = new JLabel("From");
    JLabel labelTo1 = new JLabel("To");
    JLabel labelTo2 = new JLabel("To");

    JTextField textAmount1 = new JTextField();
    JTextField textAmount2 = new JTextField();
    JTextField textFrom1 = new JTextField("złoty");
    JTextField textFrom2 = new JTextField();
    JTextField textTo1 = new JTextField();
    JTextField textTo2 = new JTextField("złoty");

    JButton convert = new JButton("Convert");

    JComboBox<String> comboBox1 = new JComboBox();
    JComboBox<String> comboBox2 = new JComboBox();


    public Converter(HashMap<String, String> kursyWalut) {

        labelAmount1.setBounds(25,10,80,25);
        textAmount1.setBounds(10,35,80,25);
        labelAmount2.setBounds(25,75,80,25);
        textAmount2.setBounds(10,100,80,25 );

        labelFrom1.setBounds(170,10,80,25);
        textFrom1.setHorizontalAlignment(JLabel.CENTER);
        textFrom1.setBounds(120,35,150,25);
        labelFrom2.setBounds(170,75,80,25);
        comboBox1.setBounds(120,100,150,25 );

        labelTo1.setBounds(365,10,80,25);
        comboBox2.setBounds(300,35,150,25);
        labelTo2.setBounds(365,75,80,25);
        textTo2.setHorizontalAlignment(JLabel.CENTER);
        textTo2.setBounds(300,100,150,25 );

        for (String s: kursyWalut.keySet()
             ) {comboBox1.addItem(s);
        }
        comboBox1.doLayout();

        for (String s: kursyWalut.keySet()
             ) {comboBox2.addItem(s);
        }
        comboBox2.doLayout();



        frame.setLayout(null);
        frame.setSize(500,500);
        frame.setVisible(true);
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
        frame.add(textFrom2);
        frame.add(textTo1);
        frame.add(textTo2);
        frame.add(comboBox1);
        frame.add(comboBox2);

    }
}
