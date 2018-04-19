package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkraceni;
	private JLabel lblKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private MenjacnicaGUI gp;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DodajKursGUI(MenjacnicaGUI gp) {
		setTitle("Dodaj kurs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 260, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSifra = new JTextField();
		textFieldSifra.setBounds(13, 26, 86, 20);
		contentPane.add(textFieldSifra);
		textFieldSifra.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(133, 11, 46, 14);
		contentPane.add(lblNaziv);
		
		textFieldNaziv = new JTextField();
		textFieldNaziv.setBounds(133, 26, 86, 20);
		contentPane.add(textFieldNaziv);
		textFieldNaziv.setColumns(10);
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(13, 11, 46, 14);
		contentPane.add(lblSifra);
		
		textFieldProdajni = new JTextField();
		textFieldProdajni.setBounds(13, 71, 86, 20);
		contentPane.add(textFieldProdajni);
		textFieldProdajni.setColumns(10);
		
		textFieldKupovni = new JTextField();
		textFieldKupovni.setBounds(133, 71, 86, 20);
		contentPane.add(textFieldKupovni);
		textFieldKupovni.setColumns(10);
		
		textFieldSrednji = new JTextField();
		textFieldSrednji.setBounds(13, 115, 86, 20);
		contentPane.add(textFieldSrednji);
		textFieldSrednji.setColumns(10);
		
		textFieldSkraceni = new JTextField();
		textFieldSkraceni.setBounds(133, 115, 86, 20);
		contentPane.add(textFieldSkraceni);
		textFieldSkraceni.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(13, 57, 70, 14);
		contentPane.add(lblProdajniKurs);
		
		lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(133, 57, 86, 14);
		contentPane.add(lblKupovniKurs);
		
		lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(13, 102, 86, 14);
		contentPane.add(lblSrednjiKurs);
		
		lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(133, 102, 86, 14);
		contentPane.add(lblSkraceniNaziv);
		
		JButton btnDodaj = new JButton("DODAJ");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kurs = "Sifra: " + textFieldSifra.getText() + ", skraceni naziv: " +
				textFieldSkraceni.getText()  + ", prodajni kurs: "
				+ textFieldProdajni.getText() + ", srednji kurs: " + textFieldSrednji.getText()
				+ ", kupovni kurs: " + textFieldKupovni.getText() + ", naziv: " + textFieldNaziv.getText();
				
				gp.ispisiStatus(kurs);
				dispose();
			}
		});
		btnDodaj.setBounds(10, 146, 89, 23);
		contentPane.add(btnDodaj);
		
		JButton btnOdustani = new JButton("ODUSTANI");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(130, 146, 89, 23);
		contentPane.add(btnOdustani);
		
		this.gp=gp;
	}
}
