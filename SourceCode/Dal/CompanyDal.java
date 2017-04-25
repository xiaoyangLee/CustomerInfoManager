package com.lxy.customerinfomanager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.util.StringUtil;

/**
 * 公司数据库操作类
 * @author xiaoyang
 *
 */
public class CompanyDal {
	/**
	 * 公司添加函数
	 * @param con
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Company company) throws Exception{
		String sql="insert into t_company values(null,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,company.getCompanyName() );
		pstmt.setString(2,company.getCompanyTel());
		pstmt.setString(3, company.getCompanyEmail());
		pstmt.setString(4, company.getCompanyAddress());
		pstmt.setString(5, company.getCompanyDesc());
		
		return pstmt.executeUpdate();
	}
	/**
	 * 公司查询
	 * @param con
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con,Company company)throws Exception {
		StringBuffer stringBuffer=new StringBuffer("select * from t_company where t_company.companyName is not NULL");
		if (StringUtil.isNotEmpty(company.getCompanyName())) {
			stringBuffer.append(" and t_company.companyName like '%"+company.getCompanyName()+"%'");
		}
		if (StringUtil.isNotEmpty(company.getCompanyAddress())) {
			stringBuffer.append(" and t_company.companyAddress like '%"+company.getCompanyAddress()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(stringBuffer.toString());
		return pstmt.executeQuery();		
	}
	/**
	 * 公司修改
	 * @param con
	 * @param company
	 * @return
	 * @throws Exception
	 */
	public int modify(Connection con,Company company)throws Exception {
		String sql="update t_company set companyName=?,companyTel=?,companyEmail=?,companyAddress=?,companyDesc=? where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, company.getCompanyName());
		pstmt.setString(2, company.getCompanyTel());
		pstmt.setString(3, company.getCompanyEmail());
		pstmt.setString(4, company.getCompanyAddress());
		pstmt.setString(5, company.getCompanyDesc());
		pstmt.setInt(6, company.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 公司删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
	
			String sql="delete from t_company where id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			return pstmt.executeUpdate();
	}
}
