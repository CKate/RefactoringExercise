import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pochi_000 on 01/03/2017.
 */
public abstract class AbstractSearchDialog extends JDialog implements ActionListener{
    EmployeeDetails parent;
    JButton search, cancel;
    JTextField searchField;
    private String searchBy, enterSearchLabel;
    private SearchNavPanelBuilder searchNavPanelBuilder;

    public AbstractSearchDialog(EmployeeDetails parent, SearchNavPanelBuilder searchNavPanelBuilder, String searchBy, String enterSearchLabel, String titleDialog)
    {
        setModal(true);
        this.parent = parent;
        this.searchNavPanelBuilder = searchNavPanelBuilder;
        this.searchBy = searchBy;
        this.enterSearchLabel = enterSearchLabel;
        this.setTitle(titleDialog);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(searchPane());
        setContentPane(scrollPane);

        getRootPane().setDefaultButton(search);

        setSize(500, 190);
        setLocation(350, 250);
        setVisible(true);
    }

    public Container searchPane()
    {
        JPanel searchPanel = new JPanel(new GridLayout(3,1));
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel searchLabel;

        searchPanel.add(new JLabel(searchBy));

        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.add(searchLabel = new JLabel(enterSearchLabel));
        searchLabel.setFont(this.parent.font1);
        textPanel.add(searchField = new JTextField(20));
        searchField.setFont(this.parent.font1);
        searchField.setDocument(new JTextFieldLimit(20));

        buttonPanel.add(search = new JButton("Search"));
        search.addActionListener(this);
        search.requestFocus();

        buttonPanel.add(cancel = new JButton("Cancel"));
        cancel.addActionListener(this);

        searchPanel.add(textPanel);
        searchPanel.add(buttonPanel);

        return searchPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public EmployeeDetails getParent() {
        return parent;
    }

    public JButton getSearch() {
        return search;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public SearchNavPanelBuilder getSearchNavPanelBuilder() {
        return searchNavPanelBuilder;
    }

}
