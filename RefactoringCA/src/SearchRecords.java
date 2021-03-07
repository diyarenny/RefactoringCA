import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchRecords {

	JTextField searchByIdField, searchBySurnameField;
	private JTextField idField, ppsField, surnameField, firstNameField, salaryField;

	Employee currentEmployee;
	CheckInput check = new CheckInput();
	NavigateRecords navigate;
	DisplayRecords display;

	public void searchEmployeeById() {
		boolean found = false;

		try {
			if (check.isSomeoneToDisplay()) {
				navigate.firstRecord();
				int firstId = currentEmployee.getEmployeeId();
			
				if (searchByIdField.getText().trim().equals(idField.getText().trim()))
					found = true;
				else if (searchByIdField.getText().trim().equals(Integer.toString(currentEmployee.getEmployeeId()))) {
					found = true;
					display.displayRecords(currentEmployee);
				} 
				else {
					navigate.nextRecord();
					while (firstId != currentEmployee.getEmployeeId()) {
						
						if (Integer.parseInt(searchByIdField.getText().trim()) == currentEmployee.getEmployeeId()) {
							found = true;
							display.displayRecords(currentEmployee);
							break;
						} else
							navigate.nextRecord();
					} 
				} 
				if (!found)
					JOptionPane.showMessageDialog(null, "Employee not found!");
			} 
		} 
		catch (NumberFormatException e) {
			searchByIdField.setBackground(new Color(255, 150, 150));
			JOptionPane.showMessageDialog(null, "Wrong ID format!");
		} 
		searchByIdField.setBackground(Color.WHITE);
		searchByIdField.setText("");
	}

	// search Employee by surname
	public void searchEmployeeBySurname() {
		boolean found = false;
		
		if (check.isSomeoneToDisplay()) {
			navigate.firstRecord();
			String firstSurname = currentEmployee.getSurname().trim();
		
			if (searchBySurnameField.getText().trim().equalsIgnoreCase(surnameField.getText().trim()))
				found = true;
			else if (searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
				found = true;
				display.displayRecords(currentEmployee);
			} 
			else {
				navigate.nextRecord();
				while (!firstSurname.trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
					
					if (searchBySurnameField.getText().trim().equalsIgnoreCase(currentEmployee.getSurname().trim())) {
						found = true;
						display.displayRecords(currentEmployee);
						break;
					} 
					else
						navigate.nextRecord();
				}
			} 
		
			if (!found)
				JOptionPane.showMessageDialog(null, "Employee not found!");
		} 
		searchBySurnameField.setText("");
	}
}
