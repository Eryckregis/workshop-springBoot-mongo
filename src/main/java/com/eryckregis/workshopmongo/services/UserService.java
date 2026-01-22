package com.eryckregis.workshopmongo.services;

import com.eryckregis.workshopmongo.domain.User;
import com.eryckregis.workshopmongo.dto.UserDTO;
import com.eryckregis.workshopmongo.repositories.UserRepository;
import com.eryckregis.workshopmongo.services.exception.objectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping
    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
    }

    @PostMapping
    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    @DeleteMapping
    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @PutMapping
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj ,User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}