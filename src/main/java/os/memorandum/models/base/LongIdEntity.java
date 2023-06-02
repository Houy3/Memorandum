package os.memorandum.models.base;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor

@MappedSuperclass
public abstract class LongIdEntity {


    @Id
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LongIdEntity that = (LongIdEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return (int)(long)id;
    }
}
