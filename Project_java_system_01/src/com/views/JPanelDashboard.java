package com.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import com.entities.Department;
import com.entities.Employee;
import com.entities.Location;
import com.entities.Project;
import com.entities.Titles;
import com.entities.Transfer;
import com.models.DepamentModel;
import com.models.EmployeeModel;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.models.TitlesModel;
import com.models.TransferModel;

import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class JPanelDashboard extends JPanel {
	private JLabel jlabelEmployees;
	private JLabel jlabelDepartment;
	private JLabel jlabelTitles;
	private JLabel jlabelLocation;
	private JLabel jlabelProject;
	private JLabel jlabelTransfer;

	/**
	 * Create the panel.
	 */
	public JPanelDashboard() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(95, 176, 378, 123);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(-12, 107, 400, 16);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Employees");
		lblNewLabel.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_user_24px.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(16, 6, 356, 26);
		panel.add(lblNewLabel);
		
		jlabelEmployees = new JLabel("56");
		jlabelEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelEmployees.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelEmployees.setIcon(null);
		jlabelEmployees.setBounds(222, 29, 150, 66);
		panel.add(jlabelEmployees);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(95, 322, 378, 123);
		add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 139, 139));
		panel_1_1.setBounds(-12, 107, 400, 16);
		panel_2.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Departments");
		lblNewLabel_3.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_department_24px_1.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_3.setBounds(16, 6, 356, 26);
		panel_2.add(lblNewLabel_3);
		
		jlabelDepartment = new JLabel("56");
		jlabelDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelDepartment.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelDepartment.setBounds(222, 28, 150, 66);
		panel_2.add(jlabelDepartment);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(95, 471, 378, 123);
		add(panel_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(0, 139, 139));
		panel_1_2.setBounds(-12, 107, 400, 16);
		panel_3.add(panel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("Titles");
		lblNewLabel_4.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_web_design_24px.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_4.setBounds(16, 6, 356, 26);
		panel_3.add(lblNewLabel_4);
		
		jlabelTitles = new JLabel("56");
		jlabelTitles.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelTitles.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelTitles.setBounds(222, 29, 150, 66);
		panel_3.add(jlabelTitles);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(639, 176, 378, 123);
		add(panel_4);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(0, 139, 139));
		panel_1_3.setBounds(-12, 107, 400, 16);
		panel_4.add(panel_1_3);
		
		JLabel lblNewLabel_5 = new JLabel("Location");
		lblNewLabel_5.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_location_24px.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_5.setBounds(16, 6, 356, 26);
		panel_4.add(lblNewLabel_5);
		
		jlabelLocation = new JLabel("56");
		jlabelLocation.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelLocation.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelLocation.setBounds(222, 29, 150, 66);
		panel_4.add(jlabelLocation);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(639, 322, 378, 123);
		add(panel_5);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(new Color(0, 139, 139));
		panel_1_4.setBounds(-12, 107, 400, 16);
		panel_5.add(panel_1_4);
		
		JLabel lblasda = new JLabel("Projects");
		lblasda.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_project_24px.png")));
		lblasda.setHorizontalAlignment(SwingConstants.LEFT);
		lblasda.setForeground(Color.GRAY);
		lblasda.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblasda.setBounds(16, 6, 356, 26);
		panel_5.add(lblasda);
		
		jlabelProject = new JLabel("56");
		jlabelProject.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelProject.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelProject.setBounds(222, 29, 150, 66);
		panel_5.add(jlabelProject);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(639, 471, 378, 123);
		add(panel_6);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(new Color(0, 139, 139));
		panel_1_5.setBounds(-12, 107, 400, 16);
		panel_6.add(panel_1_5);
		
		JLabel lblNewLabel_7 = new JLabel("Request transfers");
		lblNewLabel_7.setIcon(new ImageIcon(JPanelDashboard.class.getResource("/resources/icons8_profile_28px.png")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setForeground(Color.GRAY);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_7.setBounds(16, 6, 356, 26);
		panel_6.add(lblNewLabel_7);
		
		jlabelTransfer = new JLabel("56");
		jlabelTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		jlabelTransfer.setFont(new Font("SansSerif", Font.BOLD, 48));
		jlabelTransfer.setBounds(222, 29, 150, 66);
		panel_6.add(jlabelTransfer);
		
		JLabel lblNewLabel_2 = new JLabel("Dashboard");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(20, 17, 267, 28);
		add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(95, 85, 921, 64);
		add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Wellcome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(6, 6, 909, 52);
		panel_7.add(lblNewLabel_1);
		
		loadData();
	}
	
	private void loadData() {
		// load Employee
		EmployeeModel employeeModel = new EmployeeModel();
		List<Employee>employees = employeeModel.findAll();
		if(employees!=null) {
			jlabelEmployees.setText(String.valueOf(employees.size()));
		}else {
			jlabelEmployees.setText("0");
		}
		
		// load Location
		LocationModel locationModel = new LocationModel();
		List<Location>locations = locationModel.findAll();
		if(locations!=null) {
			jlabelLocation.setText(String.valueOf(locations.size()));
		}else {
			jlabelLocation.setText("0");
		}
		
		// load department
		DepamentModel depamentModel = new DepamentModel();
		List<Department>departments = depamentModel.findAll();
		if(departments!=null) {
			jlabelDepartment.setText(String.valueOf(departments.size()));
		}else {
			jlabelDepartment.setText("0");
		}
		
		// load project
		ProjectModel projectModel = new ProjectModel();
		List<Project> projects = projectModel.findAll();
		if(projects!=null) {
			jlabelProject.setText(String.valueOf(projects.size()));
		}else {
			jlabelProject.setText("0");
		}
		
		// load titles
		TitlesModel titlesModel = new TitlesModel();
		List<Titles> titles = titlesModel.findAll();
		if(titles!=null) {
			jlabelTitles.setText(String.valueOf(titles.size()));
		}else {
			jlabelTitles.setText("0");
		}
		
		// load titles
		TransferModel transferModel = new TransferModel();
		List<Transfer> transfers = transferModel.findAll();
		System.out.println(transfers);
		if(transfers!=null) {
			jlabelTransfer.setText(String.valueOf(transfers.size()));
		}else {
			jlabelTransfer.setText("0");
		}
		
	}
}
