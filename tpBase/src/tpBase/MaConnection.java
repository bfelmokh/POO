package tpBase;
import java.sql.*;

public class MaConnection {

	Connection con=null;
	Statement st=null;
	public MaConnection() {
		// TODO Auto-generated constructor stub
		// chargement driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loaded ... ");
				}catch (ClassNotFoundException e) {
					System.out.println("Problem ..."+e.getMessage());
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tpjava","root","");
					System.out.println("Connected ... ");
					//Creation Statement
					Statement st=con.createStatement();
				} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Connexion Erreur"+e.getMessage());
				}
	}
	void select(String req) {
		try {
			ResultSet rs=st.executeQuery(req);
			ResultSetMetaData rsmd=rs.getMetaData();
			int nbrc=rsmd.getColumnCount();
			String[] titre = new String[nbrc];
			for (int i=0;i<nbrc;i++) {
				/* les indice de rs et rsmd commence par 1 
				 */
				System.out.println(rsmd.getColumnName(i+1));
				titre[i]=rsmd.getColumnName(i+1);
			}
			while (rs.next()) {
				
			}
			Show(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	private void Show(ResultSet rs) {
		// TODO Auto-generated method stub
		
	}
	
}
