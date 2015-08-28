import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * A class to create a protein counter
 * 
 * @author Ricky Dam
 * @version June 20, 2015 
 * 
 * @author Ricky Dam
 * @version June 21, 2015
 */
public class ProteinCounter implements ActionListener
{   
   private JMenuItem resetItem; // a menuItem for resetting and with keyboard shortcut
   private JMenuItem quitItem; // a menuItem for quitting and with keyboard shortcut   
   private JLabel labelFeed; // the label that changes depending on what is happening   
   private JLabel labelDisplay;
   private double proteinCount;
   private JTextField proteinCountDisplay;
   private JTextArea history;
   private JLabel historyTitle;
   private boolean firstHistory;
   
   private JButton shake;
   private JButton milk;
   private JButton yogurt;
   private JButton egg;
   private JButton beef;
   private JButton chicken;
   private JButton pork;
   private JButton bread;
   private JButton pita;
   private JButton rice;
   private JButton apple;
   private JButton banana;
   private JButton blueberry;   
   private JButton potato;
   private JButton cucumber;
   private JButton greenbeans;
   /** 
    * Constructs a Protein Counter
    */
   public ProteinCounter()       
   {   
      firstHistory = true;
      
      JFrame frame = new JFrame("Ricky's Protein Counter");      
      frame.setPreferredSize(new Dimension(1291, 1200)); // default size      
      Container contentPane = frame.getContentPane();
      contentPane.setLayout(new BorderLayout()); // The number of panes
      
      // ********************** Menu Bar **********************
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);
      
      JMenu fileMenu = new JMenu("File");
      fileMenu.setFont(new Font(null, Font.BOLD, 23));
      menuBar.add(fileMenu);
      
      final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
      
      resetItem = new JMenuItem("Clear (Ctrl+C)"); 
      resetItem.setFont(new Font(null, Font.BOLD, 30));
      fileMenu.add(resetItem);
      resetItem.addActionListener(this);
      resetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, SHORTCUT_MASK));
      
      quitItem = new JMenuItem("Quit (Ctrl+Q)");
      quitItem.setFont(new Font(null, Font.BOLD, 30));
      fileMenu.add(quitItem);
      quitItem.addActionListener(this);
      quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
      
      labelFeed = new JLabel();
      labelFeed.setText(" You may begin counting your protein intake.");
      labelFeed.setFont(new Font(null, Font.BOLD, 25));
      contentPane.add(labelFeed, BorderLayout.SOUTH);
           
      // ********************** Main Panel **********************
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new GridLayout(7, 1));           
      
      // ---------- Display Panel ---------- //
      JPanel displayPanel = new JPanel();
      displayPanel.setLayout(new GridLayout(1, 1));             
      
      labelDisplay = new JLabel(" Protein(g): ");      
      Color white = new Color(255, 255, 255);
      labelDisplay.setBackground(white);
      labelDisplay.setOpaque(true);
      labelDisplay.setFont(new Font(null, Font.BOLD, 60));
      labelDisplay.setHorizontalAlignment(JLabel.CENTER);
      displayPanel.add(labelDisplay);      
                  
      proteinCount = 0.0;
      proteinCountDisplay = new JTextField();
      proteinCountDisplay.setBackground(white);
      proteinCountDisplay.setOpaque(true);
      proteinCountDisplay.setEditable(false);
      proteinCountDisplay.setFont(new Font(null, Font.BOLD, 120));
      proteinCountDisplay.setHorizontalAlignment(JTextField.CENTER);
      proteinCountDisplay.setText("" + proteinCount);      
      displayPanel.add(proteinCountDisplay);
      
      mainPanel.add(displayPanel);
      
      // ---------- Dairy Panel ---------- //
      JPanel supplementPanel = new JPanel();
      supplementPanel.setLayout(new GridLayout(1, 1));    
      TitledBorder supp = BorderFactory.createTitledBorder("Supplement");
      supp.setTitleFont(new Font(null, Font.BOLD, 25));
      supplementPanel.setBorder(supp);
      
      // Protein Shake
      shake = new JButton();      
      shake.setLayout(new GridLayout(2, 1));
      
      JLabel supplement_1 = new JLabel("Protein Shake (1 scoop + 400mL of Milk)");
      supplement_1.setFont(new Font(null, 0, 25));
      supplement_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel supplement_2 = new JLabel("24.0g + 14.4g");
      supplement_2.setFont(new Font(null, Font.BOLD, 40));
      supplement_2.setHorizontalAlignment(JTextField.CENTER);
      
      shake.add(supplement_1);
      shake.add(supplement_2);     
      supplementPanel.add(shake);

      ////////////      
      shake.addActionListener(this);   
            
      mainPanel.add(supplementPanel);      
      
      // ---------- Dairy Panel ---------- //
      JPanel dairyPanel = new JPanel();
      dairyPanel.setLayout(new GridLayout(1, 1));    
      TitledBorder dairy = BorderFactory.createTitledBorder("Dairy");
      dairy.setTitleFont(new Font(null, Font.BOLD, 25));
      dairyPanel.setBorder(dairy);
      
      // Milk
      milk = new JButton();      
      milk.setLayout(new GridLayout(2, 1));
      
      JLabel dairy_1 = new JLabel("Milk (250g : 1 glass)");
      dairy_1.setFont(new Font(null, 0, 25));
      dairy_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel dairy_2 = new JLabel("9.0g");
      dairy_2.setFont(new Font(null, Font.BOLD, 40));
      dairy_2.setHorizontalAlignment(JTextField.CENTER);
      
      milk.add(dairy_1);
      milk.add(dairy_2);     
      dairyPanel.add(milk);
      
      // Yogurt
      yogurt = new JButton();
      yogurt.setLayout(new GridLayout(2, 1));
      
      JLabel dairy_3 = new JLabel("Yogurt (100g : 1 container)");
      dairy_3.setFont(new Font(null, 0, 25));
      dairy_3.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel dairy_4 = new JLabel("3.0g");
      dairy_4.setFont(new Font(null, Font.BOLD, 40));
      dairy_4.setHorizontalAlignment(JTextField.CENTER);
      
      yogurt.add(dairy_3);
      yogurt.add(dairy_4);     
      dairyPanel.add(yogurt);
      
      // Yogurt
      egg = new JButton();
      egg.setLayout(new GridLayout(2, 1));
      
      JLabel dairy_5 = new JLabel("Egg (61g : 1 egg)");
      dairy_5.setFont(new Font(null, 0, 25));
      dairy_5.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel dairy_6 = new JLabel("6.0g");
      dairy_6.setFont(new Font(null, Font.BOLD, 40));
      dairy_6.setHorizontalAlignment(JTextField.CENTER);
      
      egg.add(dairy_5);
      egg.add(dairy_6);     
      dairyPanel.add(egg);
      
      ////////////      
      milk.addActionListener(this);
      yogurt.addActionListener(this);
      egg.addActionListener(this);
            
      mainPanel.add(dairyPanel);
      
      // ---------- Meat Panel ---------- //
      JPanel meatPanel = new JPanel();
      meatPanel.setLayout(new GridLayout(1, 1));      
      TitledBorder meat = BorderFactory.createTitledBorder("Meat");
      meat.setTitleFont(new Font(null, Font.BOLD, 25));
      meatPanel.setBorder(meat);
      
      // Beef
      beef = new JButton();      
      beef.setLayout(new GridLayout(2, 1));
      
      JLabel meat_1 = new JLabel("Beef (100g)");
      meat_1.setFont(new Font(null, 0, 25));
      meat_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel meat_2 = new JLabel("22.0g");
      meat_2.setFont(new Font(null, Font.BOLD, 40));
      meat_2.setHorizontalAlignment(JTextField.CENTER);
      
      beef.add(meat_1);
      beef.add(meat_2);      
      meatPanel.add(beef);
      
      // Chicken
      chicken = new JButton();      
      chicken.setLayout(new GridLayout(2, 1));
      
      JLabel meat_3 = new JLabel("Chicken (100g)");
      meat_3.setFont(new Font(null, 0, 25));
      meat_3.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel meat_4 = new JLabel("25.0g");
      meat_4.setFont(new Font(null, Font.BOLD, 40));
      meat_4.setHorizontalAlignment(JTextField.CENTER);
      
      chicken.add(meat_3);
      chicken.add(meat_4);     
      meatPanel.add(chicken);
      
      // Pork
      pork = new JButton();      
      pork.setLayout(new GridLayout(2, 1));
      
      JLabel meat_5 = new JLabel("Pork (100g)");
      meat_5.setFont(new Font(null, 0, 25));
      meat_5.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel meat_6 = new JLabel("21.0g");
      meat_6.setFont(new Font(null, Font.BOLD, 40));
      meat_6.setHorizontalAlignment(JTextField.CENTER);
      
      pork.add(meat_5);
      pork.add(meat_6);     
      meatPanel.add(pork);
      
      ////////////      
      beef.addActionListener(this);
      chicken.addActionListener(this);
      pork.addActionListener(this);
     
      mainPanel.add(meatPanel);
      
      // ---------- Grain Panel ---------- //
      JPanel grainPanel = new JPanel();
      grainPanel.setLayout(new GridLayout(1, 1));      
      TitledBorder grain = BorderFactory.createTitledBorder("Grain");
      grain.setTitleFont(new Font(null, Font.BOLD, 25));
      grainPanel.setBorder(grain);
      
      // Multi-Grain Bread
      bread = new JButton();      
      bread.setLayout(new GridLayout(2, 1));
      
      JLabel grain_1 = new JLabel("Bread (82g : 2 slices)");
      grain_1.setFont(new Font(null, 0, 25));
      grain_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel grain_2 = new JLabel("10.0g");
      grain_2.setFont(new Font(null, Font.BOLD, 40));
      grain_2.setHorizontalAlignment(JTextField.CENTER);
      
      bread.add(grain_1);
      bread.add(grain_2);      
      grainPanel.add(bread);
      
      // Pita
      pita = new JButton();      
      pita.setLayout(new GridLayout(2, 1));
      
      JLabel grain_3 = new JLabel("Pita (60g : 1 pita)");
      grain_3.setFont(new Font(null, 0, 25));
      grain_3.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel grain_4 = new JLabel("5.0g");
      grain_4.setFont(new Font(null, Font.BOLD, 40));
      grain_4.setHorizontalAlignment(JTextField.CENTER);
      
      pita.add(grain_3);
      pita.add(grain_4);     
      grainPanel.add(pita);

      // Rice
      rice = new JButton();      
      rice.setLayout(new GridLayout(2, 1));
      
      JLabel grain_5 = new JLabel("Rice (200g)");
      grain_5.setFont(new Font(null, 0, 25));
      grain_5.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel grain_6 = new JLabel("4.5g");
      grain_6.setFont(new Font(null, Font.BOLD, 40));
      grain_6.setHorizontalAlignment(JTextField.CENTER);
      
      rice.add(grain_5);
      rice.add(grain_6);     
      grainPanel.add(rice);
      
      ////////////      
      bread.addActionListener(this);
      pita.addActionListener(this);   
      rice.addActionListener(this); 
     
      mainPanel.add(grainPanel);
      
      // ---------- Fruit Panel ---------- //
      JPanel fruitPanel = new JPanel();
      fruitPanel.setLayout(new GridLayout(1, 1));      
      TitledBorder fruit = BorderFactory.createTitledBorder("Fruit");
      fruit.setTitleFont(new Font(null, Font.BOLD, 25));
      fruitPanel.setBorder(fruit);
      
      // Apple
      apple = new JButton();      
      apple.setLayout(new GridLayout(2, 1));
      
      JLabel fruit_1 = new JLabel("Apple (100g)");
      fruit_1.setFont(new Font(null, 0, 25));
      fruit_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel fruit_2 = new JLabel("0.3g");
      fruit_2.setFont(new Font(null, Font.BOLD, 40));
      fruit_2.setHorizontalAlignment(JTextField.CENTER);
      
      apple.add(fruit_1);
      apple.add(fruit_2);      
      fruitPanel.add(apple);
      
      // Banana
      banana = new JButton();      
      banana.setLayout(new GridLayout(2, 1));
      
      JLabel fruit_3 = new JLabel("Banana (100g)");
      fruit_3.setFont(new Font(null, 0, 25));
      fruit_3.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel fruit_4 = new JLabel("1.1g");
      fruit_4.setFont(new Font(null, Font.BOLD, 40));
      fruit_4.setHorizontalAlignment(JTextField.CENTER);
      
      banana.add(fruit_3);
      banana.add(fruit_4);     
      fruitPanel.add(banana);
      
      // Blueberry
      blueberry = new JButton();      
      blueberry.setLayout(new GridLayout(2, 1));
      
      JLabel fruit_5 = new JLabel("Blueberry (100g)");
      fruit_5.setFont(new Font(null, 0, 25));
      fruit_5.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel fruit_6 = new JLabel("0.7g");
      fruit_6.setFont(new Font(null, Font.BOLD, 40));
      fruit_6.setHorizontalAlignment(JTextField.CENTER);
      
      blueberry.add(fruit_5);
      blueberry.add(fruit_6);     
      fruitPanel.add(blueberry);
      
      ////////////      
      apple.addActionListener(this);
      banana.addActionListener(this);  
      blueberry.addActionListener(this);
     
      mainPanel.add(fruitPanel);
      
      // ---------- Vegetable Panel ---------- //
      JPanel vegetablePanel = new JPanel();
      vegetablePanel.setLayout(new GridLayout(1, 1));      
      TitledBorder vegetable = BorderFactory.createTitledBorder("Vegetable");
      vegetable.setTitleFont(new Font(null, Font.BOLD, 25));
      vegetablePanel.setBorder(vegetable);
      
      // Potato
      potato = new JButton();      
      potato.setLayout(new GridLayout(2, 1));
      
      JLabel vegetable_1 = new JLabel("Potato (100g)");
      vegetable_1.setFont(new Font(null, 0, 25));
      vegetable_1.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel vegetable_2 = new JLabel("2.0g");
      vegetable_2.setFont(new Font(null, Font.BOLD, 40));
      vegetable_2.setHorizontalAlignment(JTextField.CENTER);
      
      potato.add(vegetable_1);
      potato.add(vegetable_2);      
      vegetablePanel.add(potato);
      
      // Cucumber
      cucumber = new JButton();      
      cucumber.setLayout(new GridLayout(2, 1));
      
      JLabel vegetable_3 = new JLabel("Cucumber (100g)");
      vegetable_3.setFont(new Font(null, 0, 25));
      vegetable_3.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel vegetable_4 = new JLabel("0.6g");
      vegetable_4.setFont(new Font(null, Font.BOLD, 40));
      vegetable_4.setHorizontalAlignment(JTextField.CENTER);
      
      cucumber.add(vegetable_3);
      cucumber.add(vegetable_4);      
      vegetablePanel.add(cucumber);
      
      // Green Beans
      greenbeans = new JButton();      
      greenbeans.setLayout(new GridLayout(2, 1));
      
      JLabel vegetable_5 = new JLabel("Green Beans (100g)");
      vegetable_5.setFont(new Font(null, 0, 25));
      vegetable_5.setHorizontalAlignment(JTextField.CENTER);
      
      JLabel vegetable_6 = new JLabel("1.8g");
      vegetable_6.setFont(new Font(null, Font.BOLD, 40));
      vegetable_6.setHorizontalAlignment(JTextField.CENTER);
      
      greenbeans.add(vegetable_5);
      greenbeans.add(vegetable_6);      
      vegetablePanel.add(greenbeans);
      
      ////////////      
      potato.addActionListener(this);
      cucumber.addActionListener(this);
      greenbeans.addActionListener(this);
     
      mainPanel.add(vegetablePanel);
      
      // ********************** History Panel **********************      
      JPanel historyPanel = new JPanel();
      historyPanel.setLayout(new BorderLayout());        
      
      historyTitle = new JLabel("History");     
      historyTitle.setBackground(white);
      historyTitle.setOpaque(true);
      historyTitle.setFont(new Font(null, Font.BOLD, 50));
      historyTitle.setHorizontalAlignment(JLabel.CENTER);
      historyPanel.add(historyTitle, BorderLayout.NORTH);   
      
      history = new JTextArea(5, 10); // (length, width)
      history.setEditable(false);
      JScrollPane pane = new JScrollPane(history);
      history.setLineWrap(true);
      historyPanel.add(pane, BorderLayout.CENTER);
      history.setCaretPosition(history.getDocument().getLength());
      history.setFont(new Font(null, Font.BOLD, 30));
      //history.setHorizontalAlignment(JTextArea.CENTER);
      
      /////////////////////////////////////      
      contentPane.add(mainPanel, BorderLayout.WEST);
      contentPane.add(historyPanel, BorderLayout.EAST);
      
      
      // ********************** Finalizing **********************
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
      frame.pack();
      frame.setResizable(true);
      frame.setVisible(true);      
   }    
   
   /**
    * Checks for what action was performed by the user.
    * 
    * @param The event that has been done by the user
    */
   public void actionPerformed(ActionEvent event)
   {
       Object object = event.getSource();
       if(object instanceof JButton) {
           JButton theButton = (JButton) event.getSource();           
           //*****************************************************
           if(firstHistory) {             
               if(theButton == shake) {
                   proteinCount += 24.0 + 14.4;
                   labelFeed.setText(" Latest : Protein Shake with 400mL of Milk");
                   history.append(" Protein Shake");
               }
               //*****************************************************
               if(theButton == milk) {
                   proteinCount += 9.0;
                   labelFeed.setText(" Latest : Milk");
                   history.append(" Milk");
               }
               if(theButton == yogurt) {
                   proteinCount += 3.0;
                   labelFeed.setText(" Latest : Yogurt");
                   history.append(" Yogurt");
               }
               if(theButton == egg) {
                   proteinCount += 6.0;
                   labelFeed.setText(" Latest : Egg");
                   history.append(" Egg");
               }
               //*****************************************************
               if(theButton == beef) {
                   proteinCount += 22.0;
                   labelFeed.setText(" Latest : Beef");
                   history.append(" Beef");
               }
               if(theButton == chicken) {
                   proteinCount += 25.0;
                   labelFeed.setText(" Latest : Chicken");
                   history.append(" Chicken");
               }
               if(theButton == pork) {
                   proteinCount += 21.0;
                   labelFeed.setText(" Latest : Pork");
                   history.append(" Pork");
               }
               //*****************************************************
               if(theButton == bread) {
                   proteinCount += 10.0;
                   labelFeed.setText(" Latest : Bread");
                   history.append(" Bread");
               }
               if(theButton == pita) {
                   proteinCount += 5.0;
                   labelFeed.setText(" Latest : Pita");
                   history.append(" Pita");
               }
               if(theButton == rice) {
                   proteinCount += 4.5;
                   labelFeed.setText(" Latest : Rice");
                   history.append(" Rice");
               }
               //*****************************************************
               if(theButton == apple) {
                   proteinCount += 0.3;
                   labelFeed.setText(" Latest : Apple");
                   history.append(" Apple");
               }
               if(theButton == banana) {
                   proteinCount += 1.1;
                   labelFeed.setText(" Latest : Banana");
                   history.append(" Banana");
               }
               if(theButton == blueberry) {
                   proteinCount += 0.7;
                   labelFeed.setText(" Latest : Blueberry");
                   history.append(" Blueberry");
               }
               //*****************************************************
               if(theButton == potato) {
                   proteinCount += 2.0;
                   labelFeed.setText(" Latest : Potato");
                   history.append(" Potato");
               }
               if(theButton == cucumber) {
                   proteinCount += 0.6;
                   labelFeed.setText(" Latest : Cucumber");
                   history.append(" Cucumber");
               }
               if(theButton == greenbeans) {
                   proteinCount += 1.8;
                   labelFeed.setText(" Latest : Green Beans");
                   history.append(" Green Beans");
               }
               firstHistory = false;
           }
           else {             
               if(theButton == shake) {
                   proteinCount += 24.0 + 14.4;
                   labelFeed.setText(" Latest : Protein Shake with 400mL of Milk");
                   history.append("\n" + " Protein Shake");
               }
               //*****************************************************
               if(theButton == milk) {
                   proteinCount += 9.0;
                   labelFeed.setText(" Latest : Milk");
                   history.append("\n" + " Milk");
               }
               if(theButton == yogurt) {
                   proteinCount += 3.0;
                   labelFeed.setText(" Latest : Yogurt");
                   history.append("\n" + " Yogurt");
               }
               if(theButton == egg) {
                   proteinCount += 6.0;
                   labelFeed.setText(" Latest : Egg");
                   history.append("\n" + " Egg");
               }
               //*****************************************************
               if(theButton == beef) {
                   proteinCount += 22.0;
                   labelFeed.setText(" Latest : Beef");
                   history.append("\n" + " Beef");
               }
               if(theButton == chicken) {
                   proteinCount += 25.0;
                   labelFeed.setText(" Latest : Chicken");
                   history.append("\n" + " Chicken");
               }
               if(theButton == pork) {
                   proteinCount += 21.0;
                   labelFeed.setText(" Latest : Pork");
                   history.append("\n" + " Pork");
               }
               //*****************************************************
               if(theButton == bread) {
                   proteinCount += 10.0;
                   labelFeed.setText(" Latest : Bread");
                   history.append("\n" + " Bread");
               }
               if(theButton == pita) {
                   proteinCount += 5.0;
                   labelFeed.setText(" Latest : Pita");
                   history.append("\n" + " Pita");
               }
               if(theButton == rice) {
                   proteinCount += 4.5;
                   labelFeed.setText(" Latest : Rice");
                   history.append("\n" + " Rice");
               }
               //*****************************************************
               if(theButton == apple) {
                   proteinCount += 0.3;
                   labelFeed.setText(" Latest : Apple");
                   history.append("\n" + " Apple");
               }
               if(theButton == banana) {
                   proteinCount += 1.1;
                   labelFeed.setText(" Latest : Banana");
                   history.append("\n" + " Banana");
               }
               if(theButton == blueberry) {
                   proteinCount += 0.7;
                   labelFeed.setText(" Latest : Blueberry");
                   history.append("\n" + " Blueberry");
               }
               //*****************************************************
               if(theButton == potato) {
                   proteinCount += 2.0;
                   labelFeed.setText(" Latest : Potato");
                   history.append("\n" + " Potato");
               }
               if(theButton == cucumber) {
                   proteinCount += 0.6;
                   labelFeed.setText(" Latest : Cucumber");
                   history.append("\n" + " Cucumber");
               }
               if(theButton == greenbeans) {
                   proteinCount += 1.8;
                   labelFeed.setText(" Latest : Green Beans");
                   history.append("\n" + " Green Beans");
               }
           }
           //*****************************************************
           proteinCountDisplay.setText(String.format(Locale.US, "%.1f", proteinCount));
           //proteinCountDisplay.setText(" " + proteinCount);
       }   
       else { // Find out which menuItem has been clicked      
           JMenuItem element = (JMenuItem) object;
           if(element == resetItem) { // the player chose to reset the game
               proteinCount = 0;
               proteinCountDisplay.setText("" + proteinCount);
               labelFeed.setText(" Cleared.");
               history.setText("");
               firstHistory = true;
           }
           if (element == quitItem) { // the player chose to quit the game
               System.exit(0);
           }
       }
   }
}





































