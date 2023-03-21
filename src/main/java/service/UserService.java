package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> UsersList() {
        return userRepository.findAll();
    }

    public User UserById(Integer id){
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
    }
    public User CreatedUser (User user){
        return userRepository.save(user);
    }

    public User UpdateUser (Integer id, User user){
        User userUpdate = UserById(id);
        userUpdate.setName(user.getName());
        return userRepository.save(userUpdate);
    }

    public void DeleteUser (Integer id){
        userRepository.deleteById(id);
    }

}
