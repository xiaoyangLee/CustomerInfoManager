package com.lxy.customerinfomanager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lxy.customerinfomanager.model.Customer;
import com.lxy.customerinfomanager.util.StringUtil;

/**
 * 客户数据库操作类
 * 
 * @author xiaoyang
 *
 */
public class CustomerDal {
	/**
	 * 客户添加操作
	 * 
	 * @param con
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Customer customer) throws Exception {
		String sql = "insert into t_customer values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, customer.getCustomerName());
		pstmt.setString(2, customer.getSex());
		pstmt.setString(3, customer.getCustomerTel());
		pstmt.setString(4, customer.getCustomerEmail());
		pstmt.setString(5, customer.getCustomerDesc());
		pstmt.setInt(6, customer.getCompanyId());
		pstmt.setInt(7, customer.getProductId());

		return pstmt.executeUpdate();
	}
	/**
	 * 查询操作
	 * @param con
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con, Customer customer) throws Exception {
		StringBuffer stringBuffer = new StringBuffer(
				"select t_customer.id,customerName,sex,customerTel,customerEmail,companyName,productName,customerDesc from t_company,t_customer,t_product "
						+ "where t_customer.companyId=t_company.id and t_customer.productId=t_product.id and t_product.companyId=t_company.id ");
		if (StringUtil.isNotEmpty(customer.getCustomerName())) {
			stringBuffer.append(" and t_customer.customerName like '%"+customer.getCustomerName()+"%'");
		}
		if (customer.getCompanyId()!=null&&customer.getCompanyId()!=-1) {
			stringBuffer.append(" and t_customer.companyId ="+customer.getCompanyId());	
		}
		if (customer.getProductId()!=null&&customer.getProductId()!=-1) {
			stringBuffer.append(" and t_customer.productId="+customer.getProductId());
		}
		stringBuffer.append(" group by id");
		PreparedStatement pstmt = con.prepareStatement(stringBuffer.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 修改操作
	 * @param con
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public int modify(Connection con,Customer customer) throws Exception{
		String sql="update t_customer set customerName=?,sex=?,"
				+ "customerTel=?,customerEmail=?,companyId=?,productId=?,customerDesc=? "
				+ "where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,customer.getCustomerName());
		pstmt.setString(2, customer.getSex());
		pstmt.setString(3, customer.getCustomerTel());
		pstmt.setString(4, customer.getCustomerEmail());
		pstmt.setInt(5, customer.getCompanyId());
		pstmt.setInt(6, customer.getProductId());
		pstmt.setString(7, customer.getCustomerDesc());
		pstmt.setInt(8, customer.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 删除操作
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql="delete from t_customer where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
}
