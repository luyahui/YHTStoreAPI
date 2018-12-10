import com.yhtart.Application;
import com.yhtart.model.Author;
import com.yhtart.service.AuthorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @Test
    public void save(){
        Author a = new Author();
        a.setName("孙尧佳");
        Assert.assertEquals("孙尧佳",  authorService.save(a).getName());

    }
}
