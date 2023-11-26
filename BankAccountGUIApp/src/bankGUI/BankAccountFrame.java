package bankGUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BankAccountFrame extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton goToSummaryButton;
	private JButton withdrawButton;
	private JButton depositButton;
	private JLabel balanceField;
	private BankAccount bankAccount;
	
	public BankAccountFrame() {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints layoutConst = null;
		
		// create a new dummy BankAccount for testing GUI
		createDummyBankAccount();
		
		// create buttons and text labels
		goToSummaryButton = new JButton("Account Summary");
		goToSummaryButton.addActionListener(this);
		
		balanceField = new JLabel("Welcome " + bankAccount.getFirstName() + "!");
		
		// add components to panel using grid bag layout
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(100, 50, 100, 50);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.CENTER;
		panel.add(balanceField, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 50, 10, 50);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		goToSummaryButton.setHorizontalTextPosition(JButton.CENTER);
		panel.add(goToSummaryButton, layoutConst);
		
		add(panel);
	}
	
	// helper method to update balance on label component
	private void updateBalanceField() {
		balanceField.setText("");
		balanceField.setText("Balance: " + "$" + String.format("%1$,.2f", bankAccount.getBalance()));
	}
	
	// helper method to create a dummy bank account for testing GUI
	private void createDummyBankAccount() {
		bankAccount = new BankAccount();
		bankAccount.setFirstName("John");
		bankAccount.setLastName("Doe");
		bankAccount.setAccountID(1047364);
		bankAccount.deposit(1000.56);
	}

	// carry out action when button is clicked
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton sourceEvent = (JButton)event.getSource();
		
		// when clicking on Account Summary button
		if (sourceEvent == goToSummaryButton) {
			GridBagConstraints layoutConst = null;
			
			updateBalanceField();
			
			panel.remove(goToSummaryButton);
			
			withdrawButton = new JButton("Withdraw");
			withdrawButton.setHorizontalTextPosition(JButton.CENTER);
			withdrawButton.addActionListener(this);
			
			depositButton = new JButton("Deposit");
			depositButton.setHorizontalTextPosition(JButton.CENTER);
			depositButton.addActionListener(this);
			
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets(10, 10, 10, 10);
			layoutConst.gridx = 0;
			layoutConst.gridy = 1;
			panel.add(withdrawButton, layoutConst);
			
			layoutConst = new GridBagConstraints();
			layoutConst.insets = new Insets(10, 10, 10, 10);
			layoutConst.gridx = 1;
			layoutConst.gridy = 1;
			panel.add(depositButton, layoutConst);
			
		// when clicking on Withdraw button	
		} else if (sourceEvent == withdrawButton) {
			String amount = JOptionPane.showInputDialog("Enter amount to withdraw:");
			
			try {
				String message = bankAccount.withdraw(Double.parseDouble(amount));
				
				updateBalanceField();
				
				JOptionPane.showMessageDialog(this, message);
			} catch(NumberFormatException e) {
				// if user doesn't enter an actual number, show a message
				JOptionPane.showMessageDialog(this, "Invalid Amount!");
			}
		}
		
		// when clicking on deposit button
		else if (sourceEvent == depositButton) {
			String amount = JOptionPane.showInputDialog("Enter amount to deposit:");
			
			try {
				String message = bankAccount.deposit(Double.parseDouble(amount));
				
				updateBalanceField();
				
				JOptionPane.showMessageDialog(this, message);
			} catch(NumberFormatException e) {
				// if user doesn't enter an actual number, show a message
				JOptionPane.showMessageDialog(this, "Invalid Amount!");
			}
		}
	}
	
	
	public static void main(String[] args) {
		BankAccountFrame frame = new BankAccountFrame();
		
		frame.setTitle("Bank Account");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

}
