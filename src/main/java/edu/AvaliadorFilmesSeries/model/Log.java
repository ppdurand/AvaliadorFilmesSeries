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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Log(double stars, String critic, Movie movie, User user) {
        this.stars = stars;
        this.critic = critic;
        this.movie = movie;
        this.user = user;
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
                ", user=" + user.getName() +
                '}';
    }
}
