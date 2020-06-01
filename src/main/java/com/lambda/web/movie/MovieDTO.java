package com.lambda.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@Component
public class MovieDTO {
    private String movieSeq, rank, title, rankDate;

    public String getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(String movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieSeq='" + movieSeq + '\'' +
                ", rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }
}