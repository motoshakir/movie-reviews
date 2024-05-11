package dev.shakir.movies.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collation = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private ObjectId id;

    private String body;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;


    public Review(String body, LocalDateTime createdDate,LocalDateTime modifiedDate){
        this.body = body;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }


}
