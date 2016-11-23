import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class TimerTest extends JFrame implements ActionListener{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static final long serialVersionUID = 7416567620110237028L;
    JTextArea area;
    Timer timer;
    int count; // Counts the number of sendings done by the timer
    boolean running; // Indicates if the timer is started (true) or stopped (false)

    public TimerTest() {
     //   super("Test");
        setBounds(30,30,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        area = new JTextArea();
        area.setBounds(0, 0, 500, 400);
        add(area);

        JButton button = new JButton("Click Me!");
        button.addActionListener(this);
        button.setBounds(200, 400, 100, 40);
        add(button);

        // Initialization of the timer. 1 second delay and this class as ActionListener
        timer = new Timer(1000, this);
        timer.setRepeats(true); // Send events until someone stops it
        count = 0; // in the beginning, 0 events sended by timer
        running = false;
        //System.out.println(timer.isRepeats());
        setVisible(true); // Shows the frame
    }

    public void actionPerformed(ActionEvent e) {
        if (! running) {
            timer.start();
            running = true;
        }
        // Writing the current time and increasing the cont times
        area.append(Calendar.getInstance().getTime().toString()+"\n");
        JButton button = new JButton("Click Me!");
        //button.addActionListener(this);
        button.setBounds(count*2, 400, 100, 40);
        add(button);
       // button.setLabel("x");
        count++;
        if (count == 10) {
            timer.stop();
            count = 0;
            running = false;
        }
    }

    public static void main(String[] args) {
        // Executing the frame with its Timer
        new TimerTest();
    }
}