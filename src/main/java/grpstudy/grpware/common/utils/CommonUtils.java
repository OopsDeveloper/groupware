package grpstudy.grpware.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CommonUtils {

    /**
     * @description 로그인 아이디 얻기
     * @date 2022. 08. 13.
     * @author 고용수
     * @return
     */
    public static String getLoginId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !"anonymousUser".equals(authentication.getName())) {
            return authentication.getName();
        } else {
            return null;
        }
    }

    /**
     * @param data
     * @return
     * @description object to json
     * @date 2022. 08. 13.
     * @author 고용수
     */
    public static String toJson(Object data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "json 변환을 실패하였습니다.";
        }
    }
}
