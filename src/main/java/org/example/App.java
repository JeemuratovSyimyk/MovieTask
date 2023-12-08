package org.example;

import org.example.Entity.Cast;
import org.example.Entity.DataBase;
import org.example.Entity.Director;
import org.example.Entity.Movie;
import org.example.Enum.Genre;
import org.example.Service.Findable;
import org.example.Service.Sortable;
import org.example.ServiceImpl.FindableImpl;
import org.example.ServiceImpl.SortableImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        int num;
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minutes = now.getMinute();
        int second = now.getSecond();
        if(hour >18) {
            System.out.println(" Добрый вечер! ");
        }else if (hour >12) {
            System.out.println(" Добрый день! ");
        }else {
            System.out.println(" Доброе утро! ");
        }
        System.out.println(" Время: " + hour + ":" + minutes + ":" + second);

        Sortable sortable = new SortableImpl();
        Findable findable = new FindableImpl();
        DataBase dataBase = new DataBase();

        List<Director> directors = new ArrayList<>();
        Director director1 = new Director("Sam", "Raimi");
        Director director2 = new Director("Avi", "Arad");
        Director director3 = new Director("Alvin", "Sargent");
        Director director4 = new Director("David", "Koepp");
        Director director5 = new Director("Eric", "Hayden");
        Director director6 = new Director("Bryce", "Dallas How");

        List<Cast> casts = new ArrayList<>();
        Cast cast1 = new Cast("Andrew Garfield", "Peter Porker");
        Cast cast2 = new Cast("Daniel Redcliffe", "Harry Poter");
        Cast cast3 = new Cast("Chris Evans", "Avengers");
        Cast cast4 = new Cast("Sisi Wang", "Yang Xian");
        Cast cast5 = new Cast("Robert Downey", "Tony Stark");
        Cast cast6 = new Cast("Chris Hemsworth", "Thor");

       List<Movie>movies = new ArrayList<>();
        Movie movie1 = new Movie("Spider-Man", 2015, Genre.FANTASY, director1, cast1);
        Movie movie2 = new Movie("Harry Poter", 2020, Genre.FANTASY, director2, cast2);
        Movie movie3 = new Movie("Capitan America", 2021, Genre.FANTASY, director3, cast3);
        Movie movie4 = new Movie("Where is my Home", 2022, Genre.DRAMA, director4, cast4);
        Movie movie5 = new Movie("Civil War", 2019, Genre.FANTASY, director5, cast5);
        Movie movie6 = new Movie("Thor", 2018, Genre.FANTASY, director6, cast6);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);

        while (true) {
            System.out.println("""

                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Choose an operation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                 | 1-Get all movies                    ||  2-Find movie by name              |
                                 | 3-Find movie by  actor name          ||  4-Find movie by year              |
                                 | 5-Find movie by director            ||  6-Find movie by genre             |
                                 | 7-Find movie by role                ||  8-Sort movies by name (A to Z)    |
                                 | 9-Sort movies by name (Z to A)      || 10-Sort movies by year (Ascending)|
                                 | 11-Sort movies by year (Descending) || 12-Sort movies by director        |
                            """);

            switch (num = scanner.nextInt()) {
                case 1:
                    List<Movie> allMovies = findable.getAllMovies(movies);
                    for (Movie movie : allMovies) {
                        System.out.println(movie);
                    }
                    break;
                case 2:
                    findable.findMovieByFullNameOrPartName();
                    System.out.println("Введите поисковый запрос:");
                    String searchQuery = scanner.next();
                    System.out.println("Фильмы найденные по поисковому запросу:");
                    findable.findMovieByFullNameOrPartName(movies, searchQuery);
                case 3:
                    findable.findMovieByActorName(movies);
                case 4:
                    findable.findMovieByYear(movies);
                case 5:
                    findable.findMovieByDirector(movies);
                case 6:
                    findable.findMovieByGenre(movies);
                case 7:
                    findable.findMovieByRole(movies);
            }
        }

    }
}