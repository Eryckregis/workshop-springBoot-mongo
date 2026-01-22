package com.eryckregis.workshopmongo.services;

import com.eryckregis.workshopmongo.domain.User;
import com.eryckregis.workshopmongo.repositories.UserRepository;
import com.eryckregis.workshopmongo.services.exception.objectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
private UserRepository userRepository;

@GetMapping
public List<User> findAll(){
    return userRepository.findAll();
}

@GetMapping
    public User findByID(String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
}



}
