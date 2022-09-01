package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmIGVFPrecio extends JDialog implements ActionListener {
	private JTextField txtPrecioBase;
	private JTextField txtIgv;
	private JTextField txtPf;
	private JButton btnCalcular;
	private JButton btnBorrar;
	private JButton btnCerrar;
	private JButton btnCopiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIGVFPrecio dialog = new FrmIGVFPrecio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmIGVFPrecio() {
		setModal(true);
		setTitle("IGV FUERA DE PRECIO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmIGVFPrecio.class.getResource("/icon/calculadora.png")));
		setResizable(false);
		setBounds(100, 100, 548, 336);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 532, 297);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRECIO BASE:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(73, 47, 129, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MONTO IGV:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(85, 106, 122, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRECIO FINAL:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(67, 163, 140, 25);
		panel.add(lblNewLabel_2);
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrecioBase.setBounds(211, 48, 156, 24);
		panel.add(txtPrecioBase);
		txtPrecioBase.setColumns(10);
		
		txtIgv = new JTextField();
		txtIgv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIgv.setEditable(false);
		txtIgv.setBounds(211, 106, 156, 25);
		panel.add(txtIgv);
		txtIgv.setColumns(10);
		
		txtPf = new JTextField();
		txtPf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPf.setEditable(false);
		txtPf.setBounds(211, 165, 156, 25);
		panel.add(txtPf);
		txtPf.setColumns(10);
		
		btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(390, 47, 103, 25);
		panel.add(btnCalcular);
		
		btnCopiar = new JButton("COPIAR");
		btnCopiar.addActionListener(this);
		btnCopiar.setBounds(390, 163, 103, 25);
		panel.add(btnCopiar);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(113, 235, 89, 25);
		panel.add(btnBorrar);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(289, 235, 89, 25);
		panel.add(btnCerrar);
		
		JLabel lblNewLabel_3 = new JLabel("18%");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(400, 110, 46, 14);
		panel.add(lblNewLabel_3);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCopiar) {
			actionPerformedBtnCopiar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnCalcular) {
			actionPerformedBtnCalcular(e);
		}
	}
	protected void actionPerformedBtnCalcular(ActionEvent e) {
		
	}
	
	private double redondear(double num) {
		return Math.rint(num*100/100);
	}
	
	
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtPrecioBase.setText("");
		txtIgv.setText("");
		txtPf.setText("");
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnCopiar(ActionEvent e) {
		
	}
}
