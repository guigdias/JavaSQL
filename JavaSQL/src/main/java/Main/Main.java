package Main;

import Cliente.model.Cliente;
import DAO.ClienteDAO;
import java.util.*;


public class Main {
	
	
	public static void main(String[] args) 
	{
		int id;
		int op;
		Scanner input = new Scanner(System.in);
		Cliente cliente = new Cliente();
		ClienteDAO clientedao = new ClienteDAO();
		String nome;
		int idade;
		String email;
		
		System.out.println("\n1-Insert\n2-Select\n3-Update\n4-Delete\n5-Sair");
		op = input.nextInt();
		//INSERT
		if(op == 1)
		{
			System.out.println("Nome a ser inserido: ");
			nome = input.next();
			cliente.setNome(nome);
			System.out.println("Idade a ser inserida: ");
			idade = input.nextInt();
			cliente.setIdade(idade);
			System.out.println("Email a ser inserido: ");
			email = input.next();
			cliente.setEmail(email);
			input.close();
			clientedao.Insert(cliente); 
		} 
		// SELECT
		if(op == 2)
		{
			for(Cliente clienteSelect : clientedao.getClientes())
			{
			System.out.println("ID do cliente: " +clienteSelect.getId());
			System.out.println("Cliente: " +clienteSelect.getNome());
			System.out.println("Idade do cliente: " + clienteSelect.getIdade());
			System.out.println("Email do cliente: " + clienteSelect.getEmail());
			System.out.println("\n");
			}
		}
		
		
		// UPDATE
		if(op == 3)
		{
			System.out.println("Nome a ser atualizado: ");
			nome = input.next();
			cliente.setNome(nome);
			System.out.println("Idade a ser atualizada: ");
			idade = input.nextInt();
			cliente.setIdade(idade);
			System.out.println("Email a ser atualizado: ");
			email = input.next();
			cliente.setEmail(email);
			System.out.println("ID a ser atualizado: ");
			id = input.nextInt();
			cliente.setId(id);
			input.close();
			clientedao.Update(cliente);
		}
		
		// DELETE
		if(op == 4)
		{
			System.out.println("Escolha o ID de cliente a ser deletado: ");
			id = input.nextInt();
			input.close();
			clientedao.Delete(id);
		}

		if(op == 5)
		{
			return;
		}
		
		
	}

}
