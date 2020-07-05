package com.ss.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@ApiModel(description = "All user details")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(notes = "Name should have atleast 2 chars")
    @Size(min = 2,message = "Name should have atleast 2 chars")
    private String name;
    @Past
    @ApiModelProperty(notes = "Should be in past")
    private Instant dob;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDob() {
        return dob;
    }

    public void setDob(Instant dob) {
        this.dob = dob;
    }

    public User(Integer id, @Size(min = 2, message = "Name should have atleast 2 chars") String name, @Past Instant dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
