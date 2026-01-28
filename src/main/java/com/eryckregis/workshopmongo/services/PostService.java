package com.eryckregis.workshopmongo.services;

import com.eryckregis.workshopmongo.domain.Post;
import com.eryckregis.workshopmongo.repositories.PostRepository;
import com.eryckregis.workshopmongo.services.exception.objectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(()-> new objectNotFoundException("Post nao encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}



