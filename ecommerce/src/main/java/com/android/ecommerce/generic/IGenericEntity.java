package com.android.ecommerce.generic;

/**
 * Cette interface est conçue pour être implémentée par les classes d'entités.
 * Elle comprend des méthodes pour mettre à jour des entités existantes, récupérer
 * leur identifiant et créer de nouvelles instances de l'entité.
 * Ces méthodes sont ensuite utilisée dans @GenericCRUDService.
 *
 * @param <T> le type de l'entité
 * 
 * Documentation du pattern de générique controller
 * https://ultimate.systems/web/blog/generic-controllers-and-services-in-spring-boot-java
 * 
 * Video d'implémentation 
 * https://www.youtube.com/watch?v=hs2YLwld804
 */
public interface IGenericEntity<T> {
    
    /**
     * Met à jour l'entité courante avec les données de l'entité source fournie.
     * 
     * @param source l'entité source contenant les nouvelles données
     */
    void update(T source); 
    
    /**
     * Récupère l'identifiant unique de l'entité.
     * 
     * @return l'ID de l'entité sous forme d'un Integer
     */
    Integer getId(); 
    
    /**
     * Crée une nouvelle instance de l'entité.
     * 
     * @return une nouvelle instance du type d'entité T
     */
    T createNewInstance(); 

}


