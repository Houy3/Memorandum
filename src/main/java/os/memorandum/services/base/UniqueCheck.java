package os.memorandum.services.base;

import java.util.Optional;

public class UniqueCheck<Entity> implements Check<Entity> {


    @Override
    public Optional<ValidationError> execute(Entity entity) {
        return Optional.empty();
    }
}
