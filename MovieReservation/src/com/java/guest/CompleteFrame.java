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

import com.java.dao.MovieDAO;
import com.java.dao.ReservationDAO;
import com.java.dto.Movie;
import com.java.dto.Reservation;

public class CompleteFrame extends JFrame {

	private JFrame frame;
	private String id;
	private String m_name;
	private String m_theater;
	private String m_startDay;
	private String m_startTime;
	private int m_price;
	
	public CompleteFrame() {}
	
	public CompleteFrame(String id,String m_name, String m_theater, String m_startDay, String m_startTime, int m_price, String seatInfo, String m_poster) {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		
		System.out.println("좌석정보 : " + seatInfo);
		JPanel completePanel = new JPanel();
		completePanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(completePanel);
		completePanel.setBackground(Color.lightGray);
		completePanel.setLayout(null);
		
		ImageIcon completeIcon = new ImageIcon("images/"+m_name+".jpg");
		
		JLabel completeImageLabel = new JLabel(completeIcon);
		completeImageLabel.setBounds(30, 120, 230, 342);
		completePanel.add(completeImageLabel);
		
		JLabel completeSelectLabel = new JLabel("선택한 영화");
		completeSelectLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		completeSelectLabel.setBounds(100, 80, 100, 20);
		completePanel.add(completeSelectLabel);
		
		JLabel completeNameLabel = new JLabel("제목 :  " + m_name);
		completeNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeNameLabel.setBounds(400, 80, 300, 30);
		completePanel.add(completeNameLabel);
		
		JLabel completeDayLabel = new JLabel("상영 날짜 :  " + m_startDay);
		completeDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeDayLabel.setBounds(355, 150, 200, 30);
		completePanel.add(completeDayLabel);
		
		JLabel completeTimeLabel = new JLabel("상영 시간 :  " + m_startTime);
		completeTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeTimeLabel.setBounds(355, 220, 200, 30);
		completePanel.add(completeTimeLabel);
		
		JLabel completeTheaterLabel = new JLabel("상영관 :  " + m_theater);
		completeTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeTheaterLabel.setBounds(380, 290, 200, 30);
		completePanel.add(completeTheaterLabel);
		
		JLabel completeSeatLabel = new JLabel("좌석 :  " + seatInfo);
		completeSeatLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completeSeatLabel.setBounds(400, 360, 300, 30);
		completePanel.add(completeSeatLabel);

		JLabel completePriceLabel = new JLabel("가격 :  " + m_price);
		completePriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		completePriceLabel.setBounds(400, 430, 200, 30);
		completePanel.add(completePriceLabel);
		
		JButton rsvCompleteBtn = new JButton("예매 완료");
		rsvCompleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rsvCompleteBtn.setBounds(800, 440, 100, 30);
		completePanel.add(rsvCompleteBtn);
		
		JButton beforeButton = new JButton("이전화면");
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeButton.setBounds(30, 20, 100, 30);
		completePanel.add(beforeButton);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ChoiceSeatFrame frame = new ChoiceSeatFrame(id,m_name,m_theater,m_startDay,m_startTime,m_price,m_poster);
			}
		});

		rsvCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reservation reserve = new Reservation();
				reserve.setRsv_id(id);
				reserve.setRsv_name(m_name);
				reserve.setRsv_poster(m_poster);
				reserve.setRsv_startDay(m_startDay);
				reserve.setRsv_startTime(m_startTime);
				reserve.setRsv_theater(m_theater);
				reserve.setRsv_seat(seatInfo);
				reserve.setRsv_price(m_price);
				
				ReservationDAO dao = ReservationDAO.getInstance();
				int save = dao.save(reserve);
				
				Movie movie = new Movie();
				movie.setM_count(1);
				movie.setM_name(m_name);
				
				MovieDAO dao2 = MovieDAO.getInstance();
				int count = dao2.count(movie);
				System.out.println(count);
				
				int result = save + count;
				if (2 == result) {
					JOptionPane.showMessageDialog(null, "예매 완료");
				} else {
					JOptionPane.showMessageDialog(null, "예매 실패");
				}
				
				//Movie movie = new Movie();
				frame.dispose();
				StartFrame frame = new StartFrame(id);
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
