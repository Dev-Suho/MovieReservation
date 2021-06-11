package com.java.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.dao.MemberDAO;
import com.java.dto.Member;

public class MemberManagementFrame extends JFrame {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private static String id;
	
	public MemberManagementFrame() {
		this(null);
	}
	
	public MemberManagementFrame(String id) {
		this.id = id;
		frame = new JFrame();
		frame.setTitle("영화 예매 프로그램");
		frame.setSize(1200, 700);	
		frame.setResizable(false); // 창 크기 고정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임을 닫으면 프로그램도 같이 종료	
		frame.setLocationRelativeTo(null); // 화면 가운데에 생성
		frame.getContentPane().setLayout(null);		
		frame.setVisible(true);
		
		JPanel memberManagementPanel = new JPanel();
		memberManagementPanel.setBounds(0, 0, 1196, 672);
		frame.getContentPane().add(memberManagementPanel);
		memberManagementPanel.setBackground(Color.lightGray);
		memberManagementPanel.setLayout(new BorderLayout(0,0));
		
		JLabel memberListLabel = new JLabel("회원 목록");
		memberListLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberListLabel.setPreferredSize(new Dimension(100, 40));
		memberManagementPanel.add(memberListLabel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel(new GridLayout(1, 2));
		JButton memberDeleteButton = new JButton("회원 삭제");
		JButton beforeButton = new JButton("이전화면");
		southPanel.add(memberDeleteButton);
		southPanel.add(beforeButton);
		beforeButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberDeleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		memberManagementPanel.add(southPanel, BorderLayout.SOUTH);
		
		MemberDAO dao = MemberDAO.getInstance();
		Vector<String> memberName = dao.getMemberName();
		Vector<Member> members = dao.findByAll();
		
		tableModel = new DefaultTableModel(memberName, 0);
		
		for (int i = 0; i < members.size(); i++) {
			Vector<Object> row = new Vector<>();
			row.addElement(members.get(i).getId());
			row.addElement(members.get(i).getPwd());
			row.addElement(members.get(i).getName());
			row.addElement(members.get(i).getTel());
			row.addElement(members.get(i).getAddr());
			row.addElement(members.get(i).getBirth());
			row.addElement(members.get(i).getGender());
			row.addElement(members.get(i).getCreateDate());
			tableModel.addRow(row);
		}	
		
		JTable memberTable = new JTable(tableModel);
		memberTable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		memberManagementPanel.add(memberTable, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(memberTable);
		memberManagementPanel.add(scrollPane, BorderLayout.CENTER);
		
		beforeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminFrame frame = new AdminFrame(id);
			}
		});
		
		memberDeleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = memberTable.getSelectedRow();
				if(row < 0) {
					row = memberTable.getRowCount()-1;
				}
				Object id = memberTable.getValueAt(row, 0);
				
				tableModel.removeRow(row);
				
				Member member = new Member();
				member.setId((String)id);
				
				MemberDAO dao = MemberDAO.getInstance();
				int result = dao.delete(member);
				
				if (1 == result) {
					JOptionPane.showMessageDialog(null, "회원삭제 완료");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "회원삭제 실패");
					dispose();
				}
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementFrame frame = new MemberManagementFrame();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
}
