package org.graph.graphqlexample.controller;

import lombok.RequiredArgsConstructor;
import org.graph.graphqlexample.entity.User;
import org.graph.graphqlexample.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MutationMapping
    public User createUser(@Argument String firstName,
                           @Argument String lastName,
                           @Argument String email,
                           @Argument String password
                           ){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Integer id){
        return userService.deleteUser(id);
    }

    @QueryMapping
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @QueryMapping
    public User getUser(@Argument Integer id){
        return userService.getUserById(id);
    }
}
