package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dto.PriceDTO;

public class PriceView extends JFrame{
	
	private static PriceView priceView;
	
	public static PriceView getInstance() {
		if(priceView == null) {
			priceView = new PriceView();
		}
		return priceView;
	}
	
	private Container contain = getContentPane();
	private JLabel label;
	
	private JTable jtable;
	private JScrollPane jscrPane;
	
	
	private String columnNames[] = {
		"Beverage", "Short", "Tall", "Grande"	
	};
	
	private Object rowData[][];
	
	private DefaultTableModel model;	// table의 넓이를 설정
	
	List<PriceDTO> list = null;
	
	public void view(List<PriceDTO> list) {
		//super("메뉴판");
		contain.setLayout(null);
		
		label = new JLabel("메뉴판");
		label.setBounds(300,10,120,15);
		contain.add(label);
		
		this.list = list;
		
		// Jtable row를 생성
		rowData = new Object[list.size()][4];
		
		// list에서 테이블로 데이터를 삽입하기 위한 처리
		for(int i = 0 ; i < list.size() ; i++) {
			rowData[i][0] = list.get(i).getBeverage();
			rowData[i][1] = list.get(i).getShort_();
			rowData[i][2] = list.get(i).getTall();
			rowData[i][3] = list.get(i).getGrande();
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0){
		    public boolean isCellEditable(int row, int column) {
		      return false;
		    }
		  };
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		
		
		// column의 폭을 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(500);
		jtable.getColumnModel().getColumn(1).setMaxWidth(100);
		jtable.getColumnModel().getColumn(2).setMaxWidth(100);
		jtable.getColumnModel().getColumn(3).setMaxWidth(100);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		contain.add(jscrPane);
		
		
		setSize(640,480);
		setLocation(800,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

