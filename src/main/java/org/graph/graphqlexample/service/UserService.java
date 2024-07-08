package org.graph.graphqlexample.service;

import lombok.RequiredArgsConstructor;
import org.graph.graphqlexample.entity.User;
import org.graph.graphqlexample.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        if(user==null){
            throw new RuntimeException("user is null");
        }
        return userRepository.save(user);
    }

    public User getUserById(Integer id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new RuntimeException("no user found with this id "+id);
        }
        return user.get();
    }

    public Boolean deleteUser(Integer id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new RuntimeException("no user found with this id "+id);
        }
        userRepository.deleteById(id);
        return true;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        Optional<User> user1=userRepository.findById(user.getId());
        if(user1.isEmpty()){
            throw new RuntimeException("no user found with this id "+id);
        }
        var newUser=User.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return userRepository.save(newUser);
    }
}
