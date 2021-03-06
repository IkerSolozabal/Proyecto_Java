package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class InicioUsuario extends JFrame {
	static InicioUsuario frame;
	private JPanel contentPane;
	static JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblNearEat;
	static JPasswordField passwordField;
	private JButton btnInicio;
	private static int contInicio=0;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InicioUsuario();
					frame.setVisible(true);
					if(contInicio>=3) {
						frame.setVisible(false);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(137, 132, 180, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(55, 135, 72, 14);
		contentPane.add(lblUsuario);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(55, 166, 89, 14);
		contentPane.add(lblContrasea);

		lblNearEat = new JLabel("Near Eat");
		lblNearEat.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		lblNearEat.setBounds(137, 43, 201, 102);
		contentPane.add(lblNearEat);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 163, 180, 20);
		contentPane.add(passwordField);

		JLabel lblNoTienesCuenta = new JLabel("No tienes cuenta?");
		lblNoTienesCuenta.setBounds(10, 236, 126, 14);
		contentPane.add(lblNoTienesCuenta);

		JButton btnRegistrate = new JButton("Registrate");
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario reg = new RegistroUsuario();
				reg.main(null);
				frame.setVisible(false);
			}
		});
		btnRegistrate.setBounds(117, 232, 111, 23);
		contentPane.add(btnRegistrate);

		JLabel lblEresEmpresa = new JLabel("Eres empresa?");
		lblEresEmpresa.setBounds(238, 236, 100, 14);
		contentPane.add(lblEresEmpresa);

		JButton btnEmpresa = new JButton("Empresa");
		btnEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioEmpresa empresa =new InicioEmpresa();
				empresa.main(null);
				frame.setVisible(false);
			}
		});
		btnEmpresa.setBounds(335, 232, 89, 23);
		contentPane.add(btnEmpresa);

		btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(sesionUsuario()) {
						MenuBusqueda inicio=new MenuBusqueda();
						inicio.main(null);
						frame.setVisible(false);
					};
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInicio.setBounds(185, 186, 89, 23);
		contentPane.add(btnInicio);
	}

	public static boolean sesionUsuario() throws SQLException {
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = null;
		
		String correo = "'" + txtUsuario.getText() + "'";
		rs = stm.executeQuery("Select * from users where correo=" + correo);
		if (!rs.next()) {
			JOptionPane.showMessageDialog(null, "Correo Invalido");
			contInicio++;
			System.out.println(contInicio);
			if(contInicio>=3) {
				frame.setVisible(false);
			}
			return false;
		} else {
			String pass = passwordField.getText();
			String contr = rs.getString(3);
			if (pass.equals(contr)) {
				JOptionPane.showMessageDialog(null, "Bienvenido " + rs.getString(4) + "\n\n\n");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Contraseņa Incorrecta");
				contInicio++;
				System.out.println(contInicio);
				if(contInicio>=3) {
					frame.setVisible(false);
				}
				}
			return false;
		}
		

	}
}
