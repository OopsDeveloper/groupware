package grpstudy.grpware.auth.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("authVO")
public class AuthVO {
    private String authId;
    private String authAuth;
}
