package os.memorandum.services.base;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import os.memorandum.models.base.BaseEntity;
import os.memorandum.repositories.base.BaseJpaRepository;
import os.memorandum.utils.ReflectionUtils;


public abstract class BaseService<Entity extends BaseEntity, Repository extends BaseJpaRepository<Entity>> {

    protected final Repository repository;

    protected final ConversionService converter;

    protected BaseService(Repository repository,
                          @Qualifier("conversionService") ConversionService converter) {
        this.repository = repository;
        this.converter = converter;
    }

    protected final Class<Entity> getEntityClass() {
        return ReflectionUtils.getGenericParameterClass(this.getClass(), 1);
    }

    protected final Entity entityNewInstance() {
        return ReflectionUtils.getObject(getEntityClass());
    }
}
