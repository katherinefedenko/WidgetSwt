package Widget;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class Widget {

	public void task1(Shell shell) {
		Set<String> comboBoxOptionSet = new HashSet<>();
		Group group1 = new Group(shell, SWT.SHADOW_IN);
		group1.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group1.setLayoutData(rowData);
		group1.setText("Group 1");

		Text text = new Text(group1, SWT.BORDER);

		Button button = new Button(group1, SWT.PUSH);
		button.setText("Press to add item");

		Combo combo = new Combo(group1, SWT.NONE);

		button.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String textField = text.getText();
				if (!comboBoxOptionSet.contains(textField)) {
					comboBoxOptionSet.add(textField);
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setText("Warning");
					messageBox.setMessage("This item already exists");
					messageBox.open();
				}
				combo.setItems(comboBoxOptionSet.toArray(new String[comboBoxOptionSet.size()]));
				combo.pack();
				text.setText("");
			}
		});
	}

	public void task2(Shell shell) {
		Group group = new Group(shell, SWT.SHADOW_IN);
		group.setText("Group 2");
		group.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group.setLayoutData(rowData);

		Text text = new Text(group, SWT.BORDER);

		Button button1 = new Button(group, SWT.PUSH);
		button1.setText("Press to change button2");
		Button button2 = new Button(group, SWT.PUSH);
		button2.setText("Press to change buttons");

		button1.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String textField = text.getText();
				button2.setText(textField);
				button2.pack();
				text.setText("");
			}

		});
		button2.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String buttonChange1 = button1.getText();
				String buttonChange2 = button2.getText();
				button2.setText(buttonChange1);
				button1.setText(buttonChange2);
				button1.pack();
				button2.pack();
				text.setText("");
			}

		});

	}

	public void task3(Shell shell) {
		Group group = new Group(shell, SWT.SHADOW_IN);
		group.setText("Group 3");
		group.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group.setLayoutData(rowData);

		Text text = new Text(group, SWT.BORDER);

		Button button = new Button(group, SWT.PUSH);
		button.setText("Press to select item");

		Group groupRadio = new Group(group, SWT.SHADOW_IN);
		groupRadio.setText("Group for RadioButtons");
		groupRadio.setLayout(new GridLayout());
		Button radioButton1 = new Button(groupRadio, SWT.RADIO);
		radioButton1.setText("1");
		Button radioButton2 = new Button(groupRadio, SWT.RADIO);
		radioButton2.setText("2");
		Button radioButton3 = new Button(groupRadio, SWT.RADIO);
		radioButton3.setText("3");

		button.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				radioButton1.setSelection(false);
				radioButton2.setSelection(false);
				radioButton3.setSelection(false);
				String textField = text.getText();
				if (textField.contentEquals(radioButton1.getText())) {
					radioButton1.setSelection(true);
				} else if (textField.contentEquals(radioButton2.getText())) {
					radioButton2.setSelection(true);
				} else if (textField.contentEquals(radioButton3.getText())) {
					radioButton3.setSelection(true);
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setText("Warning");
					messageBox.setMessage("There is no item accoarding to your request");
					messageBox.open();
				}
				text.setText("");
			}
		});
	}

	public void task4(Shell shell) {
		Group group = new Group(shell, SWT.SHADOW_IN);
		group.setText("Group 4");
		group.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group.setLayoutData(rowData);

		Text text = new Text(group, SWT.BORDER);

		Button button = new Button(group, SWT.PUSH);
		button.setText("Press to select item");
		Button checkBox1 = new Button(group, SWT.CHECK);
		checkBox1.setText("1");
		Button checkBox2 = new Button(group, SWT.CHECK);
		checkBox2.setText("2");
		Button checkBox3 = new Button(group, SWT.CHECK);
		checkBox3.setText("3");

		button.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent arg0) {
				String textField = text.getText();
				if (textField.contentEquals(checkBox1.getText())) {
					checkBox1.setSelection(!checkBox1.getSelection());
				} else if (textField.contentEquals(checkBox2.getText())) {
					checkBox2.setSelection(!checkBox2.getSelection());
				} else if (textField.contentEquals(checkBox3.getText())) {
					checkBox3.setSelection(!checkBox3.getSelection());
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setText("Warning");
					messageBox.setMessage("There is no item accoarding to your request");
					messageBox.open();
				}
				text.setText("");
			}
			
		});
	}

	public void task5(Shell shell) {
		Group group = new Group(shell, SWT.SHADOW_IN);
		group.setText("Group 5");
		group.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 250;
		rowData.width = 200;
		group.setLayoutData(rowData);

		Text text = new Text(group, SWT.BORDER);

		Button button1 = new Button(group, SWT.PUSH);
		button1.setText("Press to add item");
		Button button2 = new Button(group, SWT.PUSH);
		button2.setText("To the right");
		Button button3 = new Button(group, SWT.PUSH);
		button3.setText("To the left");

		Table table = new Table(group, SWT.BORDER |SWT.MULTI |SWT.FULL_SELECTION);
		
		GridData layoutTable = new GridData();
		layoutTable.heightHint = 100;
		layoutTable.widthHint = 120;
		table.setLayoutData(layoutTable);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn column1 = new TableColumn(table, SWT.CENTER);
		column1.setText("Column 1");
		column1.pack();
		TableColumn column2 = new TableColumn(table, SWT.CENTER);
		column2.setText("Column 2");
		column2.pack();
		
		button1.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, text.getText());
				text.setText("");
			}
		});
		button2.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
				if(item.getText(0).contentEquals("")) return;
				else {
					item.setText(1, item.getText(0));
					item.setText(0, "");
				}
			}
		});
		button3.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
				if(item.getText(1).contentEquals("")) return;
				else {
				item.setText(0, item.getText(1));
				item.setText(1, "");
				}
			}
		});
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout());
		shell.setText("Shell");
		shell.setSize(500, 500);
		Widget widget = new Widget();
		widget.task1(shell);
		widget.task2(shell);
		widget.task3(shell);
		widget.task4(shell);
		widget.task5(shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
