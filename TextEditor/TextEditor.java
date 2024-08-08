package TextEditor;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;   
    JSpinner spinner; 
    JLabel FontLabel;
    JButton colorButton;
    JComboBox FontBox;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;


    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setLocation(500,200);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);

        //TextArea
        textArea = new JTextArea();
        this.add(textArea);
        textArea.setSize(450,450);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN, 20));

        //ScrollPane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Spinner
        FontLabel = new JLabel("Font Size:");
        spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(50,25));
        spinner.setValue(20);
        spinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
            textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN, (int) spinner.getValue()));
            }
            
        });
        //colorButton
        colorButton = new JButton("Color");
        colorButton.addActionListener(this);
        colorButton.setOpaque(true);

        //FOntBox
        String[] font = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        FontBox = new JComboBox<>(font);
        FontBox.addActionListener(this);
        FontBox.setSelectedItem("Arial");
        FontBox.setOpaque(true);

        //MenuBar

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        //\MenuBar

        this.setJMenuBar(menuBar);
        this.add(FontLabel);
        this.add(spinner);
        this.add(colorButton);
        this.add(FontBox);
        this.add(scrollPane);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==colorButton){
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Choose a color", Color.BLACK );
            textArea.setForeground(color);

        }

        if(e.getSource()==FontBox){
            textArea.setFont(new Font((String)FontBox.getSelectedItem(), Font.PLAIN , 20));

        }

        if(e.getSource()==openItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files","txt");
            int res = fileChooser.showOpenDialog(null);
            if(res == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner scan = null;
                try {
                    scan = new Scanner(file);
                    if(file.isFile()){
                        while (scan.hasNextLine()) {
                            String Line = scan.nextLine() + "\n";
                            textArea.append(Line);
                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }finally{
                    scan.close();
                }

            }
        }
        if(e.getSource()==saveItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int res = fileChooser.showSaveDialog(null);
            if(res == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileout = null;
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileout = new PrintWriter(file);
                    fileout.println(textArea.getText());
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }finally{
                    fileout.close();
                }    
            }
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
    }

}

