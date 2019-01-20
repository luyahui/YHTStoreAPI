import com.yhtart.Application;
import com.yhtart.model.User;
import com.yhtart.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Assert.assertEquals(userRepository.save(user).getUsername(), "admin");
    }
}
