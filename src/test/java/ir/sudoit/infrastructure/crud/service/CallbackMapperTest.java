package ir.sudoit.infrastructure.crud.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CallbackMapperTest
{
    private CallbackMapper<String, String> mapper;
    private String source, target;

    @BeforeEach
    public void setUp()
    {
        source = "source";
        target = "target";
        mapper = new CallbackMapper<>(this::map, this::callback);
    }

    private String map(String source, String target)
    {
        return source + "/" + target;
    }

    private void callback(String source, String target)
    {
        assertThat(source).isEqualTo(this.source);
        assertThat(target).isEqualTo(this.source + "/" + this.target);
    }

    @Test
    void apply()
    {
        assertThat(mapper.apply(source, target)).isEqualTo(this.source + "/" + this.target);
    }
}