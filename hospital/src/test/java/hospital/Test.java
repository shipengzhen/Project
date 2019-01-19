package hospital;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spz.hospital.pojo.Usee;
import com.spz.hospital.service.IUseeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Autowired
    private IUseeService useeService;
    
    @org.junit.Test
    public void test(){
        List<Usee> usees = useeService.getUsees();
        for (Usee usee : usees) {
            System.out.println(usee);
        }
    }
}
