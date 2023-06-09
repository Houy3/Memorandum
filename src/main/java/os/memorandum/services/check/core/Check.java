package os.memorandum.services.check.core;



import java.util.Optional;

@FunctionalInterface
public interface Check<Entity> {

    Optional<ValidationError> execute(Entity entity);
}
