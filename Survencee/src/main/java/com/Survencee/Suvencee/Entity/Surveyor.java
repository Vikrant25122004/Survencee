package com.Survencee.Suvencee.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Surveyor")
@AllArgsConstructor
@NoArgsConstructor
public class Surveyor {
    @Id
    private ObjectId SurveyorId;
    @NonNull
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
