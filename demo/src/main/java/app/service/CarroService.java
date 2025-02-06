package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.Carro;

@Service
public class CarroService {

	public String save(Carro carro) {

		// REFATORAR DEPOIS COM BD

		return "O carro "+carro.getNome()+" foi salvo com sucesso!";
	}


	public Carro findById(long id) {
		//
		Carro carro = new Carro(3, "Uno", "Preto");

		if(carro.getId() == id) {
			return carro;
		}else
			return null;
	}


	public List<Carro> findAll(){

		List<Carro> lista = new ArrayList<>();

		lista.add(new Carro(1,"Fiesta", "Preto"));
		lista.add(new Carro(2,"HRV", "Preto"));
		lista.add(new Carro(3,"Celta", "Preto"));
		lista.add(new Carro(4,"Marea", "Preto"));

		return lista;
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
