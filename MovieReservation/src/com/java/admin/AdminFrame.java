package com.java.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.java.login.LoginFrame;

public class AdminFrame extends JFrame {

	private JFrame frame;
	
	public AdminFrame() {
		this(null);
	}
	public AdminFrame(String id) {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(false);
		
		if(id == null) {
			JOptionPane.showMessageDialog(null, "인증되지 않은 사용자 입니다.");
			dispose();
			frame.dispose();
		} else {
			frame.setVisible(true);
		}
		
		JPanel adminPanel = new JPanel();
		adminPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(adminPanel);
		adminPanel.setBackground(Color.lightGray);
		adminPanel.setLayout(null);	
		adminPanel.setVisible(true);
		
		JButton movieListBtn = new JButton("영화 관리");
		movieListBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		movieListBtn.setBounds(200, 150, 200, 200);
		adminPanel.add(movieListBtn);
		
		JButton memberListBtn = new JButton("회원 관리");
		memberListBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberListBtn.setBounds(600, 150, 200, 200);
		adminPanel.add(memberListBtn);
		
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		logoutBtn.setBounds(800, 30, 100, 30);
		adminPanel.add(logoutBtn);
		
		movieListBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MovieManagementFrame frame = new MovieManagementFrame(id);
			}
		});
		
		memberListBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberManagementFrame frame = new MemberManagementFrame(id);
			}
		});
		
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	
	}

}
