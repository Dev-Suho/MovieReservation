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
import javax.swing.JTextField;

public class ChoiceSeatFrame extends JFrame {

	private JFrame frame;
	
	public ChoiceSeatFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		ImageIcon movieImage1 = new ImageIcon("images/비와 당신의 이야기.jpg");
		ImageIcon movieImage2 = new ImageIcon("images/미나리.jpg");
		ImageIcon movieImage3 = new ImageIcon("images/분노의 질주.jpg");
		
		JPanel rsvPanel2 = new JPanel();
		rsvPanel2.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(rsvPanel2);
		rsvPanel2.setBackground(Color.lightGray);
		rsvPanel2.setLayout(null);
		
		JLabel rsvLabel2 = new JLabel("선택한 영화");
		rsvLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rsvLabel2.setBounds(100, 80, 100, 20);
		rsvPanel2.add(rsvLabel2);
		
		JLabel movieLabel = new JLabel(movieImage1);
		movieLabel.setBounds(30, 120, 230, 342);
		rsvPanel2.add(movieLabel);
		
		JLabel dateLabel = new JLabel("날짜");
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		dateLabel.setBounds(300, 50, 50, 20);
		rsvPanel2.add(dateLabel);
		
		JLabel timeLabel = new JLabel("시간");
		timeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		timeLabel.setBounds(400, 50, 50, 20);
		rsvPanel2.add(timeLabel);
		
		JLabel peopleNumLabel = new JLabel("인원수");
		peopleNumLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		peopleNumLabel.setBounds(750, 50, 50, 20);
		rsvPanel2.add(peopleNumLabel);
		
		JTextField peopleNumField = new JTextField();
		peopleNumField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		peopleNumField.setBounds(800, 50, 100, 20);
		rsvPanel2.add(peopleNumField);
		
		JButton selectBtn = new JButton("선택");
		selectBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		selectBtn.setBounds(910, 50, 70, 22);
		rsvPanel2.add(selectBtn);
		
		JButton paymentBtn = new JButton("결제");
		paymentBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		paymentBtn.setBounds(850, 500, 100, 25);
		rsvPanel2.add(paymentBtn);
		/*
		JSpinner dateSpinner = new JSpinner();
		rsvPanel2.setBounds(360, 50, 100, 20);
		rsvPanel2.add(dateSpinner);
		*/
		
		
		JTable rsvTable = new JTable();
		rsvTable.setBounds(300, 80, 600, 400);
		rsvPanel2.add(rsvTable);
		
		paymentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CompleteFrame frame = new CompleteFrame();
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ChoiceSeatFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
