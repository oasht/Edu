package org.example.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Review {

    private String text;

    private int rating;
    public Review(String text, int rating) {
        this.text = text;
        this.rating = rating;
    }
}
