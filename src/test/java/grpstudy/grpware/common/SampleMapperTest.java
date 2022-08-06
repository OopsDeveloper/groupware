package grpstudy.grpware.common;

import grpstudy.grpware.common.domain.SampleVO;
import grpstudy.grpware.common.mapper.SampleMapper;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
public class SampleMapperTest {
    @Setter(onMethod_ = @Autowired)
    SampleMapper mapper;

    @Test
    public void mapperTest(){
        SampleVO vo = mapper.getSample();

        System.out.println(vo);
    }
}
