package br.marcel.melo.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class UserDAO {
	
	
	public ArrayList<User> getAllUsers(){
		Connection con = ConexaoMySQL.getConexaoMySQL();
		ArrayList<User> users = new ArrayList<User>();
		
		String sql = "SELECT id, nome, cpf, email FROM users";
		try {
		
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nome"));
				user.setCpf(rs.getString("cpf"));
				user.setEmail(rs.getString("email"));
				
				users.add(user);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConexaoMySQL.fecharConexao();
		return users;
	}
	
	public User getUser(int id){
		Connection con = ConexaoMySQL.getConexaoMySQL();
		User user = new User();
		
		String sql = "SELECT id, nome, cpf, email FROM users WHERE id=?";
		try {
		
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
				
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("nome"));
			user.setCpf(rs.getString("cpf"));
			user.setEmail(rs.getString("email"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConexaoMySQL.fecharConexao();
		return user;
	}
	
	public boolean updateUser(User usuario){
		Connection con = ConexaoMySQL.getConexaoMySQL();
		
		String sql = "UPDATE users SET nome=?, cpf=?, email=? WHERE id=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getName());
			ps.setString(2, usuario.getCpf());
			ps.setString(3, usuario.getEmail());
			ps.setInt(4, usuario.getId());
			
			ps.executeUpdate();
			ConexaoMySQL.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
	}
	
	public boolean saveUser(User usuario){
		Connection con = ConexaoMySQL.getConexaoMySQL();
		
		String sql = "INSERT INTO Default.users (nome, cpf, email) VALUES(?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, usuario.getName());
			ps.setString(2, usuario.getCpf());
			ps.setString(3, usuario.getEmail());
			
			ps.executeUpdate();
			ConexaoMySQL.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
	}
	
	public boolean deleteUser(int id){
		Connection con = ConexaoMySQL.getConexaoMySQL();
		
		String sql = "DELETE FROM users WHERE id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ConexaoMySQL.fecharConexao();
			return ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			ConexaoMySQL.fecharConexao();
			return false;
		}
	}
	
}
