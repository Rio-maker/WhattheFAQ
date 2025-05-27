package com.whatthefaq.forum;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

// Import all annotations
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutionException;

// To sent out APIs
// Creating the endpoints

@Controller
public class CRUDController {

    public CRUDService crudService;

    // Constructor
    public CRUDController(CRUDService crudService) {
        this.crudService = crudService;
    }

    // REST CONTROLLER ENDPOINTS

    // CREATE
    @PostMapping("/create")
    public String createCRUD(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return CRUDService.createCRUD(crud);
    }

    // RETRIEVE
//    @GetMapping("/get")
//    public CRUD getCRUD(@RequestParam String documentId) throws InterruptedException, ExecutionException {
//        return CRUDService.getCRUD(documentId);
//    }

    @GetMapping("/getUser/{documentId}")
    void getUser(@PathVariable String documentId) throws ExecutionException, InterruptedException {
        // Logic to retrieve user with the given ID
        CRUDService.getCRUD(documentId);
    }

    // UPDATE
    @PutMapping("/update")
    public String updateCRUD(@RequestBody CRUD crud) throws InterruptedException, ExecutionException {
        return CRUDService.updateCRUD(crud);
    }

    // DELETE
//    @PutMapping("/delete")
//    public String deleteCRUD(@RequestParam String documentId) throws InterruptedException, ExecutionException {
//        return CRUDService.deleteCRUD(documentId);
//    }

    @PutMapping("/delete/{documentId}")
    public String deleteCRUD(@PathVariable String documentId) throws InterruptedException, ExecutionException {
        System.out.println("hereeee");
        return CRUDService.deleteCRUD(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("Test Get Endpoint is Working");
    }

    @GetMapping("/test/{id}")
    void getURL(@PathVariable String id) {
        // Logic to retrieve user with the given ID
        System.out.println(id);
//        return "User ID: " + id;
    }
}
