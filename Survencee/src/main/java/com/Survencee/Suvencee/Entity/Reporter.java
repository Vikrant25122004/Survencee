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
@Document(collection = "Reporters")
@AllArgsConstructor
@NoArgsConstructor
public class Reporter {
    @Id
    private ObjectId repId;
    @NonNull
    @Indexed(unique = true)
    private String repoUsername;
    @NonNull
    private String reporter_name;
    @NonNull
    private String channel_name;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
