package os.memorandum.services.check;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.data.domain.Example;
import os.memorandum.models.base.BaseEntity;
import os.memorandum.repositories.base.BaseJpaRepository;
import os.memorandum.services.check.core.Check;
import os.memorandum.services.check.core.ValidationError;
import os.memorandum.utils.ReflectionUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UniqueCheck<Entity extends BaseEntity, Repository extends BaseJpaRepository<Entity>> implements Check<Entity> {

    private final Repository repository;

    private final String fieldName;

    private final Class<Entity> entityClass;

    @Override
    public Optional<ValidationError> execute(Entity entity) {

        Entity entityToCheck = ReflectionUtils.getObject(entityClass);

        try {
            FieldUtils.writeField(entityToCheck,
                    fieldName,
                    FieldUtils.readField(entity, fieldName, true),
                    true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Problems with UniqueCheck reflection.");
        }

        List<Entity> matches = repository.findAll(Example.of(entityToCheck));

        if (matches.contains(entity)) {
            return Optional.of(new ValidationError("", "unique constraint violation"));
        }


//        DataAccessException

        System.out.println(repository.exists(Example.of(entityToCheck)));
        return Optional.empty();
    }
}
