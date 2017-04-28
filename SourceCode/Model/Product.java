package com.lxy.customerinfomanager.model;
/**
 * 产品模型类
 * @author xiaoyang
 *
 */
public class Product {
	private int id;	//产品编号
	private String productName;	//产品名称
	private String companyName;	//产品公司
	private float price;		//产品价格
	private String	productDesc;//产品简介
	private Integer companyId;	//公司ID
	private float price2;
	public float getPrice2() {
		return price2;
	}
	public void setPrice2(float price2) {
		this.price2 = price2;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Product() {
		super();
	}
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	public Product(String productName, Integer companyId) {
		super();
		this.productName = productName;
		this.companyId = companyId;
	}
	public Product(String productName, float price, Integer companyId, float price2) {
		super();
		this.productName = productName;
		this.price = price;
		this.companyId = companyId;
		this.price2 = price2;
	}
	public Product(int id, String productName, String companyName, float price, String productDesc) {
		super();
		this.id = id;
		this.productName = productName;
		this.companyName = companyName;
		this.price = price;
		this.productDesc = productDesc;
	}
	public Product(String productName, float price, String productDesc, Integer companyId) {
		super();
		this.productName = productName;
		this.price = price;
		this.productDesc = productDesc;
		this.companyId = companyId;
	}
	public Product(String productName, String companyName, float price, String productDesc, Integer companyId) {
		super();
		this.productName = productName;
		this.companyName = companyName;
		this.price = price;
		this.productDesc = productDesc;
		this.companyId = companyId;
	}
	
	public Product(int id, String productName, float price, String productDesc, Integer companyId) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.productDesc = productDesc;
		this.companyId = companyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	@Override
	public String toString() {
		return productName;
	}
	
	

}
