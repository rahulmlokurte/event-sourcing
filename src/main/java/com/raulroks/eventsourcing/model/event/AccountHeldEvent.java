package com.raulroks.eventsourcing.model.event;

import com.raulroks.eventsourcing.model.aggregator.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
