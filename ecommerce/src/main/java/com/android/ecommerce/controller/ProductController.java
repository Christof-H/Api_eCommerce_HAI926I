package com.android.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.android.ecommerce.generic.GenericCRUDController;
import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.product.Product;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericCRUDController<Product>{

	protected ProductController(IGenericCRUDRepository<Product> genericRepository) {
		super(genericRepository, Product.class);
		// TODO Auto-generated constructor stub
	}


	/*
	@Autowired
	ProduitService produitService;
	
	@GetMapping("/produits")
	public Iterable<Produit> getProduits() {
        return produitService.getProduits();
    }

    @GetMapping("/produit/{idp}")
    public Produit getProduitById(@PathVariable Integer idp) {
        return produitService.getProduitById(idp);
    }
    
    @PostMapping("/addProduit")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduit(@RequestBody Produit produit) {
		produitService.saveProduct(produit);
	}
    
    @PatchMapping("/produit/{idp}")
    public Produit updateProduit (@PathVariable Integer idp, @RequestBody Produit updatedProduit) {
    	return produitService.updateProduit(idp, updatedProduit);
    }
    */
}
