package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.java.dao.MemberDAO;
import com.java.dao.MemberInfoDAO;
import com.java.dao.ReservationDAO;
import com.java.dto.Member;

public class MyPageFrame extends JFrame{

	private JFrame frame;
	private String id;
	
	public MyPageFrame() {}
	
	public MyPageFrame(String id) {
		this.id = id;
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
		
		ReservationDAO rsvDao = ReservationDAO.getInstance();
		String rsvName = rsvDao.getReservationName(id);
		String rsvPoster= rsvDao.getReservationPoster(id);
		String rsvStartDay = rsvDao.getReservationStartDay(id);
		String rsvStartTime = rsvDao.getReservationStartTime(id);
		String rsvTheater = rsvDao.getReservationTheater(id);
		String rsvSeat = rsvDao.getReservationSeat(id);
		int rsvPrice = rsvDao.getReservationPrice(id);
		
		MemberInfoDAO dao = MemberInfoDAO.getInstance();
		String memberId = dao.getMemberInfoId(id);
		String memberPwd = dao.getMemberInfoPwd(id);
		String memberName = dao.getMemberInfoName(id);
		String memberTel = dao.getMemberInfoTel(id);
		String memberAddr = dao.getMemberInfoAddr(id);
		String memberBirth = dao.getMemberInfoBirth(id);
		String memberGender = dao.getMemberInfoGender(id);
		
		System.out.println("회원아이디 : " + memberId);
		
		JLabel memberInfoLabel = new JLabel("회원 정보");
		memberInfoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberInfoLabel.setBounds(155, 30, 100, 22);
		myPagePanel.add(memberInfoLabel);
		
		JLabel idLabel = new JLabel("ID :  " + memberId);
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		idLabel.setBounds(150, 100, 150, 23);
		myPagePanel.add(idLabel);
		
		JLabel pwdLabel = new JLabel("PWD :  " + memberPwd);
		pwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pwdLabel.setBounds(125, 150, 200, 20);
		myPagePanel.add(pwdLabel);
		
		JLabel nameLabel = new JLabel("이름 :  " + memberName);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		nameLabel.setBounds(130, 200, 200, 23);
		myPagePanel.add(nameLabel);

		JLabel telLabel = new JLabel("전화번호 :  " + memberTel);
		telLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		telLabel.setBounds(95, 250, 400, 20);
		myPagePanel.add(telLabel);

		JLabel addressLabel = new JLabel("주소 :  " + memberAddr);
		addressLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		addressLabel.setBounds(130, 300, 400, 20);
		myPagePanel.add(addressLabel);
		
		JLabel birthLabel = new JLabel("생년월일 :  " + memberBirth);
		birthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		birthLabel.setBounds(95, 350, 200, 20);
		myPagePanel.add(birthLabel);
		
		JLabel genderLabel = new JLabel("성별 :  " + memberGender);
		genderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		genderLabel.setBounds(130, 400, 200, 20);
		myPagePanel.add(genderLabel);
		
		JButton beforeButton = new JButton("이전화면");
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeButton.setBounds(30, 500, 100, 30);
		myPagePanel.add(beforeButton);
		
		JButton modifyButton = new JButton("회원정보 수정");
		modifyButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		modifyButton.setBounds(800, 500, 140, 30);
		myPagePanel.add(modifyButton);
		
		// 예매정보
		JLabel reserveInfoLabel = new JLabel("예매 정보");
		reserveInfoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		reserveInfoLabel.setBounds(600, 30, 100, 22);
		myPagePanel.add(reserveInfoLabel);
		
		ImageIcon reservationIcon = new ImageIcon("images/"+rsvPoster);
		
		JLabel rsvPosterLabel = new JLabel(reservationIcon);
		rsvPosterLabel.setBounds(400, 100, 230, 342);
		myPagePanel.add(rsvPosterLabel);
		
		JLabel rsvNameLabel = new JLabel("영화제목 : " + rsvName);
		rsvNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvNameLabel.setBounds(670, 130, 300, 23);
		myPagePanel.add(rsvNameLabel);
		
		JLabel rsvStartDayLabel = new JLabel("상영날짜 : " + rsvStartDay);
		rsvStartDayLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvStartDayLabel.setBounds(670, 180, 200, 20);
		myPagePanel.add(rsvStartDayLabel);
		
		JLabel rsvStartTimeLabel = new JLabel("상영시간 : " + rsvStartTime);
		rsvStartTimeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvStartTimeLabel.setBounds(670, 230, 200, 20);
		myPagePanel.add(rsvStartTimeLabel);

		JLabel rsvTheaterLabel = new JLabel("상영관 : " + rsvTheater);
		rsvTheaterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvTheaterLabel.setBounds(670, 280, 400, 20);
		myPagePanel.add(rsvTheaterLabel);

		JLabel rsvSeatLabel = new JLabel("좌석 : " + rsvSeat);
		rsvSeatLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvSeatLabel.setBounds(670, 330, 400, 20);
		myPagePanel.add(rsvSeatLabel);
		
		JLabel rsvPriceLabel = new JLabel("가격 : " + rsvPrice);
		rsvPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		rsvPriceLabel.setBounds(670, 380, 200, 20);
		myPagePanel.add(rsvPriceLabel);
		
		if (null == rsvName) {
			rsvNameLabel.setVisible(false);
			rsvPosterLabel.setVisible(false);
			rsvPriceLabel.setVisible(false);
			rsvSeatLabel.setVisible(false);
			rsvStartDayLabel.setVisible(false);
			rsvStartTimeLabel.setVisible(false);
			rsvTheaterLabel.setVisible(false);
		}

		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartFrame frame = new StartFrame(id);
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberModifyFrame frame = new MemberModifyFrame(id);
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
