package com.eryckregis.workshopmongo.repositories;

import com.eryckregis.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

    @Query("{'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
