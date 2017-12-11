package com.yr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yr.dao.BookShopDaoImpl;
import com.yr.entry.Account;
import com.yr.entry.Book;
import com.yr.entry.BookStock;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookShopDaoImpl bookShopDaoImpl;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,rollbackFor=Exception.class,readOnly=false)
	public void testTransactional(int id,String isbn){
		Account account = bookShopDaoImpl.getBalance(id);
		Book book = bookShopDaoImpl.getBookPrice(isbn);
		BookStock bookStock = bookShopDaoImpl.getBookStock(isbn);
		double balance = account.getBalance();
		double bookPrice = book.getPrice();
		int stock = bookStock.getStock();
		if (balance>=bookPrice) {
			balance=balance-bookPrice;
			Account account2 = new Account(id, balance);
			bookShopDaoImpl.deductMoney(account2);
			if (stock>0) {
				BookStock bookStock2 = new BookStock(isbn, stock);
				bookShopDaoImpl.deductStock(bookStock2);
			}else {
				throw new RuntimeException();
			}
		}else {
			throw new RuntimeException();  
		}
	}
}
