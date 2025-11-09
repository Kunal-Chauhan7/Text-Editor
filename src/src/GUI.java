import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GUI implements ActionListener { // GUI implement the action listener so that we can use the action events

    public static HashMap<String, Color> LanguageKeyWordsAndSyntax; // making an Object so we can pass the Keywords

    public static void main(String[] args) {
        new GUI();
    }
    JFrame window; // creating a window for the application so basically a window where all the function will be added
    JTextPane textArea; // this is the place where the user can write their code and text
    // edit the JTextArea does not support styling so changed it to JTextPane
    JScrollPane scrollPane; // this is that scroll bar which will appear horizontally and vertically
    JMenuBar menuBar; // creating a menu bar which will be on the top og the app
    JMenu menuFile,menuEdit,menuFormat,menuTheme,menuLanguage; // these are called submenu in short these are menu in the menu bar
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // these are the menu item they are present in the menu
    JMenuItem themeDark, themeLight; // themes
    JMenuItem Java, Cpp;

    FileFunction fileFunction = new FileFunction(this); // creating the object and passing this object {in short the gui object that got created}

    public void createWindow(){
        window = new JFrame("Pandu lipi"); // initialized the frame with a title of sandesh
        window.setSize(800,600); // setting the height and width of the frame by default
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // making sure that the frame closes properly
    }
    public void createTextArea() {
        textArea = new JTextPane(); // initialized the textarea for writing space
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // initializing the scroll pane around the text area and passing the arguments when to show the scrollbar pane
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // so this will create an empty border and that means that the scroll pane will have 0 border
        window.add(scrollPane); // adding the scroll pane to the window and it will the text area as well
        textArea.addKeyListener(new java.awt.event.KeyAdapter() { // So i am adding an event listener here so whenever a key is pressed this will get executed
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                fileFunction.CheckSyntaxHiLighting(LanguageKeyWordsAndSyntax); // call the method
            }
        });
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

    public void createLanguageMenu(){
        Java = new JMenuItem("Java"); // creating menu item
        Cpp = new JMenuItem("C++"); // creating menu item

        menuLanguage.add(Java); // adding menu item to menu
        menuLanguage.add(Cpp); // adding menu item to menu

        Java.addActionListener(this); // adding event listener
        Cpp.addActionListener(this); // adding event listener

        Java.setActionCommand("Set Java"); // setting their commands
        Cpp.setActionCommand("Set C++"); // setting their commands

    }

    public void createTheme(){

        fileFunction.ChangeThemeToLight(); // making the theme dark by default whenever someone opens the IDE

        themeLight = new JMenuItem("Light"); // creating light theme menu item
        themeDark = new JMenuItem("Dark"); //  creating dark theme menu item

        menuTheme.add(themeDark); // adding dark theme to the theme menu
        menuTheme.add(themeLight); // adding light theme to the theme menu

        themeLight.addActionListener(this); // adding action listener on light theme menu item
        themeLight.setActionCommand("ChangeLightTheme"); // adding action command on that theme

        themeDark.addActionListener(this); // adding action listener on dark theme menu item
        themeDark.setActionCommand("ChangeDarkTheme"); // adding action command on that theme
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
        createTheme(); // creating the theme menu bar
        LanguageKeyWordsAndSyntax = SyntaxHilighting.JAVAKEYWORDS; // default keep the syntax for java
        window.setVisible(true); // display the window
        createLanguageMenu(); // creating the menu
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
            case "ChangeLightTheme" : fileFunction.ChangeThemeToLight(); break;
            case "ChangeDarkTheme" :fileFunction.ChangeThemeToDark(); break;
            case "Set Java": LanguageKeyWordsAndSyntax = SyntaxHilighting.JAVAKEYWORDS; break;
            case "Set C++": LanguageKeyWordsAndSyntax = SyntaxHilighting.CPPKEYWORDS; break;
        }
    }
}
