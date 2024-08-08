package Clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat dayFormat;
    JLabel timLabel;
    JLabel dateLabel;
    JLabel dayLabel;
    String day;
    String date;
    String time;
    
    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setSize(350,200);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0,0,100));

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        timLabel = new JLabel();
        timLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
        timLabel.setForeground(Color.GREEN);
        timLabel.setOpaque(true);
        timLabel.setBackground(Color.BLACK);

        dateLabel = new JLabel();
        dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        dateLabel.setForeground(Color.GREEN);
        dateLabel.setOpaque(true);
        dateLabel.setBackground(Color.BLACK);

        dayFormat = new SimpleDateFormat("EEEE");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
        dayLabel.setForeground(Color.GREEN);
        dayLabel.setOpaque(true);
        dayLabel.setBackground(Color.BLACK);
            
        this.add(timLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        setTime();
    }

    public void setTime(){

        while(true){
        time = timeFormat.format(Calendar.getInstance().getTime());
        timLabel.setText(time);

        date = dateFormat.format(Calendar.getInstance().getTime());
        dateLabel.setText(date);

        day = dayFormat.format(Calendar.getInstance().getTime());
        dayLabel.setText(day);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }

}
