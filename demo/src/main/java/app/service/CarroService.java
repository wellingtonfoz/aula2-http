package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	

	public String save(Carro carro) {
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

}
