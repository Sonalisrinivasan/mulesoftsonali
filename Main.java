package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert(" The boy in stripped pajamas ","  Asa Butterfield  "," Jack Scanlon ",2008," Mark Herman ");
	insert(" Five feet apart "," Cole sprouse "," Haley Lu Richardson ",2019," Justin Baldoni ");
	insert(" Hostile "," Javier Botet "," Brittany Ashworth ",2017 ," Mathieu Turi");
	insert(" Wonderful nightmare "," Seung-heon  "," Uhm Jung-hwa ",2015 ," Kim Je-yeong ");
	insert(" Grave of the fireflies","Sakuma "," Akiyuki",1988,"Isao");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
