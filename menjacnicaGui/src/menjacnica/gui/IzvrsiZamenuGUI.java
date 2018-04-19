package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKupovni;
	private JTextField textFieldProdajni;
	private JTextField textFieldIznos;
	private MenjacnicaGUI gp;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI(MenjacnicaGUI gp) {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(10, 11, 70, 14);
		contentPane.add(lblKupovniKurs);
		
		JLabel lblValuta = new JLabel("Valuta");
		lblValuta.setBounds(128, 11, 46, 14);
		contentPane.add(lblValuta);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(208, 11, 70, 14);
		contentPane.add(lblProdajniKurs);
		
		textFieldKupovni = new JTextField();
		textFieldKupovni.setEditable(false);
		textFieldKupovni.setBounds(10, 31, 86, 20);
		contentPane.add(textFieldKupovni);
		textFieldKupovni.setColumns(10);
		
		JComboBox comboBoxValuta = new JComboBox();
		comboBoxValuta.setPreferredSize(new Dimension(40, 20));
		comboBoxValuta.setMinimumSize(new Dimension(40, 20));
		comboBoxValuta.addItem("EUR");
		comboBoxValuta.addItem("CHF");
		comboBoxValuta.addItem("USD");
		comboBoxValuta.setBounds(128, 31, 46, 20);
		contentPane.add(comboBoxValuta);
		
		textFieldProdajni = new JTextField();
		textFieldProdajni.setEditable(false);
		textFieldProdajni.setBounds(208, 31, 86, 20);
		contentPane.add(textFieldProdajni);
		textFieldProdajni.setColumns(10);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(10, 84, 46, 14);
		contentPane.add(lblIznos);
		
		textFieldIznos = new JTextField();
		textFieldIznos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textFieldIznos.setBounds(10, 105, 86, 20);
		contentPane.add(textFieldIznos);
		textFieldIznos.setColumns(10);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setBounds(128, 84, 100, 14);
		contentPane.add(lblVrstaTransakcije);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Kupovina");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(128, 104, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Prodaja");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(128, 133, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textFieldIznos.setText(slider.getValue() + "");
			}
		});
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(10);
		slider.setBounds(10, 163, 284, 53);
		contentPane.add(slider);
		
		JButton btnIzvrsiZamenu = new JButton("IZVRSI ZAMENU");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String transakcija;
				if (rdbtnNewRadioButton.isSelected())
					transakcija = "kupovina";
				else
					transakcija = "prodaja";
				String kurs = "Naziv valute: " + comboBoxValuta.getSelectedItem() + ", iznos: " + textFieldIznos.getText()
						+ ", transakcija: " + transakcija;
				gp.ispisiStatus(kurs);
				dispose();
			}
		});
		btnIzvrsiZamenu.setBounds(20, 227, 109, 23);
		contentPane.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("ODUSTANI");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setMinimumSize(new Dimension(109, 23));
		btnOdustani.setMaximumSize(new Dimension(109, 23));
		btnOdustani.setBounds(169, 227, 109, 23);
		contentPane.add(btnOdustani);
	}
}
