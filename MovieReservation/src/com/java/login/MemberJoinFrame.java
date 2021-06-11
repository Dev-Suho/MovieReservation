package com.java.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.java.dao.MemberDAO;
import com.java.dto.Member;
import com.java.util.Time;

public class MemberJoinFrame extends JFrame{

	private JFrame frame;
	
	public MemberJoinFrame() {
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBounds(200,30, 600, 500);
		frame.getContentPane().add(memberJoinPanel);
		memberJoinPanel.setBackground(Color.lightGray);
		memberJoinPanel.setLayout(null);	
		memberJoinPanel.setVisible(true);
		
		JLabel joinLabel = new JLabel("회원가입");
		joinLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinLabel.setBounds(280, 50, 100, 20);
		memberJoinPanel.add(joinLabel);
		
		JLabel joinIdLabel = new JLabel("ID  : ");
		joinIdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinIdLabel.setBounds(210, 100, 100, 20);
		memberJoinPanel.add(joinIdLabel);
		
		JTextField joinIdField = new JTextField();
		joinIdField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinIdField.setBounds(250, 100, 150, 25);
		joinIdField.setColumns(10);
		memberJoinPanel.add(joinIdField);
		
		JButton idCheckButton = new JButton("중복체크");
		idCheckButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		idCheckButton.setBounds(420, 100, 100, 25);
		memberJoinPanel.add(idCheckButton);
		
		JLabel joinPwdLabel = new JLabel("PW  : ");
		joinPwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinPwdLabel.setBounds(200, 150, 100, 20);
		memberJoinPanel.add(joinPwdLabel);
		
		JTextField joinPwdField = new JTextField();
		joinPwdField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinPwdField.setBounds(250, 150, 150, 25);
		memberJoinPanel.add(joinPwdField);
		
		JLabel joinNameLabel = new JLabel("이름  : ");
		joinNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinNameLabel.setBounds(195, 200, 100, 20);
		memberJoinPanel.add(joinNameLabel);
		
		JTextField joinNameField = new JTextField();
		joinNameField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinNameField.setBounds(250, 200, 150, 20);
		memberJoinPanel.add(joinNameField);
		
		JLabel joinTelLabel = new JLabel("핸드폰 번호 : ");
		joinTelLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinTelLabel.setBounds(150, 250, 100, 20);
		memberJoinPanel.add(joinTelLabel);
		
		JTextField joinTelField = new JTextField();
		joinTelField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinTelField.setBounds(250, 250, 150, 20);
		memberJoinPanel.add(joinTelField);
		
		JLabel joinAddrLabel = new JLabel("주소 : ");
		joinAddrLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinAddrLabel.setBounds(195, 300, 100, 20);
		memberJoinPanel.add(joinAddrLabel);
		
		JTextField joinAddrField = new JTextField();
		joinAddrField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinAddrField.setBounds(250, 300, 300, 20);
		memberJoinPanel.add(joinAddrField);
		
		JLabel joinNumLabel = new JLabel("주민등록번호 : ");
		joinNumLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinNumLabel.setBounds(130, 350, 120, 20);
		memberJoinPanel.add(joinNumLabel);
		
		JTextField joinNumField = new JTextField();
		joinNumField.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		joinNumField.setBounds(250, 350, 60, 20);
		joinNumField.setColumns(6);
		memberJoinPanel.add(joinNumField);
		
		JLabel joinNumLabel2 = new JLabel("- *******");
		joinNumLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		joinNumLabel2.setBounds(320, 350, 100, 20);
		memberJoinPanel.add(joinNumLabel2);
		
		JRadioButton joinMaleButton = new JRadioButton("남자");
		joinMaleButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		joinMaleButton.setBounds(200, 400, 70, 25);
		memberJoinPanel.add(joinMaleButton);
		
		JRadioButton joinFemaleButton = new JRadioButton("여자");
		joinFemaleButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		joinFemaleButton.setBounds(330, 400, 70, 25);
		memberJoinPanel.add(joinFemaleButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(joinFemaleButton);
		bg.add(joinMaleButton);
		
		JButton beforeRsvButton = new JButton("이전화면");
		beforeRsvButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeRsvButton.setBounds(30, 50, 100, 30);
		memberJoinPanel.add(beforeRsvButton);
		
		JButton memberJoinButton = new JButton("회원 등록");
		memberJoinButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		memberJoinButton.setBounds(200, 450, 200, 30);
		memberJoinPanel.add(memberJoinButton);
		
		idCheckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = MemberDAO.getInstance();
				int result = dao.findByUserId(joinIdField.getText());
				if (1 == result) {
					JOptionPane.showMessageDialog(null,"회원 아이디가 중복되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null,"사용 가능한 아이디입니다.");
				}
			}
		});
		memberJoinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Member member = new Member();
				member.setId(joinIdField.getText());
				member.setPwd(joinPwdField.getText());
				member.setName(joinNameField.getText());
				member.setTel(joinTelField.getText());
				member.setAddr(joinAddrField.getText());
				member.setBirth(joinNumField.getText());
				if (joinFemaleButton.isSelected()) {
					member.setGender("Female");
				}
				else if (joinMaleButton.isSelected()) {
					member.setGender("Male");
				}
				else {
					System.out.println("젠더 설정 실패");
				}
				member.setCreateDate(Time.localDateTimeToTimeStamp(LocalDateTime.now()));
				
				MemberDAO dao = MemberDAO.getInstance();
				int result = dao.save(member);
				
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "회원등록 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원등록 실패");
					dispose();
				}
				frame.dispose();
				LoginFrame frame = new LoginFrame();
			}
		});
		
		beforeRsvButton.addActionListener(new ActionListener() {
			
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
					MemberJoinFrame frame = new MemberJoinFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
