package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    @DisplayName("메시지 코드 리졸버 오브젝트")
    void messageCodesResolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required","item");

        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        Assertions.assertThat(messageCodes).containsExactly("required.item","required");
    }

    @Test
    void messageCodesResolverField(){
        String[] strings = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        for (String string : strings) {
            System.out.println("string = " + string);
        }

        Assertions.assertThat(strings).containsExactly("required.item.itemName", "required.itemName","required.java.lang.String", "required");
    }
}
