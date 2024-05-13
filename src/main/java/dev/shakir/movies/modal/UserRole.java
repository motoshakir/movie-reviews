package dev.shakir.movies.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="userRole")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    private ObjectId id;

    private String roleName;

}
