package pL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class mainViewPO extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JLabel verselab1;
	private JTextField verstext1;
	private JLabel verselab2;
	private JTextField verstext2;
	private JButton assignButton;
	private JButton tokenButton;
	private JFrame frame;
	private JList rootList;
	private JList tokenList;
	private JScrollPane scrollpaneRoot;
	private JScrollPane scrollpaneToken;
	private JLabel rootlab1;
	private JLabel tokenlab1;

	public static void main(String[] args) {
		new mainViewPO();
	}

	public mainViewPO() {
		frame = new JFrame("Poems Library");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0x5E7986));
		frame.setForeground(Color.WHITE);

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new GridBagLayout());
		GridBagConstraints t = new GridBagConstraints();
		t.insets = new Insets(10, 10, 10, 10);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setLayout(new GridBagLayout());
		GridBagConstraints b = new GridBagConstraints();
		b.insets = new Insets(10, 10, 10, 10);

		titlePanel.setBackground(new Color(0x5E7986));
		buttonPanel.setBackground(new Color(0x5E7986));

		titleLabel = new JLabel("Poem Verse");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 11));
		titleLabel.setForeground(Color.WHITE);

		verselab1 = new JLabel("Misra 1");
		verselab1.setForeground(Color.WHITE);
		verstext1 = new JTextField(20);

		verselab2 = new JLabel("Misra 2");
		verselab2.setForeground(Color.WHITE);
		verstext2 = new JTextField(20);

		rootlab1 = new JLabel("Root's List");
		rootlab1.setForeground(Color.WHITE);

		tokenlab1 = new JLabel("Token's List");
		tokenlab1.setForeground(Color.WHITE);

		rootList = new JList<>();
		rootList.setFont(new Font("Arial", Font.BOLD, 14));
		scrollpaneRoot = new JScrollPane(rootList);

		tokenList = new JList<>();
		tokenList.setFont(new Font("Arial", Font.BOLD, 14));
		scrollpaneToken = new JScrollPane(tokenList);

		assignButton = createStyledButton("Assignment");
		tokenButton = createStyledButton("Tokenize");

		t.gridwidth = 2;
		t.gridy = 0;
		titlePanel.add(titleLabel, t);
		t.gridy = 1;
		titlePanel.add(verselab1, t);
		titlePanel.add(verstext1, t);
		t.gridy = 2;
		titlePanel.add(verselab2, t);
		titlePanel.add(verstext2, t);

		t.gridwidth = 0;
		t.gridy = 3;
		titlePanel.add(rootlab1, t);
		titlePanel.add(tokenlab1, t);

		buttonPanel.add(assignButton);
		buttonPanel.add(tokenButton);

		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(scrollpaneRoot, BorderLayout.WEST);
		frame.add(scrollpaneToken, BorderLayout.EAST);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		
		//Update list
		
		rootList.addListSelectionListener(e->{
			if(!e.getValueIsAdjusting()) {
				assignButton.setEnabled(true);
			}
		});
		
		tokenList.addListSelectionListener(e->{
			if(!e.getValueIsAdjusting()) {
				assignButton.setEnabled(true);
			}
		});

		assignButton.addActionListener(e -> {
			String selectedroot=(String) rootList.getSelectedValue();
			String selectedtoken=(String) tokenList.getSelectedValue();
		});

		frame.setVisible(true);
	}

	private JButton createStyledButton(String label) {
		JButton button = new JButton(label);
		button.setPreferredSize(new Dimension(90, 20));
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setBackground(Color.WHITE);
		button.setForeground(new Color(0x5E7986));

		// Add hover effect to buttons
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				button.setBackground(new Color(0x5E7986));
				button.setForeground(new Color(0x5E7986));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setBorder(BorderFactory.createEmptyBorder());
				button.setBackground(Color.WHITE);
				button.setForeground(new Color(0x5E7986));
			}
		});

		return button;
	}
}