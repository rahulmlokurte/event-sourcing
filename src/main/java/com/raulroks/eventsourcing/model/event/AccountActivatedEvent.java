package com.raulroks.eventsourcing.model.event;

import com.raulroks.eventsourcing.model.aggregator.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
