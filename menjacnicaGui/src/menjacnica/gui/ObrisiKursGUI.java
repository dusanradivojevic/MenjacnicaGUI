package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkraceni;
	private MenjacnicaGUI gp;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI gp) {
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 244, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(31, 11, 46, 14);
		contentPane.add(lblSifra);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(127, 11, 46, 14);
		contentPane.add(lblNaziv);
		
		textFieldSifra = new JTextField();
		textFieldSifra.setBounds(21, 29, 86, 20);
		contentPane.add(textFieldSifra);
		textFieldSifra.setColumns(10);
		
		textFieldNaziv = new JTextField();
		textFieldNaziv.setBounds(118, 29, 86, 20);
		contentPane.add(textFieldNaziv);
		textFieldNaziv.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(31, 60, 76, 14);
		contentPane.add(lblProdajniKurs);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(118, 60, 86, 14);
		contentPane.add(lblKupovniKurs);
		
		textFieldProdajni = new JTextField();
		textFieldProdajni.setBounds(21, 85, 86, 20);
		contentPane.add(textFieldProdajni);
		textFieldProdajni.setColumns(10);
		
		textFieldKupovni = new JTextField();
		textFieldKupovni.setBounds(118, 85, 86, 20);
		contentPane.add(textFieldKupovni);
		textFieldKupovni.setColumns(10);
		
		lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(31, 119, 76, 14);
		contentPane.add(lblSrednjiKurs);
		
		lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(118, 119, 86, 14);
		contentPane.add(lblSkraceniNaziv);
		
		textFieldSrednji = new JTextField();
		textFieldSrednji.setBounds(21, 144, 86, 20);
		contentPane.add(textFieldSrednji);
		textFieldSrednji.setColumns(10);
		
		textFieldSkraceni = new JTextField();
		textFieldSkraceni.setBounds(118, 144, 86, 20);
		contentPane.add(textFieldSkraceni);
		textFieldSkraceni.setColumns(10);
				
		JButton btnOdustani = new JButton("ODUSTANI");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(118, 196, 89, 23);
		contentPane.add(btnOdustani);
		
		JButton btnObrisi = new JButton("OBRISI");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kurs = "Sifra: " + textFieldSifra.getText() + ", skraceni naziv: " +
						textFieldSkraceni.getText()  + ", prodajni kurs: "
						+ textFieldProdajni.getText() + ", srednji kurs: " + textFieldSrednji.getText()
						+ ", kupovni kurs: " + textFieldKupovni.getText() + ", naziv: " + textFieldNaziv.getText();
						
						gp.ispisiStatus(kurs);
						dispose();
			}
		});
		btnObrisi.setEnabled(false);
		btnObrisi.setBounds(21, 196, 89, 23);
		contentPane.add(btnObrisi);
		
		JCheckBox chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi kurs");
		chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxZaistaObrisiKurs.isSelected())
					btnObrisi.setEnabled(true);
				else
					btnObrisi.setEnabled(false);
			}
		});
		chckbxZaistaObrisiKurs.setBounds(21, 171, 110, 23);
		contentPane.add(chckbxZaistaObrisiKurs);
	}
	
}
