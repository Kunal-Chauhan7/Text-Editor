import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileFunction {
    GUI gui; // creating an object of GUI
    String fileName; // this is the file name that will be opened in the editor
    String fileAddress; // this will be the address of the file that has been opened in the file editor
    public FileFunction(GUI gui){ // passing the GUI object to the constructor
        this.gui = gui; // assigning the object to argument object
    }
    public void newFile(){
        gui.textArea.setText(""); // setting the textArea of the file to blank
        gui.window.setTitle("New"); // changing to the name of the window to new
        fileName = null; // means a new file name will be created it should be null
        fileAddress = null; // the file address will be null as well
    }
    void open(){
        FileDialog fd = new FileDialog(gui.window,"Open",FileDialog.LOAD); // made a object of File Dialog and calling it on the gui window and the fileDialog is of LOAD
        fd.setVisible(true); // set the file Dialog to true

        if(fd.getFile()!=null){ // if file Dialog gets something
            fileName = fd.getFile(); // assigning the file name to file name
            fileAddress = fd.getDirectory(); // getting the address of the file
            gui.window.setTitle(fileName); // display the file name
        }
        System.out.println("The File name and the address : "+fileName+fileAddress);
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName // read from this file
            )); // read characters from the character input stream
            gui.textArea.setText(""); // setting the text input area as blank
            String line = null;
            while((line = br.readLine())!=null){ // while the br can read line we will iterate
                gui.textArea.append(line+"\n"); // adding the current line which is read by the br to the text area
            }
            br.close(); // close the file reader
        } catch(Exception e){
            System.out.println("FILE NOT OPENED!");
        }
    }
    void save (){
        if(fileName==null){ // the file does not exist
            saveAs(); // make a new file in this case
        } else{
            try{
                FileWriter fileWriter = new FileWriter(fileAddress + fileName); // open the file for writing or make the file to write
                fileWriter.write(gui.textArea.getText()); // get the text from the textArea
                gui.window.setTitle(fileName); // set the name of the window
                fileWriter.close(); //close the writer
            }catch (Exception e){
                System.out.println("SOMETHING WENT WRONG");
            }
        }
    }
    void saveAs(){
        FileDialog fd = new FileDialog(gui.window,"Save As",FileDialog.SAVE); // so what exactly is going on here is we are making a new file dialog for save as
        fd.setVisible(true); // making that fileDialog visible
        if(fd.getFile()!=null){ // that file is not null
            fileName = fd.getFile(); // get the filename
            fileAddress = fd.getDirectory(); // the address we want to store the data
            gui.window.setTitle(fileName); // set the title of the window of that file
        }
        try {
            FileWriter fileWriter = new FileWriter(fileAddress + fileName); // open the file for writing or make the file to write
            fileWriter.write(gui.textArea.getText()); // get the text from the textArea
            fileWriter.close();
        } catch (Exception e){
            System.out.println("SOMETHING WENT WRONG!");
        }
    }
    void exit(){
        System.exit(0);
    }

    void ChangeThemeToDark(){
        gui.textArea.setBackground(Color.DARK_GRAY);
    }

    void ChangeThemeToLight(){
        gui.textArea.setBackground(new Color(228, 245, 243));
    }
}
