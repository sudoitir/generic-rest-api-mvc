package ir.sudoit.infrastructure.crud.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import static org.assertj.core.api.Assertions.assertThat;

class BaseEntityTest
{
    private Model x;
    private Model y;
    private Model z;

    @BeforeEach
    public void setUp()
    {
        x = new Model(1);
        y = new Model(1);
        z = new Model(1);
    }


    @Test
    void reflexive()
    {
        assertThat(x).isEqualTo(x);
    }

    @Test
    void symmetric()
    {
        assertThat(x).isEqualTo(y);
        assertThat(y).isEqualTo(x);
    }

    @Test
    void transitive()
    {
        assertThat(x).isEqualTo(y);
        assertThat(y).isEqualTo(z);
        assertThat(z).isEqualTo(x);
    }

    @Test
    void consistence()
    {
        for (int i = 0; i < 1000; i++)
        {
            assertThat(x).isEqualTo(y);
        }
    }

    @Test
    void nullComparison()
    {
        assertThat(new Model(null)).isNotNull();
        assertThat(new Model(0)).isNotNull();
        assertThat(new Model(Integer.MIN_VALUE)).isNotNull();
        assertThat(new Model(Integer.MAX_VALUE)).isNotNull();
    }

    @Test
    void hashCodeContract()
    {
        assertThat(x.equals(y)).isTrue();
        assertThat(x.hashCode()).isEqualTo(y.hashCode());

        // consistence
        assertThat(x.hashCode()).isEqualTo(x.hashCode());
    }

    @Test
    void comparisonWithProxy()
    {
        Model model = new Model(1);
        Model proxy = (Model) Enhancer.create(
                Model.class,
                (MethodInterceptor) (object, method, args, methodProxy)->methodProxy.invoke(model, args)
        );
        assertThat(model).isEqualTo(proxy);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class Model extends BaseEntity<Integer>
    {
        private Integer id;
    }
}