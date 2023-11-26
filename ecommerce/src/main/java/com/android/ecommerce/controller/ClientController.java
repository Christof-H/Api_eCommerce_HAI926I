package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.android.ecommerce.model.Client;
import com.android.ecommerce.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	ClientService clientService;
	
	@GetMapping("/clients")
	public Iterable<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/client/{numc}")
    public Client getClientById(@PathVariable Integer numc) {
        return clientService.getClientById(numc);
    }
    
    @PostMapping("/addClient")
	@ResponseStatus(HttpStatus.CREATED)
	public void addClient(@RequestBody Client client) {
		clientService.save(client);
	}
}
