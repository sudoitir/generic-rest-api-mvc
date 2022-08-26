package ir.sudoit.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class NotFoundException extends RuntimeException
{

    private final String code;

    private final String message;

}