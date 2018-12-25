import com.yhtart.Application;
import com.yhtart.model.Author;
import com.yhtart.model.Material;
import com.yhtart.model.Product;
import com.yhtart.model.ProductType;
import com.yhtart.service.AuthorService;
import com.yhtart.service.MaterialService;
import com.yhtart.service.ProductService;
import com.yhtart.service.ProductTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private MaterialService materialService;

    @Test
    public void save(){
        ProductType type = productTypeService.findById(1);
        Material material = materialService.findById(2);
        Author author = authorService.findByID(3);
        Date date = new Date(System.currentTimeMillis());

        // 紫砂壶1
        Product p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs001");
        p.setName("紫砂壶1");
        p.setImgUrls("https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg?proc=autoorient");
        p.setDate(date);
        Assert.assertEquals("紫砂壶1", productService.save(p).getName());

        // 紫砂壶2
        p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs002");
        p.setName("紫砂壶2");
        p.setImgUrls("https://dimg05.c-ctrip.com/images/100a0c00000064pqzDAB6_C_238_268.jpg");
        p.setDate(date);
        productService.save(p);

        // 紫砂壶3
        p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs003");
        p.setName("紫砂壶3");
        p.setImgUrls("https://youimg1.c-ctrip.com/target/10080j0000009zuyqADB9_R_300_300_Q90.jpg?proc=autoorient");
        p.setDate(date);
        productService.save(p);


        // 紫砂壶4
        p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs004");
        p.setName("紫砂壶4");
        p.setImgUrls("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
        p.setDate(date);
        productService.save(p);

        // 紫砂壶5
        p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs005");
        p.setName("紫砂壶5");
        p.setImgUrls("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
        p.setDate(date);
        productService.save(p);

        // 紫砂壶6
        p = new Product();
        p.setAuthor(author);
        p.setMaterial(material);
        p.setType(type);
        p.setNum("zs006");
        p.setName("紫砂壶6");
        p.setImgUrls("https://dimg02.c-ctrip.com/images/fd/tg/g2/M05/87/D9/Cghzf1WwsVWAFjE2ACqTKYbSfPQ625_D_220_150.jpg");
        p.setDate(date);
        productService.save(p);
    }
}
