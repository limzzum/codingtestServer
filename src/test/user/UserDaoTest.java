//package user;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import org.junit.jupiter.api.Test;
//import com.ssafy.model.dao.user.UserDaoImpl;
//import java.sql.SQLException;
//
//public class UserDaoTest {
//
//    @Test
//    void selectTest() throws SQLException {
//        assertThat(UserDaoImpl.getUserDao().selectById("ssafy").getName()).isEqualTo("왕싸피");
//        assertThat(UserDaoImpl.getUserDao().selectById("ssafy").getPassword()).isEqualTo("ssafy");
//    }
//}
