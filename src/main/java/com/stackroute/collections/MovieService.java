package com.stackroute.collections;

import java.time.LocalDate;
import java.util.*;

public class MovieService {

    // Property to store movieMap
    private final Map<Movie, Integer> movieMap;

    /**
     * Constructor to create movieMap as an empty LinkedHashMap object
     */
    public MovieService() {
        this.movieMap = new LinkedHashMap<>();
    }

    /*
    Returns the movieMap object
     */
    public Map<Movie, Integer> getMovieMap() {
        return movieMap;
    }

    /*
    Add key-value pairs of Movie-Integer type and returns Set of Map.Entry
     */
    public Set<Map.Entry<Movie, Integer>> addKeyValuePairsToMap(Movie movie, Integer rating) {
        movieMap.put(movie, rating);
        return movieMap.entrySet();
    }

    /*
    Return Set of movie names having rating greater than or equal to given rating
     */
    public List<String> getHigherRatedMovieNames(int rating) {
        List<String> higherRatedMovies = new ArrayList<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            if (entry.getValue() >= rating) {
                higherRatedMovies.add(entry.getKey().getMovieName());
            }
        }
        return higherRatedMovies;
    }

    /*
    Return Set of movie names belonging to specific genre
     */
    public List<String> getMovieNamesOfSpecificGenre(String genre) {
        List<String> genreMovies = new ArrayList<>();
        for (Movie movie : movieMap.keySet()) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                genreMovies.add(movie.getMovieName());
            }
        }
        return genreMovies;
    }

    /*
    Return Set of movie names which are released after Specific releaseDate and having rating less than or equal to 3
    */
    public List<String> getMovieNamesReleasedAfterSpecificDateAndRatingLesserThanThree(LocalDate releaseDate) {
        List<String> moviesReleasedAfterDate = new ArrayList<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            if (entry.getKey().getReleaseDate().isAfter(releaseDate) && entry.getValue() <= 3) {
                moviesReleasedAfterDate.add(entry.getKey().getMovieName());
            }
        }
        return moviesReleasedAfterDate;
    }

    /*
    Return set of movies sorted by release dates in ascending order.
    Hint: Use TreeMap
     */
    public List<Movie> getSortedMovieListByReleaseDate() {
        Map<LocalDate, Movie> sortedMap = new TreeMap<>();
        for (Map.Entry<Movie, Integer> entry : movieMap.entrySet()) {
            sortedMap.put(entry.getKey().getReleaseDate(), entry.getKey());
        }
        return new ArrayList<>(sortedMap.values());
    }

    /*
   Return set of movies sorted by rating.
   Hint: Use Comparator and LinkedHashMap
    */
    public Map<Movie, Integer> getSortedMovieListByRating() {
        List<Map.Entry<Movie, Integer>> movieList = new LinkedList<>(movieMap.entrySet());
        movieList.sort(Map.Entry.comparingByValue());
        Map<Movie, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Movie, Integer> entry : movieList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
