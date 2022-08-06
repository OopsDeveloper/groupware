package grpstudy.grpware.common.service;

import grpstudy.grpware.common.domain.SampleVO;
import grpstudy.grpware.common.mapper.SampleMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    @Setter(onMethod_ = @Autowired)
    SampleMapper mapper;

    @Override
    public SampleVO read() {
        return mapper.getSample();
    }
}
