package DAO;
import java.sql.*;
import java.util.*;

import Cliente.model.Cliente;
import Factory.ConnectionFactory;

public class ClienteDAO 
{
	//CRUD
	
	public void Insert(Cliente cliente)
	{
		String sql = "INSERT INTO cliente(nome, idade, email) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement insert = null;
		
		try
		{
			conn = ConnectionFactory.createConnectionToMYSQL();
			
			insert = conn.prepareStatement(sql);
			
			insert.setString(1, cliente.getNome());
			insert.setInt(2, cliente.getIdade());
			insert.setString(3, cliente.getEmail());
			insert.execute();
			System.out.println("Cliente inserido!");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		finally
		{
			try 
			{
				if(insert != null)
				{
					insert.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
	}
	
	
	
		public List<Cliente> getClientes()
		{
			String sql = "SELECT * FROM cliente";
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			// Classe que vai recuperar os dados do banco - SELECT
			
			ResultSet rset = null;
			
			try
			{
				conn = ConnectionFactory.createConnectionToMYSQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while(rset.next())
				{
					 Cliente cliente = new Cliente();
					 
					 cliente.setId(rset.getInt("id"));
					 
					 cliente.setNome(rset.getString("nome"));
					 
					 cliente.setIdade(rset.getInt("idade"));
					 
					 cliente.setEmail(rset.getString("email"));
					 
					 clientes.add(cliente);
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
			finally
			{
				try 
				{
					if(rset != null)
					{
						rset.close();
					}
					if(pstm!=null)
					{
						pstm.close();
					}
					if(conn!=null)
					{
						conn.close();
					}
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
			return clientes;
		}
		
		public void Update(Cliente cliente)
		{
			String sql = "UPDATE cliente SET nome = ?, idade = ?, email = ?" + "WHERE id = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try
			{
				conn = ConnectionFactory.createConnectionToMYSQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getNome());
				
				pstm.setInt(2, cliente.getIdade());
				
				pstm.setString(3, cliente.getEmail());
				
				pstm.setInt(4, cliente.getId());
				
				pstm.execute();
				
				System.out.println("Cliente Atualizado!");
				
			}
			
			catch(Exception e)
			{
				System.out.print(e);
			}
			finally
			{
				try 
				{
					if(pstm != null)
					{
						pstm.close();
					}
					if(conn!=null)
					{
						conn.close();
					}
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		}
		
		public void Delete(int id)
		{
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			Connection conn = null;
			
			PreparedStatement pstm = null;
			
			try
			{
				conn = ConnectionFactory.createConnectionToMYSQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				pstm.execute();
				
				System.out.println("Cliente deletado! ");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try 
				{
					if(pstm != null)
					{
						pstm.close();
					}
					if(conn!=null)
					{
						conn.close();
					}
				}
				catch(Exception e)
				{
					System.out.print(e);
				}
			}
		}
	}

