package com.java.guest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.dao.MemberInfoDAO;

public class MemberModifyFrame extends JFrame {

	private JFrame frame;
	private String id;
	
	public MemberModifyFrame() {}
	
	public MemberModifyFrame(String id) {
		this.id = id;
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1000, 600);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel memberModifyPanel = new JPanel();
		memberModifyPanel.setBounds(0, 0, 996, 572);
		frame.getContentPane().add(memberModifyPanel);
		memberModifyPanel.setBackground(Color.lightGray);
		memberModifyPanel.setLayout(null);	
		memberModifyPanel.setVisible(true);
		
		JLabel memberInfoLabel = new JLabel("회원 정보수정");
		memberInfoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberInfoLabel.setBounds(430, 30, 130, 22);
		memberModifyPanel.add(memberInfoLabel);
		MemberInfoDAO dao = MemberInfoDAO.getInstance();
		
		String memberId = dao.getMemberInfoId(id);
		String memberPwd = dao.getMemberInfoPwd(id);
		String memberName = dao.getMemberInfoName(id);
		String memberTel = dao.getMemberInfoTel(id);
		String memberAddr = dao.getMemberInfoAddr(id);
		String memberBirth = dao.getMemberInfoBirth(id);
		String memberGender = dao.getMemberInfoGender(id);
		
		JLabel idLabel = new JLabel("ID : ");
		idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		idLabel.setBounds(300, 100, 100, 20);
		memberModifyPanel.add(idLabel);
		
		JLabel idField = new JLabel(memberId);
		idField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		idField.setBounds(350, 100, 100, 23);
		memberModifyPanel.add(idField);
		
		JLabel pwdLabel = new JLabel("PWD : ");
		pwdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pwdLabel.setBounds(275, 150, 100, 20);
		memberModifyPanel.add(pwdLabel);
		
		JTextField pwdField = new JTextField(memberPwd);
		pwdField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		pwdField.setBounds(350, 150, 100, 23);
		memberModifyPanel.add(pwdField);
		
		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		nameLabel.setBounds(280, 200, 100, 20);
		memberModifyPanel.add(nameLabel);
		
		JLabel nameField = new JLabel(memberName);
		nameField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		nameField.setBounds(350, 200, 100, 23);
		memberModifyPanel.add(nameField);
		
		JLabel telLabel = new JLabel("전화번호 : ");
		telLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		telLabel.setBounds(245, 250, 100, 20);
		memberModifyPanel.add(telLabel);
		
		JTextField telField = new JTextField(memberTel);
		telField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		telField.setBounds(350, 250, 200, 23);
		memberModifyPanel.add(telField);
		
		JLabel addressLabel = new JLabel("주소 : ");
		addressLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		addressLabel.setBounds(280, 300, 100, 20);
		memberModifyPanel.add(addressLabel);
		
		JTextField addrField = new JTextField(memberAddr);
		addrField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		addrField.setBounds(350, 300, 100, 23);
		memberModifyPanel.add(addrField);
		
		JLabel birthLabel = new JLabel("생년월일 : ");
		birthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		birthLabel.setBounds(245, 350, 100, 20);
		memberModifyPanel.add(birthLabel);
		
		JLabel birthField = new JLabel(memberBirth);
		birthField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		birthField.setBounds(350, 350, 100, 23);
		memberModifyPanel.add(birthField);
		
		JLabel genderLabel = new JLabel("성별 : ");
		genderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		genderLabel.setBounds(280, 400, 100, 20);
		memberModifyPanel.add(genderLabel);
		
		JLabel genderField = new JLabel(memberGender);
		genderField.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		genderField.setBounds(350, 400, 100, 23);
		memberModifyPanel.add(genderField);
		
		JButton beforeButton = new JButton("이전화면");
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		beforeButton.setBounds(30, 500, 100, 30);
		memberModifyPanel.add(beforeButton);
		
		JButton modifyButton = new JButton("회원정보 수정");
		modifyButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		modifyButton.setBounds(800, 500, 140, 30);
		memberModifyPanel.add(modifyButton);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyPageFrame frame = new MyPageFrame(id);
			}
		});
		
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberInfoDAO dao = MemberInfoDAO.getInstance();
				int result = dao.update(idField.getText(), pwdField.getText(), telField.getText(), addrField.getText());
				
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "회원수정이 완료되었습니다.");
					frame.dispose();
					MyPageFrame frame = new MyPageFrame(id);
				}
				else {
					JOptionPane.showMessageDialog(null, "회원정보를 다시 확인해주세요.");
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberModifyFrame frame = new MemberModifyFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
