package bluecode.tech.challenge.services;

import bluecode.tech.challenge.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    public void shoudlThrowErrorWhenAgeIsNegative() {
        User user = new User();
        user.setAge(-1);
        Assertions.assertThatThrownBy(() -> userService.createUser(user))
                .isInstanceOf(RuntimeException.class);
    }

}
