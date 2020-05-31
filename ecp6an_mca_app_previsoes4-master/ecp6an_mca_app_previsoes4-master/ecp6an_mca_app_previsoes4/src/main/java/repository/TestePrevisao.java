package repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Cidade;
import model.Previsao;
import model.Semana;

public class TestePrevisao {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Semana s = new Semana();
		s.setDiaDaSemana("Sabado");
		manager.persist(s);
		
		Cidade c = new Cidade();
		c.setNome("Sydney");
		c.setLatitude(55.753576);
		c.setLongitude(37.622432);
		manager.persist(c);
		
		Previsao p = new Previsao();
		p.setTemperaturaMin(15.0);
		p.setTemperaturaMax(28.0);
		p.setUmidadeRelAr(55.0);
		p.setLocalDate(LocalDate.now());
		p.setSemana(s);
		p.setCidade(c);
		p.setDescricao("Sabado temperatura Max " + p.getCidade().getNome() + " de 28 C a Min será de 15 C, umidade em 55%.");
		manager.persist(p);
		transaction.commit();
		JPAUtil.close();
	}
}
