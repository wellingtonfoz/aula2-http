package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Proprietario;
import app.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	@Autowired
	private ProprietarioRepository proprietarioRepository;
	
	
	public String save(Proprietario proprietario) {
		
		//REGRA DE NEGÓCIO 001
		if(proprietario.getIdade() < 18)
			proprietario.setMenorIdade(true);
		else
			proprietario.setMenorIdade(false);
		
		
		//REGRA DE NEGÓCIO 002
		Proprietario prop = this.proprietarioRepository.findByCPF(proprietario.getCpf());
		if(prop != null) {
			throw new RuntimeException("Jà existe o proprietario COM O CPF "+prop.getCpf());
		}
		
		this.proprietarioRepository.save(proprietario);
		return "Salvo com sucesso";
	}
	

	public Proprietario findById(long id) {
		return this.proprietarioRepository.findById(id).get();
	}


	public List<Proprietario> findAll(){
		return this.proprietarioRepository.findAll();
	}

	public String update(Proprietario proprietario, long id) {

		//comunicação banco

		return "O proprietario " + proprietario.getNome() + " foi atualizado com sucesso!";
	}


	public String delete(long id) {

		//comunicação banco

		return "O proprietario foi deletado com sucesso!";
	}
	
	

}
