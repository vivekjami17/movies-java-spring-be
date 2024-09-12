package dev.vivek.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // this class represent each document in the movies collection
@Data // takes care of all getter setters and string methods
@AllArgsConstructor // Annotation for constructor telling it will take all the private fields as arguments
@NoArgsConstructor // Annotation for constructor which takes no constructor whatsoever.
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference // Db will store only ids of the reviews and the reviews will be in separate collection.
    // manual reference relationship
    private List<Review> reviewIds;
}
