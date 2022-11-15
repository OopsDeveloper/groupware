package grpstudy.grpware.place.service;

import grpstudy.grpware.place.domain.PlaceVO;
import grpstudy.grpware.place.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService{

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public int setPlace(PlaceVO vo) {
       int cnt = placeMapper.setPlace(vo);

        return cnt;
    }
}
