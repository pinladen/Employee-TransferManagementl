package com.views.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.check.CheckValidate;
import com.entities.Project;
import com.entities.Titles;
import com.models.TitlesModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class JPanelTitles extends JPanel {
	private JTable jtableTitles;
	private JTextField jtextName;
	private JTextField jtextSalaries;
	private JTextField jtextFind;
	private JLabel jlabelTitles;

	/**
	 * Create the panel.
	 */
	public JPanelTitles() {
		setBackground(Color.WHITE);
		setLayout(null);
																																														
																																																JScrollPane scrollPane = new JScrollPane();
																																																scrollPane.setBorder(new LineBorder(new Color(0, 139, 139), 3));
																																																scrollPane.setBounds(83, 169, 899, 219);
																																																add(scrollPane);
																																																
																																																		jtableTitles = new JTable();
																																																		jtableTitles.addMouseListener(new MouseAdapter() {
																																																			@Override
																																																			public void mouseClicked(MouseEvent e) {
																																																				clickDatamouseClicked(e);
																																																			}
																																																		});
																																																		scrollPane.setViewportView(jtableTitles);
																																																		
																																																				JPanel panel_2 = new JPanel();
																																																				panel_2.setBounds(83, 400, 899, 79);
																																																				add(panel_2);
																																																				panel_2.setBackground(Color.WHITE);
																																																				panel_2.setLayout(null);
																																																				panel_2.setBorder(new TitledBorder(null, "Find", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																				
																																																						jtextFind = new JTextField();
																																																						jtextFind.setColumns(10);
																																																						jtextFind.setBounds(21, 23, 406, 35);
																																																						panel_2.add(jtextFind);
																																																						
																																																								JButton btnFind = new JButton("Find");
																																																								btnFind.setIcon(new ImageIcon(JPanelTitles.class.getResource("/resources/search_24px.png")));
																																																								btnFind.setBackground(new Color(0, 139, 139));
																																																								btnFind.setForeground(Color.WHITE);
																																																								btnFind.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																								btnFind.addActionListener(new ActionListener() {
																																																									public void actionPerformed(ActionEvent e) {
																																																										btnFind_actionPerformed(e);
																																																									}
																																																								});
																																																								btnFind.setBounds(461, 22, 188, 35);
																																																								panel_2.add(btnFind);
																																																								
																																																										JButton btnReset = new JButton("Reset");
																																																										btnReset.setIcon(new ImageIcon(JPanelTitles.class.getResource("/resources/icons8_Refresh_24px_7.png")));
																																																										btnReset.setBackground(new Color(0, 139, 139));
																																																										btnReset.setForeground(Color.WHITE);
																																																										btnReset.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																										btnReset.addActionListener(new ActionListener() {
																																																											public void actionPerformed(ActionEvent e) {
																																																												loadData();
																																																											}
																																																										});
																																																										btnReset.setBounds(680, 21, 188, 36);
																																																										panel_2.add(btnReset);
																																																										
																																																										JPanel panel_1 = new JPanel();
																																																										panel_1.setBounds(83, 491, 477, 224);
																																																										add(panel_1);
																																																										panel_1.setBackground(Color.WHITE);
																																																										panel_1.setBorder(new TitledBorder(null, "Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																																																										panel_1.setLayout(null);
																																																																
																																																																		JLabel lblNewLabel = new JLabel("Name");
																																																																		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																																		lblNewLabel.setBounds(63, 42, 75, 35);
																																																																		panel_1.add(lblNewLabel);
																																																																		
																																																																				jtextName = new JTextField();
																																																																				jtextName.setBounds(150, 42, 265, 35);
																																																																				panel_1.add(jtextName);
																																																																				jtextName.setColumns(10);
																																																																				
																																																																						jtextSalaries = new JTextField();
																																																																						jtextSalaries.setBounds(150, 105, 265, 32);
																																																																						panel_1.add(jtextSalaries);
																																																																						jtextSalaries.setColumns(10);
																																																																						
																																																																								JLabel lblSalaries = new JLabel("Salaries");
																																																																								lblSalaries.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																																								lblSalaries.setBounds(63, 103, 65, 36);
																																																																								panel_1.add(lblSalaries);
																																																																								
																																																																								JLabel lblNewLabel_2 = new JLabel("Titles Management");
																																																																								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
																																																																								lblNewLabel_2.setForeground(new Color(30, 144, 255));
																																																																								lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
																																																																								lblNewLabel_2.setBounds(83, 51, 899, 43);
																																																																								add(lblNewLabel_2);
																																																																								
																																																																								JPanel panel = new JPanel();
																																																																								panel.setBackground(Color.WHITE);
																																																																								panel.setBorder(new TitledBorder(null, "Action", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
																																																																								panel.setBounds(599, 491, 375, 233);
																																																																								add(panel);
																																																																								panel.setLayout(null);
																																																																								
																																																																										JButton btnUpdate = new JButton("Update");
																																																																										btnUpdate.setBounds(108, 90, 198, 49);
																																																																										panel.add(btnUpdate);
																																																																										btnUpdate.setIcon(new ImageIcon(JPanelTitles.class.getResource("/resources/icons8_reset_24px_1.png")));
																																																																										btnUpdate.setBackground(new Color(0, 139, 139));
																																																																										btnUpdate.setForeground(Color.WHITE);
																																																																										btnUpdate.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																																										
																																																																										JButton JButtonReset = new JButton("reset");
																																																																										JButtonReset.setBounds(108, 151, 198, 44);
																																																																										panel.add(JButtonReset);
																																																																										JButtonReset.setIcon(new ImageIcon(JPanelTitles.class.getResource("/resources/icons8_Refresh_24px_7.png")));
																																																																										JButtonReset.setBackground(new Color(0, 139, 139));
																																																																										JButtonReset.setForeground(Color.WHITE);
																																																																										JButtonReset.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																																										
																																																																												JButton btnAdd = new JButton("Add");
																																																																												btnAdd.setBounds(108, 34, 198, 44);
																																																																												panel.add(btnAdd);
																																																																												btnAdd.setIcon(new ImageIcon(JPanelTitles.class.getResource("/resources/icons8_Add_New_24px.png")));
																																																																												btnAdd.setBackground(new Color(0, 139, 139));
																																																																												btnAdd.setForeground(Color.WHITE);
																																																																												btnAdd.setFont(new Font("SansSerif", Font.PLAIN, 14));
																																																																												
																																																																												JLabel lblNewLabel_3 = new JLabel("Titles :");
																																																																												lblNewLabel_3.setForeground(Color.DARK_GRAY);
																																																																												lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 14));
																																																																												lblNewLabel_3.setBounds(83, 123, 75, 25);
																																																																												add(lblNewLabel_3);
																																																																												
																																																																												jlabelTitles = new JLabel("13");
																																																																												jlabelTitles.setFont(new Font("SansSerif", Font.BOLD, 14));
																																																																												jlabelTitles.setBounds(158, 123, 55, 25);
																																																																												add(jlabelTitles);
																																																																												btnAdd.addActionListener(new ActionListener() {
																																																																													public void actionPerformed(ActionEvent e) {
																																																																														btnAdd_actionPerformed(e);
																																																																													}
																																																																												});
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
		loadData();

	}
	
	public void JButtonReset_actionPerformed(ActionEvent e) {
     jtextName.setText("");
     jtextSalaries.setText("");
    
     
     
	}
	public void btnFind_actionPerformed(ActionEvent e) {
		String dataFind = jtextFind.getText();
		CheckValidate check = new CheckValidate();
		if (check.checkString(dataFind)) {
			TitlesModel titlesModel = new TitlesModel();
			fillDatatoJTable(titlesModel.searchByKeyword(dataFind));
		}else {
			JOptionPane.showMessageDialog(null, "String is not null");
		}
	}

	private void fillDatatoJTable(List<Titles> titles) {

		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Salary");
		defaultTableModel.addColumn("Status");

		for (Titles pr : titles) {
			defaultTableModel.addRow(new Object[] { pr.getTitle_id(), pr.getTitle_name(), pr.getSalaries(),
					pr.isStatus() ? "show" : "hide"

			});
		}
		jtableTitles.setModel(defaultTableModel);
		jtableTitles.getTableHeader().setReorderingAllowed(false);

	}

	private void loadData() {
		TitlesModel titlesModel = new TitlesModel();
		fillDatatoJTable(titlesModel.findAll());
		jlabelTitles.setText(String.valueOf(titlesModel.findAll().size()));
	}

	public void clickDatamouseClicked(MouseEvent e) {
		int selectedRow = jtableTitles.getSelectedRow();
		int id = Integer.parseInt(jtableTitles.getValueAt(selectedRow, 0).toString());
		System.out.print("id: " + id);
		TitlesModel titlesModel = new TitlesModel();
		Titles titles = titlesModel.findById(id);
		jtextName.setText(titles.getTitle_name());
		String salaries = Double.toString(titles.getSalaries());
		jtextSalaries.setText(salaries);
		
	}

	public void btnAdd_actionPerformed(ActionEvent e) {
		TitlesModel titlesModel = new TitlesModel();
		Titles titles = new Titles();
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		String salaries = jtextSalaries.getText();
		if (check.checkName(name)) {
			titles.setTitle_name(name);
			if (check.checkNumber(salaries)) {
				titles.setSalaries(Double.parseDouble(salaries));
				titles.setStatus(true);
				if (titlesModel.create(titles)) {
					JOptionPane.showMessageDialog(null, "Success");
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "False");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Salaries can only be entered from 0 to 9 ");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}

	}

	public void btnUpdate_actionPerformed(ActionEvent e) {
		int selectedRow = jtableTitles.getSelectedRow();
		int id = Integer.parseInt(jtableTitles.getValueAt(selectedRow, 0).toString());
		TitlesModel titlesModel = new TitlesModel();
		Titles titles = new Titles();
		titles.setTitle_id(id);
		CheckValidate check = new CheckValidate();
		String name = jtextName.getText();
		String salaries = jtextSalaries.getText();
		if (check.checkName(name)) {
			titles.setTitle_name(name);
			if (check.checkNumber(salaries)) {
				titles.setSalaries(Double.parseDouble(salaries));
				if (titlesModel.update(titles)) {
					JOptionPane.showMessageDialog(null, "Success");
					loadData();
				} else {
					JOptionPane.showMessageDialog(null, "Faild");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Salaries can only be entered from 0 to 9 ");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Name is not null");
		}
		
	}
}
