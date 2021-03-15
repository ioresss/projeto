package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import domain.Funcionario;

import lombok.Data;
import persistence.FuncionarioDAO;

@Named
@ViewScoped
@Data
public class FuncionarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private FuncionarioDAO fDAO;
	private List<Funcionario> funcionarios;
	
	@PostConstruct
	public void iniciar() {
		fDAO = new FuncionarioDAO();
		funcionario = new Funcionario();
		listar();
	}
	
	
	public void salvar() {
		fDAO.cadastrar(funcionario);
		Messages.addGlobalInfo("Funcionario salva com sucesso!");
		listar();
		limpar();
	}
	
	public void listar() {
		funcionarios = fDAO.relatorioGeral();
	}
	
	public void selecionar(Funcionario f) {
		System.out.println(f);	
		funcionario = f;
	}
	
	public void limpar() {
		funcionario = new Funcionario();
		funcionarios = fDAO.relatorioGeral();
	}
	
	public void excluir() {
		fDAO.excluir(funcionario.getMatricula());
		limpar();
		Messages.addGlobalInfo("Funcionario excluído com sucesso!");
	}
	
	public void alterar() {
		fDAO.alterar(funcionario);
		limpar();
		Messages.addGlobalInfo("Funcionario alterado com sucesso!");
		
	}
}
