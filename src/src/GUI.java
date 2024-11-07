import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener { // GUI implement the action listener so that we can use the action events
    public static void main(String[] args) {
        new GUI();
    }
    JFrame window; // creating a window for the application so basically a window where all the function will be added
    JTextArea textArea; // this is the place where the user can write their code and text
    JScrollPane scrollPane; // this is that scroll bar which will appear horizontally and vertically
    JMenuBar menuBar; // creating a menu bar which will be on the top og the app
    JMenu menuFile,menuEdit,menuFormat,menuTheme,menuLanguage; // these are called submenu in short these are menu in the menu bar
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // these are the menu item they are present in the menu

    FileFunction fileFunction = new FileFunction(this); // creating the object and passing this object {in short the gui object that got created}

    public void createWindow(){
        window = new JFrame("Sandesh"); // initialized the frame with a title of sandesh
        window.setSize(800,600); // setting the height and width of the frame by default
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // making sure that the frame closes properly
    }
    public void createTextArea(){
        textArea = new JTextArea(); // initialized the textarea for writing space
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // initializing the scroll pane around the text area and passing the arguments when to show the scrollbar pane
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // so this will create an empty border and that means that the scroll pane will have 0 border
        window.add(scrollPane); // adding the scroll pane to the window and it will the text area as well
    }
    public void createMenuBar(){
        menuBar = new JMenuBar(); // creating a menu bar which contains the menu
        window.setJMenuBar(menuBar); // adding the menu bar to the application
        menuFile = new JMenu("File"); // creating a new menu ( part of menu bar)
        menuEdit = new JMenu("Edit"); // creating a new menu ( part of menu bar)
        menuFormat = new JMenu("Format"); // creating a new menu ( part of menu bar)
        menuTheme  = new JMenu("Theme"); // creating a new menu ( part of menu bar)
        menuLanguage = new JMenu("Language"); // creating a new menu ( part of menu bar)
        menuBar.add(menuFile); //adding the menu onto the menu bar
        menuBar.add(menuEdit); //adding the menu onto the menu bar
        menuBar.add(menuFormat); //adding the menu onto the menu bar
        menuBar.add(menuTheme); //adding the menu onto the menu bar
        menuBar.add(menuLanguage); //adding the menu onto the menu bar
    }

    public void createFileMenu(){
        iNew = new JMenuItem("New"); // initializing the menu item for the file menu
        iOpen = new JMenuItem("Open"); // initializing the menu item for the file menu
        iSave = new JMenuItem("Save"); // initializing the menu item for the file menu
        iSaveAs = new JMenuItem("Save As"); // initializing the menu item for the file menu
        iExit = new JMenuItem("Exit"); // initializing the menu item for the file menu
        menuFile.add(iNew); // adding the menu item onto the file menu
        menuFile.add(iOpen); // adding the menu item onto the file menu
        menuFile.add(iSave); // adding the menu item onto the file menu
        menuFile.add(iSaveAs); // adding the menu item onto the file menu
        menuFile.add(iExit); // adding the menu item onto the file menu
        iNew.addActionListener(this); // we have implement the action listener, so we can use this to refer to the action listener
        iNew.setActionCommand("New"); // whenever action occur on this INew a new action command will be generated named new
        iOpen.addActionListener(this); // adding an action listener to the Open
        iOpen.setActionCommand("Open"); // adding the action command to the open
        iSaveAs.addActionListener(this); //adding the action listener
        iSaveAs.setActionCommand("SaveAs"); // setting the command associated to this option
        iSave.addActionListener(this); //adding the action listener
        iSave.setActionCommand("Save"); // setting the command associated to this option
        iExit.addActionListener(this); //adding the action listener
        iExit.setActionCommand("Exit"); // setting the command associated to this option
    }

    public GUI(){ // constructor of the class
        createWindow(); // creating the window
        createTextArea(); // creating the text area
        createMenuBar(); // creating the menus and menu bar
        createFileMenu(); // creating the menu items for the file menu
        window.setVisible(true); // display the window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // whenever a action get performed this method will return that event action command
        switch (command){ // checking which command was it
            case "New": fileFunction.newFile(); break; // if the action command is New this case will get executed
            case "Open" : fileFunction.open();break; // if the action command is Open this case will get executed
            case "Save" : fileFunction.save();break; // if the action command is Open this case will get executed
            case "SaveAs" : fileFunction.saveAs();break; // if the action command is Open this case will get executed
            case "Exit" : fileFunction.exit();break; // exit
        }
    }
}
