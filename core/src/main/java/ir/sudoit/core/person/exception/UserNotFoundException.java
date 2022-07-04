package ir.sudoit.core.person.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 721888536048794863L;

    private final Integer code;

    private final String message;

}
