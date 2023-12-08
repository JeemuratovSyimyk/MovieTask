package org.example.Service;

import org.example.Entity.Movie;

import java.util.List;

public interface Findable {
    List<Movie> getAllMovies(List<Movie>movies);

    void findMovieByFullNameOrPartName(List<Movie>movies ,String searchQuery);

    void findMovieByActorName(List<Movie>movies);

    void findMovieByYear(List<Movie>movies);

    void findMovieByDirector(List<Movie>movies);

    void findMovieByGenre(List<Movie>movies);

    void findMovieByRole(List<Movie>movies);

    void findMovieByFullNameOrPartName();
}
