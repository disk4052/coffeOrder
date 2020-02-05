package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dto.OrderDTO;
import singleton.Singleton;

public class OrderMain extends JFrame {
	
	Container contain = getContentPane();

	JPanel main, size, syrup, etc;
	JButton order, price, orderShow, logout;
	JLabel cup, sizeLabel, syrupLabel, etcLabel;
	JTextField cupTf;

	JRadioButton sizeS, sizeT, sizeG, v, c, h, n;
	JCheckBox shot, cream;

	ButtonGroup sizeGroup, syrupGroup;

	JComboBox<String> combo;
	String combo_list[] = { "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카페 라떼", "카푸치노",
			"아메리카노", "오늘의 커피" };

	List<OrderDTO> list = new ArrayList<OrderDTO>();

	public OrderMain() {
		super("메인화면");

		contain.setLayout(null);

		main = new JPanel();
		size = new JPanel();
		syrup = new JPanel();
		etc = new JPanel();

		main.setLayout(null);
		main.setSize(600, 600);
		main.setLocation(50, 0);

		size.setLayout(null);
		size.setSize(100, 150);
		size.setLocation(20, 180);

		syrup.setLayout(null);
		syrup.setSize(100, 170);
		syrup.setLocation(190, 180);

		etc.setLayout(null);
		etc.setSize(120, 150);
		etc.setLocation(360, 180);

		logout = new JButton("로그아웃");
		logout.setSize(100, 20);
		logout.setLocation(10, 30);
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Viewer();
				dispose();
			}
		});
		
		main.add(logout);
		
		order = new JButton("주문하기");
		order.setSize(100, 30);
		order.setLocation(250, 450);
		order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if ((!((String) (combo.getSelectedItem())).equals(null))
						&& !(Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup).equals("선택안함"))
						&& !(cupTf.getText().equals("0"))) {
					String select = (String) combo.getSelectedItem();
					list.add(
							new OrderDTO(0,
										  select,
										  Singleton.getInstance().ordCtrl.buttonCheck(syrupGroup),
										  Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup),
										  Singleton.getInstance().ordCtrl.checkBox(shot),
										  Singleton.getInstance().ordCtrl.checkBox(cream),
										  Integer.parseInt(cupTf.getText()),
										  (Singleton.getInstance().ordCtrl.priceSearch(select, Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup))) *
										   Integer.parseInt(cupTf.getText()),
										  "",
										  Singleton.getInstance().getLoginID()));
					new OrderDetail(list);
					dispose();
				} else {
					JOptionPane.showMessageDialog(main, "항목을 채워주세요.");
				}
			}
		});
		
		orderShow = new JButton("주문내역");
		orderShow.setSize(100, 30);
		orderShow.setLocation(370, 450);
		orderShow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FinalView();
				dispose();
			}
		});
		
		main.add(orderShow);

		price = new JButton("메뉴보기");
		price.setSize(100, 20);
		price.setLocation(400, 30);
		price.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton.getInstance().priCtrl.getList();
			}
		});

		cup = new JLabel("잔");
		cup.setSize(100, 30);
		cup.setLocation(200, 450);

		sizeLabel = new JLabel("크기");
		sizeLabel.setLocation(0, 0);
		sizeLabel.setSize(30, 30);
		size.add(sizeLabel);

		syrupLabel = new JLabel("시럽");
		syrupLabel.setLocation(0, 0);
		syrupLabel.setSize(30, 30);
		syrup.add(syrupLabel);

		etcLabel = new JLabel("기타");
		etcLabel.setLocation(0, 0);
		etcLabel.setSize(30, 30);
		etc.add(etcLabel);

		cupTf = new JTextField("0");
		cupTf.setSize(50, 30);
		cupTf.setLocation(150, 450);

		sizeS = new JRadioButton("Short");
		sizeS.setLocation(0, 30);
		sizeS.setSize(100, 30);

		sizeT = new JRadioButton("Tall");
		sizeT.setLocation(0, 60);
		sizeT.setSize(100, 30);

		sizeG = new JRadioButton("Grande");
		sizeG.setLocation(0, 90);
		sizeG.setSize(100, 30);

		sizeGroup = new ButtonGroup();

		size.add(sizeS);
		size.add(sizeT);
		size.add(sizeG);

		sizeGroup.add(sizeG);
		sizeGroup.add(sizeS);
		sizeGroup.add(sizeT);

		v = new JRadioButton("바닐라");
		v.setLocation(0, 30);
		v.setSize(100, 30);

		c = new JRadioButton("캬라멜");
		c.setLocation(0, 60);
		c.setSize(100, 30);

		h = new JRadioButton("헤이즐넛");
		h.setLocation(0, 90);
		h.setSize(100, 30);

		n = new JRadioButton("선택안함");
		n.setLocation(0, 120);
		n.setSize(100, 30);

		syrupGroup = new ButtonGroup();

		syrup.add(v);
		syrup.add(c);
		syrup.add(h);
		syrup.add(n);

		syrupGroup.add(v);
		syrupGroup.add(c);
		syrupGroup.add(h);
		syrupGroup.add(n);

		shot = new JCheckBox("샷 추가");
		shot.setLocation(0, 30);
		shot.setSize(100, 30);

		cream = new JCheckBox("휘핑크림 추가");
		cream.setLocation(0, 60);
		cream.setSize(120, 30);

		etc.add(shot);
		etc.add(cream);

		combo = new JComboBox<String>(combo_list);
		combo.setLocation(100, 100);
		combo.setSize(300, 30);

		main.add(combo);
		main.add(order);
		main.add(cup);
		main.add(cupTf);
		main.add(price);
		main.add(etc);
		main.add(syrup);
		main.add(size);

		contain.add(main);

		setSize(600, 600);
		setLocation(200, 200);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public OrderMain(List<OrderDTO> list) {
		super("메인화면");
		this.list = list;

		contain.setLayout(null);

		main = new JPanel();
		size = new JPanel();
		syrup = new JPanel();
		etc = new JPanel();

		main.setLayout(null);
		main.setSize(600, 600);
		main.setLocation(50, 0);

		size.setLayout(null);
		size.setSize(100, 150);
		size.setLocation(20, 180);

		syrup.setLayout(null);
		syrup.setSize(100, 170);
		syrup.setLocation(190, 180);

		etc.setLayout(null);
		etc.setSize(120, 150);
		etc.setLocation(360, 180);
		
		logout = new JButton("로그아웃");
		logout.setSize(100, 20);
		logout.setLocation(10, 30);
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Viewer();
				dispose();
			}
		});
		
		main.add(logout);

		order = new JButton("주문하기");
		order.setSize(100, 30);
		order.setLocation(250, 450);
		order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if ((!((String) (combo.getSelectedItem())).equals(null))
						&& !(Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup).equals("선택안함"))
						&& !(cupTf.getText().equals("0"))) {
					String select = (String) combo.getSelectedItem();
					list.add(new OrderDTO(0,
										  select,
										  Singleton.getInstance().ordCtrl.buttonCheck(syrupGroup),
										  Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup),
										  Singleton.getInstance().ordCtrl.checkBox(shot),
										  Singleton.getInstance().ordCtrl.checkBox(cream),
										  Integer.parseInt(cupTf.getText()),
										  (Singleton.getInstance().ordCtrl.priceSearch(select, Singleton.getInstance().ordCtrl.buttonCheck(sizeGroup))) *
										   Integer.parseInt(cupTf.getText()),
										  "",
										  Singleton.getInstance().getLoginID()));
					new OrderDetail(list);
					dispose();
				} else {
					JOptionPane.showMessageDialog(main, "항목을 채워주세요.");
				}
			}
		});
		
		orderShow = new JButton("중간내역");
		orderShow.setSize(100, 30);
		orderShow.setLocation(370, 450);
		orderShow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderDetail(list);
				dispose();
			}
		});
		
		main.add(orderShow);

		price = new JButton("메뉴보기");
		price.setSize(100, 20);
		price.setLocation(400, 30);
		price.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton.getInstance().priCtrl.getList();
			}
		});

		cup = new JLabel("잔");
		cup.setSize(100, 30);
		cup.setLocation(200, 450);

		sizeLabel = new JLabel("크기");
		sizeLabel.setLocation(0, 0);
		sizeLabel.setSize(30, 30);
		size.add(sizeLabel);

		syrupLabel = new JLabel("시럽");
		syrupLabel.setLocation(0, 0);
		syrupLabel.setSize(30, 30);
		syrup.add(syrupLabel);

		etcLabel = new JLabel("기타");
		etcLabel.setLocation(0, 0);
		etcLabel.setSize(30, 30);
		etc.add(etcLabel);

		cupTf = new JTextField("0");
		cupTf.setSize(50, 30);
		cupTf.setLocation(150, 450);

		sizeS = new JRadioButton("Short");
		sizeS.setLocation(0, 30);
		sizeS.setSize(100, 30);

		sizeT = new JRadioButton("Tall");
		sizeT.setLocation(0, 60);
		sizeT.setSize(100, 30);

		sizeG = new JRadioButton("Grande");
		sizeG.setLocation(0, 90);
		sizeG.setSize(100, 30);

		sizeGroup = new ButtonGroup();

		size.add(sizeS);
		size.add(sizeT);
		size.add(sizeG);

		sizeGroup.add(sizeG);
		sizeGroup.add(sizeS);
		sizeGroup.add(sizeT);

		v = new JRadioButton("바닐라");
		v.setLocation(0, 30);
		v.setSize(100, 30);

		c = new JRadioButton("캬라멜");
		c.setLocation(0, 60);
		c.setSize(100, 30);

		h = new JRadioButton("헤이즐넛");
		h.setLocation(0, 90);
		h.setSize(100, 30);

		n = new JRadioButton("선택안함");
		n.setLocation(0, 120);
		n.setSize(100, 30);

		syrupGroup = new ButtonGroup();

		syrup.add(v);
		syrup.add(c);
		syrup.add(h);
		syrup.add(n);

		syrupGroup.add(v);
		syrupGroup.add(c);
		syrupGroup.add(h);
		syrupGroup.add(n);

		shot = new JCheckBox("샷 추가");
		shot.setLocation(0, 30);
		shot.setSize(100, 30);

		cream = new JCheckBox("휘핑크림 추가");
		cream.setLocation(0, 60);
		cream.setSize(120, 30);

		etc.add(shot);
		etc.add(cream);

		combo = new JComboBox<String>(combo_list);
		combo.setLocation(100, 100);
		combo.setSize(300, 30);

		main.add(combo);
		main.add(order);
		main.add(cup);
		main.add(cupTf);
		main.add(price);
		main.add(etc);
		main.add(syrup);
		main.add(size);

		contain.add(main);

		setSize(600, 600);
		setLocation(200, 200);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
