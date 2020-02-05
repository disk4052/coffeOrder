package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.OrderDTO;
import singleton.Singleton;

public class FinalView extends JFrame{
	Container contain = getContentPane();

	private JTable jtable;
	private JScrollPane jscrPane;

	private JButton logout;

	String columnNames[] = { "Espresso Beverage", "�ֹ���¥", "��ũ��", "�ܼ�", "�ݾ�"};

	Object rowData[][];

	DefaultTableModel model; // table�� ���̸� ����
	
	List<OrderDTO> list = null;

	public FinalView() {
		super("�ֹ�����");
		contain.setLayout(null);

		JLabel label = new JLabel("�ֹ�����");
		label.setBounds(10, 10, 120, 15);
		contain.add(label);

		// dao�� ���ؼ� list�� ���
		list = Singleton.getInstance().ordCtrl.getOrderList(Singleton.getInstance().getLoginID());

		// Jtable row�� ����
		rowData = new Object[list.size()][7];

		// list���� ���̺�� �����͸� �����ϱ� ���� ó��
		for (int i = 0; i < list.size(); i++) {
			rowData[i][0] = list.get(i).getBeverage(); // ���� ��ȣ
			rowData[i][1] = list.get(i).getWdate(); // ���� ����
			rowData[i][2] = list.get(i).getCupSize(); // �ۼ���
			rowData[i][3] = list.get(i).getCup();
			rowData[i][4] = list.get(i).getPrice();
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
		jtable.getColumnModel().getColumn(1).setMaxWidth(150);
		jtable.getColumnModel().getColumn(2).setMaxWidth(70);
		jtable.getColumnModel().getColumn(3).setMaxWidth(70);
		jtable.getColumnModel().getColumn(4).setMaxWidth(70);

		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		contain.add(jscrPane);

		logout = new JButton("����ȭ������");
		logout.setLocation(50, 370);
		logout.setSize(150, 50);
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderMain();
				dispose();
			}
		});
		
		contain.add(logout);
		
		setSize(640, 480);
		setLocation(200, 200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
