package com.java.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.dao.MemberDAO;

public class PwdSearchFrame extends JFrame {

	private JFrame frame;
	
	public PwdSearchFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel pwdSearchPanel = new JPanel();
		pwdSearchPanel.setBounds(200,30, 600, 500);
		frame.getContentPane().add(pwdSearchPanel);
		pwdSearchPanel.setBackground(Color.lightGray);
		pwdSearchPanel.setLayout(null);
		pwdSearchPanel.setVisible(true);
		
		ImageIcon loginIcon = new ImageIcon("images/login.png");
		
		JLabel loginLabel = new JLabel(loginIcon);
		loginLabel.setBounds(150, 50, 300, 177);
		pwdSearchPanel.add(loginLabel);
		
		JLabel pwdLabel = new JLabel("비밀번호 찾기");
		pwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwdLabel.setBounds(230,250, 150, 22);
		pwdSearchPanel.add(pwdLabel);
		
		JLabel idSearchLabel = new JLabel("아이디  : ");
		idSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		idSearchLabel.setBounds(130, 300, 120, 22);
		pwdSearchPanel.add(idSearchLabel);
		
		JTextField idSearchField = new JTextField();
		idSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idSearchField.setBounds(220, 300, 200, 30);
		pwdSearchPanel.add(idSearchField);
		
		JLabel nameSearchLabel = new JLabel("이름  :");
		nameSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		nameSearchLabel.setBounds(150,350, 120, 22);
		pwdSearchPanel.add(nameSearchLabel);
		
		JTextField nameSearchField = new JTextField();
		nameSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameSearchField.setBounds(220, 350, 200, 30);
		pwdSearchPanel.add(nameSearchField);
		
		JLabel phoneSearchLabel = new JLabel("전화번호( - 포함)  :");
		phoneSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		phoneSearchLabel.setBounds(50,400, 150, 22);
		pwdSearchPanel.add(phoneSearchLabel);
		
		JTextField phoneSearchField = new JTextField();
		phoneSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phoneSearchField.setBounds(220, 400, 200, 30);
		pwdSearchPanel.add(phoneSearchField);
		
		JButton pwdSearchButton = new JButton("비밀번호 찾기");
		pwdSearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		pwdSearchButton.setBounds(240, 450, 120, 30);
		pwdSearchPanel.add(pwdSearchButton);
		
		JButton beforeFrameButton = new JButton("이전화면");
		beforeFrameButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeFrameButton.setBounds(480, 20, 100, 30);
		pwdSearchPanel.add(beforeFrameButton);
		
		beforeFrameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
		
		pwdSearchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = MemberDAO.getInstance();
				String Searchpwd = dao.searchPwd(idSearchField.getText(), nameSearchField.getText(), phoneSearchField.getText());
				
				if (null != Searchpwd) 
				{
				JOptionPane.showMessageDialog(null, "PWD는 " + Searchpwd + " 입니다.");
				frame.dispose();
				LoginFrame frame = new LoginFrame();
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"조회되지 않는 회원정보입니다." );
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwdSearchFrame frame = new PwdSearchFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
