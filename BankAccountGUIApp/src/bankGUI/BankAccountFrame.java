package bankGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BankAccountFrame extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton goToSummaryButton;
	private JButton withdrawButton;
	private JButton depositButton;
	private JLabel balanceField;
	
	public BankAccountFrame() {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints layoutConst = null;
		
		// create buttons and text labels
		goToSummaryButton = new JButton("Account Summary");
		goToSummaryButton.addActionListener(this);
		
		balanceField = new JLabel("Welcome!");
		
		// add components to panel using grid bag layout
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.CENTER;
		panel.add(balanceField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		goToSummaryButton.setHorizontalTextPosition(JButton.CENTER);
		panel.add(goToSummaryButton, layoutConst);
		
		add(panel);
	}

	public void actionPerformed(ActionEvent event) {
		JButton sourceEvent = (JButton)event.getSource();
		
		if (sourceEvent == goToSummaryButton) {
			GridBagConstraints layoutConst = null;
			
			balanceField.setText("");
			balanceField.setText("$300");
			
			panel.remove(goToSummaryButton);
			
			withdrawButton = new JButton("Withdraw");
			withdrawButton.setHorizontalTextPosition(JButton.CENTER);
			withdrawButton.addActionListener(this);
			
			depositButton = new JButton("Deposit");
			depositButton.setHorizontalTextPosition(JButton.CENTER);
			depositButton.addActionListener(this);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
			panel.add(withdrawButton, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.gridx = 1;
			layoutConst.gridy = 1;
			panel.add(depositButton, layoutConst);
			
		}
		
	}
	
	public static void main(String[] args) {
		BankAccountFrame frame = new BankAccountFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
