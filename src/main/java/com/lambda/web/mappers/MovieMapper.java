package com.lambda.web.mappers;

import com.lambda.web.movie.MovieDTO;
import com.lambda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.awt.print.Paper;
import java.util.List;


@Repository
public interface MovieMapper {

    public void insertMovie(MovieDTO movie);
    public void updateMovie(MovieDTO movie);
    public void deleteMovie(MovieDTO movie);
    public int count();
    public List<MovieDTO> selectMovies(Pager paper);
    public MovieDTO selectMovie(String movieSeq);
}
