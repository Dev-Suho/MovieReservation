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

public class IdSearchFrame extends JFrame {

	private JFrame frame;
	
	public IdSearchFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel idSearchPanel = new JPanel();
		idSearchPanel.setBounds(200,30, 600, 500);
		frame.getContentPane().add(idSearchPanel);
		idSearchPanel.setBackground(Color.lightGray);
		idSearchPanel.setLayout(null);
		idSearchPanel.setVisible(true);
		
		ImageIcon loginIcon = new ImageIcon("images/login.png");
		
		JLabel loginLabel = new JLabel(loginIcon);
		loginLabel.setBounds(150, 50, 300, 177);
		idSearchPanel.add(loginLabel);
		
		JLabel idLabel = new JLabel("아이디 찾기");
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idLabel.setBounds(240,250, 120, 22);
		idSearchPanel.add(idLabel);
		
		JLabel nameSearchLabel = new JLabel("이름  : ");
		nameSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		nameSearchLabel.setBounds(150, 300, 120, 22);
		idSearchPanel.add(nameSearchLabel);
		
		JTextField nameSearchField = new JTextField();
		nameSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameSearchField.setBounds(220, 300, 200, 30);
		idSearchPanel.add(nameSearchField);
		
		JLabel birthSearchLabel = new JLabel("생년월일  :");
		birthSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		birthSearchLabel.setBounds(115,350, 120, 22);
		idSearchPanel.add(birthSearchLabel);
		
		JTextField birthSearchField = new JTextField();
		birthSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		birthSearchField.setBounds(220, 350, 200, 30);
		idSearchPanel.add(birthSearchField);
		
		JLabel phoneSearchLabel = new JLabel("전화번호( - 포함)  :");
		phoneSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		phoneSearchLabel.setBounds(50,400, 150, 22);
		idSearchPanel.add(phoneSearchLabel);
		
		JTextField phoneSearchField = new JTextField();
		phoneSearchField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		phoneSearchField.setBounds(220, 400, 200, 30);
		idSearchPanel.add(phoneSearchField);
		
		JButton idSearchButton = new JButton("아이디 찾기");
		idSearchButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idSearchButton.setBounds(240, 450, 120, 30);
		idSearchPanel.add(idSearchButton);
		
		JButton beforeFrameButton = new JButton("이전화면");
		beforeFrameButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeFrameButton.setBounds(480, 20, 100, 30);
		idSearchPanel.add(beforeFrameButton);
		
		beforeFrameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
		
		idSearchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = MemberDAO.getInstance();
				String searchId = dao.searchId(nameSearchField.getText(), birthSearchField.getText(), phoneSearchField.getText());
				
				if (null != searchId) {
				JOptionPane.showMessageDialog(null,"ID는 " + searchId + " 입니다." );
				frame.dispose();
				LoginFrame frame = new LoginFrame();
				}
				else {
					JOptionPane.showMessageDialog(null,"조회되지 않는 회원정보입니다." );
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdSearchFrame frame = new IdSearchFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
