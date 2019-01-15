import com.yhtart.Application;
import com.yhtart.model.Customer;
import com.yhtart.service.EmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testSendEmail(){
//        String from = "no-reply@yhtart.com";
        String to = "luyh1090169180@gmail.com";
        String subject = "Test";
        String content = "This is a test Email";

        Assert.assertTrue(emailService.sendMail(to, subject, content));
    }

    @Test
    public void testSendToCustomer(){
        Customer customer = new Customer();
        customer.setName("路亚辉");
        customer.setCellphone("12345678901");
        customer.setProductUrl("https://www.abc.com/def");

        Assert.assertTrue(emailService.sendMailByCustomer(customer));
    }
}
