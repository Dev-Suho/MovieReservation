package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPageFrame extends JFrame{

	private JFrame frame;
	
	public MyPageFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel myPagePanel = new JPanel();
		myPagePanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(myPagePanel);
		myPagePanel.setBackground(Color.lightGray);
		myPagePanel.setLayout(null);	
		myPagePanel.setVisible(true);
		
		JLabel memberInfoLabel = new JLabel("회원 정보");
		memberInfoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		memberInfoLabel.setBounds(450, 50, 100, 20);
		myPagePanel.add(memberInfoLabel);
		
		JButton beforeButton = new JButton("이전화면");
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeButton.setBounds(30, 500, 100, 30);
		myPagePanel.add(beforeButton);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame();
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MyPageFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
