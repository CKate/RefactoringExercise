import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;

/**
 * Created by pochi_000 on 01/03/2017.
 */
public abstract class AbstractSearchDialog extends JDialog implements ActionListener{
    EmployeeDetails parent;
    JButton search, cancel;
    JTextField searchField;
    String searchBy, enterSearchLabel;

    public AbstractSearchDialog(EmployeeDetails parent)
    {
        setModal(true);
        this.parent = parent;
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

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public String getEnterSearchLabel() {
        return enterSearchLabel;
    }

    public void setEnterSearchLabel(String enterSearchLabel) {
        this.enterSearchLabel = enterSearchLabel;
    }
}
