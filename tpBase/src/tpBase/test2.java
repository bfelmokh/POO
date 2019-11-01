package tpBase;

import java.sql.*;

public class test2 {
		public static void main(String[] args) {
			MaConnection mc=new MaConnection();
			mc.select("select * from etudiant");
		}
}
