package in.falconworks.orgservice.domain.common.event;

import java.time.LocalDateTime;

public class DomainEvent<T> {
    private final T value;
    private final LocalDateTime timeStamp;

    public DomainEvent(T value) {
        this.value = value;
        this.timeStamp = LocalDateTime.now();
    }

    public T getValue() {
        return value;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
