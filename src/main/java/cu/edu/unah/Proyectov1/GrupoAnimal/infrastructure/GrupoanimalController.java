package cu.edu.unah.Proyectov1.GrupoAnimal.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.unah.Proyectov1.GrupoAnimal.domian.Grupoanimal;
import cu.edu.unah.Proyectov1.GrupoAnimal.application.GrupoanimalService;

@RequestMapping("/grupoanimal")
@RestController
public class GrupoanimalController {
	
	@Autowired
	private GrupoanimalService GrupoanimalService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Grupoanimal>> findAll() {
		try {
			return new ResponseEntity<List<Grupoanimal>>(GrupoanimalService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Grupoanimal> findById(
			
						@PathVariable int id) {
		try {
			return new ResponseEntity<Grupoanimal>(GrupoanimalService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Grupoanimal> create(
			
			@RequestBody Grupoanimal univ) throws URISyntaxException {
		Grupoanimal result = GrupoanimalService.save(univ);

		return ResponseEntity.created(new URI("/Grupoanimal/create/" + result.getIdGrupoAnimal())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Grupoanimal> updateGrupoanimal(
			
			
			@RequestBody Grupoanimal univ) throws URISyntaxException {
		if (univ.getIdGrupoAnimal() == 0) {
			return new ResponseEntity<Grupoanimal>(HttpStatus.NOT_FOUND);
		}

		try {
			Grupoanimal result = GrupoanimalService.update(univ);

			return ResponseEntity.created(new URI("/Grupoanimal/updated/" + result.getIdGrupoAnimal())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable int id) {
		GrupoanimalService.delete(id);

		return ResponseEntity.ok().build();
	}

}
