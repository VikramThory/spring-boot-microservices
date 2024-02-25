package com.vikramsingh.accounts.dto;

import com.vikramsingh.accounts.model.Accounts;

import java.util.List;

/**
 * @author Vikram Singh on 26-02-2024
 * @git <a href="https://github.com/VikramThory">...</a>
 */
public class CustomerDetails {

    private Accounts accounts;

    private List<Cards> cards;

    private List<Loans> loans;

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public List<Loans> getLoans() {
        return loans;
    }

    public void setLoans(List<Loans> loans) {
        this.loans = loans;
    }
}
