package grpstudy.grpware.login;

import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/spring-config/security-context.xml"
                        })
public class LoginTest {
    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Setter(onMethod_ = @Autowired)
    private DataSource dt;

    @Test
    public void testInsertMember() {
        String sql = "insert into tbl_member(userid, userpw, username) values (?,?,?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try{
            con = dt.getConnection();
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, "member01");
            pstmt.setString(2, pwencoder.encode("member01"));
            pstmt.setString(3, "멤버테스트");

            pstmt.executeUpdate();

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(pstmt != null) { try{ pstmt.close(); } catch(Exception e) {} }
            if(con != null) { try{ con.close(); } catch(Exception e) {} }
        }
    }

}
