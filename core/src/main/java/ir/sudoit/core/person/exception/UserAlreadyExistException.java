package ir.sudoit.core.person.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@RequiredArgsConstructor
public class UserAlreadyExistException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5779620030439213829L;

    private final Integer code;

    private final String message;

}
