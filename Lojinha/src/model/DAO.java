package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe modelo - conexão com o banco
 * @author joao.vssouza42
 *
 */
public class DAO {
	//Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.153:3306/lhlcell";
	private String user = "root";
	private String password = "123@senac";
	
	/**
	 * Método responsável pela conexão
	 * @return con /null
	 */
	public Connection conectar() {
		// objeto usado para conexão
		Connection con = null;
		// tratamento de exceções
		try {
			Class.forName(driver);
			// Estabelecer a conexão
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
