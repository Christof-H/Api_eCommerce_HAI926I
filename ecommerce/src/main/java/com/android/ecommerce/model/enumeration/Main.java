package com.android.ecommerce.model.enumeration;

import java.util.HashSet;
import java.util.Set;

import com.android.ecommerce.model.Client;
import com.android.ecommerce.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {
        // Create a sample Client object
        Client client = new Client();
        client.setId(1);
        Set<Category> c = new HashSet<Category>();
        c.add(Category.CLOTHING);
        c.add(Category.TOY);
        client.setinterestsCenter(c);
        client.setUserType(Role.CLIENT);
        client.setLastName("Doe");
        client.setFirstName("John");
        client.setEmail("johndoe@example.com");
        client.setPostcode("12345");
        client.setUserType(Role.CLIENT);

        // Serialize objects to JSON and print to console
        ObjectMapper objectMapper = new ObjectMapper();

        String clientJson = objectMapper.writeValueAsString(client);


        System.out.println("Client JSON:");
        System.out.println(clientJson);


    }
}
