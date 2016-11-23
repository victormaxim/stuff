import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableCreatingDemo {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Object rowData[][] = { { " ", " ","3"," "," "," "," "," ", " " },
    		{ " ", "4","5"," "," "," "," "," ", " " },
    		{ " ", " ","7"," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " },
    		{ " ", " "," "," "," "," "," "," ", " " }
    		
         };
    Object columnNames[] = { "A", "B","C"," "," "," "," "," ", " "  };
    JTable table = new JTable(rowData, columnNames);

   
    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(400, 400);
    
    frame.setVisible(true);
//      System.out.println(table.editCellAt(2,2));
      System.out.println(table.getModel().getValueAt(2,2));



  }
}