package edu.AvaliadorFilmesSeries.application.dto;

import edu.AvaliadorFilmesSeries.domain.model.User;

public class EditUserDTO {
    private String name;
    private String bio;


    public EditUserDTO(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public void fromUser(User user){
        this.setName(user.getName());
        this.setBio(user.getBio());
    }

    public User toUser(User user){
        user.setName(this.getName());
        user.setBio(this.getBio());

        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
