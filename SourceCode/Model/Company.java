package com.lxy.customerinfomanager.model;
/**
 * 公司模型类
 * @author xiaoyang
 *
 */
public class Company {

	private int id;		//公司编号
	private String companyName;	//公司名称
	private String companyTel;	//联系电话
	private String companyEmail;	//电子邮箱
	private String companyAddress;	//公司地址
	private String companyDesc;		//公司简介
	public Company(int id, String companyName, String companyTel, String companyEmail, String companyAddress,
			String companyDesc) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyTel = companyTel;
		this.companyEmail = companyEmail;
		this.companyAddress = companyAddress;
		this.companyDesc = companyDesc;
	}
	public Company() {
		super();
	}
	
	public Company(String companyName, String companyAddress) {
		super();
		this.companyName = companyName;
		this.companyAddress = companyAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyDesc() {
		return companyDesc;
	}
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	public Company(String companyName, String companyTel, String companyEmail, String companyAddress,
			String companyDesc) {
		super();
		this.companyName = companyName;
		this.companyTel = companyTel;
		this.companyEmail = companyEmail;
		this.companyAddress = companyAddress;
		this.companyDesc = companyDesc;
	}
	@Override
	public String toString() {
		return companyName;
	}
	
}
