package grpstudy.grpware.place.mapper;

import grpstudy.grpware.place.domain.PlaceVO;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceMapper {
    int setPlace(PlaceVO vo);
}
