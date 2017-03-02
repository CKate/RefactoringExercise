/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class SearchBySurnameDialog extends AbstractSearchDialog{

	// constructor for search by surname dialog
	public SearchBySurnameDialog(EmployeeDetails parent) {
		super(parent);
		setTitle("Search by Surname");
		this.searchBy = "Search by Surname";
		this.enterSearchLabel = "Enter Surname:";
	}// end SearchBySurnameDialog
	
	// initialize search container
	public Container searchPane() {
		return super.searchPane();
	}// end searchPane

	// action listener for save and cancel button
	public void actionPerformed(ActionEvent e) {
		// if option search, search for Employee
		if(e.getSource() == search){
			this.parent.searchBySurnameField.setText(searchField.getText());
			// search Employee by surname
			this.parent.searchEmployeeBySurname();
			dispose();// dispose dialog
		}// end if
		// else dispose dialog
		else if(e.getSource() == cancel)
			dispose();// dispose dialog
	}// end actionPerformed
}// end class SearchBySurnameDialog
