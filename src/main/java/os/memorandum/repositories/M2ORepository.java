package os.memorandum.repositories;

import os.memorandum.models.M2OEntity;
import os.memorandum.repositories.base.BaseJpaRepository;

public interface M2ORepository extends BaseJpaRepository<M2OEntity> {


    M2OEntity findTestEntityById(Long id);
}
