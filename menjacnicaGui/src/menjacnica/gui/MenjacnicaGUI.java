package menjacnica.gui;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenjacnicaGUI {

	private JTextArea textArea;
	private JFrame frmMenjacnica;
	private JTable table;
	private MenjacnicaGUI gp = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI window = new MenjacnicaGUI();
					window.frmMenjacnica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenjacnicaGUI() {
		
		frmMenjacnica = new JFrame();
		frmMenjacnica.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				apkExit();
			}
		});
		frmMenjacnica.setTitle("Menjacnica");
		frmMenjacnica.setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/Th11-Paper-money.jpeg")));
		frmMenjacnica.setBounds(100, 100, 450, 300);
		frmMenjacnica.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmMenjacnica.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frmMenjacnica.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setMinWidth(25);
		table.getColumnModel().getColumn(2).setMinWidth(10);
		table.getColumnModel().getColumn(3).setMinWidth(10);
		table.getColumnModel().getColumn(4).setMinWidth(10);
		table.getColumnModel().getColumn(5).setMinWidth(10);
		scrollPane.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKursGUI dodajKurs = new DodajKursGUI(gp);
				dodajKurs.setVisible(true);
			}
		});
		popupMenu.add(mntmDodajKurs);
		
		JMenuItem mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
		popupMenu.add(mntmIzbrisiKurs);
		
		JMenuItem mntmIzvrsiIzmenu = new JMenuItem("Izvrsi izmenu");
		popupMenu.add(mntmIzvrsiIzmenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setPreferredSize(new Dimension(10, 50));
		frmMenjacnica.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 50));
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		this.textArea = textArea;
		textArea.setPreferredSize(new Dimension(4, 35));
		scrollPane_1.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 1));
		frmMenjacnica.getContentPane().add(panel, BorderLayout.EAST);
		
		JButton btnDodajKurs = new JButton("Dodaj kurs");
		btnDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dodajKurs=new DodajKursGUI(gp);
				dodajKurs.setVisible(true);
			}
		});
		btnDodajKurs.setPreferredSize(new Dimension(95, 23));
		panel.add(btnDodajKurs);
		
		JButton btnIzbrisiKurs = new JButton("Izbrisi kurs");
		btnIzbrisiKurs.setPreferredSize(new Dimension(95, 23));
		panel.add(btnIzbrisiKurs);
		
		JButton btnIzvsiIzmenu = new JButton("Izvrsi izmenu");
		panel.add(btnIzvsiIzmenu);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenjacnica.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				
				int a = fc.showOpenDialog(null); //na ceo ekran
				
				if(a == fc.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					textArea.append("Otvoren je fajl: "+ f);
				}
				
			}
		});
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				
				int a = fc.showSaveDialog(null);
				
				if(a == fc.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					textArea.append("Sacuvan je fajl: "+ f);
				}
			}
		});
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcija = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da izadjete?", "Izlaz",
						JOptionPane.YES_NO_CANCEL_OPTION);
				
				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
				
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbou = new JMenuItem("About");
		mntmAbou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prikaziAboutProzor();
			}
		});
		mntmAbou.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnHelp.add(mntmAbou);
		
	}

	private void prikaziAboutProzor(){
		JOptionPane.showMessageDialog(frmMenjacnica.getContentPane(),
				"Autor: Dusan Radivojevic.", "O programu",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void apkExit() {
		int opcija = JOptionPane.showConfirmDialog(frmMenjacnica.getContentPane(),
				"Da li ZAISTA zelite da izadjete iz apliacije?", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public void ispisiStatus(String s) {
		textArea.append(s);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
}
