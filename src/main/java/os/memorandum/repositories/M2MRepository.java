package os.memorandum.repositories;

import os.memorandum.models.M2MEntity;
import os.memorandum.repositories.base.BaseJpaRepository;

public interface M2MRepository extends BaseJpaRepository<M2MEntity> {


    M2MEntity findTestEntityById(Long id);
}
