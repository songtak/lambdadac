package com.lambda.web.movie;
import lombok.*;

import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity(name="movie") @Component
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo;
    @Column(length = 50, nullable = false)
    private String seq;
    @Column(length = 300, nullable = false)
    private String moviename;

    public  Movie(){}

    @Builder
    public Movie(String seq, String moviename){
        this.seq = seq;
        this.moviename = moviename;
    }
    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
}
