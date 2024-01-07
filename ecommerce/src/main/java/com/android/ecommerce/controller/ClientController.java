package com.android.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.User;
import com.android.ecommerce.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    

    @GetMapping("/{numclient}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer numclient) {
        return clientService.getClientById(numclient);
    }

}
