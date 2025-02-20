package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Proprietario;
import app.service.ProprietarioService;

@RestController
@RequestMapping("/api/proprietario")
public class ProprietarioController {



	@Autowired
	private ProprietarioService proprietarioService;



	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Proprietario proprietario){
		try {
			//quando tudo tiver lindo e der certo
			String mensagem = this.proprietarioService.save(proprietario);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Proprietario> findById(@PathVariable long id){
		try {
			//quando tudo tiver lindo e der certo
			Proprietario proprietario = this.proprietarioService.findById(id);
			return new ResponseEntity<>(proprietario, HttpStatus.OK );

		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}


	@GetMapping("/findAll")
	public ResponseEntity<List<Proprietario>> findAll(){

		try {
			List<Proprietario> lista = this.proprietarioService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}

	}


	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Proprietario proprietario, @PathVariable long id){
		try {

			String mensagem = this.proprietarioService.update(proprietario, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			//quando tudo tiver lindo e der certo
			String mensagem = this.proprietarioService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );

		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}




}
