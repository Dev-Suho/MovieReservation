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
import javax.swing.JTable;

public class ReservationFrame extends JFrame {

	private JFrame frame;
	
	public ReservationFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel rsvPanel = new JPanel();
		rsvPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(rsvPanel);
		rsvPanel.setBackground(Color.lightGray);
		rsvPanel.setLayout(null);
		
		ImageIcon movieImage1 = new ImageIcon("images/비와 당신의 이야기.jpg");
		ImageIcon movieImage2 = new ImageIcon("images/미나리.jpg");
		ImageIcon movieImage3 = new ImageIcon("images/분노의 질주.jpg");
		
		
		JButton beforeRsvButton = new JButton("이전화면");
		beforeRsvButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeRsvButton.setBounds(30, 500, 100, 30);
		rsvPanel.add(beforeRsvButton);
		
		JButton nextRsvButton = new JButton("선택완료");
		nextRsvButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nextRsvButton.setBounds(830, 500, 100, 30);
		rsvPanel.add(nextRsvButton);
		
		JLabel rsvLabel = new JLabel("예매");
		rsvLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		rsvLabel.setBounds(500,30, 40, 25);
		rsvPanel.add(rsvLabel);
		
		JTable movieListTable = new JTable();
		movieListTable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		movieListTable.setBounds(100, 70, 800, 400);
		rsvPanel.add(movieListTable);
		
		beforeRsvButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame();
			}
		});
		
		nextRsvButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ChoiceSeatFrame frame = new ChoiceSeatFrame();
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ReservationFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
