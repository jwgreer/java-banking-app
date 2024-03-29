package edu.weber.cs3230.projects.finalproject;


import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class WithdrawDialog  extends javax.swing.JDialog {

    /**
     * Creates new form DepositDialog
     */
    public WithdrawDialog(java.awt.Frame parent, boolean modal, BankAccount account) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        withdrawAmountLabel = new javax.swing.JLabel();
        withdrawAmountTextField = new javax.swing.JTextField();
        withdrawOKButton = new javax.swing.JButton();
        withdrawCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        withdrawAmountLabel.setText("Withdraw Amount:");
        getContentPane().add(withdrawAmountLabel);
        getContentPane().add(withdrawAmountTextField);

        withdrawOKButton.setText("OK");
        withdrawOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawOKButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawOKButton);

        withdrawCancelButton.setText("Cancel");
        withdrawCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawCancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(withdrawCancelButton);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositCancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_depositCancelButtonActionPerformed

    private void withdrawOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositOKButtonActionPerformed
        StringBuilder warnings = new StringBuilder();

        // Verify withdrawal amount is not empty and is a positive number
        if (withdrawAmountTextField.getText().isEmpty()) {
            warnings.append("Withdraw amount is empty.\n");
        } else {
            BigDecimal amount = new BigDecimal(withdrawAmountTextField.getText());

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                warnings.append("Withdraw amount must be a positive number.\n");
            } else {
                try {
                    account.withdraw(amount);
                } catch (InsufficientFundException e) {
                    warnings.append("Insufficient funds for withdrawal.\n");
                }
            }
        }

        if (warnings.length() > 0) {

            JOptionPane.showMessageDialog(this, warnings.toString(), "Withdraw Warnings", JOptionPane.WARNING_MESSAGE);
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_depositOKButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel withdrawAmountLabel;
    private javax.swing.JTextField withdrawAmountTextField;
    private javax.swing.JButton withdrawCancelButton;
    private javax.swing.JButton withdrawOKButton;
    // End of variables declaration//GEN-END:variables

    private BankAccount account;

}