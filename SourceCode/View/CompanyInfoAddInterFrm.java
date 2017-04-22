package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lxy.customerinfomanager.dal.CompanyDal;
import com.lxy.customerinfomanager.model.Company;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class CompanyInfoAddInterFrm extends JInternalFrame {
	private JTextField companyNameText;
	private JTextField companyTelText;
	private JTextField companyEmailText;
	private JTextField companyAddressText;
	private JTextArea companyDescTextArea;

	CompanyDal companyDal = new CompanyDal();
	DbUtil dbUtil = new DbUtil();

	public CompanyInfoAddInterFrm(JDesktopPane table) {
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
					CompanyInfoAddInterFrm frame = new CompanyInfoAddInterFrm();
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
	public CompanyInfoAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u516C\u53F8\u6DFB\u52A0");
		getContentPane().setFont(new Font("新宋体", Font.PLAIN, 16));
		setBounds(100, 100, 935, 566);

		JLabel label = new JLabel("\u516C\u53F8\u540D\u79F0");
		label.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyNameText = new JTextField();
		companyNameText.setColumns(10);

		JLabel label_1 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		label_1.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyTelText = new JTextField();
		companyTelText.setColumns(10);

		JLabel label_2 = new JLabel("\u7535\u5B50\u90AE\u7BB1");
		label_2.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyEmailText = new JTextField();
		companyEmailText.setColumns(10);

		JLabel label_3 = new JLabel("\u516C\u53F8\u5730\u5740");
		label_3.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyAddressText = new JTextField();
		companyAddressText.setColumns(10);

		JLabel label_4 = new JLabel("\u516C\u53F8\u4ECB\u7ECD");
		label_4.setFont(new Font("新宋体", Font.PLAIN, 16));

		companyDescTextArea = new JTextArea();

		JButton addBtn = new JButton("\u6DFB\u52A0");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断有无权限
				if (IsRoot.flag==false) {
					companyInfoAddActionPerform(e);
				}else {
					JOptionPane.showMessageDialog(null, "你不是管理员，无此操作权限！");
					return;
				}
				
			}
		});
		addBtn.setIcon(new ImageIcon(CompanyInfoAddInterFrm.class.getResource("/images/add.png")));
		addBtn.setFont(new Font("新宋体", Font.PLAIN, 16));

		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerform(e);
			}
		});
		resetBtn.setIcon(new ImageIcon(CompanyInfoAddInterFrm.class.getResource("/images/modify.png")));
		resetBtn.setFont(new Font("新宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(132).addGroup(groupLayout
						.createParallelGroup(
								Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(companyAddressText,
												GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(companyEmailText))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 64,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(companyTelText))
								.addGroup(groupLayout.createSequentialGroup().addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(companyNameText)))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(addBtn).addGap(209)
												.addComponent(resetBtn))
										.addComponent(companyDescTextArea, GroupLayout.PREFERRED_SIZE, 679,
												GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(135, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(59)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
								.addComponent(companyNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(companyTelText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(companyEmailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(companyAddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(companyDescTextArea, GroupLayout.PREFERRED_SIZE, 152,
												GroupLayout.PREFERRED_SIZE))
						.addGap(47).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(addBtn)
								.addComponent(resetBtn))
						.addContainerGap(120, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}

	// 重置处理
	private void resetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.companyNameText.setText("");
		this.companyTelText.setText("");
		this.companyEmailText.setText("");
		this.companyAddressText.setText("");
		this.companyDescTextArea.setText("");
	}
	/**
	 * 公司信息添加
	 * @param e
	 */
	private void companyInfoAddActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String companyName = this.companyNameText.getText();
		String companyTel = this.companyTelText.getText();
		String companyEmail = this.companyEmailText.getText();
		String companyAddress = this.companyAddressText.getText();
		String companyDesc = this.companyDescTextArea.getText();
		if (StringUtil.isEmpty(companyName)) {
			JOptionPane.showMessageDialog(null, "公司名不能为空");
			return;
		}
		Company company = new Company(companyName, companyTel, companyEmail, companyAddress, companyDesc);
		Connection con = null;
		try {

			con = dbUtil.getCon();
			int add = companyDal.add(con, company);
			if (add == 1) {
				JOptionPane.showMessageDialog(null, "公司添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "公司添加失败");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}
	}

}
