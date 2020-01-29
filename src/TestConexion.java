import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestConexion {

	public static int opcion;

	public static void main(String[] args) throws SQLException {
		boolean sesion = false;
		while (!sesion) {
			switch (menuInicial()) {
			case 1:
				sesionUsuario();
				sesion=true;
				break;
			case 2:
				sesionEmpresa();
				sesion=true;
				break;
			case 3:
				crearUsuario();
				break;
			default:
				System.out.println("Error");
			}
		}
	}

	public static String getQuery() {
		String query = "";

		return query;
	}

	public static int menuInicial() {
		Scanner in = new Scanner(System.in);
		System.out.println("*** NEAR EAT ***");
		System.out.println("1) Inicio sesion como usuario.");
		System.out.println("2) Inicio sesion como empresa.");
		System.out.println("3) Crear cuenta de usuario");
		System.out.println("4) Crear cuenta como empresa");
		System.out.println("5) Salir");
		System.out.println("Seleccione una opcion");
		return opcion = in.nextInt();
	}

	public static void sesionUsuario() throws SQLException {
		boolean sesion=false;
		Scanner in = new Scanner(System.in);
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = null;

		while (!sesion) {
			System.out.println("Introduzca su correo: ");
			String correo = "'" + in.next() + "'";
			rs = stm.executeQuery("Select * from usuario where correo=" + correo);
			if (!rs.next()) {
				System.out.println("Correo invalido");
			} else {
				System.out.println("Introduzca su contrase�a:");
				String pass = in.next();
				String contr = rs.getString(3);
				if (pass.equals(contr)) {
					System.out.println("Bienvenido " + rs.getString(4) +"\n\n\n");
					sesion = true;
				} else
					System.out.println("Contrase�a invalida");
			}

		}
	}

	public static void sesionEmpresa() throws SQLException {
		boolean sesion=false;
		Scanner in = new Scanner(System.in);
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = null;

		while (!sesion) {
			System.out.println("Introduzca su correo: ");
			String correo = "'" + in.next() + "'";
			rs = stm.executeQuery("Select * from empresa where correo=" + correo);
			if (!rs.next()) {
				System.out.println("Correo invalido");
			} else {
				System.out.println("Introduzca su contrase�a:");
				String pass = in.next();
				String contr = rs.getString(3);
				if (pass.equals(contr)) {
					System.out.println("Bienvenido " + rs.getString(5) + "\n\n\n");

					sesion = true;
				} else
					System.out.println("Contrase�a invalida");
			}

		}
	}

	public static void crearUsuario() throws SQLException {
		Scanner in = new Scanner(System.in);
		Conexion conexion = new Conexion();
		Connection cn = conexion.conectar();
		Statement stm = cn.createStatement();
		ResultSet rs = null;
		boolean creado = false;
		while (!creado) {
			System.out.println("Introduzca un correo para crear la cuenta: ");
			String correo = in.next();
			rs = stm.executeQuery("Select * from usuario where correo='" + correo + "'");
			if (!rs.next()) {
				System.out.println("Introduzca una contrase�a de 8 a 20 caracteres: ");
				String pass=in.next();
				if(pass.length()<21 && pass.length()>7) {
					in.nextLine();
					System.out.println("Introduzca su nombre completo: ");
					String nombre=in.nextLine();
					System.out.println("Introduzca su fecha de nacimiento (aaaa-mm-dd):");
					String fecha_nac=in.next();
					System.out.println("Introduzca su numero de telefono (solo numeros):");
					long tlfno=in.nextLong();
					System.out.println("Introduzca su sexo (1.Hombre - 2.Mujer): ");
					int sexo=in.nextInt()-1;
					try {
						String query="Insert into usuario (correo, password, Nombre, fecha_nac, num_tfno, sexo) values('"+correo+"','"+pass+"','"+nombre+"','"+fecha_nac+"',"+tlfno+","+sexo+")";
						stm.executeUpdate(query);
					}catch(SQLException e) {
						System.out.println("Error al crear");
					}creado=true;
					}else
					System.out.println("Contrase�a con formato no permitido");
			} else
				System.out.println("Correo ya registrado.");
		}
	}
}