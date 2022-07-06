package ir.sudoit.infrastructure.crud.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UuidEntity extends BaseEntity<UUID> {

    @Id
    private UUID id;
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @Column
    private Boolean isDeleted = Boolean.FALSE;
    @Version
    private Long version;

    protected UuidEntity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UuidEntity that = (UuidEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(createdDate, that.createdDate)) return false;
        if (!Objects.equals(updatedDate, that.updatedDate)) return false;
        if (!Objects.equals(isDeleted, that.isDeleted)) return false;
        return Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}