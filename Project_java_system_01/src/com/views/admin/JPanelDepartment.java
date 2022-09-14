package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.check.CheckValidate;
import com.entities.Department;
import com.entities.Location;
import com.entities.Project;
import com.models.DepamentModel;
import com.models.LocationModel;
import com.models.ProjectModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class JPanelDepartment extends JPanel {
	private JTextField jtextName;
	private JTable jtableDepartment;
	private JTextField jtextFind;
	private JLabel jlabelDepartments;

	/**
	 * Create the panel.
	 */
	public JPanelDepartment() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
	        UIManager.getDefaults().put("Table.alternateRowColor", new Color(240,248,255));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 139, 139), 4));
		scrollPane.setBounds(129, 163, 831, 212);
		add(scrollPane);
		
		jtableDepartment = new JTable();
		JTableHeader header = jtableDepartment.getTableHeader();
		header.setFont(new Font("SansSerif",Font.BOLD,14));
		jtableDepartment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTable_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableDepartment);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Find", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(129, 387, 831, 79);
		add(panel_2);
		
		jtextFind = new JTextField();
		jtextFind.setColumns(10);
		jtextFind.setBounds(21, 23, 310, 35);
		panel_2.add(jtextFind);
		
		JButton btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon(JPanelDepartment.class.getResource("/resources/search_24px.png")));
		btnFind.setBackground(new Color(0, 139, 139));
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFind_actionPerformed(e);
			}
		});
		btnFind.setBounds(416, 22, 155, 35);
		panel_2.add(btnFind);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(JPanelDepartment.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		btnReset.setBackground(new Color(0, 139, 139));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
			}
		});
		btnReset.setBounds(613, 22, 151, 35);
		panel_2.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(129, 478, 476, 195);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 82, 67, 26);
		panel.add(lblNewLabel);
		
		jtextName = new JTextField();
		jtextName.setBounds(131, 78, 301, 37);
		panel.add(jtextName);
		jtextName.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Department Management");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(129, 29, 831, 38);
		add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(617, 478, 343, 195);
		add(panel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(JPanelDepartment.class.getResource("/resources/icons8_Add_New_24px.png")));
		btnAdd.setBounds(88, 34, 186, 37);
		panel_1.add(btnAdd);
		btnAdd.setBackground(new Color(0, 139, 139));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(JPanelDepartment.class.getResource("/resources/icons8_reset_24px_1.png")));
		btnUpdate.setBounds(88, 83, 186, 37);
		panel_1.add(btnUpdate);
		btnUpdate.setBackground(new Color(0, 139, 139));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JButton JButtonReset = new JButton("reset");
		JButtonReset.setIcon(new ImageIcon(JPanelDepartment.class.getResource("/resources/icons8_Refresh_24px_7.png")));
		JButtonReset.setBounds(88, 132, 186, 37);
		panel_1.add(JButtonReset);
		JButtonReset.setBackground(new Color(0, 139, 139));
		JButtonReset.setForeground(Color.WHITE);
		JButtonReset.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Departments :");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(129, 113, 100, 38);
		add(lblNewLabel_1);
		
		jlabelDepartments = new JLabel("0");
		jlabelDepartments.setFont(new Font("SansSerif", Font.BOLD, 14));
		jlabelDepartments.setBounds(237, 121, 24, 25);
		add(jlabelDepartments);
		JButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButtonReset_actionPerformed(e);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		loadData();
		
	}
	
	public void JButtonReset_actionPerformed(ActionEvent e) {
     jtextName.setText("");
    
    
     
     
	}
	public void btnFind_actionPerformed(ActionEvent e) {
		String dataFind = jtextFind.getText();
		CheckValidate check = new CheckValidate();
		if(check.checkString(dataFind)) {			
			DepamentModel depamentModel = new DepamentModel();
			List<Department> departments = depamentModel.searchByKeyword(dataFind);
			fillDatatoJTable(departments);
		}else {
			JOptionPane.showMessageDialog(null, "String is not null");
		}
	}
	
	private void fillDatatoJTable(List<Department> departments) {
		
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Created");
		defaultTableModel.addColumn("Status");

		for (Department pr : departments) {
			defaultTableModel.addRow(new Object[] { 
				pr.getDepamentId(),
				pr.getDepamentName(),
				pr.getCreated(),
				pr.isStatus() ? "show" : "hide"

			});
		}
	    jtableDepartment.setModel(defaultTableModel);
		jtableDepartment.getTableHeader().setReorderingAllowed(false);

	}
	
	private void loadData() {
		DepamentModel depamentModel = new DepamentModel();
		jlabelDepartments.setText(String.valueOf(depamentModel.findAll().size()));
		fillDatatoJTable(depamentModel.findAll());
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		DepamentModel depamentModel = new DepamentModel();
		Department department = new Department();
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		
		
		if(check.checkName(name)) {
			department.setDepamentName(name);		
			department.setCreated(new Date());
			department.setStatus(true);
			if(depamentModel.create(department)) {
				JOptionPane.showMessageDialog(null, "Success");
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "False");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
		
		
		
	}
	
	public void clickTable_mouseClicked(MouseEvent e) {
		int selectedRow = jtableDepartment.getSelectedRow();
		int id = Integer.parseInt(jtableDepartment.getValueAt(selectedRow, 0).toString());
		System.out.print("id: " + id);
		DepamentModel depamentModel = new DepamentModel();
		Department pro = depamentModel.findById(id);
		jtextName.setText(pro.getDepamentName());
		
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		int selectedRow = jtableDepartment.getSelectedRow();
		int id = Integer.parseInt(jtableDepartment.getValueAt(selectedRow, 0).toString());
		DepamentModel depamentModel = new DepamentModel();
		Department department = depamentModel.findById(id);
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		if(check.checkName(name)) {
			department.setDepamentName(name);
			if(depamentModel.update(department)) {
				JOptionPane.showMessageDialog(null, "Success");
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "Can not update !!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
	}
}
