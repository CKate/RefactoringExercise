/*
 * 
 * This is a dialog for searching Employees by their surname.
 * 
 * */

import java.awt.Container;
import java.awt.event.ActionEvent;

public class SearchBySurnameDialog extends AbstractSearchDialog{

	public SearchBySurnameDialog(EmployeeDetails parent, SearchNavPanelBuilder searchNavPanelBuilder) {
		super(parent, searchNavPanelBuilder, "Search by Surname", "Enter Surname:", "Search by Surname");
	}
	
	public Container searchPane() {
		return super.searchPane();
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.getSearch()){
			this.getSearchNavPanelBuilder().getSearchByIdField().setText(this.getSearchField().getText());
			this.parent.searchEmployeeBySurname(this.getSearchField().getText());
			dispose();
		}
		else if(e.getSource() == this.getCancel())
			dispose();
	}
}
