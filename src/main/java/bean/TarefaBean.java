package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import domain.Funcionario;
import domain.Tarefa;
import lombok.Data;
import persistence.FuncionarioDAO;
import persistence.TarefaDAO;

@Named
@ViewScoped
@Data
public class TarefaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FuncionarioDAO fDAO;
	private List<Funcionario> funcionarios;
	private Tarefa tarefa;
	private TarefaDAO pDAO;
	private List<Tarefa> tarefas;
	@PostConstruct
	
	
	public void iniciar() {
		fDAO = new FuncionarioDAO();
		pDAO = new TarefaDAO();
		tarefas = pDAO.relatorioGeral();
		funcionarios = fDAO.relatorioGeral();
		tarefa = new Tarefa();
	}
	
	public void listarFuncionarios() {
		funcionarios = fDAO.relatorioGeral();
	}
	
	public void listarTarefas() {
		tarefas = pDAO.relatorioGeral();
	}
	
	public void cadastrar() {
		pDAO.cadastrar(tarefa);
		Messages.addGlobalInfo("Tarefa cadastrada com sucesso!");
		limpar();
	}
	
	public void selecionar(Tarefa p) {
		System.out.println(p);	
		tarefa = p;
	}
	
	public void limpar() {
		tarefa = new Tarefa();
		funcionarios = fDAO.relatorioGeral();
		tarefas = pDAO.relatorioGeral();
	}
	
	public void excluir() {
		pDAO.excluir(tarefa.getCodigo());
		limpar();
		Messages.addGlobalInfo("Tarefa excluída com sucesso!");
	}
	
	public void alterar() {
		pDAO.alterar(tarefa);
		limpar();
		Messages.addGlobalInfo("Tarefa alterada com sucesso!");
		
	}
}
