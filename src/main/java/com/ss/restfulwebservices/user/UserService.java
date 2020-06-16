package com.ss.restfulwebservices.user;

import com.ss.restfulwebservices.exception.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("1","John", (new Date(80,1,12)).toInstant()));
        userList.add(new User("2","John", (new Date(81,1,11)).toInstant()));
        userList.add(new User("3","John", (new Date(82,1,10)).toInstant()));
    }

    private static int userCount = 3;

    public List<User> findAllUsers(){
        return userList;
    }

    public User findOneUser(String id){
        Optional<User> optionalUser = userList.stream().filter(user -> user.getId().equals(id)).findFirst();
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("id - "+id);
        }
        return optionalUser.get();
    }

    public void addUser(User user){
        if(user.getId() == null){
            user.setId(String.valueOf(++userCount));
        }
        userList.add(user);
    }

    public User deleteUser(String id){
        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId().equals(id)){
                iterator.remove();
                return user;
            }
        }
        throw new UserNotFoundException("id - "+id);
    }
}
