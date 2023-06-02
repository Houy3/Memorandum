package os.memorandum.repositories.base;

import org.springframework.data.jpa.repository.JpaRepository;
import os.memorandum.models.base.LongIdEntity;

public interface MainEntityJpaRepository<T extends LongIdEntity> extends JpaRepository<T, Long> {
}
