package com.lxy.customerinfomanager.model;
/**
 * 客户模型类
 * @author xiaoyang
 *
 */
public class Customer {
	private int id;					//客户编号
	private String customerName;	//客户姓名
	private String sex;				//客户性别
	private String customerTel;		//联系电话
	private String customerEmail;	//电子邮箱
	private String customerDesc;	//客户简介
	private String companyName;		//公司名称
	private String productName;		//产品名称
	private Integer productId;			//产品ID
	private Integer companyId;			//公司ID
	
	
	public Customer(String customerName, String sex, String customerTel, String customerEmail, String customerDesc,
			Integer productId, Integer companyId) {
		super();
		this.customerName = customerName;
		this.sex = sex;
		this.customerTel = customerTel;
		this.customerEmail = customerEmail;
		this.customerDesc = customerDesc;
		this.productId = productId;
		this.companyId = companyId;
	}
	public Customer(int id, String customerName, String sex, String customerTel, String customerEmail,
			String customerDesc, String companyName, String productName) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.sex = sex;
		this.customerTel = customerTel;
		this.customerEmail = customerEmail;
		this.customerDesc = customerDesc;
		this.companyName = companyName;
		this.productName = productName;
	}
	public Customer() {
		super();
	}
	
	public Customer(String customerName, String sex, String customerTel, String customerEmail, String customerDesc,
			String companyName, String productName, Integer productId, Integer companyId) {
		super();
		this.customerName = customerName;
		this.sex = sex;
		this.customerTel = customerTel;
		this.customerEmail = customerEmail;
		this.customerDesc = customerDesc;
		this.companyName = companyName;
		this.productName = productName;
		this.productId = productId;
		this.companyId = companyId;
	}
	
	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}
	
	public Customer(int id, String customerName, String sex, String customerTel, String customerEmail,
			String customerDesc, Integer productId, Integer companyId) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.sex = sex;
		this.customerTel = customerTel;
		this.customerEmail = customerEmail;
		this.customerDesc = customerDesc;
		this.productId = productId;
		this.companyId = companyId;
	}
	public Customer(String customerName, Integer productId, Integer companyId) {
		super();
		this.customerName = customerName;
		this.productId = productId;
		this.companyId = companyId;
	}
	public Customer(String customerName, Integer companyId) {
		super();
		this.customerName = customerName;
		this.companyId = companyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerDesc() {
		return customerDesc;
	}
	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
}
