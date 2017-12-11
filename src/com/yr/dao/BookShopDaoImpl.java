package com.yr.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yr.entry.Account;
import com.yr.entry.Book;
import com.yr.entry.BookStock;
import com.yr.mapper.BookMapper;

@Repository
public class BookShopDaoImpl implements BookShopDao{

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Account getBalance(int id) {
		
		return bookMapper.getBalance(id);
	}

	@Override
	public Book getBookPrice(String isbn) {
		
		return bookMapper.getBookPrice(isbn);
	}

	@Override
	public BookStock getBookStock(String isbn) {
		
		return bookMapper.getBookStock(isbn);
	}

	@Override
	public void deductMoney(Account account) {
		// TODO Auto-generated method stub
		bookMapper.deductMoney(account);
	}

	@Override
	public void deductStock(BookStock bookStock) {
		// TODO Auto-generated method stub
		bookMapper.deductStock(bookStock);
	}
	
}
