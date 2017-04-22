package com.lxy.customerinfomanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AboutUsInterFrm extends JInternalFrame {
	//´°Ìå¾ÓÖÐ¼ÓÔØ
	public AboutUsInterFrm(JDesktopPane table) {
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
					AboutUsInterFrm frame = new AboutUsInterFrm();
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
	public AboutUsInterFrm() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 1015, 665);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(AboutUsInterFrm.class.getResource("/images/90a401d831c9e9a7c4b191197bf259fa_r.jpg")));
		
		JLabel lblCopyright = new JLabel("Copyright@\u674E\u8096\u9633");
		lblCopyright.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		
		JLabel lblb = new JLabel("\u5B66\u53F7\uFF1AB14051022");
		lblb.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u8BA1\u7B97\u673A\u4E0E\u4FE1\u606F\u5DE5\u7A0B\u5B66\u9662");
		label.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		
		JLabel lblQq = new JLabel("QQ\uFF1A405609333");
		lblQq.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		
		JLabel lblEmailqqcom = new JLabel("Email\uFF1A\u4E0A\u9762\u90A3\u4E2A\u52A0qq.com");
		lblEmailqqcom.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCopyright)
						.addComponent(lblb, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 176, Short.MAX_VALUE)
						.addComponent(label_1)
						.addComponent(lblQq)
						.addComponent(lblEmailqqcom, GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 586, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(lblCopyright)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblb, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblQq)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEmailqqcom, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}
}
