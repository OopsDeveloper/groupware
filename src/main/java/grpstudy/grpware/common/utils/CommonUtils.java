package grpstudy.grpware.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
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

    /**
     * HttpServletRequest 에 담긴 요소를 반환
     * @date 2022. 12. 03.
     * @author 김연세
     * @return HttpServletRequest
     * */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestHolder =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestHolder.getRequest();
    }

    /**
     * REQUEST에 담겨있는 값을 HashParameterMap에 담아서 반환
     * VO를 사용하지 않고 Map으로 파라미터를 넘길 경우에 사용
     * @date 2022. 12. 03.
     * @author 김연세
     * @return HashParameterMap
     * */
    public static HashParameterMap setRequestParameterMap(){
        HashParameterMap params = new HashParameterMap();

        Enumeration<String> names = getRequest().getParameterNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();
            params.setObject(name, getRequest().getParameter(name));
        }

        return params;
    }
}
