package os.memorandum.services.check.core;

import org.springframework.core.convert.ConversionService;
import os.memorandum.exceptions.ServiceValidationException;
import os.memorandum.models.base.BaseEntity;
import os.memorandum.repositories.base.BaseJpaRepository;
import os.memorandum.services.base.BaseService;

import java.util.*;


public abstract class CheckService<Entity extends BaseEntity, Repository extends BaseJpaRepository<Entity>> extends BaseService<Entity, Repository> {

    private final List<Check<Entity>> checks;

    public CheckService(Repository repository,
                        ConversionService converter) {
        super(repository, converter);
        checks = Objects.requireNonNullElse(registerChecks(new ArrayList<>()), new ArrayList<>());
    }


    protected void save(Entity entity) {
        executeChecks(entity);
        repository.save(entity);
    }

    private void executeChecks(Entity entity)  {
        List<ValidationError> errors = new ArrayList<>();
        checks.forEach(check -> check.execute(entity).ifPresent(errors::add));
        if (!errors.isEmpty()) {
            throw new ServiceValidationException(errors);
        }
    }

    protected abstract List<Check<Entity>> registerChecks(List<Check<Entity>> checks);

}
