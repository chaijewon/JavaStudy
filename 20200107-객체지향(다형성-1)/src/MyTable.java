import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
public class MyTable extends JFrame implements ActionListener,MouseListener{
    JTable table;// 테이블 모양 관리 
    DefaultTableModel model;// 데이터 관리
    JLabel la1,la2,la3;
    JTextField tf1,tf2,tf3;
    JButton b;
    TableColumn column;
    public MyTable() {
    	la1=new JLabel("이름");
    	la2=new JLabel("주소");
    	la3=new JLabel("전화");
    	
    	tf1=new JTextField(7);
    	tf2=new JTextField(7);
    	tf3=new JTextField(7);
    	b=new JButton("등록");
    	
    	JPanel p=new JPanel();
    	p.add(la1);p.add(tf1);
    	p.add(la2);p.add(tf2);
    	p.add(la3);p.add(tf3);
    	p.add(b);
    	
    	
    	// 테이블
    	String[] col= {"이름","주소","전화"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		
    	};
    	table=new JTable(model);
    	table.setRowHeight(38);
    	JScrollPane js=new JScrollPane(table);
    	table.getTableHeader().setReorderingAllowed(false);
    	//table.setShowHorizontalLines(false);
    	table.setShowGrid(false);
    	table.getTableHeader().setBackground(Color.pink);
    	js.getViewport().setBackground(Color.white);
    	add("Center",js);
    	
    	add("North",p);
    	setSize(640, 480);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// 이벤트 등록 
    	b.addActionListener(this);
    	table.addMouseListener(this);
    	
    	for(int i=0;i<3;i++)
    	{
    		column=table.getColumnModel().getColumn(i);
    		TableCellRenderer rend=column.getCellRenderer();
    		
    		if(i==0)
    		{
    			column.setPreferredWidth(150);
    			
    		}
    		else if(i==1)
    		{
    			column.setPreferredWidth(450);
    		}
    		else if(i==2)
    		{
    			column.setPreferredWidth(250);
    		}
    		
    		column.setCellRenderer(rend);
    	}
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MyTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			String name=tf1.getText();
			if(name.length()<1)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력하세요");
				return;
			}
			String addr=tf2.getText();
			String tel=tf3.getText();
			
			String[] data= {name,addr,tel};
			model.addRow(data);
			
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)
			{
				int row=table.getSelectedRow();
				String name=(String)model.getValueAt(row, 0);
				String addr=(String)model.getValueAt(row, 1);
				String tel=(String)model.getValueAt(row, 2);
				
				String data="이름:"+name+"\n"
						   +"주소:"+addr+"\n"
						   +"전화:"+tel;
				
				JOptionPane.showMessageDialog(this, data);
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
