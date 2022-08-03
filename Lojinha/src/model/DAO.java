package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe modelo - conex�o com o banco
 * @author joao.vssouza42
 *
 */
public class DAO {
	//Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.26.49.153:3306/lhlcell";
	private String user = "root";
	private String password = "123@senac";
	
	/**
	 * M�todo respons�vel pela conex�o
	 * @return con /null
	 */
	public Connection conectar() {
		// objeto usado para conex�o
		Connection con = null;
		// tratamento de exce��es
		try {
			Class.forName(driver);
			// Estabelecer a conex�o
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
