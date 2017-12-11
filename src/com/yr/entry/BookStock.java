package com.yr.entry;

public class BookStock {

	private String isbn;
	private int stock;
	
	public BookStock() {
		super();
	}
	public BookStock(String isbn, int stock) {
		super();
		this.isbn = isbn;
		this.stock = stock;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "BookStock [isbn=" + isbn + ", stock=" + stock + "]";
	}
	
}
