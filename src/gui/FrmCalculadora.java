package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class FrmCalculadora extends JFrame implements ActionListener, KeyListener, ClipboardOwner {

	private JPanel contentPane;
	private JTextField txtPrecioBase;
	private JTextField txtIGV;
	private JTextField txtPrecioFinal;
	private JButton btnCalcular;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JButton btnCopiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCalculadora frame = new FrmCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCalculadora() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCalculadora.class.getResource("/icon/calculadora.png")));
		setResizable(false);
		setTitle("CALCULADORA IGV v 1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("PRECIO BASE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(31, 40, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MONTO IGV:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(31, 85, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO FINAL:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(31, 131, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setEditable(false);
		txtPrecioBase.setBounds(142, 38, 161, 20);
		contentPane.add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setBounds(142, 83, 161, 20);
		contentPane.add(txtIGV);
		txtIGV.setColumns(10);
		
		txtPrecioFinal = new JTextField();
		txtPrecioFinal.addKeyListener(this);
		txtPrecioFinal.setBounds(142, 129, 161, 20);
		contentPane.add(txtPrecioFinal);
		txtPrecioFinal.setColumns(10);
		txtPrecioFinal.requestFocus();
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(this);
		btnCalcular.setFocusable(false);
		btnCalcular.setBounds(51, 185, 101, 23);
		contentPane.add(btnCalcular);
		
		JLabel lblNewLabel_3 = new JLabel("18%");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(322, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton_1 = new JButton("BORRAR");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setBounds(214, 185, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_4 = new JLabel("(USAR . PARA DECIMALES)");
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(142, 151, 161, 14);
		contentPane.add(lblNewLabel_4);
		
		btnCopiar = new JButton("COPIAR");
		btnCopiar.setFocusable(false);
		btnCopiar.addActionListener(this);
		btnCopiar.setBounds(320, 37, 89, 23);
		contentPane.add(btnCopiar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCopiar) {
			actionPerformedBtnCopiar(e);
		}
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnCalcular) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		double preBase, igv, montoF, preciIGV;
		
		montoF = Double.parseDouble(txtPrecioFinal.getText());
		
		preciIGV = montoF/1.18;	
		igv = montoF-preciIGV;
		preBase = montoF-igv;
		
		txtPrecioBase.setText(redondear(preBase)+"");
		txtIGV.setText(redondear(igv)+"");		
	}
	
	public void setClipboard(String texto) {
		StringSelection txt = new StringSelection(texto);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(txt, this);
	}
	
	private double redondear(double num) {
		return Math.rint(num*100)/100;
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		txtIGV.setText("");
		txtPrecioBase.setText("");
		txtPrecioFinal.setText("");
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPrecioFinal) {
			keyTypedTxtPrecioFinal(e);
		}
	}
	protected void keyTypedTxtPrecioFinal(KeyEvent e) {
		char cteclapres = e.getKeyChar();
		if(cteclapres==KeyEvent.VK_ENTER) {
			btnCalcular.doClick();
		}
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		
		
	}
	protected void actionPerformedBtnCopiar(ActionEvent e) {
		setClipboard(txtPrecioBase.getText());
	}
}
