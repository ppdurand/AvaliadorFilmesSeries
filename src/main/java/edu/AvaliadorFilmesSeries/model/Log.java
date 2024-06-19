package edu.AvaliadorFilmesSeries.model;

public class Log {
    private double stars;
    private Movie movie;
    private String critic;


    public Log(double stars, Movie movie, String critic) {
        this.stars = stars;
        this.movie = movie;
        this.critic = critic;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public void setCritic(String critic) {
        this.critic = critic;
    }

    @Override
    public String toString() {
        return "Log{" +
                "stars=" + stars +
                ", movie=" + movie +
                ", critic='" + critic + '\'' +
                '}';
    }
}
