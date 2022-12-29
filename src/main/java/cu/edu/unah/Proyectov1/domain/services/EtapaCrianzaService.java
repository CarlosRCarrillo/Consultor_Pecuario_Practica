package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.EtapaCrianza;
import cu.edu.unah.Proyectov1.model.EtapaCrianzaPK;
import cu.edu.unah.Proyectov1.repository.EtapaCrianzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EtapaCrianzaService {

	@Autowired
	private EtapaCrianzaRepository etapaCrianzarepository;
	
	public EtapaCrianza save(EtapaCrianza etapaCrianza) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (etapaCrianza.getEtapaCrianzaPK() != null && etapaCrianzarepository.existsById(etapaCrianza.getEtapaCrianzaPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return etapaCrianzarepository.save(etapaCrianza);
	}

	public EtapaCrianza update(EtapaCrianza etapaCrianza) {
		if (etapaCrianza.getEtapaCrianzaPK() != null && !etapaCrianzarepository.existsById(etapaCrianza.getEtapaCrianzaPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return etapaCrianzarepository.save(etapaCrianza);
	}

	public List<EtapaCrianza> findAll() {
		return etapaCrianzarepository.findAll();
	}

	
	
	public EtapaCrianza findId(EtapaCrianzaPK id) {
		EtapaCrianza univ = etapaCrianzarepository.findById(id).get();
		return univ;

	}

	public void delete(EtapaCrianzaPK id) {
		etapaCrianzarepository.deleteById(id);
}
}