package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessafeCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void meesageCodesResolverObject(){
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        for(String messageCode : messageCodes){
            System.out.println("messageCode = " + messageCode);
        }

        Assertions.assertThat(messageCodes).contains("required.item", "required");
    }

    @Test
    @DisplayName("메시지 코드스 리졸버 필드")
    void messageCodesResolverField(){
        String[] strings = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}
