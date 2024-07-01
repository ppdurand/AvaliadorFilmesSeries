package edu.AvaliadorFilmesSeries.rest.exceptions;


public class NotValidStarsNumber extends RuntimeException{
    public NotValidStarsNumber() {
        super("A avaliação deve ser de 0 à 10 estrelas");
    }

    public NotValidStarsNumber(String message) {
        super(message);
    }
}
