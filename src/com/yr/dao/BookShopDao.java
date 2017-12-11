package com.yr.dao;

import com.yr.entry.Account;
import com.yr.entry.Book;
import com.yr.entry.BookStock;

public interface BookShopDao {

	public Account getBalance(int id);
	public Book getBookPrice(String isbn);
	public BookStock getBookStock(String isbn);
	public void deductMoney(Account account);
	public void deductStock(BookStock bookStock);
}
