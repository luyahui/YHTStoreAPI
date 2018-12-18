import com.yhtart.Application;
import com.yhtart.model.Author;
import com.yhtart.model.Product;
import com.yhtart.service.AuthorService;
import com.yhtart.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthorService authorService;

//    @Test
//    public void save(){
//        Author author = authorService.findByID(1);
//
//        // 紫砂壶1
//        Product p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs001");
//        p.setName("紫砂壶1");
//        p.setImgUrl("https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg?proc=autoorient");
//        Assert.assertEquals("紫砂壶1", productService.save(p).getName());
//
//        // 紫砂壶2
//        p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs002");
//        p.setName("紫砂壶2");
//        p.setImgUrl("https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg");
//        productService.save(p);
//
//        // 紫砂壶3
//        p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs003");
//        p.setName("紫砂壶3");
//        p.setImgUrl("https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg?proc=autoorient");
//        productService.save(p);
//
//
//        // 紫砂壶4
//        p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs004");
//        p.setName("紫砂壶4");
//        p.setImgUrl("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
//        productService.save(p);
//
//        // 紫砂壶5
//        p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs005");
//        p.setName("紫砂壶5");
//        p.setImgUrl("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
//        productService.save(p);
//
//        // 紫砂壶6
//        p = new Product();
//        p.setAuthor(author);
//        p.setMaterial("紫砂");
//        p.setType("方器");
//        p.setNum("zs006");
//        p.setName("紫砂壶6");
//        p.setImgUrl("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
//        productService.save(p);
//    }
}
