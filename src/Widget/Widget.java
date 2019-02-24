package Widget;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Widget {
	
	public static void task1(Shell shell) {
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
				String x = text.getText();
				if (!comboBoxOptionSet.contains(x)) {
					comboBoxOptionSet.add(x);
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.CANCEL);
					messageBox.setText("Warning");
					messageBox.setMessage("This item already exists");
					messageBox.open();
				}
				combo.setItems(comboBoxOptionSet.toArray(new String[comboBoxOptionSet.size()]));
				combo.pack();
			}

		});
	}
	
	public static void task2(Shell shell){
		Group group2 = new Group(shell, SWT.SHADOW_IN);
		group2.setText("Group 2");
		group2.setLayout(new GridLayout());
		
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group2.setLayoutData(rowData);

		Text text2 = new Text(group2, SWT.BORDER);

		Button button21 = new Button(group2, SWT.PUSH);
		button21.setText("Press to change button2");

		Button button22 = new Button(group2, SWT.PUSH);
		button22.setText("Press to change buttons");

		button21.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String x2 = text2.getText();
				button22.setText(x2);
				button22.pack();
			}

		});
		button22.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String buttonChange1 = button21.getText();
				String buttonChange2 = button22.getText();
				button22.setText(buttonChange1);
				button21.setText(buttonChange2);
				button21.pack();
				button22.pack();
			}

		});

	}
	
	public static void task3(Shell shell){
		Group group3 = new Group(shell, SWT.SHADOW_IN);
		group3.setText("Group 3");
		group3.setLayout(new GridLayout());
		
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group3.setLayoutData(rowData);

		Text text3 = new Text(group3, SWT.BORDER);

		Button button3 = new Button(group3, SWT.PUSH);
		button3.setText("Press to select item");

		Button radioButton1 = new Button(group3, SWT.RADIO);
		radioButton1.setText("Button1");

		Button radioButton2 = new Button(group3, SWT.RADIO);
		radioButton2.setText("Button2");

		Button radioButton3 = new Button(group3, SWT.RADIO);
		radioButton3.setText("Button3");

		button3.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				String x3 = text3.getText();

			}

		});
	}
	
	public static void task4(Shell shell) {
		Group group4 = new Group(shell, SWT.SHADOW_IN);
		group4.setText("Group 4");
		group4.setLayout(new GridLayout());
		
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;

		group4.setLayoutData(rowData);

		Text text4 = new Text(group4, SWT.BORDER);

		Button button4 = new Button(group4, SWT.PUSH);
		button4.setText("Press to select item");

		Button checkBox1 = new Button(group4, SWT.CHECK);
		checkBox1.setText("CheckBox1");

		Button checkBox2 = new Button(group4, SWT.CHECK);
		checkBox2.setText("CheckBox2");

		Button checkBox3 = new Button(group4, SWT.CHECK);
		checkBox3.setText("CheckBox3");
	}
	
	public static void task5(Shell shell) {
		Group group5 = new Group(shell, SWT.SHADOW_IN);
		group5.setText("Group 5");
		group5.setLayout(new GridLayout());
		
		RowData rowData = new RowData();
		rowData.height = 150;
		rowData.width = 150;
		group5.setLayoutData(rowData);

	}
	public static void main(String[] args) {
		

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout());
		shell.setText("Shell");

		shell.setSize(500, 500);
		task1(shell);
		task2(shell);
		task3(shell);
		task4(shell);
		task5(shell);
		shell.open();
		
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
