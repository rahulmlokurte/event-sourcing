package com.raulroks.eventsourcing.model.events;

import com.raulroks.eventsourcing.model.aggregates.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
