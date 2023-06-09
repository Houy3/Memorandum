package os.memorandum.services.check;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.util.Assert;
import os.memorandum.models.base.BaseEntity;
import os.memorandum.repositories.base.BaseJpaRepository;
import os.memorandum.services.check.core.Check;
import os.memorandum.services.check.core.ValidationError;
import os.memorandum.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Optional;

@RequiredArgsConstructor
public class UniqueCheck<Entity extends BaseEntity, Repository extends BaseJpaRepository<Entity>> implements Check<Entity> {

    protected final Repository repository;

    protected final String fieldName;

    @Override
    public Optional<ValidationError> execute(Entity entity) {

        Class<Entity> entityClass = ReflectionUtils.getGenericParameterClass(this.getClass(), 1);
        Field field = ReflectionUtils.findField(entityClass, fieldName);
        Assert.notNull(field, "The field was not found.");
        Object value = ReflectionUtils.getField(field, entity);

        Entity entityToCheck = ReflectionUtils.getObject(entityClass);
        ReflectionUtils.setField(field, entityToCheck, value);

        System.out.println(entityToCheck);

        System.out.println(repository.exists(Example.of(entityToCheck)));
        return Optional.empty();
    }
}
