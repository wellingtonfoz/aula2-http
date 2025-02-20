package app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Proprietario;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private ProprietarioService proprietarioService;
	

	public String save(Carro carro) {
		carro.setDataHora(LocalDateTime.now());
		
		
		//REGRA DE NEGÓCIO 001
		if(carro.getAno() >= 2020 && carro.getAno() <= 2025)
			carro.setTipo("SEMINOVO");
		else if(carro.getAno() < 2020)
			carro.setTipo("ANTIGO");
		
		
		//REGRA DE NEGÓCIO 002
		if(carro.getAno() > 2025) {
			throw new RuntimeException("Não é possível cadastrar carro acima de 2025");
		}
		
		
		
		//REGRA DE NEGÓCIO 003
		boolean temMenorIdade = false;
		
		for(int i=0; i<carro.getProprietarios().size(); i++) {
			
			Proprietario prop = this.proprietarioService.findById(carro.getProprietarios().get(i).getId());
			
			if(prop.isMenorIdade()) {
				temMenorIdade = true;
			}
		}
		
		if(temMenorIdade)
			throw new RuntimeException("Não pode salvar carro com proprietario menor de idade");
		
	
		
		this.carroRepository.save(carro);
		return "O carro "+carro.getNome()+" foi salvo com sucesso!";
	}


	public Carro findById(long id) {
		return this.carroRepository.findById(id).get();
	}


	public List<Carro> findAll(){
		return this.carroRepository.findAll();
	}

	public String update(Carro carro, long id) {

		//comunicação banco

		return "O carro " + carro.getNome() + " foi atualizado com sucesso!";
	}


	public String delete(long id) {

		//comunicação banco

		return "O carro foi deletado com sucesso!";
	}
	
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNomeStartingWithIgnoreCase(nome);
	}
	
	public List<Carro> findByAnoBetween(int ano1, int ano2){
		return this.carroRepository.findByAnoBetween(ano1, ano2);
	}
	
	public List<Carro> findByDataHoraBetween(LocalDateTime dataHora1, LocalDateTime dataHora2){
		return this.carroRepository.findByDataHoraBetween(dataHora1, dataHora2);
	}

}
