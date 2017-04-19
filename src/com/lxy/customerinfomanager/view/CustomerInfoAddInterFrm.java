package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lxy.customerinfomanager.dal.CompanyDal;
import com.lxy.customerinfomanager.dal.CustomerDal;
import com.lxy.customerinfomanager.dal.ProductDal;
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.model.Customer;
import com.lxy.customerinfomanager.model.Product;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class CustomerInfoAddInterFrm extends JInternalFrame {
	private JTextField customerNameText;
	private JTextField customerTelText;
	private JTextField customerEmailText;
	private JTextArea customerDescTextArea;
	private JRadioButton radioBtnMan;
	private JRadioButton radioBtnWoman;
	private JComboBox companyComboBox;
	private JComboBox productComboBox;
	DbUtil dbUtil=new DbUtil();
	CompanyDal companyDal=new CompanyDal();
	ProductDal productDal=new ProductDal();
	CustomerDal customerDal=new CustomerDal();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public CustomerInfoAddInterFrm(JDesktopPane table) {
		// TODO Auto-generated constructor stub
		this();
		this.setLocation((table.getWidth()-this.getWidth())/2, (table.getHeight()-this.getHeight())/2);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfoAddInterFrm frame = new CustomerInfoAddInterFrm();
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
	public CustomerInfoAddInterFrm() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 1077, 641);
		
		JLabel label = new JLabel("\u5BA2\u6237\u540D\u79F0");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		customerNameText = new JTextField();
		customerNameText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		radioBtnMan = new JRadioButton("\u7537");
		buttonGroup.add(radioBtnMan);
		radioBtnMan.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		radioBtnWoman = new JRadioButton("\u5973");
		buttonGroup.add(radioBtnWoman);
		radioBtnWoman.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		customerTelText = new JTextField();
		customerTelText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7535\u5B50\u90AE\u7BB1");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		customerEmailText = new JTextField();
		customerEmailText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u5728\u516C\u53F8");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u8BBE\u8BA1\u4EA7\u54C1");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		customerDescTextArea = new JTextArea();
		
		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					customerAddActionPerform(e);
				}else {
					JOptionPane.showMessageDialog(null, "你不是管理员，无此操作权限！");
					return;
				}
				
			}
		});
		addBtn.setIcon(new ImageIcon(CustomerInfoAddInterFrm.class.getResource("/images/add.png")));
		addBtn.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerform(e);
			}
		});
		resetBtn.setIcon(new ImageIcon(CustomerInfoAddInterFrm.class.getResource("/images/reset.png")));
		resetBtn.setFont(new Font("新宋体", Font.PLAIN, 18));
		
		companyComboBox = new JComboBox();
		
		productComboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(companyComboBox, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerEmailText, 228, 228, 228))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerTelText))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerNameText, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addBtn)
									.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE))
								.addComponent(productComboBox, 0, 228, Short.MAX_VALUE))))
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(radioBtnMan)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(radioBtnWoman))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(resetBtn)
								.addComponent(customerDescTextArea, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(customerNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(radioBtnMan)
						.addComponent(radioBtnWoman))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(customerTelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(customerEmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(companyComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(productComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(customerDescTextArea, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))))
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(resetBtn))
					.addContainerGap(184, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillCompany();	//初始化公司下拉框
		fillProduct();	//初始化产品下拉框

	}
	//重置处理
	private void resetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.customerNameText.setText("");
		this.customerTelText.setText("");
		this.customerEmailText.setText("");
		this.customerDescTextArea.setText("");
		this.radioBtnMan.setSelected(true);
		if (this.companyComboBox.getItemCount() > 0) {
			this.companyComboBox.setSelectedIndex(0);
		}
		if (this.productComboBox.getItemCount() > 0) {
			this.productComboBox.setSelectedIndex(0);
		}
	}
	/**
	 * 客户添加处理
	 * @param e
	 */
	private void customerAddActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String customerName=this.customerNameText.getText();
		String sex="";
		if (this.radioBtnMan.isSelected()) {
			sex="男";
		}else if (this.radioBtnWoman.isSelected()) {
			sex="女";
		}
		String customerTel=this.customerTelText.getText();
		String customerEmail=this.customerEmailText.getText();
		String customerDesc=this.customerDescTextArea.getText();
		Company company=(Company) this.companyComboBox.getSelectedItem();
		int companyId=company.getId();
		Product product=(Product) this.productComboBox.getSelectedItem();
		int productId=product.getId();
		Customer customer=new Customer(customerName, sex, customerTel, customerEmail, customerDesc, productId, companyId);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addnum=customerDal.add(con, customer);
			if (addnum==1) {
				JOptionPane.showMessageDialog(null, "客户添加成功！");
			}else {
				JOptionPane.showMessageDialog(null, "客户添加失败！");
				return;
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
		
	}
	/**
	 * 初始化公司名下拉框
	 */
	private void fillCompany(){
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
	/**
	 * 初始化产品下拉框
	 */
	private void fillProduct(){
		Connection con = null;
		Product product=null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = productDal.query(con, new Product());
			while (resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt("id"));
				product.setProductName(resultSet.getString("productName"));
				this.productComboBox.addItem(product);
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
