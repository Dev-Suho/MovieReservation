package com.java.guest;

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

import com.java.login.LoginFrame;

public class StartFrame extends JFrame {

	private JFrame frame;
	private String id;
	
	public StartFrame() {
		this(null);
	}
	
	public StartFrame(String id) {
		
		this.id = id;
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		if (id == null) {
			JOptionPane.showMessageDialog(null, "인증되지 않은 사용자입니다");
			dispose();
			frame.dispose();
		}
		else {
			frame.setVisible(true);
		}
		
		JPanel startPanel = new JPanel();
		startPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(startPanel);
		startPanel.setBackground(Color.darkGray);
		startPanel.setLayout(null);	
		startPanel.setVisible(true);
		
		ImageIcon logoImage = new ImageIcon("images/Cinema_banner_logo.jpg");
		
		JLabel movieLogoLabel = new JLabel(logoImage);
		movieLogoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		movieLogoLabel.setBounds(150, 20, 700, 393);
		startPanel.add(movieLogoLabel);
		
		JButton rsvBtn = new JButton("예매");
		rsvBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		rsvBtn.setBounds(100, 425, 200, 130);
		startPanel.add(rsvBtn);
		
		JButton recomBtn = new JButton("상영작 순위");
		recomBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		recomBtn.setBounds(400, 425, 200, 130);
		startPanel.add(recomBtn);
		
		JButton myPageBtn = new JButton("마이페이지");
		myPageBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		myPageBtn.setBounds(700, 425, 200, 130);
		startPanel.add(myPageBtn);
		
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		logoutBtn.setBounds(875, 30, 100, 30);
		startPanel.add(logoutBtn);
		
		rsvBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReservationFrame frame = new ReservationFrame(id);
			}
		});
		
		recomBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RecomFrame frame = new RecomFrame(id);
			}
		});	
		
		myPageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyPageFrame frame = new MyPageFrame(id);
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
					new StartFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
