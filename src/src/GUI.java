import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        new GUI();
    }
    JFrame window; // creating a window for the application so basically a window where all the function will be added
    JTextArea textArea; // this is the place where the user can write their code and text
    JScrollPane scrollPane; // this is that scroll bar which will appear horizontally and vertically
    JMenuBar menuBar; // creating a menu bar which will be on the top og the app
    JMenu menuFile,menuEdit,menuFormat,menuTheme,menuLanguage; // these are called submenu in short these are menu in the menu bar
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit; // these are the menu item they are present in the menu
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
    }

    public GUI(){ // constructor of the class
        createWindow(); // creating the window
        createTextArea(); // creating the text area
        createMenuBar(); // creating the menus and menu bar
        createFileMenu(); // creating the menu items for the file menu
        window.setVisible(true); // display the window
    }
}
