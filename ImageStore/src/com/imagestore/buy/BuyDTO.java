package com.imagestore.buy;

import java.sql.Date;

public class BuyDTO {
	private int buy_seq;//순서
	private String nickname;//작가명
	private String work;//작품명
	private Date buy_date;//구매일자
	private int price; //구매금액
	public int getBuy_seq() {
		return buy_seq;
	}
	public void setBuy_seq(int buy_seq) {
		this.buy_seq = buy_seq;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
