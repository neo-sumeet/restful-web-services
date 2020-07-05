package com.ss.restfulwebservices.user;

import com.ss.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("jpa/users")
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("jpa/users/{id}")
    public EntityModel<User> findOneUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException("id - "+ id);

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAllUsers()).withRel("all-users");

        EntityModel<User> model = EntityModel.of(user.get(),link);

        return model;
    }

    @PostMapping("jpa/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("jpa/users/{id}/posts")
    public  List<Post> retrievePosts(@PathVariable("id") int userId){
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("id - "+ userId);
        return user.get().getPosts();
    }

    @PostMapping("jpa/users/{id}/posts")
    public ResponseEntity<Object> addPost(@PathVariable("id") int userId, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("id - "+ userId);
        post.setUser(user.get());
        postRepository.save(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{postId}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
