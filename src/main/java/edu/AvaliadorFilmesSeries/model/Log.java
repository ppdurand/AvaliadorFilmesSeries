package edu.AvaliadorFilmesSeries.model;

import jakarta.persistence.*;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double stars;
    private String critic;
    @Embedded
    private Movie movie;


    public Log(double stars, Movie movie, String critic) {
        this.stars = stars;
        this.movie = movie;
        this.critic = critic;
    }

    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public double getStars() {
        return stars;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getCritic() {
        return critic;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public void setCritic(String critic) {
        this.critic = critic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", stars=" + stars +
                ", critic='" + critic + '\'' +
                ", movie=" + movie +
                '}';
    }
}
