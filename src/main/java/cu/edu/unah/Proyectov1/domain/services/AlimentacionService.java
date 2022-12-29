package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.Animal;
import cu.edu.unah.Proyectov1.model.AnimalPK;
import cu.edu.unah.Proyectov1.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AlimentacionService {

	@Autowired
	private AnimalRepository animalrepository;
	
	public Animal save(Animal animal) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (animal.getAnimalPK() != null && animalrepository.existsById(animal.getAnimalPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return animalrepository.save(animal);
	}

	public Animal update(Animal animal) {
		if (animal.getAnimalPK() != null && !animalrepository.existsById(animal.getAnimalPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return animalrepository.save(animal);
	}

	public List<Animal> findAll() {
		return animalrepository.findAll();
	}

	
	
	public Animal findId(AnimalPK id) {
		Animal univ = animalrepository.findById(id).get();
		return univ;

	}

	public void delete(AnimalPK id) {
		animalrepository.deleteById(id);
}
}