package com.android.ecommerce.generic;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Generic controller class implémentant les opérations CRUD pour un type d'entité donnée.
 * Cette classe abstraite peut-être hérité dans un controller specific à une entité to .
 *
 * @param <T> Le type de l'entité, qui dois implémenter IGenericEntity.
 */
public abstract class GenericCRUDController<T extends IGenericEntity<T>>{

	private final GenericCRUDService<T> genericService; 
	 
	protected GenericCRUDController(IGenericCRUDRepository<T> genericRepository, Class<T> entityClass) {
		this.genericService = new GenericCRUDService<T>(genericRepository, entityClass) {
		};
	}

	/**
	 * Retourne toutes les tuples de la table .
	 * 
	 * @return ReponseEntity contenant la liste des tuples.
	 */
	@GetMapping("")
	public ResponseEntity<List<T>> findAll(){
		return ResponseEntity.ok(genericService.findAll()); 
	}

	/**
	 * Retourne un seul tuple par son ID.
	 * 
	 * @param id l'identifiant de l'entité retrouvée.
	 * @return ReponseEntity contenant le tuples.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<T> get(@PathVariable Integer id) {
		return ResponseEntity.ok(genericService.get(id));
	}

	/**
	 * Créer un nouveau tuple.
	 * 
	 * @param createNewRecord l'instance de l'entité à créer.
	 * @return ResponseEntity contenenant l'instance crée.
	 */
	@PostMapping("")
	public ResponseEntity<T> create(@RequestBody @Valid T createNewRecord) {
		return ResponseEntity.ok(genericService.create(createNewRecord));
	}

	/**
	 * Modifie un tuple existant dans la base
	 * 
	 * @param updatedRecord le tuple existant avec les informations modifiée.
	 * @return ResponseEntity contenant le tuple modifiée.
	 */
	@PutMapping("")
	public ResponseEntity<T> update(@RequestBody @Valid T updatedRecord) {
		return ResponseEntity.ok(genericService.update(updatedRecord));
	}

	/**
	 * Supprimer un tuple par son identifiant.
	 * 
	 * @param id l'identifiant du tuple à supprimer
	 * @return ResponseEntity avec un message de confirmation de suppression.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete (@PathVariable Integer id){
		genericService.delete(id);
		return ResponseEntity.ok("Record deleted");
	}

}
