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
	int buttonAmount;
	Button[][] radioButton;
	Group[] groupRadio;
	Group groupRadios;
	boolean stop = false;
	Thread thread;
	public void addComboBoxItem(Shell shell) {
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

	public void changeButtons(Shell shell) {
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

	public void selectRadioButton(Shell shell) {
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

	public void selectCheckBox(Shell shell) {
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

	public void addTableItem(Shell shell) {
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

		Table table = new Table(group, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);

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
				if (item.getText(0).contentEquals(""))
					return;
				else {
					item.setText(1, item.getText(0));
					item.setText(0, "");
				}
			}
		});
		button3.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent arg0) {
				TableItem item = table.getSelection()[0];
				if (item.getText(1).contentEquals(""))
					return;
				else {
					item.setText(0, item.getText(1));
					item.setText(1, "");
				}
			}
		});
	}

	public void addRadioButtons(Shell shell) {
		Group group = new Group(shell, SWT.SHADOW_IN | SWT.V_SCROLL);

		group.setText("Group 6");
		group.setLayout(new GridLayout());
		RowData rowData = new RowData();
		rowData.height = 2000;
		rowData.width = 2000;
		group.setLayoutData(rowData);

		Text text = new Text(group, SWT.BORDER);

		Button buttonGen = new Button(group, SWT.PUSH);
		buttonGen.setText("Press to gen");

		Button startButton = new Button(group, SWT.PUSH);
		startButton.setText("Start");

		Button stopButton = new Button(group, SWT.PUSH);
		stopButton.setText("Stop");

		buttonGen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				groupRadios = new Group(group, SWT.SHADOW_IN | SWT.V_SCROLL | SWT.H_SCROLL);
				groupRadios.setText("Group for RadioButtons");

				GridLayout gridLayoutradios = new GridLayout();
				gridLayoutradios.marginLeft = 10;
				gridLayoutradios.marginRight = 5;
				gridLayoutradios.numColumns = 1;
				groupRadios.setLayout(gridLayoutradios);

				buttonAmount = Integer.parseInt(text.getText());
				radioButton = new Button[buttonAmount][buttonAmount];
				groupRadio = new Group[radioButton.length];

				for (int i = 0; i < buttonAmount; i++) {
					groupRadio[i] = new Group(groupRadios, SWT.SHADOW_IN);
					groupRadio[i].setLayout(new GridLayout());
					groupRadio[i].pack();
					for (int j = 0; j < buttonAmount; j++) {
						radioButton[i][j] = new Button(groupRadio[i], SWT.RADIO);
					}
					GridLayout gridLayout = new GridLayout();
					gridLayout.marginLeft = 10;
					gridLayout.marginRight = 5;
					gridLayout.numColumns = buttonAmount;
					groupRadios.setLayout(gridLayout);
					text.setText("");
				}
				groupRadios.pack();
				group.pack();
			}
		});

		startButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0){
				stop = false;
				thread = new Thread( new Runnable() {
	                public void run() {
	                 {
	                	for (int i = 0; i < groupRadio.length / 2; i++) {
	                    try {
	                        Thread.sleep(1000);
	                        
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                    final int index = i;
	                    shell.getDisplay().asyncExec( new Runnable() {
	                        public void run() {
	                        	if(stop == false) {
	                            radioButton[index][index].setSelection(true);
	                        	groupRadios.pack();
	    						group.pack();
	                        	}
	                        	else thread.interrupt();
	                        }
	                        
	                    });
	                }
	                	int j = groupRadio.length / 2;
						int k = radioButton.length - 1;
						if (groupRadio.length % 2 == 0) {
							while (j < groupRadio.length && k >= radioButton.length / 2) {								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								final int index_k = k;
								final int index_j = j;
								shell.getDisplay().asyncExec( new Runnable() {
			                        public void run() {
			                        	if(stop == false) {
			                        	radioButton[index_j][index_k].setSelection(true);
			                        	groupRadios.pack();
			    						group.pack();
			                        	}
			                        	else thread.interrupt();
			                        }
			                    });
								j++;
								k--;
							}
						} else {
							while (j < groupRadio.length && k > radioButton.length / 2) {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								final int index_k = k;
								final int index_j = j;
								shell.getDisplay().asyncExec( new Runnable() {
			                        public void run() {
			                        	if(stop == false) {
			                        	radioButton[index_j][index_k].setSelection(true);
			                        	groupRadios.pack();
			    						group.pack();
			                        	}
			                        	else thread.interrupt();
			                        }
			                    });
								j++;
								k--;
							}
							
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							shell.getDisplay().asyncExec( new Runnable() {
		                        public void run() {
		                        	if(stop == false) {
		                        	radioButton[groupRadio.length - 1][0].setSelection(true);
									groupRadios.pack();
									group.pack();
		                        	}
		                        	else thread.interrupt();
		                        }
		                    });
						}
	                 	}
	                }
				});
				thread.start();
			}
		});
				
		group.pack();
		
		stopButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent arg0) {
				stop = true;
			}
		});
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new RowLayout(SWT.FILL));
		shell.setText("Shell");
		shell.setSize(1000, 1000);
		Widget widget = new Widget();
		widget.addComboBoxItem(shell);
		widget.changeButtons(shell);
		widget.selectRadioButton(shell);
		widget.selectCheckBox(shell);
		widget.addTableItem(shell);
		widget.addRadioButtons(shell);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
