package in.falconworks.orgservice.domain.common.event;

public class DomainEvent<T> {
    private final T value;

    public DomainEvent(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
