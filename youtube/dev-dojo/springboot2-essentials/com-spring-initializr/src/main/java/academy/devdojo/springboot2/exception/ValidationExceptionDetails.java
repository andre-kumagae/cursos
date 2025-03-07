package academy.devdojo.springboot2.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

// como nao utiliza todos os codigos boilerplate, retiramos o @Data e deixamos o @Getter apenas
@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String fieldMessage;
}
