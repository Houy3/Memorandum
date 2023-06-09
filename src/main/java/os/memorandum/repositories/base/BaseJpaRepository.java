package os.memorandum.repositories.base;

import org.springframework.data.jpa.repository.JpaRepository;
import os.memorandum.models.base.BaseEntity;

public interface BaseJpaRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
