package com.yurets_y.spring_tutor_001.ch8_jpa.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class SingerSummary implements Serializable {
    private String firstName;
    private String lastName;
    private String latestAlbum;
    private Date releaseDate;

    public SingerSummary(String firstName, String lastName,
            String latestAlbum, Date releaseDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.latestAlbum = latestAlbum;
        this.releaseDate = releaseDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLatestAlbum() {
        return latestAlbum;
    }

    public String toString() {
        return String.format(Locale.ENGLISH,"First name: %1$s, Last Name: %2$s, " +
                "Most Recent Album: %3$s, released on %4$tA, %4$tD",firstName,lastName,latestAlbum,releaseDate);


    }
}
