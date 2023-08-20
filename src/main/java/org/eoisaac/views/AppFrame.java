package org.eoisaac.views;

import org.eoisaac.controllers.CategoryController;
import org.eoisaac.controllers.TransactionController;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionSummary;
import org.eoisaac.model.entities.TransactionType;
import org.eoisaac.utils.CurrencyUtils;
import org.eoisaac.utils.DateUtils;
import org.eoisaac.utils.TransactionUtils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author saulo.cabral
 */
public class AppFrame extends JFrame {
  private final CategoryController categoryController;
  private final TransactionController transactionController;

  // Variables declaration - do not modify//GEN-BEGIN:variables

  private List<TransactionEntity> transactions;
  private TransactionSummary transactionSummary;
  private boolean hasTransactions = false;

  private JButton createTransactionButton;
  private JComboBox<String> transactionCategoryComboBox;
  private JFormattedTextField transactionEntryDateField;
  private JButton deleteTransactionButton;
  private JLabel totalBalance;
  private JTable transactionsTable;

  private JRadioButton transactionTypeIncomeRadioButton;
  private JRadioButton transactionTypeExpenseRadioButton;
  private JLabel totalExpense;
  private JLabel transactionNameLabel;
  private JLabel transactionCategoryLabel;
  private JLabel transactionPriceLabel;
  private JLabel transactionEntryDateLabel;
  private JLabel totalIncomeLabel;
  private JLabel frameTitle;
  private JLabel totalExpenseLabel;
  private JLabel totalBalanceLabel;
  private JPanel mainPanel;
  private JPanel transactionFormPanel;
  private JScrollPane transactionsTablePanel;
  private JSeparator jSeparator1;
  private JTextField transactionNameField;
  private JLabel totalIncome;
  private JTextField transactionPriceField;
  /** Creates new form AppFrame */
  public AppFrame() {
    transactionController = new TransactionController();
    categoryController = new CategoryController();

    createUIComponents();

    updateTransactionsData();
  }

  // End of variables declaration//GEN-END:variables

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(AppFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new AppFrame().setVisible(true);
          }
        });
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void createUIComponents() {

    mainPanel = new JPanel();
    transactionFormPanel = new JPanel();

    frameTitle = new JLabel();

    transactionNameLabel = new JLabel();
    transactionNameField = new JTextField();

    transactionCategoryLabel = new JLabel();
    transactionCategoryComboBox = new JComboBox<>();

    transactionPriceLabel = new JLabel();
    transactionPriceField = new JTextField();

    transactionEntryDateLabel = new JLabel();
    transactionEntryDateField = new JFormattedTextField();

    transactionTypeIncomeRadioButton = new JRadioButton();
    transactionTypeExpenseRadioButton = new JRadioButton();

    createTransactionButton = new JButton();

    jSeparator1 = new JSeparator();
    transactionsTablePanel = new JScrollPane();
    transactionsTable = new JTable();

    deleteTransactionButton = new JButton();
    totalIncomeLabel = new JLabel();
    totalIncome = new JLabel();

    totalExpenseLabel = new JLabel();
    totalExpense = new JLabel();

    totalBalanceLabel = new JLabel();
    totalBalance = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    mainPanel.setBackground(new Color(255, 255, 255));

    transactionFormPanel.setBackground(new Color(204, 204, 255));
    transactionFormPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    // Transaction Name
    transactionNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
    transactionNameLabel.setText("Nome");

    transactionNameField.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

    // Transaction Category
    transactionCategoryLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
    transactionCategoryLabel.setText("Classificação");

    // Transaction Value
    transactionCategoryComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
    transactionCategoryComboBox.setModel(new DefaultComboBoxModel<>());
    transactionCategoryComboBox.setEditable(true);

    // Transaction Price
    transactionPriceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
    transactionPriceLabel.setText("Valor");

    transactionPriceField.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

    // Transaction Entry Date
    transactionEntryDateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
    transactionEntryDateLabel.setText("Data");

    try {
      MaskFormatter mask = new MaskFormatter("##/##/####");
      mask.install(transactionEntryDateField);
    } catch (Exception e) {
      System.out.println("Error formatting date field mask");
      e.printStackTrace();
    }
    transactionEntryDateField.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // NOI18N

    // Transaction Type
    transactionTypeIncomeRadioButton.setBackground(new Color(204, 204, 255));
    transactionTypeIncomeRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
    transactionTypeIncomeRadioButton.setText("Ganho (+)");

    transactionTypeExpenseRadioButton.setBackground(new Color(204, 204, 255));
    transactionTypeExpenseRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
    transactionTypeExpenseRadioButton.setText("Gasto (-)");

    ButtonGroup transactionTypesGroup = new ButtonGroup();
    transactionTypesGroup.add(transactionTypeIncomeRadioButton);
    transactionTypesGroup.add(transactionTypeExpenseRadioButton);
    transactionTypesGroup.setSelected(transactionTypeIncomeRadioButton.getModel(), true);

    //    transactionTypeIncomeRadioButton.addActionListener(this::handleTransactionTypeSelection);
    //    transactionTypeExpenseRadioButton.addActionListener(this::handleTransactionTypeSelection);

    // Create Transaction Button
    createTransactionButton.setFont(new Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
    createTransactionButton.setText("CADASTRAR");

    createTransactionButton.addActionListener(this::handleNewTransactionFormSubmit);

    GroupLayout transactionFormGroupLayout = new GroupLayout(transactionFormPanel);
    transactionFormPanel.setLayout(transactionFormGroupLayout);
    transactionFormGroupLayout.setHorizontalGroup(
        transactionFormGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormGroupLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        transactionFormGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(transactionNameField)
                            .addComponent(transactionCategoryComboBox)
                            .addComponent(transactionPriceField)
                            .addGroup(
                                transactionFormGroupLayout
                                    .createSequentialGroup()
                                    .addGroup(
                                        transactionFormGroupLayout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(transactionNameLabel)
                                            .addComponent(transactionCategoryLabel)
                                            .addComponent(transactionPriceLabel)
                                            .addComponent(transactionEntryDateLabel)
                                            .addComponent(
                                                transactionEntryDateField,
                                                GroupLayout.PREFERRED_SIZE,
                                                137,
                                                GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                transactionFormGroupLayout
                                    .createSequentialGroup()
                                    .addComponent(transactionTypeIncomeRadioButton)
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        transactionTypeExpenseRadioButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        151,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)))
                    .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                transactionFormGroupLayout
                    .createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(
                        createTransactionButton,
                        GroupLayout.PREFERRED_SIZE,
                        252,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(69, 69, 69)));
    transactionFormGroupLayout.setVerticalGroup(
        transactionFormGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionFormGroupLayout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(transactionNameLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionNameField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionCategoryLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionCategoryComboBox,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionPriceLabel)
                    .addGap(6, 6, 6)
                    .addComponent(
                        transactionPriceField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(transactionEntryDateLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        transactionEntryDateField,
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(
                        jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addGroup(
                        transactionFormGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(transactionTypeIncomeRadioButton)
                            .addComponent(transactionTypeExpenseRadioButton))
                    .addGap(39, 39, 39)
                    .addComponent(createTransactionButton)
                    .addContainerGap(73, Short.MAX_VALUE)));

    // Transactions Table
    transactionsTable.setBorder(BorderFactory.createEtchedBorder());
    transactionsTable.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    transactionsTable.setModel(
        new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Tipo", "Nome", "Classificação", "valor", "Data", "Cadastro"}));
    transactionsTablePanel.setViewportView(transactionsTable);

    transactionsTable.addMouseListener(
        new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            handleSelectedTransaction(evt);
          }
        });

    // Delete Transaction Button
    deleteTransactionButton.setText("DEL");

    totalIncomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalIncomeLabel.setText("Recebido:");

    totalIncome.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalIncome.setText("0.00");

    totalExpenseLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalExpenseLabel.setText("Gastos:");

    totalExpense.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalExpense.setText("0.00");

    totalBalanceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalBalanceLabel.setText("Diferença:");

    totalBalance.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // NOI18N
    totalBalance.setText("0.00");

    frameTitle.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
    frameTitle.setText("Finanças Anual Seu José");
    createTransactionButton.addActionListener(this::handleNewTransactionFormSubmit);

    GroupLayout transactionsTableGroupLayout = new GroupLayout(mainPanel);
    mainPanel.setLayout(transactionsTableGroupLayout);
    transactionsTableGroupLayout.setHorizontalGroup(
        transactionsTableGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                transactionsTableGroupLayout
                    .createSequentialGroup()
                    .addGroup(
                        transactionsTableGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                transactionsTableGroupLayout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(
                                        transactionFormPanel,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(
                                        transactionsTableGroupLayout
                                            .createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(
                                                transactionsTableGroupLayout
                                                    .createSequentialGroup()
                                                    .addComponent(totalIncomeLabel)
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(totalIncome)
                                                    .addGap(64, 64, 64)
                                                    .addComponent(totalExpenseLabel)
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(totalExpense)
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                    .addComponent(totalBalanceLabel)
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(totalBalance)
                                                    .addGap(24, 24, 24)
                                                    .addComponent(deleteTransactionButton))
                                            .addComponent(
                                                transactionsTablePanel,
                                                GroupLayout.PREFERRED_SIZE,
                                                592,
                                                GroupLayout.PREFERRED_SIZE)))
                            .addGroup(
                                transactionsTableGroupLayout
                                    .createSequentialGroup()
                                    .addGap(363, 363, 363)
                                    .addComponent(frameTitle)))
                    .addContainerGap(16, Short.MAX_VALUE)));
    transactionsTableGroupLayout.setVerticalGroup(
        transactionsTableGroupLayout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                GroupLayout.Alignment.TRAILING,
                transactionsTableGroupLayout
                    .createSequentialGroup()
                    .addComponent(frameTitle)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addGroup(
                        transactionsTableGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(transactionsTablePanel)
                            .addComponent(
                                transactionFormPanel,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        transactionsTableGroupLayout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteTransactionButton)
                            .addComponent(totalIncomeLabel)
                            .addComponent(totalIncome)
                            .addComponent(totalExpenseLabel)
                            .addComponent(totalExpense)
                            .addComponent(totalBalanceLabel)
                            .addComponent(totalBalance))
                    .addContainerGap()));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(
                mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void resetFormFields() {
    transactionNameField.setText("");
    transactionPriceField.setText("");
    transactionEntryDateField.setText("");
    transactionCategoryComboBox.setSelectedIndex(0);
  }

  private void deleteTransaction(UUID transactionId) {
    transactionController.deleteTransaction(transactionId);
    updateTransactionsData();
  }

  private void updateTransactionsData() {
    transactions = transactionController.getAllTransactions(); // or use local variable as cache

    hasTransactions = !transactions.isEmpty();

    renderTransactionsTable();
    renderCategoriesComboBox();
    renderTransactionsSummary();
  }

  private void handleNewTransactionFormSubmit(ActionEvent evt) {
    String transactionName = transactionNameField.getText();
    String transactionValue = transactionPriceField.getText();
    String entryDate = transactionEntryDateField.getText();
    String selectedCategory = (String) transactionCategoryComboBox.getSelectedItem();
    boolean isIncome = transactionTypeIncomeRadioButton.isSelected();
    TransactionType transactionType = isIncome ? TransactionType.INCOME : TransactionType.EXPENSE;
    Instant entryDateInstant = DateUtils.convertStringToInstant(entryDate);
    float transactionValueFloat = Float.parseFloat(transactionValue);

    Optional<CategoryEntity> category = categoryController.createCategory(selectedCategory);

    if (category.isEmpty()) {
      System.out.println("Category not created");
      return;
    }

    Optional<TransactionEntity> createdTransaction =
        transactionController.createTransaction(
            transactionName,
            transactionType,
            transactionValueFloat,
            entryDateInstant,
            category.get());

    if (createdTransaction.isEmpty()) {
      System.out.println("Transaction not created");
      return;
    }

    transactions.add(createdTransaction.get());
    updateTransactionsData();
    resetFormFields();
  }

  public void handleSelectedTransaction(MouseEvent evt) {
    int selectedRow = transactionsTable.getSelectedRow();
    DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
    UUID selectedTransactionId = (UUID) tableModel.getValueAt(selectedRow, 0);

    deleteTransaction(selectedTransactionId);
  }

  public void renderTransactionsSummary() {
    transactionSummary = TransactionUtils.calculateTransactionSummary(transactions);
    totalIncome.setText(CurrencyUtils.formatCurrency(transactionSummary.getTotalIncome()));
    totalExpense.setText(CurrencyUtils.formatCurrency(transactionSummary.getTotalExpense()));
    totalBalance.setText(CurrencyUtils.formatCurrency(transactionSummary.getTotalBalance()));
  }

  private void renderTransactionsTable() {
    DefaultTableModel tableModel = (DefaultTableModel) transactionsTable.getModel();
    tableModel.setRowCount(0);

    List<String> hiddenColumnIndexes = List.of("ID", "Tipo");
    transactionsTable.setDefaultRenderer(
        Object.class, new TransactionTableRowRenderer(hiddenColumnIndexes));

    transactions.forEach(
        transaction -> {
          tableModel.addRow(
              new Object[] {
                transaction.getId(),
                transaction.getType(),
                transaction.getName(),
                transaction.getCategory().getName(),
                CurrencyUtils.formatCurrency(transaction.getValue()),
                DateUtils.convertInstantToString(transaction.getEntryDate()),
                DateUtils.convertInstantToString(transaction.getCreatedAt()),
              });
        });
  }

  private void renderCategoriesComboBox() {
    DefaultComboBoxModel<String> comboBoxModel =
        (DefaultComboBoxModel<String>) transactionCategoryComboBox.getModel();
    comboBoxModel.removeAllElements();
    categoryController
        .getAllCategories()
        .forEach(
            category -> {
              comboBoxModel.addElement(category.getName());
            });
  }
}
