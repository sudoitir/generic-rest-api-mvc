package ir.sudoit.core.person.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@RequiredArgsConstructor
public class UserAccessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4772807202714349200L;

    private final Integer code;

    private final String message;
}
