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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.admin.AdminFrame;
import com.java.dao.MemberDAO;
import com.java.guest.MemberJoinFrame;
import com.java.guest.StartFrame;

public class LoginFrame extends JFrame {

	private JFrame frame;
	
	public LoginFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(200,30, 600, 500);
		frame.getContentPane().add(loginPanel);
		loginPanel.setBackground(Color.lightGray);
		loginPanel.setLayout(null);
		loginPanel.setVisible(true);
		
		ImageIcon loginIcon = new ImageIcon("images/login.png");
		
		JLabel loginLabel = new JLabel(loginIcon);
		loginLabel.setBounds(150, 50, 300, 177);
		loginPanel.add(loginLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setBounds(100,250, 40, 20);
		loginPanel.add(idLabel);
		
		JLabel pwdLabel = new JLabel("PW");
		pwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwdLabel.setBounds(100,300, 40, 20);
		loginPanel.add(pwdLabel);
		
		JTextField idField = new JTextField();
		idField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idField.setBounds(150, 250, 300, 30);
		loginPanel.add(idField);
		
		JPasswordField pwdField = new JPasswordField();
		pwdField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwdField.setBounds(150, 300, 300, 30);
		loginPanel.add(pwdField);
		
		JButton loginButton = new JButton("로그인");
		loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		loginButton.setBounds(150, 350, 300, 30);
		loginPanel.add(loginButton);
		
		JButton signButton = new JButton("회원가입");
		signButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		signButton.setBounds(150, 400, 100, 30);
		loginPanel.add(signButton);
		
		JButton IdSearchButton = new JButton("아이디 찾기");
		IdSearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		IdSearchButton.setBounds(350, 400, 100, 30);
		loginPanel.add(IdSearchButton);
		
		JButton pwdSearchButton = new JButton("비밀번호 찾기");
		pwdSearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		pwdSearchButton.setBounds(350, 430, 100, 30);
		loginPanel.add(pwdSearchButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				char[] pwd = pwdField.getPassword();
				
				String pw = "";
				for(char cha : pwd) {
					Character.toString(cha);
					pw += (pwd.equals("")) ? "" + cha + "" : "" + cha + ""; 
				}
				
				MemberDAO dao = MemberDAO.getInstance();
				int result = dao.findByUsernameAndPassword(id, pw);
				if(result == 1) {
					frame.dispose();
					StartFrame frame = new StartFrame();
				}
				else if (result == 2) {
					frame.dispose();
					AdminFrame frame = new AdminFrame(id);
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}			
			}
		});
		
		signButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					frame.dispose();
					MemberJoinFrame frame = new MemberJoinFrame();
				
			}
		});
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
