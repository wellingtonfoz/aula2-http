package app.service;

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

}
