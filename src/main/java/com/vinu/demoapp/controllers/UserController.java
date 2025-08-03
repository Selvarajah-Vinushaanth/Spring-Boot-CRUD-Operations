package com.vinu.demoapp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinu.demoapp.entity.UserEntity;
import com.vinu.demoapp.exceptions.ResourceNotFoundException;
import com.vinu.demoapp.model.User;
import com.vinu.demoapp.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // @GetMapping
    // public String getUsers(){
    //     return "Users";
    // }
    // @GetMapping
    // public List<User> getUsers(){
    //     return Arrays.asList(new User(1L,"Vinu","vinu@gmail.com"),new User(2L, "subo", "selvasubo@gmail.com"));
    // }
    @Autowired
    private UserRepository userRepository;

     @GetMapping
    public List<UserEntity> getUsers(){
        // return Arrays.asList(new User(1L,"Vinu","vinu@gmail.com"),new User(2L, "subo", "selvasubo@gmail.com"));
        return userRepository.findAll();
    }
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        // System.out.println("post create user called"+userEntity.getEmail()+userEntity.getName());
        return userRepository.save(userEntity);
        

    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));
        
    }
    @PutMapping("/{id}")
    public UserEntity updateuser(@RequestBody UserEntity userEntity,@PathVariable Long id){
        UserEntity userData= userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));
        userData.setEmail(userEntity.getEmail());
        userData.setName(userEntity.getName());
        return userRepository.save(userData);
    }
    // @DeleteMapping("/{id}")
    // public UserEntity deleteUser(@PathVariable Long id){
    //     UserEntity userData=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id "+id));
    //     userRepository.delete(userData);
    //     return userData;

    // }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        UserEntity userData=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id "+id));
        userRepository.delete(userData);
        return ResponseEntity.ok().build();

    }


}
