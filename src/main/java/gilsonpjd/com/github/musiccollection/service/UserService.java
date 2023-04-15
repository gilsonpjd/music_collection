package gilsonpjd.com.github.musiccollection.service;

import gilsonpjd.com.github.musiccollection.DTO.UserDto;
import gilsonpjd.com.github.musiccollection.model.User;
import gilsonpjd.com.github.musiccollection.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> UsersList() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        List<UserDto> usersDto = new ArrayList<>();
        for (User user : users) {
            UserDto dto = new UserDto(user);
            usersDto.add(dto);
        }
        return usersDto;
    }
    public UserDto UserById(Integer id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new NoSuchElementException("User Not Found");
        }
        UserDto dto = new UserDto(user);
        return dto;
    }

    public UserDto CreatedUser(User user) {
        UserDto userDto = new UserDto(user);
        CheckIfNameExists(userDto);
        try {
            User save = userRepository.save(user);
            UserDto dto = new UserDto(save);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user");
        }
    }

    private void CheckIfNameExists(UserDto user) {
        List<User> users = userRepository.findAll();
        for (User userAux : users) {
            if (userAux.getName().equals(user.getName())) {
                throw new RuntimeException("User already exists");
            }
        }
    }
    public UserDto UpdateUser(Integer id, User user) {
        UserDto userDto = new UserDto(user);
        CheckIfNameExists(userDto);
        userRepository.findById(id);
        User userUpdate = new User();
        userUpdate.setId(id);
        userUpdate.setName(userDto.getName());
        User save = userRepository.save(userUpdate);
        UserDto dto = new UserDto(save);
        return dto;
    }

    public void DeleteUser(Integer id) {
        UserById(id);
        userRepository.deleteById(id);
    }

}
