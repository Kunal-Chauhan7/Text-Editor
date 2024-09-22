import java.awt.*;

public class FileFunction {
    GUI gui; // creating an object of GUI
    public FileFunction(GUI gui){ // passing the GUI object to the constructor
        this.gui = gui; // assigning the object to argument object
    }
    public void newFile(){
        gui.textArea.setText(""); // setting the textArea of the file to blank
        gui.window.setTitle("New"); // changing to the name of the window to new
    }
    void open(){
        FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD); // made a object of File Dialog and calling it on the gui window and the fileDialog is of LOAD
        fd.setVisible(true); // set the file Dialog to true
    }
}
