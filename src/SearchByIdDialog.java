/*
 * 
 * This is the dialog for Employee search by ID
 * 
 * */

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class SearchByIdDialog extends AbstractSearchDialog {

	public SearchByIdDialog(EmployeeDetails parent, SearchNavPanelBuilder searchNavPanelBuilder) {
		super(parent, searchNavPanelBuilder,  "Search by ID", "Enter ID:", "Search by ID");
	}
	
	public Container searchPane() {
		return super.searchPane();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			try {
				Double.parseDouble(this.getSearchField().getText());
				this.getSearchNavPanelBuilder().getSearchByIdField().setText(this.getSearchField().getText());
				this.parent.searchEmployeeById(this.getSearchField().getText());
				dispose();
			}
			catch (NumberFormatException num) {
				this.getSearchField().setBackground(parent.red);
				JOptionPane.showMessageDialog(null, "Wrong ID format!");
			}
		}
		else if (e.getSource() == cancel)
			dispose();
	}
}
