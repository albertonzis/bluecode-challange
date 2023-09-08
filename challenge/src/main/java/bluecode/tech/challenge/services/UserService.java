package bluecode.tech.challenge.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public Long createUser(User user) {
       User user = userRepository.save(user);
       return user.getId();
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        User updateUser = getUser(id);
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setAge(user.getAge());
        return userRepository.save(updateUser);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
}
