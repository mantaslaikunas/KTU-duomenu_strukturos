package dialogai;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PatysSukurkite extends JFrame implements ActionListener {

    JTextField tfVardas=   new JTextField("Vardelis", 14);
    JTextField tfPavardė=  new JTextField("Pavardaitis", 14);
    JTextField tfMokestis= new JTextField("12.50", 4);
    JTextField tfDalyvSk=  new JTextField("0", 3);
    JTextField tfVisaSuma= new JTextField("0", 6);

    JButton jbReg=         new JButton("Registruoti");
    JPanel panDalyviai=    new JPanel();
    JPanel panDuomenys=    new JPanel();
    JPanel panAsmensDuo =  new JPanel();
    JPanel panRez =        new JPanel();
    JPanel panMygt =       new JPanel();

    JTextArea dalyviųZona= new JTextArea(12,24);
    JScrollPane scrDalZona=new JScrollPane(dalyviųZona);

    public PatysSukurkite() {
        Container vidus = getContentPane();
        vidus.setLayout(new BoxLayout(vidus, BoxLayout.Y_AXIS));
        vidus.add(panDalyviai);
        vidus.add(panDuomenys);
        jbReg.addActionListener(this);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        išdėstymas();
        kosmetika();
        setVisible(true);
        pack();
    }
    public void išdėstymas() {
        setLocation(500, 20);
        // sudedame duomenis į paneles
        panDalyviai.add(scrDalZona);
        panDuomenys.add(panAsmensDuo);
        panDuomenys.add(panRez);
        panDuomenys.add(panMygt);

        GridBagLayout dėstymoBūdas = new GridBagLayout();
        GridBagConstraints dėsnis = new GridBagConstraints();
        panAsmensDuo.setLayout(dėstymoBūdas);
        panRez.setLayout(dėstymoBūdas);

        dėsnis.fill = GridBagConstraints.NONE;
        dėsnis.insets = new Insets(5, 8, 0, 6);

        dėsnis.anchor = GridBagConstraints.LINE_END;
        dėsnis.gridy = GridBagConstraints.RELATIVE;
        dėsnis.gridx = 0;
        panAsmensDuo.add(new JLabel("Vardas"), dėsnis);
        panAsmensDuo.add(new JLabel("Pavardė"), dėsnis);
        panAsmensDuo.add(new JLabel("Mokestis"), dėsnis);
        panRez.add(new JLabel("Dalyvių skaičius"), dėsnis);
        panRez.add(new JLabel("Surinkta suma"), dėsnis);

        dėsnis.anchor = GridBagConstraints.LINE_START;
        dėsnis.gridx = 1;

        panAsmensDuo.add(tfVardas, dėsnis);
        panAsmensDuo.add(tfPavardė, dėsnis);
        panAsmensDuo.add(tfMokestis, dėsnis);

        panRez.add(tfDalyvSk, dėsnis);
        panRez.add(tfVisaSuma, dėsnis);

        panMygt.add(jbReg);
    }

    public void kosmetika() {
        setTitle("Patys susikurkite - KTU IF 2010");
        panDalyviai.setBorder(new TitledBorder("Kosmoso dalyvių sąrašas"));
        panDalyviai.setBackground(Color.yellow);
        panDuomenys.setBorder(new TitledBorder("Dalyvių duomenys"));
        panDuomenys.setBackground(Color.lightGray);
        panAsmensDuo.setBackground(Color.green);
        panRez. setBackground(Color.gray);
        panMygt.setBackground(Color.magenta);
    }
    private double visaSuma=0;
    private int eilėsNr=0;
    public void actionPerformed(ActionEvent e) {
        try {
            double mok = Double.parseDouble(tfMokestis.getText());
            visaSuma+=mok;
            tfDalyvSk.setText(String.format("%3d", ++eilėsNr));
            tfVisaSuma.setText(String.format("%7.2f", visaSuma));
            dalyviųZona.append(
                    String.format("%3d", eilėsNr)+": "+
                    tfVardas.getText()+ " "+
                    tfPavardė.getText()+ " "+
                    tfMokestis.getText()+"\n");
        } catch (NumberFormatException exc) {
            JOptionPane.showMessageDialog (this,"Klaidingas mokesčio formatas");
        }
    }
}
