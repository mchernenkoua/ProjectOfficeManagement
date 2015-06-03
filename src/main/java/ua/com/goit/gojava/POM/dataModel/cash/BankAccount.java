package ua.com.goit.gojava.POM.dataModel.cash;

import java.util.Currency;

import javax.persistence.*;

import ua.com.goit.gojava.POM.dataModel.common.DataObject;

@Entity
@Table(name = "bank_account")
public class BankAccount implements DataObject {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column(name = "bank_name")
	private String bankName;
	
	@Column
	private Currency currency;
	
	@Override
	public long getId() {
		
		return id;
		
	}
	
	public void setId(long id) {
		
		this.id = id;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public String getBankName() {
		
		return bankName;
		
	}
	
	public void setBankName(String bankName) {
		
		this.bankName = bankName;
		
	}
	
	public Currency getCurrency() {

		return currency;
		
	}

	public void setCurrency(Currency currency) {
		
		this.currency = currency;
		
	}
	
}