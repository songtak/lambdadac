package com.lambda.web.movie;


import com.lambda.web.mappers.MovieMapper;
import com.lambda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/list/{pageNumber}/{searchWord}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.print("검색어가 없음");
        }else{
            pxy.print("검색어가 "+searchWord);
        }
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFunction<Pager, List<MovieDTO>> f = p ->  movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print("***********");
        for(MovieDTO m : l){
            pxy.print(m.toString());
        }
        box.clear();
        box.put("count",l.size());
        box.put("list", l);
        return box.get();
    }
   /* public List<MovieDTO> list(){
        //IConsumer s = new IConsumer(){ //이름이 아니라 ()메서드로 주었기 때문에 익명이다!
            @Override
            public int max(int a, int b){
                return 0;
            }
        };
        return s.max(4, 2);
        }*/

}
