package com.stackroute.collections;

import java.time.LocalDate;
import java.util.Objects;

/*
Movie class has four fields- movieId,movieName, genre and releaseDate
This class should be of Comparable type comparing movies based on releaseDate
 */
public class Movie implements Comparable<Movie>{

    private final int movieId;
    private final String movieName;
    private final String genre;
    LocalDate releaseDate;

    public Movie(int movieId, String movieName, String genre, LocalDate releaseDate) {

        this.movieId=movieId;
        this.movieName=movieName;
        this.genre=genre;
        this.releaseDate=releaseDate;
    }

    public int getMovieId() {

        return movieId;
    }

    public String getMovieName() {

        return movieName;
    }

    public String getGenre() {

        return genre;
    }

    public LocalDate getReleaseDate() {

        return releaseDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(releaseDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName=" + movieName +
                ", genre=" + genre +
                ", releaseDate=" + releaseDate +
                '}';
    }


    @Override
    public int compareTo(Movie o) {
        return this.releaseDate.compareTo(o.releaseDate);
    }

}
