package com.mycompany.storeprojectdb;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

public class Connection {

    public static Firestore db;

    public static void conectFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("storeproyectdb-firebase-adminsdk.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Succesful conecction");
        } catch (IOException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

}
