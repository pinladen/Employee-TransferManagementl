package com.views.employee;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.entities.Department;
import com.entities.Employee;
import com.entities.EmployeeCustom;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.models.EmpDepamentModel;
import com.models.EmpLocationModel;
import com.models.EmpProjectModel;
import com.models.EmployeeModel;
import com.models.TitlesModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelChangePassword extends JPanel {
	private Map<String, Object> data;
	private Employee employee;
	private EmployeeCustom employeeCustom;
	private JPasswordField jpasswordField;
	private JButton jbuttonSave;
	/**
	 * Create the panel.
	 */
	public JPanelChangePassword() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 820, 558);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change password");
		lblNewLabel.setIcon(new ImageIcon(JPanelChangePassword.class.getResource("/resources/icons8_Password_Key_24px.png")));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setBounds(18, 11, 244, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1, 51, 822, 1);
		panel.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("New password");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel_1.setBounds(227, 202, 171, 34);
		panel.add(lblNewLabel_1);
		
		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setFont(new Font("SansSerif", Font.BOLD, 15));
		jbuttonSave.setForeground(Color.WHITE);
		jbuttonSave.setBackground(new Color(0, 139, 139));
		jbuttonSave.setBounds(226, 313, 189, 39);
		panel.add(jbuttonSave);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setBounds(226, 248, 337, 39);
		panel.add(jpasswordField);

	}
	public JPanelChangePassword(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
		
	}
	
	private void loadData() {
		try {
			EmployeeCustom employeeCustom = (EmployeeCustom) data.get("employeeCustom");
			
			if(employeeCustom != null) {
				this.employeeCustom = employeeCustom;
				this.employee = employeeCustom.getEmployee();
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		if(jpasswordField.getPassword().equals("")) {
			JOptionPane.showMessageDialog(null,"Password is not null !!" );
		}else {
			String password = String.valueOf(jpasswordField.getPassword());
			if(password.length() > 16 || password.length() < 6) {
				JOptionPane.showMessageDialog(null, "Password must be between 6 and 16 . in length");
			}else {
				employee.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
				EmployeeModel employeeModel = new EmployeeModel();
				if (employeeModel.update(employee)) {
					JOptionPane.showMessageDialog(null, "Change password successfully ");
				}else {
					JOptionPane.showMessageDialog(null, "Password change failed ! ");
					
				}
			}
		}
		
	}
	
}
