package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lxy.customerinfomanager.dal.CompanyDal;
import com.lxy.customerinfomanager.dal.CustomerDal;
import com.lxy.customerinfomanager.dal.ProductDal;
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.model.Customer;
import com.lxy.customerinfomanager.model.Product;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerInfoManageInterFrm extends JInternalFrame {
	private JTextField sCustomerNameText;
	private JTable table;
	private JTextField tCustomerIdText;
	private JTextField tCustomerNameText;
	private JTextField tCustomerTelText;
	private JTextField tCustomerEmailText;
	private JTextArea tCustomerDescTextArea;
	private JComboBox tProductBox;
	private JComboBox sProductBox;
	private JComboBox tCompanyBox;
	private JComboBox sCompanyBox;
	private JRadioButton radioBtnMan;
	private JRadioButton radioBtnWoman;
	DbUtil dbUtil = new DbUtil();
	CompanyDal companyDal = new CompanyDal();
	ProductDal productDal = new ProductDal();
	CustomerDal customerDal = new CustomerDal();
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public CustomerInfoManageInterFrm(JDesktopPane table) {
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
					CustomerInfoManageInterFrm frame = new CustomerInfoManageInterFrm();
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
	public CustomerInfoManageInterFrm() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 1263, 733);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1226, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1225, GroupLayout.PREFERRED_SIZE))));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap()
												.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 313,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel label_2 = new JLabel("\u7F16    \u53F7");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCustomerIdText = new JTextField();
		tCustomerIdText.setEditable(false);
		tCustomerIdText.setColumns(10);

		JLabel label_3 = new JLabel("\u5BA2\u6237\u59D3\u540D");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCustomerNameText = new JTextField();
		tCustomerNameText.setColumns(10);

		JLabel label_4 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCustomerTelText = new JTextField();
		tCustomerTelText.setColumns(10);

		JLabel label_5 = new JLabel("\u7535\u5B50\u90AE\u7BB1");
		label_5.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCustomerEmailText = new JTextField();
		tCustomerEmailText.setColumns(10);

		JLabel label_6 = new JLabel("\u6240\u5C5E\u516C\u53F8");
		label_6.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_7 = new JLabel("\u8BBE\u8BA1\u4EA7\u54C1");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_9 = new JLabel("\u4E2A\u4EBA\u7B80\u4ECB");
		label_9.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCustomerDescTextArea = new JTextArea();

		JButton modifyBtn = new JButton("\u4FEE\u6539");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					modifyActionPerform(e);
				}else{
					JOptionPane.showMessageDialog(null, "你不是管理员，无权操作此项！");
					return;
				}	
				
			}
		});
		modifyBtn.setIcon(new ImageIcon(CustomerInfoManageInterFrm.class.getResource("/images/modify.png")));
		modifyBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	if (IsRoot.flag==false) {
				deleteActionPerform(e);
			}else{
				JOptionPane.showMessageDialog(null, "你不是管理员，无权操作此项！");
				return;
			}	
				
			}
		});
		deleteBtn.setIcon(new ImageIcon(CustomerInfoManageInterFrm.class.getResource("/images/delete.png")));
		deleteBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_8 = new JLabel("\u6027\u522B");
		label_8.setFont(new Font("新宋体", Font.PLAIN, 16));

		radioBtnMan = new JRadioButton("\u7537");
		buttonGroup.add(radioBtnMan);
		radioBtnMan.setFont(new Font("新宋体", Font.PLAIN, 16));

		radioBtnWoman = new JRadioButton("\u5973");
		buttonGroup.add(radioBtnWoman);
		radioBtnWoman.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCompanyBox = new JComboBox();

		tProductBox = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(label_2)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(tCustomerIdText, GroupLayout.PREFERRED_SIZE, 99,
														GroupLayout.PREFERRED_SIZE)
												.addGap(43).addComponent(label_8)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(radioBtnMan)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(radioBtnWoman,
														GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addComponent(label_3).addComponent(label_4))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
																.addComponent(tCustomerTelText,
																		GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
																.addComponent(tCustomerNameText,
																		GroupLayout.DEFAULT_SIZE, 269,
																		Short.MAX_VALUE)))
												.addGroup(gl_panel_1.createSequentialGroup().addComponent(label_5)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(tCustomerEmailText, GroupLayout.DEFAULT_SIZE, 269,
																Short.MAX_VALUE)))
												.addGap(52)))
										.addGap(130))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(tCompanyBox, 0, 269, Short.MAX_VALUE))
												.addGroup(gl_panel_1.createSequentialGroup()
														.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 64,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(tProductBox, 0, 269, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED, 182, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(label_9)
										.addComponent(tCustomerDescTextArea, GroupLayout.PREFERRED_SIZE, 668,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(modifyBtn).addGap(207)
												.addComponent(deleteBtn)))
								.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
										.addComponent(tCustomerIdText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_8).addComponent(radioBtnMan).addComponent(radioBtnWoman,
												GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(label_9)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
								.createSequentialGroup().addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
										.addComponent(tCustomerNameText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(25)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
										.addComponent(tCustomerTelText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(27)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
										.addComponent(tCustomerEmailText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(26)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tCompanyBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(tProductBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(
										gl_panel_1.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(tCustomerDescTextArea, GroupLayout.PREFERRED_SIZE, 138,
														GroupLayout.PREFERRED_SIZE)
												.addGap(44)
												.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
														.addComponent(modifyBtn).addComponent(deleteBtn))))
						.addContainerGap(35, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressActionPerform(e);
			}

		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u7F16\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u6027\u522B", "\u8054\u7CFB\u7535\u8BDD",
						"\u7535\u5B50\u90AE\u7BB1", "\u6240\u5C5E\u516C\u53F8", "\u8BBE\u8BA1\u4EA7\u54C1",
						"\u4E2A\u4EBA\u7B80\u4ECB" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("\u5BA2\u6237\u540D");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 16));

		sCustomerNameText = new JTextField();
		sCustomerNameText.setColumns(10);

		JLabel label = new JLabel("\u516C\u53F8\u540D");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_1 = new JLabel("\u4EA7\u54C1\u540D");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerform(e);
			}
		});
		button.setIcon(new ImageIcon(CustomerInfoManageInterFrm.class.getResource("/images/search.png")));
		button.setFont(new Font("新宋体", Font.PLAIN, 16));

		sCompanyBox = new JComboBox();

		sProductBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addGap(28).addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sCustomerNameText, GroupLayout.PREFERRED_SIZE, 198,
												GroupLayout.PREFERRED_SIZE)
										.addGap(35).addComponent(label).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sCompanyBox, GroupLayout.PREFERRED_SIZE, 210,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sProductBox, GroupLayout.PREFERRED_SIZE, 210,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
										.addComponent(button).addGap(125)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(sCustomerNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(button).addComponent(label_1).addComponent(label)
						.addComponent(sCompanyBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(sProductBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillCompany("search");
		fillCompany("modify");
		fillProduct("search");
		fillProduct("modify");
		fillTable(new Customer());
	}

	/**
	 * 搜索事件
	 * 
	 * @param e
	 */
	private void searchActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String customerName = this.sCustomerNameText.getText();
		Company company = (Company) this.sCompanyBox.getSelectedItem();
		int companyId = company.getId();
		Product product = (Product) this.sProductBox.getSelectedItem();
		int productId = product.getId();
		Customer customer = new Customer(customerName, productId, companyId);
		this.fillTable(customer);

	}

	/**
	 * 初始化公司下拉框
	 * 
	 * @param type
	 */
	private void fillCompany(String type) {
		Connection con = null;
		Company company = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = companyDal.query(con, new Company());
			if ("search".equals(type)) {
				company = new Company();
				company.setCompanyName("请选择公司");
				company.setId(-1);
				this.sCompanyBox.addItem(company);
			}
			while (resultSet.next()) {
				company = new Company();
				company.setCompanyName(resultSet.getString("companyName"));
				company.setId(resultSet.getInt("id"));
				if ("search".equals(type)) {
					this.sCompanyBox.addItem(company);
				} else if ("modify".equals(type)) {
					this.tCompanyBox.addItem(company);
				}
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
	 * 
	 * @param type
	 */
	private void fillProduct(String type) {
		Connection con = null;
		Product product = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = productDal.query(con, new Product());
			if ("search".equals(type)) {
				product = new Product();
				product.setProductName("请选择产品");
				product.setId(-1);
				this.sProductBox.addItem(product);
			}
			while (resultSet.next()) {
				product = new Product();
				product.setProductName(resultSet.getString("productName"));
				product.setId(resultSet.getInt("id"));
				if ("search".equals(type)) {
					this.sProductBox.addItem(product);
				} else if ("modify".equals(type)) {
					this.tProductBox.addItem(product);
				}
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
	 * 初始化填充表格
	 * 
	 * @param customer
	 */
	private void fillTable(Customer customer) {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = customerDal.query(con, customer);
			while (resultSet.next()) {
				Vector vector = new Vector();
				vector.add(resultSet.getInt("id"));
				vector.add(resultSet.getString("customerName"));
				vector.add(resultSet.getString("sex"));
				vector.add(resultSet.getString("customerTel"));
				vector.add(resultSet.getString("customerEmail"));
				vector.add(resultSet.getString("companyName"));
				vector.add(resultSet.getString("productName"));
				vector.add(resultSet.getString("customerDesc"));
				defaultTableModel.addRow(vector);
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
	 * 表格行点击事件处理
	 * @param e
	 */
	private void mousePressActionPerform(MouseEvent e) {
			// TODO Auto-generated method stub
			int row = this.table.getSelectedRow();
			this.tCustomerIdText.setText(String.valueOf(table.getValueAt(row, 0))); 
			this.tCustomerNameText.setText((String) table.getValueAt(row, 1));
			String sex = (String) table.getValueAt(row, 2);
			if ("男".equals(sex)) {
				this.radioBtnMan.setSelected(true);
			} else if ("女".equals(sex)) {
				this.radioBtnWoman.setSelected(true);
			}
			this.tCustomerTelText.setText((String) table.getValueAt(row, 3));
			this.tCustomerEmailText.setText((String) table.getValueAt(row, 4));
			String companyName = (String) this.table.getValueAt(row, 5);
			int n = this.tCompanyBox.getItemCount();
			for (int i = 0; i < n; i++) {
				Company item = (Company) this.tCompanyBox.getItemAt(i);
				if (item.getCompanyName().equals(companyName)) {
					this.tCompanyBox.setSelectedIndex(i);
				}
			}
			String productName = (String) this.table.getValueAt(row, 6);
			int k = this.tProductBox.getItemCount();
			for (int j = 0; j < k; j++) {
				Product item = (Product) this.tProductBox.getItemAt(j);
				if (item.getProductName().equals(productName)) {
					this.tProductBox.setSelectedIndex(j);
				}
			}
			this.tCustomerDescTextArea.setText((String) table.getValueAt(row, 7));
			
		}
	/**
	 * 修改事件
	 * @param e
	 */
	private void modifyActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.tCustomerIdText.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String customerName=this.tCustomerNameText.getText();
		String customerTel=this.tCustomerTelText.getText();
		String customerEmail=this.tCustomerEmailText.getText();
		String customerDesc=this.tCustomerDescTextArea.getText();
		
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(null, "客户名称不能为空！");
			return;
		}
		
		String sex="";
		if(radioBtnMan.isSelected()){
			sex="男";
		}else if(radioBtnWoman.isSelected()){
			sex="女";
		}
		
		Company company=(Company) tCompanyBox.getSelectedItem();
		int companyId=company.getId();
		Product product=(Product) tProductBox.getSelectedItem();
		int productId=product.getId();
		Customer customer=new Customer(Integer.parseInt(id), customerName, sex, customerTel, customerEmail, customerDesc, productId, companyId);
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int addNum=customerDal.modify(con, customer);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "客户信息修改成功！");
				resetValue();
				this.fillTable(new Customer());
			}else{
				JOptionPane.showMessageDialog(null, "客户信息修改失败！");
			}
		}catch(Exception e2){
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "客户信息修改失败！");
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	/**
	 * 重置数据操作
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.tCustomerIdText.setText("");
		this.tCustomerDescTextArea.setText("");
		this.tCustomerNameText.setText("");
		this.tCustomerEmailText.setText("");
		this.tCustomerTelText.setText("");
		this.radioBtnMan.setSelected(true);
		if (this.tCompanyBox.getItemCount() > 0) {
			this.tCompanyBox.setSelectedIndex(0);
		}
		if (this.tProductBox.getItemCount()>0) {
			this.tProductBox.setSelectedIndex(0);
		}
	}
		/**
		 * 删除操作
		 * @param e
		 */
	private void deleteActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.tCustomerIdText.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n==0) {
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int num=customerDal.delete(con, id);
			if (num==1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				this.resetValue();
				this.fillTable(new Customer());
			}else{
				JOptionPane.showMessageDialog(null, "删除失败！");
				return;
			}
		}catch(Exception e1){
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	}
}
