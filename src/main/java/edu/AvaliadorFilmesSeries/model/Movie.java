package edu.AvaliadorFilmesSeries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Movie {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String releaseYear;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Director")
    private String director;
    @JsonProperty("Plot")
    private String plot;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return releaseYear;
    }

    public void setYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + releaseYear +
                ", runtime='" + runtime + '\'' +
                ", director='" + director + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
