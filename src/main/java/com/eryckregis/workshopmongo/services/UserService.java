package com.eryckregis.workshopmongo.services;

import com.eryckregis.workshopmongo.domain.User;
import com.eryckregis.workshopmongo.dto.UserDTO;
import com.eryckregis.workshopmongo.repositories.UserRepository;
import com.eryckregis.workshopmongo.services.exception.objectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new objectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}