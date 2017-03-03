import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pochi_000 on 02/03/2017.
 */
public class SearchNavPanelBuilder implements ActionListener{

    private JPanel searchPanel, navigPanel;
    private JTextField searchByIdField, searchBySurnameField;
    private JButton first, previous, next, last, searchId, searchSurname;
    private JButton add, deleteButton, edit, displayAll;
    private EmployeeDetails parent;

    public SearchNavPanelBuilder(EmployeeDetails employeeDetails) {
        this.parent = employeeDetails;
        this.searchByIdField = new JTextField(20);
        this.searchBySurnameField = new JTextField(20);
    }

    public JPanel searchPanel()
    {
        searchPanel = new JPanel(new MigLayout());

        String dimensions = "width 200:200:200, growx, pushx";
        String growPush = "growx, pushx";
        String searchDimensions = "width 35:35:35, height 20:20:20, growx, pushx, wrap";

        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchPanel.add(new JLabel("Search by ID:"), growPush);
        searchPanel.add(searchByIdField, dimensions);
        searchByIdField.addActionListener(this);
        searchByIdField.setDocument(new JTextFieldLimit(20));
        searchPanel.add(searchId = new JButton(new ImageIcon(
                        new ImageIcon("imgres.png").getImage().getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH))),
                searchDimensions);
        searchId.addActionListener(this);
        searchId.setToolTipText("Search Employee By ID");

        searchPanel.add(new JLabel("Search by Surname:"), growPush);
        searchPanel.add(searchBySurnameField, dimensions);
        searchBySurnameField.addActionListener(this);
        searchBySurnameField.setDocument(new JTextFieldLimit(20));
        searchPanel.add(
                searchSurname = new JButton(new ImageIcon(new ImageIcon("imgres.png").getImage()
                        .getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH))),
                searchDimensions);
        searchSurname.addActionListener(this);
        searchSurname.setToolTipText("Search Employee By Surname");

        return searchPanel;
    }

    public JPanel navigPanel() {
        navigPanel = new JPanel();

        navigPanel.setBorder(BorderFactory.createTitledBorder("Navigate"));
        navigPanel.add(first = new JButton(new ImageIcon(
                new ImageIcon("first.png").getImage().getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH))));
        first.setPreferredSize(new Dimension(17, 17));
        first.addActionListener(this);
        first.setToolTipText("Display first Record");

        navigPanel.add(previous = new JButton(new ImageIcon(new ImageIcon("previous.png").getImage()
                .getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH))));
        previous.setPreferredSize(new Dimension(17, 17));
        previous.addActionListener(this);
        previous.setToolTipText("Display previous Record");

        navigPanel.add(next = new JButton(new ImageIcon(
                new ImageIcon("next.png").getImage().getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH))));
        next.setPreferredSize(new Dimension(17, 17));
        next.addActionListener(this);
        next.setToolTipText("Display next Record");

        navigPanel.add(last = new JButton(new ImageIcon(
                new ImageIcon("last.png").getImage().getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH))));
        last.setPreferredSize(new Dimension(17, 17));
        last.addActionListener(this);
        last.setToolTipText("Display last Record");

        return navigPanel;
    }// end naviPanel

    public JPanel buttonPanel() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(add = new JButton("Add Record"), "growx, pushx");
        add.addActionListener(this);
        add.setToolTipText("Add new Employee Record");
        buttonPanel.add(edit = new JButton("Edit Record"), "growx, pushx");
        edit.addActionListener(this);
        edit.setToolTipText("Edit current Employee");
        buttonPanel.add(deleteButton = new JButton("Delete Record"), "growx, pushx, wrap");
        deleteButton.addActionListener(this);
        deleteButton.setToolTipText("Delete current Employee");
        buttonPanel.add(displayAll = new JButton("List all Records"), "growx, pushx");
        displayAll.addActionListener(this);
        displayAll.setToolTipText("List all Registered Employees");

        return buttonPanel;
    }

    //adding actions to the search bar, navigation bar and button panel.
    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == searchId || e.getSource() == searchByIdField)
                this.parent.searchEmployeeById(this.getSearchByIdField().getText());
            else if(e.getSource() == searchSurname || e.getSource() == searchBySurnameField)
                this.parent.searchEmployeeBySurname(this.getSearchBySurnameField().getText());
            else if(e.getSource() == first)
                this.parent.firstRecord();
            else if(e.getSource() == previous)
                this.parent.previousRecord();
            else if(e.getSource() == next)
                this.parent.nextRecord();
            else if(e.getSource() == last)
                this.parent.lastRecord();
            else if(e.getSource() == add)
                new AddRecordDialog(this.parent);
            else if(e.getSource() == edit)
                this.parent.editDetails();
            else if(e.getSource() == deleteButton)
                this.parent.deleteRecord();
            else if(e.getSource() == displayAll)
                this.parent.displayEmployeeSummaryDialog();
    }

    public JTextField getSearchByIdField() {
        return searchByIdField;
    }

    public JTextField getSearchBySurnameField() {
        return searchBySurnameField;
    }

    public JButton getSearchId() {
        return searchId;
    }

    public JButton getSearchSurname() {
        return searchSurname;
    }

}
