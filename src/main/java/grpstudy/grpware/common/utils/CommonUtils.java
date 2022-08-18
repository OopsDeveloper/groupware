package grpstudy.grpware.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;
import java.util.stream.Collectors;

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
     * @return
     * @description object to json
     * @date 2022. 08. 13.
     * @author 고용수
     * @param data
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

    /**
     * @description 로그인 계정이 admin 권한이 있는지 체크
     * @date 2022. 08. 13.
     * @author 고용수
     * @return
     */
    public static boolean isAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toSet());
        return roles.contains("ROLE_ADMIN");
    }
}
