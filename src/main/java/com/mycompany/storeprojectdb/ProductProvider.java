package com.mycompany.storeprojectdb;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Precondition;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ProductProvider {

    static Firestore db;

    public static boolean saveProduct(String collection, String document, Map<String, Object> data) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(collection).document(document);
            docRef.set(data);
            System.out.println("Save Succesfully");
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return false;
    }

    public static boolean updateProduct(String collection, String document, Map<String, Object> data) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(collection).document(document);
            docRef.update(data);
            System.out.println("updated Succesfully");
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return false;
    }

    public static boolean deleteProduct(String collection, String document) {
        db = FirestoreClient.getFirestore();
        try {
            DocumentReference docRef = db.collection(collection).document(document);
            docRef.delete(Precondition.NONE);
            System.out.println("Data errased succesfully");
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return false;
    }

    public static boolean readProducts(ArrayList<Product> lstProducts) {
        try {
            CollectionReference Products = Connection.db.collection("Product");
            ApiFuture<QuerySnapshot> querySnap = Products.get();
            for (DocumentSnapshot document : querySnap.get().getDocuments()) {
                Product product = new Product();
                product.setName(document.getString("Name"));
                product.setPrice(document.getDouble("Price"));
                product.setStock((int) Math.round(document.getDouble("Stock")));
                product.setId((int) Math.round(document.getDouble("Id")));
                lstProducts.add(product);
            }
            System.out.println("Data imported succesfully");
            return true;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return false;
    }

}
