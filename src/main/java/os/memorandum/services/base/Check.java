package os.memorandum.services.base;


import java.util.Optional;

@FunctionalInterface
public interface Check<Entity> extends Comparable<Check<Entity>> {

    Optional<ValidationError> execute(Entity entity);



    default int getOrder() {
        return 0;
    }
    @Override
    default int compareTo(Check o) {
        return this.getOrder() - o.getOrder();
    }
}
