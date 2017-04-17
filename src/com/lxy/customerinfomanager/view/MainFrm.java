package com.lxy.customerinfomanager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lxy.customerinfomanager.util.IsRoot;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setFont(new Font("新宋体", Font.PLAIN, 16));
		//setTitle("\u6B22\u8FCE\u6765\u5230CRM\u7BA1\u7406\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 730);
		//设置不同用户身份的显示
		if (IsRoot.flag==false) {
			this.setTitle("欢迎来到CRM管理主界面  当前身份：管理员");
		}else {
			this.setTitle("欢迎来到CRM管理主界面  当前身份：普通用户");
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menu.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("\u5BA2\u6237\u589E\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInfoAddInterFrm addInterFrm = new CustomerInfoAddInterFrm(table);
				addInterFrm.setVisible(true);
				table.add(addInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menuItem.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("\u5BA2\u6237\u7BA1\u7406");
		menuItem_1.addActionListener(new ActionListener() {
			//加载一个新的窗体
			public void actionPerformed(ActionEvent e) {
				CustomerInfoManageInterFrm ManageInterFrm=new CustomerInfoManageInterFrm(table);
				ManageInterFrm.setVisible(true);
				table.add(ManageInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/userName.png")));
		menuItem_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitActionPerform(e);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menuItem_7.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu.add(menuItem_7);

		JMenu mnNewMenu = new JMenu("\u516C\u53F8\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		mnNewMenu.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);

		JMenuItem menuItem_2 = new JMenuItem("\u516C\u53F8\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyInfoAddInterFrm addInterFrm=new CompanyInfoAddInterFrm(table);
				addInterFrm.setVisible(true);
				table.add(addInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menuItem_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("\u516C\u53F8\u7BA1\u7406");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyInfoManageInterFrm companyInfoManageInterFrm=new CompanyInfoManageInterFrm(table);
				companyInfoManageInterFrm.setVisible(true);
				table.add(companyInfoManageInterFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menuItem_3.setFont(new Font("新宋体", Font.PLAIN, 18));
		mnNewMenu.add(menuItem_3);

		JMenu menu_1 = new JMenu("\u4EA7\u54C1\u4FE1\u606F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menu_1.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(menu_1);

		JMenuItem menuItem_4 = new JMenuItem("\u4EA7\u54C1\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductInfoAddInterFrm addInterFrm=new ProductInfoAddInterFrm(table);
				addInterFrm.setVisible(true);
				table.add(addInterFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menuItem_4.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu_1.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("\u4EA7\u54C1\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductInfoManageInterFrm productInfoManageInterFrm=new ProductInfoManageInterFrm(table);
				productInfoManageInterFrm.setVisible(true);
				table.add(productInfoManageInterFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menuItem_5.setFont(new Font("宋体", Font.PLAIN, 18));
		menu_1.add(menuItem_5);

		JMenu menu_2 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menu_2.setFont(new Font("新宋体", Font.PLAIN, 18));
		menuBar.add(menu_2);

		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsInterFrm aboutUsInterFrm = new AboutUsInterFrm(table);
				aboutUsInterFrm.setVisible(true);
				table.add(aboutUsInterFrm);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuItem_6.setFont(new Font("新宋体", Font.PLAIN, 18));
		menu_2.add(menuItem_6);
		table = new JDesktopPane();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(table, BorderLayout.CENTER);

		// 设置JFrame居中显示
		this.setLocationRelativeTo(null);
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	// 退出事件处理
		private void quitActionPerform(ActionEvent e) {
			// TODO Auto-generated method stub
			int fg = JOptionPane.showConfirmDialog(null, "确定要退出吗？");
			if (fg == 0) {
				dispose();
			}
		}

}
