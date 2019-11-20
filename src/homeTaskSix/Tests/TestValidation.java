package homeTaskSix.Tests;

import homeTaskSix.messenger.User;
import homeTaskSix.messenger.ValidateUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тест регистрации пользователя")
public class TestValidation {
    @Test
    public void Test(){
        ValidateUser.checkUser(new User("!asd","21312"));
    }


}
