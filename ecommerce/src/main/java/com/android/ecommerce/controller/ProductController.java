package com.android.ecommerce.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.android.ecommerce.generic.GenericCRUDController;
import com.android.ecommerce.generic.IGenericCRUDRepository;
import com.android.ecommerce.model.product.Product;
import com.android.ecommerce.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericCRUDController<Product>{
	
	  private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	
    @Autowired
    private ObjectMapper objectMapper;
    
	@Autowired
	private ProductService productService;

	protected ProductController(IGenericCRUDRepository<Product> genericRepository) {
		super(genericRepository, Product.class);
	}

	@PostMapping("/create-with-image")
	public ResponseEntity<Product> createProductWithImage(
	        @RequestParam("image") MultipartFile imageFile, 
			@RequestParam("product") String productJson
	        
	        ) {

		Product product = null;
		
		 try {
			product = objectMapper.readValue(productJson, Product.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product productWithImage = productService.saveImageOfProduct(product,imageFile);
		return super.create(productWithImage);
	}

	@GetMapping("/list-product-supplier/{supplierId}")
    public ResponseEntity<List<Product>> getProduitById(@PathVariable Integer supplierId) {
        try {
            // Log the start of the request
            logger.info("Received GET request to retrieve products by supplier ID: {}", supplierId);

            // Your code for handling the request

            // Log the successful response
            logger.info("Products retrieved successfully.");
            return productService.getProductBySupplier(supplierId);
        } catch (Exception e) {
            // Log any exceptions that occur
            logger.error("Error while retrieving products by supplier ID: {}", supplierId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
	@GetMapping("/list-product-like/{name}")
    public ResponseEntity<List<Product>> getProduitLikeName(@PathVariable String name) {
		return productService.getProductLikeName(name);
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
