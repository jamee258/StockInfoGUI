package com.info.stocks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

import com.info.domain.StockInformation;
import com.info.domain.StockServiceStub;
import com.info.service.StockService;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class StockInfo {

	private JFrame frame;
	private JTextField stockSymbolTxtFld;
	private JTextField marketCapField;
	private JTextField unitPriceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockInfo window = new StockInfo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 645, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextPane txtpnStockInformation = new JTextPane();
		txtpnStockInformation.setEditable(false);
		txtpnStockInformation.setForeground(new Color(153, 51, 204));
		txtpnStockInformation.setBackground(new Color(153, 204, 255));
		txtpnStockInformation.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 16));
		txtpnStockInformation.setText("STOCK INFORMATION");
		txtpnStockInformation.setBounds(217, 11, 187, 27);
		frame.getContentPane().add(txtpnStockInformation);

		stockSymbolTxtFld = new JTextField();
		stockSymbolTxtFld.setBounds(242, 70, 86, 27);
		frame.getContentPane().add(stockSymbolTxtFld);
		stockSymbolTxtFld.setColumns(10);

		JButton btnNewButton = new JButton(">");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 51, 204));
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Button Clicked");
				StockService stockService = new StockServiceStub();
				StockInformation si = new StockInformation(2, "Pa$$w0rd", stockSymbolTxtFld.getText(), stockService);
				unitPriceField.setText(si.getCurrentPrice().toString());
				marketCapField.setText(si.getMarketCapitalisationInMillions().toString());
			}
		});
		btnNewButton.setBounds(330, 70, 49, 27);
		frame.getContentPane().add(btnNewButton);

		marketCapField = new JTextField();
		marketCapField.setEditable(false);
		marketCapField.setColumns(10);
		marketCapField.setBounds(395, 143, 103, 20);
		frame.getContentPane().add(marketCapField);

		JLabel lblMarketCap = new JLabel("MARKET CAP.");
		lblMarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarketCap.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 12));
		lblMarketCap.setBounds(395, 123, 103, 14);
		frame.getContentPane().add(lblMarketCap);

		unitPriceField = new JTextField();
		unitPriceField.setEditable(false);
		unitPriceField.setColumns(10);
		unitPriceField.setBounds(116, 143, 103, 20);
		frame.getContentPane().add(unitPriceField);

		JLabel lblUnitPrice = new JLabel("UNIT PRICE");
		lblUnitPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnitPrice.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 12));
		lblUnitPrice.setBounds(116, 123, 103, 14);
		frame.getContentPane().add(lblUnitPrice);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Pictures\\download.jfif"));
		lblNewLabel.setBounds(154, 183, 315, 144);
		frame.getContentPane().add(lblNewLabel);
	}
}