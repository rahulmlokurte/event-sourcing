package com.raulroks.eventsourcing.services;

import com.raulroks.eventsourcing.dto.AccountCreateDTO;
import com.raulroks.eventsourcing.dto.MoneyCreditDTO;
import com.raulroks.eventsourcing.dto.MoneyDebitDTO;
import com.raulroks.eventsourcing.model.events.AccountCreatedEvent;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
