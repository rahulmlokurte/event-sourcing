package com.raulroks.eventsourcing.services;

import com.raulroks.eventsourcing.dto.AccountCreateDTO;
import com.raulroks.eventsourcing.dto.MoneyCreditDTO;
import com.raulroks.eventsourcing.dto.MoneyDebitDTO;
import com.raulroks.eventsourcing.model.commands.CreateAccountCommand;
import com.raulroks.eventsourcing.model.commands.CreditMoneyCommand;
import com.raulroks.eventsourcing.model.commands.DebitMoneyCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(),accountCreateDTO.getStartingBalance(),accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(UUID.randomUUID().toString(),moneyCreditDTO.getCreditAmount(),moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(UUID.randomUUID().toString(),moneyDebitDTO.getDebitAmount(),moneyDebitDTO.getCurrency()));
    }
}
