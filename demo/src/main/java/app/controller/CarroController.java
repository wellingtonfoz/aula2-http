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

import app.dto.RequestFilterDateTimeDTO;
import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {



	@Autowired
	private CarroService carroService;



	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro){
		try {
			//quando tudo tiver lindo e der certo
			String mensagem = this.carroService.save(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id){
		try {
			//quando tudo tiver lindo e der certo
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK );

		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}


	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll(){

		try {
			List<Carro> lista = this.carroService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}

	}


	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable long id){
		try {

			String mensagem = this.carroService.update(carro, id);
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
			String mensagem = this.carroService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );

		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}


	@GetMapping("/findByNome")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
		try {
			return new ResponseEntity<>(this.carroService.findByNome(nome), HttpStatus.OK);
		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}

	@GetMapping("/findByAnoBetween")
	public ResponseEntity<List<Carro>> findByAnoBetween(@RequestParam int ano1,
			@RequestParam int ano2){
		try {
			return new ResponseEntity<>(this.carroService.findByAnoBetween(ano1,ano2), HttpStatus.OK);
		} catch (Exception e) {
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}

	@PostMapping("/findByDataHoraBetween")
	public ResponseEntity<List<Carro>> findByDataHoraBetween(@RequestBody RequestFilterDateTimeDTO request){
		try {
			List<Carro> lista = this.carroService.findByDataHoraBetween(
					request.getDataHora1(),
					request.getDataHora2());
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//deu erro... deu problema
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}



}
