package app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

	public List<Carro> findByNomeStartingWithIgnoreCase(String nome);
	
	public List<Carro> findByAnoBetween(int ano1, int ano2);

	public List<Carro> findByDataHoraBetween(LocalDateTime dataHora1, LocalDateTime dataHora2);
	
	@Query("SELECT c FROM Carro c WHERE c.cor = :cor")
	public List<Carro> buscarCarroPeloCor(String cor);
	
}
