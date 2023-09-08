package bluecode.tech.challenge.services;

import bluecode.tech.challenge.exceptions.NotFoundException;
import bluecode.tech.challenge.models.User;
import bluecode.tech.challenge.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public Long createUser(User user) {
        if (Objects.isNull(user.getAge()) || user.getAge() < 0 )
            throw new RuntimeException();

        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
            return userOptional.get();
        else
            throw new NotFoundException();
    }

    public User updateUser(Long id, User user) {
        User updateUser = getUser(id);
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setAge(user.getAge());
        return userRepository.save(updateUser);
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUser(id));
    }
}
