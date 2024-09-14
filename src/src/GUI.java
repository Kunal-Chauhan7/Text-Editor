import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        new GUI();
    }
    JFrame window; // creating a window for the application so basically a window where all the function will be added
    JTextArea textArea; // this is the place where the user can write their code and text
    JScrollPane scrollPane; // this is that scroll bar which will appear horizontally and vertically
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
    public GUI(){ // constructor of the class
        createWindow(); // creating the window
        createTextArea(); // creating the text area
        window.setVisible(true); // display the window
    }
}
