package com.Survencee.Suvencee.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;

@Document(collection = "Survey")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surveys {
    @Id
    private ObjectId id;
    @NonNull
    private String username;
    @NonNull
    private String title;
    @NonNull
    private ArrayList<String> proofs;
    @NonNull
    private String Surveys;
    private int likes = 0;
    private ArrayList<String> like = new ArrayList<>();
    private HashMap<String, String> comments = new HashMap<>();
    private int comment =0;
    private int views = 0;



}
