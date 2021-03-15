package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Tarefa;
import util.JPAUtil;

public class TarefaDAO {
	
	public void cadastrar(Tarefa t) {
		EntityManager sessao = JPAUtil.getEntityManager();
		
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(t);
		transacao.commit();
		sessao.close();
	}
	
	public Tarefa buscar(Integer codigo) {
		EntityManager sessao = JPAUtil.getEntityManager();
		Tarefa t = sessao.find(Tarefa.class, codigo);
		return t;
	}
	
	public List<Tarefa> relatorioGeral(){
		String jpql = "select t from Tarefa t order by codigo";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Tarefa> lista = consulta.getResultList();
		return lista;
	}
	
	
	public void excluir(Integer matricula) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Tarefa t = sessao.find(Tarefa.class, matricula);
		sessao.remove(t);
		transacao.commit();
		sessao.close();
	}
	
	public void alterar(Tarefa t) {
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(t);
		transacao.commit();
		sessao.close();
	}
}
