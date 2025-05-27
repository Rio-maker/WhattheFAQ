package com.whatthefaq.forum;

// Contact firebase to send data and retrieve data
// Implementation of backend logic for endpoints

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;



// Service annotation makes it a bean
@Service
public class CRUDService {

    public static String createCRUD(CRUD crud) throws ExecutionException, InterruptedException {
        // connecting to database using provided credentials
        Firestore dbFirestore = FirestoreClient.getFirestore();

        // calling the collection
        // creating the document and passing the whole CRUD object
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(crud.getName()).set(crud);


        return collectionsApiFuture.get().getUpdateTime().toString();
    }

//    public static CRUD getCRUD(String documentId) throws ExecutionException, InterruptedException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        DocumentReference documentReference = dbFirestore.collection("users").document(documentId);
//        ApiFuture<DocumentSnapshot> future = documentReference.get();
//        DocumentSnapshot document = future.get();
//        CRUD crud;
//        if (document.exists()) {
//            crud = document.toObject(CRUD.class);
//            System.out.println(crud.getName());
//            return crud;
//        }
//        return null;
//    }

    public static void getCRUD(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        CRUD crud;
        if (document.exists()) {
            System.out.println("hereeeeeee");
            crud = document.toObject(CRUD.class);
            System.out.println(crud.getDocumentId());
            System.out.println(crud.getName());
            System.out.println(crud.getProfession());
        }
    }

    public static String updateCRUD(CRUD crud) {
        return "";
    }

    public static String deleteCRUD(String documentId) {
        System.out.println("deleting user");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(documentId).delete();
        return "Successfully deleted " + documentId;
    }

//    public static String deleteUser(String documentId) {
//
//    }

}
