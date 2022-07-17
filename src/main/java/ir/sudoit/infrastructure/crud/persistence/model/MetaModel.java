package ir.sudoit.infrastructure.crud.persistence.model;

import ir.sudoit.infrastructure.crud.persistence.dto.CrudResponse;
import ir.sudoit.infrastructure.crud.utility.PropertiesConfig;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MetaModel implements CrudResponse {

    private Integer statusCode;
    private String code;
    private String message;

    public static MetaModel getInstance(PropertiesConfig propertiesConfig) {
        return new MetaModel(200,
                propertiesConfig.getResult("success-code"),
                propertiesConfig.getResult("success-text"));
    }
}