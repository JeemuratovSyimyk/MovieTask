package org.example.ServiceImpl;

import org.example.Entity.Cast;
import org.example.Entity.DataBase;
import org.example.Entity.Movie;
import org.example.Service.Findable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindableImpl implements Findable {
  Scanner scanner = new Scanner(System.in);
    private final DataBase dataBase = new DataBase();
    @Override
    public List<Movie> getAllMovies(List<Movie> movies) {
        System.out.println("Хотите отобразить все фильмы? (да нет)");
        String Movies = scanner.next().toLowerCase();
        if ("Да".equals(Movies)) {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }else {
            System.out.println("Операция отменена пользователем");
        }
        return movies;
    }

    @Override
    public void findMovieByFullNameOrPartName(List<Movie> movies, String searchQuery) {
        System.out.println("Введите поисковый запрос");
        String Movie = scanner.next();
        List<Movie> foundMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                foundMovies.add(movie);
       }
   }
        System.out.println("Фильмы найдены по поисковому запросу '" + searchQuery + "':");
        for (Movie movie : foundMovies) {
            System.out.println(movie.getName());
   }
    }

    @Override
    public void findMovieByActorName(List<Movie> movies) {
        System.out.println("Введите имя актера:");
        String actorName = scanner.next();

        List<Movie> foundMovies = new ArrayList<>();
        for(Movie movie:movies){
            Cast cast = movie.getCast();
            if(cast != null && cast.getActorFullName().toLowerCase().contains(actorName.toLowerCase())){
                foundMovies.add(movie);
            }
        }
    if (foundMovies.isEmpty()) {
        System.out.println("Фильмов с участием актера не найдено:" + actorName);
    }else {
        System.out.println("Фильмы найдены с актером:" + actorName);
        for (Movie movie: foundMovies){
            System.out.println(movie.getName());
        }
    }
    }
    @Override
    public void findMovieByYear(List<Movie> movies) {
        System.out.println("Введите год для поиска:");
   int searchYear = scanner.nextInt();
   List<Movie> foundMovies = new ArrayList<>();
    for(Movie movie:movies){
        if(movie.getYear()==searchYear){
            foundMovies.add(movie);
        }
    }
    if(foundMovies.isEmpty()) {
        System.out.println("Фильмов за этот год не найдено: " + searchYear);
    }else {
        System.out.println("Фильмы найденные за год: " + searchYear);
   for (Movie movie:foundMovies){
       System.out.println(movie.getYear());
    }
    }
    }
    @Override
    public void findMovieByDirector(List<Movie> movies) {
        System.out.println("Введите режиссера для поиска: ");
        String directorFind = scanner.next();
        boolean found = false;
        for (Movie movie: movies){
            if(movie.getDirector().equals(directorFind)){
                System.out.println("Фильм с режиссером: " + directorFind +": " + movie.getDirector());
                found = true;
            }
        }
   if(!found){
       System.out.println("Фильм с режиссером" + directorFind + " не найден");
   }
    }
    @Override
    public void findMovieByGenre(List<Movie> movies) {
        System.out.println(" Введите жанр для поиска: ");
        String GenreFind = scanner.next();
      boolean found = false;
        for (Movie movie:movies){
      if(movie.getGenre().equalsIgnoreCase(GenreFind)){
          System.out.println(" Фильм в жанре " + GenreFind + "найден" );
   found = true;
        }
        }
   if (!found){
       System.out.println(" Фильм в жанре " + GenreFind + " не найден ");
   }
    }

    @Override
    public void findMovieByRole(List<Movie> movies) {
        System.out.println("Введите роль для поиска:");
        String roleFind = scanner.next();
        boolean found = false;
        for (Movie movie:movies){
            List<String> movieRoles = movie.getRoles();
            if(movieRoles != null && movieRoles.contains(roleFind)){
                System.out.println("Фильм с ролью" +roleFind);
                found = true;
            }
        }
    if(!found){
        System.out.println("Фильм с ролью"+ roleFind + " не найден.");
    }
    }

   @Override
    public void findMovieByFullNameOrPartName() {
   }
    }

