package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lxy.customerinfomanager.dal.CompanyDal;
import com.lxy.customerinfomanager.dal.ProductDal;
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.model.Product;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ProductInfoAddInterFrm extends JInternalFrame {
	private JTextField productNameText;
	private JTextField productPriceText;
	private JComboBox companyComboBox;
	private JTextArea productDescTextArea;
	DbUtil dbUtil=new DbUtil();
	ProductDal productDal=new ProductDal();
	CompanyDal companyDal=new CompanyDal();
	public ProductInfoAddInterFrm(JDesktopPane table) {
		// TODO Auto-generated constructor stub
		this();
		this.setLocation((table.getWidth() - this.getWidth()) / 2, (table.getHeight() - this.getHeight()) / 2);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductInfoAddInterFrm frame = new ProductInfoAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductInfoAddInterFrm() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u4EA7\u54C1\u6DFB\u52A0");
		setBounds(100, 100, 800, 456);

		JLabel lblNewLabel = new JLabel("\u4EA7\u54C1\u540D\u79F0");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 16));

		productNameText = new JTextField();
		productNameText.setColumns(10);

		JLabel label = new JLabel("\u6240\u5C5E\u516C\u53F8");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_1 = new JLabel("\u4EA7\u54C1\u4EF7\u683C");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));

		productPriceText = new JTextField();
		productPriceText.setColumns(10);

		JLabel label_2 = new JLabel("\u4EA7\u54C1\u7B80\u4ECB");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					productInfoAddActionPerform(e);
				}else{
					JOptionPane.showMessageDialog(null, "你不是管理员，无权操作此项！");
					return;
				}			
			}

		});
		addBtn.setIcon(new ImageIcon(ProductInfoAddInterFrm.class.getResource("/images/add.png")));
		addBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerform(e);
			}
		});
		resetBtn.setIcon(new ImageIcon(ProductInfoAddInterFrm.class.getResource("/images/reset.png")));
		resetBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyComboBox = new JComboBox();
		
		productDescTextArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(productPriceText, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addBtn)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
								.addComponent(productDescTextArea, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(companyComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(productNameText, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(309, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(productNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(companyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(productPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(productDescTextArea, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(resetBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//初始化下拉框
		fillCompany();

	}

	// 重置事件处理
	private void resetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.productNameText.setText("");
		this.productPriceText.setText("");
		this.productDescTextArea.setText("");
		if (this.companyComboBox.getItemCount() > 0) {
			this.companyComboBox.setSelectedIndex(0);
		}
	}
	/**
	 * 产品添加
	 * @param e
	 */
	private void productInfoAddActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String productName = this.productNameText.getText();
		String productDesc = this.productDescTextArea.getText();
		String productPrice = this.productPriceText.getText();
		Company company=(Company) this.companyComboBox.getSelectedItem();
		int companyId=company.getId();
		if (StringUtil.isEmpty(productName)) {
			JOptionPane.showMessageDialog(null, "产品名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(productPrice)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		Product product=new Product(productName, Float.parseFloat(productPrice), productDesc, companyId);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=productDal.add(con, product);
			if (addnum==1) {
				JOptionPane.showMessageDialog(null, "产品添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "产品添加失败");
				return;
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally{
			try{
				dbUtil.closeCon(con);
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}
	}
		/**
		 * 初始化公司下拉框
		 */
		private void fillCompany() {
			Connection con = null;
			Company company=null;
			try {
				con = dbUtil.getCon();
				ResultSet resultSet = companyDal.query(con, new Company());
				while (resultSet.next()) {
					company=new Company();
					company.setId(resultSet.getInt("id"));
					company.setCompanyName(resultSet.getString("companyName"));
					this.companyComboBox.addItem(company);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
}
