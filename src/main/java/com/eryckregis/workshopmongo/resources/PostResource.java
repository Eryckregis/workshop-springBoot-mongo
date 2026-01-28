package com.eryckregis.workshopmongo.resources;

import com.eryckregis.workshopmongo.domain.Post;
import com.eryckregis.workshopmongo.resources.util.URL;
import com.eryckregis.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
     text = URL.decodeParam(text);
       List<Post> title = postService.findByTitle(text);
        return ResponseEntity.ok().body(title);
    }

}
