package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lxy.customerinfomanager.dal.UserDal;
import com.lxy.customerinfomanager.model.User;
import com.lxy.customerinfomanager.util.DbUtil;
import com.lxy.customerinfomanager.util.IsRoot;
import com.lxy.customerinfomanager.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNametext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblcrm = new JLabel("\u5BA2\u6237\u8D44\u6599\u7BA1\u7406\u7CFB\u7EDFCRM");
		lblcrm.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/22958PICHnk_1024.jpg")));
		lblcrm.setFont(new Font("幼圆", Font.PLAIN, 30));
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		label.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		userNametext = new JTextField();
		userNametext.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		label_1.setFont(new Font("幼圆", Font.PLAIN, 18));
		
		passwordtext = new JPasswordField();
		
		JButton loginBtn = new JButton("\u767B\u5F55");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerform(e);
			}
		});
		loginBtn.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		loginBtn.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerform(e);
			}
		});
		resetBtn.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		resetBtn.setFont(new Font("幼圆", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblcrm)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(userNametext, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordtext, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addComponent(loginBtn)
									.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
									.addComponent(resetBtn)))
							.addGap(133))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(lblcrm)
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetBtn)
						.addComponent(loginBtn))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}
	
	//重置事件处理
	private void resetActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNametext.setText("");
		this.passwordtext.setText("");
	}
	
	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName=this.userNametext.getText();
		String password=new String(this.passwordtext.getPassword());
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		//判断是否为管理员用户
		if (!userName.equals("root")) {	
			IsRoot.flag=true;
		}			
		User user =new User(userName,password);
		UserDal userDal=new UserDal();
		Connection con=null;
		DbUtil dbUtil=new DbUtil();
		try {
			con=dbUtil.getCon();
			User currentUser=userDal.login(con, user);
			if (currentUser!=null) {
				dispose(); //释放登录窗体资源
				new MainFrm().setVisible(true); //加载主窗体
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				// TODO: handle exception
				e3.printStackTrace();
			}
		}			
	}
}


