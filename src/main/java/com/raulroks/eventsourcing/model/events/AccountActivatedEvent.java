package com.raulroks.eventsourcing.model.events;

import com.raulroks.eventsourcing.model.aggregates.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
