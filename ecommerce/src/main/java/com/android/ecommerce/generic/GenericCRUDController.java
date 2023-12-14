package com.android.ecommerce.generic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class GenericCRUDController<T extends IGenericEntity<T>>{

	private final GenericCRUDService<T> genericService; 
	
	protected GenericCRUDController(GenericCRUDService<T> genericService) {
		this.genericService = genericService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<T>> findAll(){
		return ResponseEntity.ok(genericService.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<T> get(@PathVariable Integer id) {
		return ResponseEntity.ok(genericService.get(id));
	}
	
	@PostMapping("")
	public ResponseEntity<T> create(@RequestBody T createNewRecord) {
		return ResponseEntity.ok(genericService.create(createNewRecord));
	}
	
	@PutMapping("")
	public ResponseEntity<T> update(@RequestBody T updatedRecord) {
		return ResponseEntity.ok(genericService.update(updatedRecord));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete (@PathVariable Integer id){
		genericService.delete(id);
		return ResponseEntity.ok("Record deleted");
	}
	
}
