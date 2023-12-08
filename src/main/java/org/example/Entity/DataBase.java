package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class DataBase {
    private List<Movie> movies = new ArrayList<>();
    private List<Cast> casts = new ArrayList<>();
    private List<Director> directors = new ArrayList<>();


    }


