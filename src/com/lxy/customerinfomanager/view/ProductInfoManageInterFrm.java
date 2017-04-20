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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lxy.customerinfomanager.dal.CompanyDal;
import com.lxy.customerinfomanager.dal.ProductDal;
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.model.Product;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ProductInfoManageInterFrm extends JInternalFrame {
	private JTextField sProductNameText;
	private JTextField sPrice1;
	private JTextField sPrice2;
	private JTable table;
	private JTextField tProductIdText;
	private JTextField tProductNameText;
	private JTextField tPriceText;
	private JComboBox tCompanyBox;
	private JComboBox sCompanyBox;
	private JTextArea tProductDescTextArea;
	DbUtil dbUtil = new DbUtil();
	ProductDal productDal = new ProductDal();
	CompanyDal companyDal = new CompanyDal();

	public ProductInfoManageInterFrm(JDesktopPane table) {
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
					ProductInfoManageInterFrm frame = new ProductInfoManageInterFrm();
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
	public ProductInfoManageInterFrm() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("\u4EA7\u54C1\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 1078, 638);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JScrollPane scrollPane = new JScrollPane();

		JPanel Panel3 = new JPanel();
		Panel3.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(Panel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 912,
										Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 912,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(Panel3, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 16));

		tProductIdText = new JTextField();
		tProductIdText.setEditable(false);
		tProductIdText.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u4EA7\u54C1\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 16));

		tProductNameText = new JTextField();
		tProductNameText.setColumns(10);

		JLabel label_4 = new JLabel("\u6240\u5C5E\u516C\u53F8");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_5 = new JLabel("\u4EF7\u683C");
		label_5.setFont(new Font("新宋体", Font.PLAIN, 16));

		tPriceText = new JTextField();
		tPriceText.setColumns(10);

		JLabel label_6 = new JLabel("\u4EA7\u54C1\u7B80\u4ECB");
		label_6.setFont(new Font("新宋体", Font.PLAIN, 16));

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
		modifyBtn.setIcon(new ImageIcon(ProductInfoManageInterFrm.class.getResource("/images/modify.png")));
		modifyBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					deleteActionPerform(e);
				}else{
					JOptionPane.showMessageDialog(null, "你不是管理员，无权操作此项！");
					return;
				}		
			}
		});
		deleteBtn.setIcon(new ImageIcon(ProductInfoManageInterFrm.class.getResource("/images/delete.png")));
		deleteBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		tCompanyBox = new JComboBox();

		tProductDescTextArea = new JTextArea();
		GroupLayout gl_Panel3 = new GroupLayout(Panel3);
		gl_Panel3.setHorizontalGroup(gl_Panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Panel3.createSequentialGroup()
						.addGroup(gl_Panel3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Panel3.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tProductIdText, GroupLayout.PREFERRED_SIZE, 93,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tProductNameText, GroupLayout.PREFERRED_SIZE, 170,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tCompanyBox, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(tPriceText,
												GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Panel3.createSequentialGroup()
										.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_Panel3.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_Panel3.createSequentialGroup().addComponent(modifyBtn)
														.addGap(157).addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE,
																85, GroupLayout.PREFERRED_SIZE))
												.addComponent(tProductDescTextArea, GroupLayout.PREFERRED_SIZE, 714,
														GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(252, Short.MAX_VALUE)));
		gl_Panel3.setVerticalGroup(gl_Panel3.createParallelGroup(Alignment.LEADING).addGroup(gl_Panel3
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_Panel3.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(tProductIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(tProductNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(tPriceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(tCompanyBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_Panel3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE).addComponent(
								tProductDescTextArea, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_Panel3.createParallelGroup(Alignment.BASELINE).addComponent(modifyBtn)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(117, Short.MAX_VALUE)));
		Panel3.setLayout(gl_Panel3);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableMousePress(e);
			}
		});
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7", "\u4EA7\u54C1\u540D\u79F0",
						"\u6240\u5C5E\u516C\u53F8", "\u4EA7\u54C1\u4EF7\u683C", "\u4EA7\u54C1\u7B80\u4ECB" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("\u4EA7\u54C1\u540D\u79F0");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));

		sProductNameText = new JTextField();
		sProductNameText.setColumns(10);

		JLabel label_1 = new JLabel("\u6240\u5C5E\u516C\u53F8");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));

		JLabel label_2 = new JLabel("\u4EF7\u683C\u533A\u95F4");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));

		sPrice1 = new JTextField();
		sPrice1.setColumns(10);

		JLabel label_3 = new JLabel("-");

		sPrice2 = new JTextField();
		sPrice2.setColumns(10);

		JButton searchBtn = new JButton("\u641C\u7D22");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerform(e);
			}
		});
		searchBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		sCompanyBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addGap(19).addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sProductNameText, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sCompanyBox, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sPrice1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(sPrice2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(62).addComponent(searchBtn).addContainerGap(76, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(sProductNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(sPrice1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(sPrice2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(searchBtn).addComponent(sCompanyBox, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		// 初始化公司下拉框
		this.fillCompany("search");
		this.fillCompany("modify");
		// 初始化表格
		this.fillTable(new Product());
		// JOptionPane.showMessageDialog(null, "执行了这句话！");
	}

	/**
	 * 产品查询 这里花了我两个多小时，555555
	 * 
	 * @param e
	 */
	private void searchActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String productName = this.sProductNameText.getText();
		Company company = (Company) this.sCompanyBox.getSelectedItem();
		int companyId = company.getId();
		String price_s1 = this.sPrice1.getText();
		String price_s2 = this.sPrice2.getText();

		if (StringUtil.isNotEmpty(price_s1) || StringUtil.isNotEmpty(price_s2)) {
			if (StringUtil.isEmpty(price_s1) || StringUtil.isEmpty(price_s2)) {
				JOptionPane.showMessageDialog(null, "请输入另外一个价格！");
				return;
			}
			Product product = new Product(productName, Float.valueOf(price_s1), companyId, Float.valueOf(price_s2));
			this.fillTable(product);
		} else {
			Product product = new Product(productName, companyId);
			this.fillTable(product);
		}
	}

	/**
	 * 填充表格
	 * 
	 * @param product
	 */
	private void fillTable(Product product) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet = productDal.query(con, product);
			while (resultSet.next()) {
				Vector vector = new Vector();
				vector.add(resultSet.getInt("id"));
				vector.add(resultSet.getString("productName"));
				vector.add(resultSet.getString("companyName"));
				vector.add(resultSet.getFloat("productPrice"));
				vector.add(resultSet.getString("productDesc"));
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
	 * 表格行点击事件
	 * 
	 * @param e
	 */
	private void tableMousePress(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.tProductIdText.setText(String.valueOf(table.getValueAt(row, 0)));
		this.tProductNameText.setText(String.valueOf(table.getValueAt(row, 1)));
		String companyName = String.valueOf(table.getValueAt(row, 2));
		this.tPriceText.setText((Float) table.getValueAt(row, 3) + "");
		this.tProductDescTextArea.setText(String.valueOf(table.getValueAt(row, 4)));
		int n = this.tCompanyBox.getItemCount();
		for (int i = 0; i < n; i++) {
			Company item = (Company) this.tCompanyBox.getItemAt(i);
			if (item.getCompanyName().equals(companyName)) {
				this.tCompanyBox.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 重置操作
	 */
	private void resetValue() {
		this.tProductIdText.setText("");
		this.tProductNameText.setText("");
		this.tProductDescTextArea.setText("");
		this.tPriceText.setText("");
		if (this.tCompanyBox.getItemCount() > 0) {
			this.tCompanyBox.setSelectedIndex(0);
		}
	}
	/**
	 * 修改操作
	 * @param e
	 */
	private void modifyActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = this.tProductIdText.getText();
		if (id == null) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		String productName = this.tProductNameText.getText();
		if (productName == null) {
			JOptionPane.showMessageDialog(null, "产品名称不能为空！");
			return;
		}
		String productDesc = this.tProductDescTextArea.getText();
		Company company = (Company) this.tCompanyBox.getSelectedItem();
		int companyId = company.getId();
		String price = this.tPriceText.getText();
		Product product = new Product(Integer.parseInt(id),productName, Float.parseFloat(price), productDesc, companyId);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = productDal.modify(con, product);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "产品修改成功！");
				resetValue();
				this.fillTable(new Product());
			} else {
				JOptionPane.showMessageDialog(null, "产品修改失败！");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "产品修改失败！");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 删除操作
	 * @param e
	 */
	private void deleteActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.tProductIdText.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=productDal.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Product());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e2){
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}
}
