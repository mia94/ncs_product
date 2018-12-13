package ncs_product.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ncs_product.dto.Product;
import ncs_product.dto.Sale;
import ncs_product.service.ProductFrameService;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ProductUi extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfSaleCnt;
	private JTextField tfMarginRate;
	private JButton btnOutput1;
	private JButton btnOutput2;
	private JButton btnInput;
	private ProductFrameService service;


	/**
	 * Create the frame.
	 */
	public ProductUi() {
		service = new ProductFrameService();
		initComponents();
	}
	private void initComponents() {
		setTitle("입력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblCode = new JLabel("제품코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCode);
		
		tfCode = new JTextField();
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lblName = new JLabel("제품명");
		panel.add(lblName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("제품단가");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrice);
		
		tfPrice = new JTextField();
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JLabel lblSaleCnt = new JLabel("판매수량");
		lblSaleCnt.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSaleCnt);
		
		tfSaleCnt = new JTextField();
		tfSaleCnt.setColumns(10);
		panel.add(tfSaleCnt);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		
		JLabel lblMarginRate = new JLabel("마진율");
		lblMarginRate.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMarginRate);
		
		tfMarginRate = new JTextField();
		tfMarginRate.setColumns(10);
		panel.add(tfMarginRate);
		
		JLabel label_4 = new JLabel("");
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		panel_2.add(btnInput);
		
		btnOutput1 = new JButton("출력");
		btnOutput1.addActionListener(this);
		panel_2.add(btnOutput1);
		
		btnOutput2 = new JButton("출력2");
		btnOutput2.addActionListener(this);
		panel_2.add(btnOutput2);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			do_btnInput_actionPerformed(e);
		}
		if (e.getSource() == btnOutput2) {
			do_btnOutput2_actionPerformed(e);
		}
		if (e.getSource() == btnOutput1) {
			do_btnOutput1_actionPerformed(e);
		}
	}
	protected void do_btnOutput1_actionPerformed(ActionEvent e) {
		SalePriceTableUi ui = new SalePriceTableUi();
		ui.setVisible(true);
	}
	protected void do_btnOutput2_actionPerformed(ActionEvent e) {
		SalePriceTableUi ui = new SalePriceTableUi();
		ui.setVisible(false);
	}
	protected void do_btnInput_actionPerformed(ActionEvent e) {
		//입력된 데이터를 product로 받기 - 입력한 데이터 저장
				Sale sale = getSale();
				try {
					service.registerSale(sale);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println("입력 된 값 추가");
				try {
					service.selectSaleByAll();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	}
	private Sale getSale() {
		Product code = new Product(tfCode.getText().trim());
		int price = Integer.parseInt(tfPrice.getText().trim());
		int saleCnt = Integer.parseInt(tfSaleCnt.getText().trim());
		int marginRate = Integer.parseInt(tfMarginRate.getText().trim());
		
		return new Sale(0 ,code , price, saleCnt, marginRate);
	}
}
