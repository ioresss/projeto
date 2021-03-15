package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Funcionario;
import util.JPAUtil;

public class FuncionarioDAO {
	
	public void cadastrar(Funcionario f) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(f);
		transacao.commit();
		sessao.close();
	}
	
	public Funcionario buscar(Integer matricula) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Funcionario f = sessao.find(Funcionario.class, matricula);
		return f;
	}
	
	public List<Funcionario> relatorioGeral(){
		String jpql = "select f from Funcionario f order by nome";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Funcionario> lista = consulta.getResultList();
		return lista;
	}
	
	
	public void excluir(Integer matricula) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Funcionario f = sessao.find(Funcionario.class, matricula);
		sessao.remove(f);
		transacao.commit();
		sessao.close();
	}
	
	public void alterar(Funcionario f) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(f);
		transacao.commit();
		sessao.close();
	}
}
