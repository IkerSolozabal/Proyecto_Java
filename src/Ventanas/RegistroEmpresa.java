package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegistroEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEmpresa frame = new RegistroEmpresa();
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
	public RegistroEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNearEat = new JLabel("Near Eat");
		lblNearEat.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNearEat.setBounds(145, 0, 168, 28);
		contentPane.add(lblNearEat);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 59, 74, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 84, 97, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblNombreEmpresa = new JLabel("Nombre Empresa:");
		lblNombreEmpresa.setBounds(10, 143, 132, 14);
		contentPane.add(lblNombreEmpresa);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 168, 74, 14);
		contentPane.add(lblTelefono);
		
		textField = new JTextField();
		textField.setBounds(69, 56, 282, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(52, 112, 225, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 140, 227, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(94, 168, 168, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(315, 227, 89, 23);
		contentPane.add(btnCrear);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 81, 254, 23);
		contentPane.add(passwordField);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblEmpresa.setBounds(161, 26, 101, 23);
		contentPane.add(lblEmpresa);
		
		JLabel lblCif = new JLabel("CIF:");
		lblCif.setBounds(10, 109, 57, 20);
		contentPane.add(lblCif);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo:");
		lblNombreCompleto.setBounds(10, 193, 119, 20);
		contentPane.add(lblNombreCompleto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 193, 191, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
