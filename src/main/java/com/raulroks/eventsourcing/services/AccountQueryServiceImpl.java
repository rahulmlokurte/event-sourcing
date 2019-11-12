package com.raulroks.eventsourcing.services;

import org.axonframework.eventhandling.DomainEventMessage;
import org.axonframework.eventsourcing.eventstore.EventStore;

import java.util.List;
import java.util.stream.Collectors;

public class AccountQueryServiceImpl implements AccountQueryService {
    private final EventStore eventStore;

    public AccountQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream()
                .map(s -> s.getPayload()).collect(Collectors.toList());
    }
}
