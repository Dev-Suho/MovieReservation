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
import javax.swing.JPanel;

public class CompleteFrame extends JFrame {

	private JFrame frame;
	
	public CompleteFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel completePanel = new JPanel();
		completePanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(completePanel);
		completePanel.setBackground(Color.lightGray);
		completePanel.setLayout(null);
		
		ImageIcon completeIcon = new ImageIcon("images/비와 당신의 이야기.jpg");
		
		JLabel completeImageLabel = new JLabel(completeIcon);
		completeImageLabel.setBounds(30, 120, 230, 342);
		completePanel.add(completeImageLabel);
		
		JLabel completeLabel = new JLabel("선택한 영화");
		completeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		completeLabel.setBounds(100, 80, 100, 20);
		completePanel.add(completeLabel);
		
		JLabel completeLabel2 = new JLabel("날짜 :");
		completeLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeLabel2.setBounds(400, 120, 70, 30);
		completePanel.add(completeLabel2);
		
		JLabel completeDateLabel = new JLabel("2021-05-12");
		completeDateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeDateLabel.setBounds(500, 120, 150, 30);
		completePanel.add(completeDateLabel);
		
		JLabel completeLabel3 = new JLabel("시간 :");
		completeLabel3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeLabel3.setBounds(400, 200, 70, 30);
		completePanel.add(completeLabel3);
		
		JLabel completeTimeLabel = new JLabel("18:20");
		completeTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeTimeLabel.setBounds(500, 200, 150, 30);
		completePanel.add(completeTimeLabel);
		
		JLabel completeLabel4 = new JLabel("인원수 :");
		completeLabel4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeLabel4.setBounds(380, 280, 100, 30);
		completePanel.add(completeLabel4);
		
		JLabel completePeopleLabel = new JLabel("2명");
		completePeopleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completePeopleLabel.setBounds(500, 280, 150, 30);
		completePanel.add(completePeopleLabel);
		
		JLabel completeLabel5 = new JLabel("좌석 :");
		completeLabel5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeLabel5.setBounds(400, 360, 70, 30);
		completePanel.add(completeLabel5);
		
		JLabel completeSeatLabel = new JLabel("C12,C13");
		completeSeatLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeSeatLabel.setBounds(500, 360, 150, 30);
		completePanel.add(completeSeatLabel);
		
		JButton rsvCompleteBtn = new JButton("예매 완료");
		rsvCompleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rsvCompleteBtn.setBounds(800, 440, 100, 30);
		completePanel.add(rsvCompleteBtn);
		
		rsvCompleteBtn.addActionListener(new ActionListener() {
			
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
					new CompleteFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
