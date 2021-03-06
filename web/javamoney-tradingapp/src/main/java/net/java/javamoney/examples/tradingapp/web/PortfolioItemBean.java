/*
 * JSR 354 Stock-Trading System
 * Copyright 2005-2013, Werner Keil and individual contributors by the @author tag. 
 * See the copyright.txt in the distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.java.javamoney.examples.tradingapp.web;

import org.jscience.economics.money.Currency;
import org.jscience.economics.money.Money;
import org.jscience.physics.amount.Amount;


import net.java.javamoney.examples.tradingapp.business.Portfolio;
import net.neurotech.quotes.Quote;

public class PortfolioItemBean {
    private Currency currency;
    
	private String symbol;

    private int shares;

    private Quote quote;

    private Amount<Money> currentAmount;
    
    private double gainLoss;
    
    protected PortfolioItemBean(Currency curr) {
    	this.currency = curr;
    }
    
    public PortfolioItemBean(Portfolio parent) {
    	this(parent.getCurrency());
    }
    
    public int getShares() {
        return shares;
    }

    public void setShares(int quantity) {
        this.shares = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getCurrentValue() {
        return currentAmount.doubleValue(currency);
    }

    public void setCurrentValue(double currentValue) {
        //this.currentValue = currentValue;
    	this.currentAmount = Amount.valueOf(currentValue, Currency.getReferenceCurrency());
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

	/**
	 * @return the Quote value as Amount
	 */
	public Amount<Money> getQuoteAmount() {
		return Amount.valueOf(quote.getValue(), Currency.getReferenceCurrency());
	}
    
	/**
	 * @return the Quote change as Amount
	 */
	public Amount<Money> getQuoteChangeAmount() {
		return Amount.valueOf(quote.getChange(), Currency.getReferenceCurrency());
	}

    public double getGainLoss() {
        return gainLoss;
    }

    public void setGainLoss(double valueChange) {
        this.gainLoss = valueChange;
    }
    
	/**
	 * @return Gain or Loss as Amount
	 */
	public Amount<Money> getGainLossAmount() {
		return Amount.valueOf(gainLoss, Currency.getReferenceCurrency());
	}
	
	/**
	 * @return Quote Opening Price as Amount
	 */
	public Amount<Money> getQuoteOpenAmount() {
		return Amount.valueOf(quote.getOpenPrice(), Currency.getReferenceCurrency());
	}

	/**
	 * @return the currentAmount
	 */
	public Amount<Money> getCurrentAmount() {
		return currentAmount;
	}

	/**
	 * @return the currentAmount in local Currency
	 */
	public Amount<Money> getCurrentAmountLocal() {
		return currentAmount.to(currency);
	}
	
	/**
	 * @param currentAmount the currentAmount to set
	 */
	public void setCurrentAmount(Amount<Money> currentAmount) {
		this.currentAmount = currentAmount;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}