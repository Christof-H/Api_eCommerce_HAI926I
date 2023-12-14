package com.android.ecommerce.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * 
 * @CrudRepository
 * Cette interface est utilisée pour fournir les méthodes CRUD génériques. 
 * Elle est destinée à être utilisée comme interface pour créer un service et un controller 
 * générique pour les méthodes de bases de CRUD..</p>
 *
 * 
 * Annotation @NoRepositoryBean : 
 * Cette annotation indique à Spring que GenericRepository est une interface de base 
 * pour d'autres repositories et qu'elle ne doit pas être créée comme un bean lors de l'exécution. 
 * Cela permet d'éviter que Spring crée une instance de ce repository.
 * 
 * @param <T>
 * 
 * Documentation du pattern de générique controller
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * Video d'implémentation 
 * https://www.youtube.com/watch?v=hs2YLwld804
 * 
 * A noter que nous pourrions faire hérité une autre interface que CRUD comme dans l'exemple ci
 * dessus mais nous choisissons CRUD car nous n'avons pas forcément besoin des autres fonctionnalités 
 * https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
 * 
 */
@NoRepositoryBean
public interface IGenericCRUDRepository<T extends IGenericEntity<T>> extends CrudRepository<T, Integer> {

}
