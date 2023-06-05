package os.memorandum.models.base;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor

@MappedSuperclass
public abstract class LongIdEntity implements Entity {


    @Id
    @SequenceGenerator(name = "base_seq",
            sequenceName = "base_sequence",
            allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_seq")
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
        if (getId() == null) {
            return 0;
        }
        return (int)(long)getId();
    }
}
