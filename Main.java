import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  JPanel mainPanel; 

  JLabel leftLabel; 

  JTextField numberBox; 

  JButton countDownButton; 
  JButton resetButton; 


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Number counter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initalize the main panel 
    mainPanel = new JPanel(); 
    //disable layout helpers 
    mainPanel.setLayout(null); 

    //create the side label 
    leftLabel = new JLabel("Counter:"); 

    // set locations for label 
    leftLabel.setBounds(180,90,150,20); 

    //output label to main panel 
    mainPanel.add(leftLabel); 

    //add text box for counter text box 
    numberBox = new JTextField("10");

    //set location for text box 
    numberBox.setBounds(250,90,150,20); 

    //output text box to screen 
    mainPanel.add(numberBox);

    //create buttons for counting and reseting 
    countDownButton = new JButton("Count Down"); 
    resetButton = new JButton("Reset"); 

    //set locations for buttons 
    countDownButton.setBounds(170,120,120,20);  
    resetButton.setBounds(320,120,120,20); 

    //output buttons to the screen 
    mainPanel.add(countDownButton); 
    mainPanel.add(resetButton); 

    //make sure the user can't type in the text field 
    numberBox.setEnabled(false); 

    //add action listener to buttons
    countDownButton.addActionListener(this); 
    resetButton.addActionListener(this); 


    //add panel to window 
    frame.add(mainPanel);

 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand(); 

    if(command.equals("Count Down")){
      //get number from text box 
      String firstText = numberBox.getText();

      //change the string into an integer then subtract 1 
      int sideA = Integer.parseInt(firstText); 

      int newNumber = sideA - 1; 
      if(sideA <= 0){
        newNumber = 0;
      }

      //output the new number in text box 
      numberBox.setText("" + newNumber);
    }if(command.equals("Reset")){
      numberBox.setText("" + 10); 
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
