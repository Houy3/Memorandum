package os.memorandum.services.base;

import org.springframework.data.jpa.repository.JpaRepository;
import os.memorandum.exceptions.ServiceValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class CheckService<Entity, Id, Repository extends JpaRepository<Entity, Id>>  {

    protected final Repository repository;
    private final List<Check<Entity>> checks;


    protected CheckService(Repository repository) {
        this.repository = repository;

        checks = new ArrayList<>();
        checks.addAll(registerChecks());
        Collections.sort(checks);
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

    protected abstract List<Check<Entity>> registerChecks();

}
