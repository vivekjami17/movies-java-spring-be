// THis is the API layer, it will only concern itself regarding the task of getting a request from user and returning a response.

package dev.vivek.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        // Using the service class and delegating the task of getting all the movies from DB and give it back to API layer.
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(imdbId),HttpStatus.OK);
    }
}
