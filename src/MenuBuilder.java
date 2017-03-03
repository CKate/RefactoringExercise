import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by pochi_000 on 02/03/2017.
 */
public class MenuBuilder extends JMenuBar implements ActionListener{

    private JMenuItem open, save, saveAs, create, modify, delete, firstItem, lastItem, nextItem, prevItem, searchById,
            searchBySurname, listAll, closeApp;

    private JMenu fileMenu, recordMenu, navigateMenu, closeMenu;
    private EmployeeDetails parent;

    public MenuBuilder(EmployeeDetails employeeDetails) {
        buildMenuBar();
        this.parent = employeeDetails;
    }

    public void buildMenuBar()
    {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        recordMenu = new JMenu("Records");
        recordMenu.setMnemonic(KeyEvent.VK_R);
        navigateMenu = new JMenu("Navigate");
        navigateMenu.setMnemonic(KeyEvent.VK_N);
        closeMenu = new JMenu("Exit");
        closeMenu.setMnemonic(KeyEvent.VK_E);

        this.add(fileMenu);
        this.add(recordMenu);
        this.add(navigateMenu);
        this.add(closeMenu);

        this.addActionToFileMenuItems();
        this.addActionToRecordMenuItems();
        this.addActionToNavigateMenuItems();
        this.addActionToCloseMenuItems();
    }

    //Method to add action listener to File Menu Items.
    public void addActionToFileMenuItems()
    {
        fileMenu.add(open = new JMenuItem("Open")).addActionListener(this);
        open.setMnemonic(KeyEvent.VK_O);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.add(save = new JMenuItem("Save")).addActionListener(this);
        save.setMnemonic(KeyEvent.VK_S);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileMenu.add(saveAs = new JMenuItem("Save As")).addActionListener(this);
        saveAs.setMnemonic(KeyEvent.VK_F2);
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
    }

    //Method to add action listener to Record Menu Items
    public void addActionToRecordMenuItems()
    {
        recordMenu.add(create = new JMenuItem("Create new Record")).addActionListener(this);
        create.setMnemonic(KeyEvent.VK_N);
        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        recordMenu.add(modify = new JMenuItem("Modify Record")).addActionListener(this);
        modify.setMnemonic(KeyEvent.VK_E);
        modify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        recordMenu.add(delete = new JMenuItem("Delete Record")).addActionListener(this);
    }

    //Method to add action listener to Navigate Menu Items
    public void addActionToNavigateMenuItems()
    {
        navigateMenu.add(firstItem = new JMenuItem("First"));
        firstItem.addActionListener(this);
        navigateMenu.add(prevItem = new JMenuItem("Previous"));
        prevItem.addActionListener(this);
        navigateMenu.add(nextItem = new JMenuItem("Next"));
        nextItem.addActionListener(this);
        navigateMenu.add(lastItem = new JMenuItem("Last"));
        lastItem.addActionListener(this);
        navigateMenu.addSeparator();
        navigateMenu.add(searchById = new JMenuItem("Search by ID")).addActionListener(this);
        navigateMenu.add(searchBySurname = new JMenuItem("Search by Surname")).addActionListener(this);
        navigateMenu.add(listAll = new JMenuItem("List all Records")).addActionListener(this);
    }

    //Method to add action listener to close menu items
    public void addActionToCloseMenuItems()
    {
        closeMenu.add(closeApp = new JMenuItem("Close")).addActionListener(this);
        closeApp.setMnemonic(KeyEvent.VK_F4);
        closeApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource() == closeApp)
           this.parent.exitApp();
       else if(e.getSource() == open)
           this.parent.openFile();
       else if (e.getSource() == save)
       {
           this.parent.saveFile();
           this.parent.setChange(false);
       }
       else if (e.getSource() == saveAs)
       {
           this.parent.saveFileAs();
           this.parent.setChange(false);
       }
       else if (e.getSource() == searchById)
           this.parent.displaySearchByIdDialog();
       else if (e.getSource() == searchBySurname)
           this.parent.displaySearchBySurnameDialog();
       else if (e.getSource() == firstItem)
           this.parent.firstRecord();
       else if (e.getSource() == prevItem)
           this.parent.previousRecord();
       else if (e.getSource() == nextItem)
            this.parent.nextRecord();
       else if (e.getSource() == lastItem)
            this.parent.lastRecord();
       else if (e.getSource() == listAll)
            this.parent.displayEmployeeSummaryDialog();
       else if (e.getSource() == create)
            new AddRecordDialog(this.parent);
       else if (e.getSource() == modify)
           this.parent.editDetails();
       else if (e.getSource() == delete)
           this.parent.deleteRecord();
    }
}
