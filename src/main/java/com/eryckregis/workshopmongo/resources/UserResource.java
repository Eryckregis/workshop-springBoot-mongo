package com.eryckregis.workshopmongo.resources;

import com.eryckregis.workshopmongo.domain.User;
import com.eryckregis.workshopmongo.dto.UserDTO;
import com.eryckregis.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable String id){
       User obj = userService.findByID(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
