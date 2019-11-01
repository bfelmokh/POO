package tpBase;
import java.sql.*;
public class Test {
	public static void main(String[] args) {
		
		// chargement driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded ... ");
		}catch (ClassNotFoundException e) {
			System.out.println("Problem ..."+e.getMessage());
		}
		
		// connexion base
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/tpjava","root","");
			System.out.println("Connected ... ");
			
			// Creation Statement
			Statement st=con.createStatement();
			
			// Requete d'insert/update/delete
			int a = st.executeUpdate("insert into etudiant values (1,'nom','prenom')");
			if (a==0) {
				System.out.println("erreur de mis à jour");
			} else
			{
				System.out.println("Mis à jour avec success");
			}
			
			// Requete de select
			ResultSet rs=st.executeQuery("select * from etudiant");
			// Affichage
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			
		st.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connexion Erreur"+e.getMessage());
		}
		
	}
	
}
