import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmailValidaterTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testParametersFromMethod(String email, boolean isValid) {
        System.out.println("Email \"" + email + "\"" + (isValid? " is valid" : " is invalid"));
    }

    private static Stream<Arguments> provideParameters() {
        List<String> validEmail = new ArrayList<>();
        List<String> invalidEmail = new ArrayList<>();

        validEmail.add("s1f2s1dfsd2f1sd@s2dfs3.sdfe");
        validEmail.add("ab@yahoo.com");
        validEmail.add("abc@hotmail.com");

        invalidEmail.add("@gmail.com");
        invalidEmail.add("ab@gmail.");
        invalidEmail.add("@#abc@gmail.com");

        List<Arguments> validEmailArguments = new ArrayList<>();
        List<Arguments> invalidEmailArguments = new ArrayList<>();

        validEmail.forEach((email) -> validEmailArguments.add(Arguments.of(email, true)));
        invalidEmail.forEach((email) -> invalidEmailArguments.add(Arguments.of(email, false)));

        List<Arguments> allTestArguments = new ArrayList<>();
        allTestArguments.addAll(validEmailArguments);
        allTestArguments.addAll(invalidEmailArguments);

        return allTestArguments.stream();
    }

}
