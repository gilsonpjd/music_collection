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
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new RuntimeException("Empty list");
        }
        return users;
    }

    public User UserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User CreatedUser(User user) {
        CheckIfNameExists(user);
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user");
        }
    }

    private void CheckIfNameExists(User user) {
        List<User> users = userRepository.findAll();
        for (User userAux : users) {
            if (userAux.getName().equals(user.getName())) {
                throw new RuntimeException("User already exists");
            }
        }
    }
    public User UpdateUser(Integer id, User user) {
        User userUpdate = UserById(id);
        CheckIfNameExists(user);
        userUpdate.setName(user.getName());
        return userRepository.save(userUpdate);
    }

    public void DeleteUser(Integer id) {
        UserById(id);
        userRepository.deleteById(id);
    }

}
