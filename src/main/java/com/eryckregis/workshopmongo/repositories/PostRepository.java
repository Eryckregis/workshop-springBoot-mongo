package com.eryckregis.workshopmongo.repositories;

import com.eryckregis.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
