package autoShip;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiAutoShip extends JFrame
{
      public static final int WIDTH = 1000;
      public static final int HEIGHT = 800;
      public static JTextArea inputTextArea;
      public static JTextArea outputTextArea;
      private JScrollPane scrolledInputText;
      private JScrollPane scrolledOutputText;
      private JButton processInvoice;
      public static ProcessInvoice processButton = new ProcessInvoice();
      

      public GuiAutoShip()
      {
         // Constructor Defaults
         setTitle("Insert Invoice");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(WIDTH, HEIGHT);
         setLayout(new BorderLayout());
         
   
         // Input Text area
         JPanel inputTextPanel = new JPanel();
         inputTextPanel.setLayout(new FlowLayout());
         
         inputTextArea = new JTextArea("Insert invoices here", 20, 40);
         inputTextArea.setBackground(Color.white);
         
         scrolledInputText = new JScrollPane(inputTextArea);
         
         inputTextPanel.add(scrolledInputText); // Add to Panel
         add(inputTextPanel, BorderLayout.WEST);  // Add to Gui
         
         
         
         // Button - Process
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new FlowLayout());
         buttonPanel.setBackground(Color.lightGray);
         
         processInvoice = new JButton("Make Spreadsheet");
         processInvoice.addActionListener(processButton);
         
         buttonPanel.add(processInvoice); // Add to Panel
         add(buttonPanel, BorderLayout.CENTER); // Add to Gui
         
         
         
         // Output Text Area
         JPanel outputTextPanel = new JPanel();
         outputTextPanel.setLayout(new FlowLayout());
         
         outputTextArea = new JTextArea(20,40);
         outputTextArea.setBackground(Color.white);
         
         scrolledOutputText = new JScrollPane(outputTextArea);
         
         outputTextPanel.add(scrolledOutputText); // Add to Panel
         add(outputTextPanel, BorderLayout.EAST); // Add to Gui
         
      }
}

