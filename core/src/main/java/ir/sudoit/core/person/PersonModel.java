package ir.sudoit.core.person;

import ir.sudoit.core.base.BaseModel;
import lombok.*;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PersonModel extends BaseModel {

    @Serial
    private static final long serialVersionUID = -3984777947317819365L;

    private String name;

    private String mobile;

    private Long orderId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PersonModel that = (PersonModel) o;

        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(mobile, that.mobile)) return false;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
