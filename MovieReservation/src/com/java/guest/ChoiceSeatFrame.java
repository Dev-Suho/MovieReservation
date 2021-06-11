package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChoiceSeatFrame extends JFrame {

	private JFrame frame;
	private String id;
	private String m_name;
	private String m_theater;
	private String m_startDay;
	private String m_startTime;
	private int m_price;
	private String m_poster;
	
	public ChoiceSeatFrame() {
	}
	
	public ChoiceSeatFrame(String id,String m_name, String m_theater, String m_startDay, String m_startTime, int m_price, String m_poster) {
		this.m_price = m_price;
		
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel rsvPanel2 = new JPanel();
		rsvPanel2.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(rsvPanel2);
		rsvPanel2.setBackground(Color.lightGray);
		rsvPanel2.setLayout(null);
		
		
		JLabel seatChoiceLabel = new JLabel("좌석 선택");
		seatChoiceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		seatChoiceLabel.setBounds(440, 30, 100, 22);
		rsvPanel2.add(seatChoiceLabel);
		
		
		JLabel aTheaterLabel= new JLabel("A 상영관");
		aTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		aTheaterLabel.setBounds(150, 100, 100, 20);
		rsvPanel2.add(aTheaterLabel);
		
		JLabel aTheaterScreen = new JLabel("Screen");
		aTheaterScreen.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		aTheaterScreen.setOpaque(true);
		aTheaterScreen.setBackground(Color.black);
		aTheaterScreen.setForeground(Color.white);
		aTheaterScreen.setHorizontalAlignment(JLabel.CENTER);
		aTheaterScreen.setBounds(50, 150, 250, 20);
		rsvPanel2.add(aTheaterScreen);
		
		JLabel bTheaterScreen = new JLabel("Screen");
		bTheaterScreen.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bTheaterScreen.setOpaque(true);
		bTheaterScreen.setBackground(Color.black);
		bTheaterScreen.setForeground(Color.white);
		bTheaterScreen.setHorizontalAlignment(JLabel.CENTER);
		bTheaterScreen.setBounds(350, 150, 250, 20);
		rsvPanel2.add(bTheaterScreen);
		
		JLabel cTheaterScreen = new JLabel("Screen");
		cTheaterScreen.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cTheaterScreen.setOpaque(true);
		cTheaterScreen.setBackground(Color.black);
		cTheaterScreen.setForeground(Color.white);
		cTheaterScreen.setHorizontalAlignment(JLabel.CENTER);
		cTheaterScreen.setBounds(650, 150, 250, 20);
		rsvPanel2.add(cTheaterScreen);
		
		
		// 체크박스(좌석) 생성
		String[] seatNum = {"A1", "A2", "A3", "A4", "A5",
				"B1", "B2", "B3", "B4", "B5",
				"C1", "C2", "C3", "C4", "C5",
				"D1", "D2", "D3", "D4", "D5",
				"E1", "E2", "E3", "E4", "E5",
				"F1", "F2", "F3", "F4", "F5"};
		
		JCheckBox[] seatBoxA = new JCheckBox[seatNum.length];
		JCheckBox[] seatBoxB = new JCheckBox[seatNum.length];
		JCheckBox[] seatBoxC = new JCheckBox[seatNum.length];
		int seatX = 50, seatY = 0;
		System.out.println(m_theater);
			for (int i = 0; i < seatNum.length; i++) {
				if (i > 4 && i % 5 == 0) {
					seatY += 30;
					seatX = 50;
				}
				seatBoxA[i] = new JCheckBox(seatNum[i]);
				seatBoxA[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
				seatBoxA[i].setBounds(seatX, 200 + seatY, 50, 20);
				if(m_theater.equals("A")) 
					seatBoxA[i].setEnabled(true);
				else
					seatBoxA[i].setEnabled(false);
				rsvPanel2.add(seatBoxA[i]);
				seatX += 50;
			}
		
		seatY = 0;
		
		int seatBx = 350;
		for (int i = 0; i < seatNum.length; i++) {
			if (i > 4 && i % 5 == 0) {
				seatY += 30;
				seatBx = 350;
			}
			seatBoxB[i] = new JCheckBox(seatNum[i]);
			seatBoxB[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			seatBoxB[i].setBounds(seatBx, 200 + seatY, 50, 20);
			if(m_theater.equals("B")) 
				seatBoxB[i].setEnabled(true);
			else
				seatBoxB[i].setEnabled(false);
			rsvPanel2.add(seatBoxB[i]);
			seatBx += 50;
		}
		seatY = 0;
	
		int seatCx = 650;
		for (int i = 0; i < seatNum.length; i++) {
			if (i > 4 && i % 5 == 0) {
				seatY += 30;
				seatCx = 650;
			}
			seatBoxC[i] = new JCheckBox(seatNum[i]);
			seatBoxC[i].setFont(new Font("맑은 고딕", Font.BOLD, 13));
			seatBoxC[i].setBounds(seatCx, 200 + seatY, 50, 20);
			if(m_theater.equals("C")) 
				seatBoxC[i].setEnabled(true);
			else
				seatBoxC[i].setEnabled(false);
			rsvPanel2.add(seatBoxC[i]);
			seatCx += 50;
		}
	
		
		JLabel bTheaterLabel = new JLabel("B 상영관");
		bTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		bTheaterLabel.setBounds(450, 100, 100, 20);
		rsvPanel2.add(bTheaterLabel);
		
		JLabel cTheaterLabel = new JLabel("C 상영관");
		cTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cTheaterLabel.setBounds(750, 100, 100, 20);
		rsvPanel2.add(cTheaterLabel);
		
		JButton paymentBtn = new JButton("결제");
		paymentBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		paymentBtn.setBounds(850, 500, 100, 25);
		rsvPanel2.add(paymentBtn);

		JButton beforeButton = new JButton("이전화면");
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeButton.setBounds(30, 500, 100, 30);
		rsvPanel2.add(beforeButton);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ReservationFrame frame = new ReservationFrame(id);
			}
		});
		
		paymentBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String seatInfo = "";
				int count = 0;
				// 선택된 체크박스의 이름을 가져옴
				for (JCheckBox checkbox : seatBoxA ) {
					if(checkbox.isSelected())
					{
						count++;
						seatInfo += checkbox.getText() + " ";
						System.out.println(seatInfo);
					}
				}
				for (JCheckBox checkbox : seatBoxB ) {
					if(checkbox.isSelected())
					{
						count++;
						seatInfo += checkbox.getText() + " ";
						System.out.println(seatInfo);
					}
				}
				for (JCheckBox checkbox : seatBoxC ) {
					if(checkbox.isSelected())
					{
						count++;
						seatInfo += checkbox.getText() + " ";
						System.out.println(count);
					}
				}
				frame.dispose();
				CompleteFrame frame = new CompleteFrame(id,m_name,m_theater,m_startDay,m_startTime,m_price*count,seatInfo,m_poster);
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
