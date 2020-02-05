package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.OrderDTO;
import singleton.Singleton;

public class OrderDetail extends JFrame {

	Container contain = getContentPane();

	private JTable jtable;
	private JScrollPane jscrPane;

	private JButton writeBtn, logout, delete;

	String columnNames[] = { "Espresso Beverage", "�÷�", "ũ��", "���߰�", "����ũ��", "��", "�Ѿ�" };

	Object rowData[][];

	DefaultTableModel model; // table�� ���̸� ����
	
	List<OrderDTO> list = new ArrayList<OrderDTO>();

	public OrderDetail(List<OrderDTO> list) {
		super("�߰�Ȯ��");
		contain.setLayout(null);
		this.list = list;

		JLabel label = new JLabel("�߰�Ȯ��");
		label.setBounds(10, 10, 120, 15);
		contain.add(label);

		// dao�� ���ؼ� list�� ���

		// Jtable row�� ����
		rowData = new Object[list.size()][7];

		// list���� ���̺�� �����͸� �����ϱ� ���� ó��
		for (int i = 0; i < list.size(); i++) {
			rowData[i][0] = list.get(i).getBeverage(); // ���� ��ȣ
			rowData[i][1] = list.get(i).getSyrup(); // ���� ����
			rowData[i][2] = list.get(i).getCupSize(); // �ۼ���
			rowData[i][3] = list.get(i).getAddShot();
			rowData[i][4] = list.get(i).getAddCream();
			rowData[i][5] = list.get(i).getCup();
			rowData[i][6] = list.get(i).getPrice();
		}

		// ���̺� ����
		// ���̺� ���� �����ϱ� ���� Model
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setDataVector(rowData, columnNames);

		// ���̺� ����
		jtable = new JTable(model);

		// column�� ���� ����
		jtable.getColumnModel().getColumn(0).setMaxWidth(300);
		jtable.getColumnModel().getColumn(1).setMaxWidth(70);
		jtable.getColumnModel().getColumn(2).setMaxWidth(70);
		jtable.getColumnModel().getColumn(3).setMaxWidth(70);
		jtable.getColumnModel().getColumn(4).setMaxWidth(100);
		jtable.getColumnModel().getColumn(5).setMaxWidth(70);
		jtable.getColumnModel().getColumn(6).setMaxWidth(70);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		contain.add(jscrPane);

		writeBtn = new JButton("�߰��ֹ�");
		writeBtn.setBounds(510, 10, 100, 20);
		writeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(list.size() == 0) {
					new OrderMain();
					dispose();
				}
				else {
					new OrderMain(list);
					dispose();
				}
			}
		});

		logout = new JButton("�ֹ��Ϸ�");
		logout.setLocation(50, 370);
		logout.setSize(100, 50);
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton.getInstance().ordCtrl.orderInsert(list);
				new FinalView();
				dispose();
			}
		});
		
		delete = new JButton("���� �ֹ����");
		delete.setLocation(300, 370);
		delete.setSize(150, 50);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtable.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "�������ּ���.");
				}
				else {
					list.remove(jtable.getSelectedRow());
					new OrderDetail(list);
					dispose();
				}
			}
		});
		
		contain.add(delete);
		
		contain.add(writeBtn);
		contain.add(logout);

		setSize(640, 480);
		setLocation(200, 200);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
