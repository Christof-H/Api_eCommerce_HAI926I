package com.android.ecommerce.generic;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import jakarta.transaction.Transactional;

/**
 * Cette classe abstraite fournit les opérations CRUD (Create, Read, Update, Delete) génériques
 * pour une entité spécifique qui seront ensuite par notre controller générique @GenericCRUDController
 * Les entités gérées par ce service doivent implémenter l'interface @IGenericEntity.
 * @param <T>
 * 
 * Documentation du pattern de générique controller
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * Video d'implémentation 
 * https://www.youtube.com/watch?v=hs2YLwld804
 * 
 */

public abstract class GenericCRUDService<T extends IGenericEntity<T>> {

	private final IGenericCRUDRepository<T> genericRepository;

	protected GenericCRUDService(IGenericCRUDRepository<T> genericRepository) {
		this.genericRepository = genericRepository;
	}


	/**
	 * Récupère tous les tuples de l'entité et les transforme
	 * en liste 
	 * 
	 * @return une liste de toutes les entités
	 * @throws NoSuchElementException si aucun élément n'est trouvé
	 */
	public List<T> findAll() {
		Iterable<T> iterable = genericRepository.findAll();
		if (iterable.iterator().hasNext()) {
			return StreamSupport.stream(iterable.spliterator(), false)
					.collect(Collectors.toList());
		}else {
			throw new NoSuchElementException("Aucun élément trouvé");
		}

	}

	/**
	 * Récupère une entité par son identifiant.
	 * 
	 * @param id l'identifiant de l'entité
	 * @return l'entité correspondante, ou null si elle n'existe pas
	 */
	public T get(Integer id){
		return genericRepository.findById(id).orElse(null);
	}

	/**
	 * Crée une nouvelle entité dans la base de données.
	 * 
	 * @param createNewRecord l'entité à créer
	 * @return l'entité nouvellement créée
	 */
	@Transactional
	public T create(T createNewRecord){
		T dao = createNewRecord.createNewInstance();
		return genericRepository.save(dao);
	}

	/**
	 * Met à jour une entité existante.
	 * 
	 * @param updated l'entité à mettre à jour
	 * @return l'entité mise à jour
	 */
	@Transactional
	public T update(T updated){
		T dao = get(updated.getId());
		dao.update(updated);
		return genericRepository.save(dao);
	}

	/**
	 * Supprime une entité de la base de données par son identifiant.
	 * 
	 * @param id l'identifiant de l'entité à supprimer
	 */
	@Transactional
	public void delete(Integer id){
		//check if object with this id exists
		get(id);
		genericRepository.deleteById(id);
	}
}