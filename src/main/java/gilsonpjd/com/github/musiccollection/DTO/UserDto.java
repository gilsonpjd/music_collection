package gilsonpjd.com.github.musiccollection.DTO;

import gilsonpjd.com.github.musiccollection.model.User;
public class UserDto {


    private Integer id;
    private String name;

    public UserDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto(User user) {
        id = user.getId();
        name = user.getName();
    }

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
}
