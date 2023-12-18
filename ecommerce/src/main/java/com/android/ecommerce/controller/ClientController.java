package com.android.ecommerce.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	/*
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/clients")
	public Iterable<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/client/{numclient}")
    public Client getClientById(@PathVariable Integer numclient) {
        return clientService.getClientById(numclient);
    }
    
    @PatchMapping("/client/{numclient}")
	@ResponseStatus(HttpStatus.OK)
	public Client updateClient(@PathVariable Integer numclient, @RequestBody Client updatedClient) {
		return clientService.updateClient(numclient, updatedClient);
	}
    
    @PostMapping("/addClient")
	@ResponseStatus(HttpStatus.CREATED)
	public Client addClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}
    
	@DeleteMapping("/client/{numclient}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClientById(@PathVariable Integer numclient) {
		clientService.deleteClientById(numclient);
	}
	*/
}
