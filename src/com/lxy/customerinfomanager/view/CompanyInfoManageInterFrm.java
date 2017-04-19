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
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompanyInfoManageInterFrm extends JInternalFrame {
	private JTextField sCompanyNameText;
	private JTextField sCompanyAddressText;
	private JTable table;
	private JTextField tCompanyIdText;
	private JTextField tCompanyNameText;
	private JTextField tCompanyTelText;
	private JTextField tCompanyEmailText;
	private JTextField tCompanyAddressText;
	private JTextArea tCompanyDescTextArea;
	DbUtil dbUtil=new DbUtil();
	CompanyDal companyDal=new CompanyDal();
	
	public CompanyInfoManageInterFrm(JDesktopPane table) {
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
					CompanyInfoManageInterFrm frame = new CompanyInfoManageInterFrm();
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
	public CompanyInfoManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u516C\u53F8\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 1124, 655);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1086, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1084, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1085, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyIdText = new JTextField();
		tCompanyIdText.setEditable(false);
		tCompanyIdText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u516C\u53F8\u540D\u79F0");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyNameText = new JTextField();
		tCompanyNameText.setColumns(10);
		
		JLabel label_1 = new JLabel("\u516C\u53F8\u7535\u8BDD");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyTelText = new JTextField();
		tCompanyTelText.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7535\u5B50\u90AE\u7BB1");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyEmailText = new JTextField();
		tCompanyEmailText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u516C\u53F8\u5730\u5740");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyAddressText = new JTextField();
		tCompanyAddressText.setColumns(10);
		
		JLabel label_4 = new JLabel("\u516C\u53F8\u7B80\u4ECB");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JButton modifyBtn = new JButton("\u4FEE\u6539");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					modifyActionPerform(e);
				}else {
					JOptionPane.showMessageDialog(null, "你不是管理员，无此操作权限！");
					return;
				}
				
			}
		});
		modifyBtn.setIcon(new ImageIcon(CompanyInfoManageInterFrm.class.getResource("/images/modify.png")));
		modifyBtn.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		JButton deleteBtn = new JButton("\u5220\u9664");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (IsRoot.flag==false) {
					deleteActionPerform(e);
				}else {
					JOptionPane.showMessageDialog(null, "你不是管理员，无此操作权限！");
					return;
				}
				
			}
		});
		deleteBtn.setIcon(new ImageIcon(CompanyInfoManageInterFrm.class.getResource("/images/delete.png")));
		deleteBtn.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		tCompanyDescTextArea = new JTextArea();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tCompanyDescTextArea, GroupLayout.PREFERRED_SIZE, 643, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(modifyBtn)
							.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
							.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(50))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tCompanyIdText, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tCompanyNameText, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tCompanyTelText, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tCompanyEmailText, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tCompanyAddressText, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(294, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tCompanyIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(tCompanyNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(tCompanyTelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(tCompanyEmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(tCompanyAddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(modifyBtn)
						.addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tCompanyDescTextArea, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tablePressPerform(e);
			}

		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u516C\u53F8\u540D\u79F0", "\u516C\u53F8\u7535\u8BDD", "\u7535\u5B50\u90AE\u7BB1", "\u516C\u53F8\u5730\u5740", "\u516C\u53F8\u7B80\u4ECB"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u516C\u53F8\u540D\u79F0");
		lblNewLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		sCompanyNameText = new JTextField();
		sCompanyNameText.setColumns(10);
		
		JLabel label = new JLabel("\u516C\u53F8\u5730\u5740");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));
		
		sCompanyAddressText = new JTextField();
		sCompanyAddressText.setColumns(10);
		
		JButton searchBtn = new JButton("\u641C\u7D22");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerform(e);
			}

		});
		searchBtn.setIcon(new ImageIcon(CompanyInfoManageInterFrm.class.getResource("/images/search.png")));
		searchBtn.setFont(new Font("新宋体", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sCompanyNameText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sCompanyAddressText, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
					.addComponent(searchBtn)
					.addGap(90))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(sCompanyNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(sCompanyAddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Company());	//初始化填充表格
	}
	/**
	 *搜索功能实现
	 * @param e
	 */
	private void searchActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String companyName=this.sCompanyNameText.getText();
		String companyAddress=this.sCompanyAddressText.getText();
		Company company=new Company(companyName, companyAddress);
		this.fillTable(company);	
	}
	/**
	 * 表格点击事件处理
	 * @param e
	 */
	private void tablePressPerform(MouseEvent e) {
		// TODO Auto-generated method stub
		int row =this.table.getSelectedRow();
		this.tCompanyIdText.setText(String.valueOf(table.getValueAt(row, 0)));
		this.tCompanyNameText.setText((String)table.getValueAt(row, 1));
		this.tCompanyTelText.setText((String)table.getValueAt(row, 2));
		this.tCompanyEmailText.setText((String)table.getValueAt(row, 3));
		this.tCompanyAddressText.setText((String)table.getValueAt(row, 4));
		this.tCompanyDescTextArea.setText((String)table.getValueAt(row, 5));	
	}
	/**
	 * 修改事件
	 * @param e
	 */
	private void modifyActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.tCompanyIdText.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if (StringUtil.isEmpty(tCompanyNameText.getText())) {
			JOptionPane.showMessageDialog(null, "公司名称不能为空！");
			return;
		}
		String companyName=this.tCompanyNameText.getText();
		String companyTel=this.tCompanyTelText.getText();
		String companyEmail=this.tCompanyEmailText.getText();
		String companyAddress=this.tCompanyAddressText.getText();
		String companyDesc=this.tCompanyDescTextArea.getText();
		Company company=new Company(Integer.parseInt(id), companyName, companyTel, companyEmail, companyAddress, companyDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int num=companyDal.modify(con, company);
			if (num==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
				return;
			}
				
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}
	/**
	 * 删除事件处理
	 * @param e
	 */
	private void deleteActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String id=this.tCompanyIdText.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n==0) {
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int deleteNum=companyDal.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Company());
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
		Connection con=null;
		
	}
	/**
	 * 初始化填充表格
	 * @param company
	 */
	private void fillTable(Company company) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet resultSet=companyDal.query(con, company);
			while(resultSet.next()){
				Vector vector=new Vector();
				vector.add(resultSet.getInt("id"));
				vector.add(resultSet.getString("companyName"));
				vector.add(resultSet.getString("companyTel"));
				vector.add(resultSet.getString("companyEmail"));
				vector.add(resultSet.getString("companyAddress"));
				vector.add(resultSet.getString("companyDesc"));
				defaultTableModel.addRow(vector);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	/**
	 * 重置函数
	 */
	private void resetValue() {
		this.tCompanyIdText.setText("");
		this.tCompanyNameText.setText("");
		this.tCompanyTelText.setText("");
		this.tCompanyEmailText.setText("");
		this.tCompanyAddressText.setText("");
		this.tCompanyDescTextArea.setText("");
	}
}
