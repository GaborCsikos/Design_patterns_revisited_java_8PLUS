import com.milonga.PricingServiceApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PricingServiceApplication.class)
@AutoConfigureMockMvc
public class TestService {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testService() throws Exception {
        MvcResult result = mvc.perform(get("/prices")).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
    }
}
