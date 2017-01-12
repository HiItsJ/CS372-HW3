import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

/**
* CityGUI3 inherits from JComponent and implements MouseMotionListener and MouseListener; it creates a map with a city hall and a school along with police officers, teachers, and kids which can all be placed in either the city hall or the school. The statistics of the buildings and the people can all be seen by clicking on them.
* @author Josiah Gallegos
* @version 1.00, 11 January 2017
*/
public class CityGUI3 extends JComponent implements MouseMotionListener, MouseListener{

  static JFrame frame;

  int p1_X = 0, p1_Y = 0;
  int p2_X = 40, p2_Y = 0;
  int t1_X = 80, t1_Y = 0;
  int t2_X = 120, t2_Y = 0;
  int k1_X = 170, k1_Y = 18;
  int k2_X = 210, k2_Y = 18;
  int k3_X = 250, k3_Y = 18;
  Image imageCityHall, imageSchool, imagePolice, imageTeacher, imageKid, imageBackground;

  Boolean dragged = false;

  Boolean p1_drag_ready = false;
  Boolean p2_drag_ready = false;
  Boolean t1_drag_ready = false;
  Boolean t2_drag_ready = false;
  Boolean k1_drag_ready = false;
  Boolean k2_drag_ready = false;
  Boolean k3_drag_ready = false;

  Boolean p1_stats_ready = false;
  Boolean p2_stats_ready = false;
  Boolean t1_stats_ready = false;
  Boolean t2_stats_ready = false;
  Boolean k1_stats_ready = false;
  Boolean k2_stats_ready = false;
  Boolean k3_stats_ready = false;
  Boolean ch_stats_ready = false;
  Boolean s_stats_ready = false;

  ArrayList<String> occupants_CityHall = new ArrayList();
  ArrayList<String> occupants_School = new ArrayList();

  /**
  * This creates an object of the class with the abilites described in the class description.
  * @param iCH passes in the image for the city hall
  * @param iS passes in the image for the school
  * @param iP passes in the image for the police officer
  * @param iT passes in the image for the teacher
  * @param iK passes in the image for the kid
  * @param bg passes in the image for the background
  */
  public CityGUI3(Image iCH, Image iS, Image iP, Image iT, Image iK, Image bg){
    imageCityHall = iCH;
    imageSchool = iS;
    imagePolice = iP;
    imageTeacher = iT;
    imageKid = iK;
    imageBackground = bg;
    addMouseMotionListener(this);
    addMouseListener(this);
  }
  /**
  * Moves certain images accross the screen based on whether it can be dragged.
  * @param e holds the object of the mouse
  */
  public void mouseDragged(MouseEvent e){
    dragged = true;
    p1_stats_ready = false;
    p2_stats_ready = false;
    t1_stats_ready = false;
    t2_stats_ready = false;
    k1_stats_ready = false;
    k2_stats_ready = false;
    k3_stats_ready = false;
    ch_stats_ready = false;
    s_stats_ready = false;
    if (p1_drag_ready){
      p1_X = e.getX()-15;
      p1_Y = e.getY()-30;
    }
    if (p2_drag_ready){
      p2_X = e.getX()-15;
      p2_Y = e.getY()-30;
    }
    if (t1_drag_ready){
      t1_X = e.getX()-25;
      t1_Y = e.getY()-30;
    }
    if (t2_drag_ready){
      t2_X = e.getX()-25;
      t2_Y = e.getY()-30;
    }
    if (k1_drag_ready){
      k1_X = e.getX()-12;
      k1_Y = e.getY()-20;
    }
    if (k2_drag_ready){
      k2_X = e.getX()-12;
      k2_Y = e.getY()-20;
    }
    if (k3_drag_ready){
      k3_X = e.getX()-12;
      k3_Y = e.getY()-20;
    }
    repaint();
  }
  public void mouseMoved(MouseEvent e){}
  /**
  * Paints the frame with the background, city hall, school, police, teacher, and kid images.
  * @param g holds the object for graphics
  */
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.drawImage(imageBackground, 0, 0, this);
    g2.drawImage(imageCityHall, 120, 100, this);
    g2.drawImage(imageSchool, 310, 18, this);
    g2.drawImage(imagePolice, p1_X, p1_Y, this);
    g2.drawImage(imagePolice, p2_X, p2_Y, this);
    g2.drawImage(imageTeacher, t1_X, t1_Y, this);
    g2.drawImage(imageTeacher, t2_X, t2_Y, this);
    g2.drawImage(imageKid, k1_X, k1_Y, this);
    g2.drawImage(imageKid, k2_X, k2_Y, this);
    g2.drawImage(imageKid, k3_X, k3_Y, this);
  }
  public void mouseClicked(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  /**
  * Potentially allows certain images to be either viewed or dragged if clicked
  * @param e holds the object of the mouse
  */
  public void mousePressed(MouseEvent e){
    if (e.getX()<p1_X+30&&e.getX()>p1_X&&e.getY()<p1_Y+60&&e.getY()>p1_Y){
      p1_drag_ready = true;
      p1_stats_ready = true;
    }
    if (e.getX()<p2_X+30&&e.getX()>p2_X&&e.getY()<p2_Y+60&&e.getY()>p2_Y){
      p2_drag_ready = true;
      p2_stats_ready = true;
    }
    if (e.getX()<t1_X+50&&e.getX()>t1_X&&e.getY()<t1_Y+60&&e.getY()>t1_Y){
      t1_drag_ready = true;
      t1_stats_ready = true;
    }
    if (e.getX()<t2_X+50&&e.getX()>t2_X&&e.getY()<t2_Y+60&&e.getY()>t2_Y){
      t2_drag_ready = true;
      t2_stats_ready = true;
    }
    if (e.getX()<k1_X+25&&e.getX()>k1_X&&e.getY()<k1_Y+40&&e.getY()>k1_Y){
      k1_drag_ready = true;
      k1_stats_ready = true;
    }
    if (e.getX()<k2_X+25&&e.getX()>k2_X&&e.getY()<k2_Y+40&&e.getY()>k2_Y){
      k2_drag_ready = true;
      k2_stats_ready = true;
    }
    if (e.getX()<k3_X+25&&e.getX()>k3_X&&e.getY()<k3_Y+40&&e.getY()>k3_Y){
      k3_drag_ready = true;
      k3_stats_ready = true;
    }
    if (e.getX()<180&&e.getX()>120&&e.getY()<180&&e.getY()>100){
      ch_stats_ready = true;
    }
    if (e.getX()<380&&e.getX()>310&&e.getY()<88&&e.getY()>18){
      s_stats_ready = true;
    }
  }
  /**
  * Displays stats of an image depending on whether it has not been dragged and has been pressed. It will also add certain people to certain buildings if they are placed on them.
  * @param e holds the object of the mouse
  */
  public void mouseReleased(MouseEvent e){
    if (!dragged){
      if (p1_stats_ready)
        JOptionPane.showMessageDialog(frame, "Police Officer: Mr. Burtin\nAge: 45\nPhone number: 5673452\nRole: Patrol");
      if (p2_stats_ready)
        JOptionPane.showMessageDialog(frame, "Police Officer: Mr. Higgins\nAge: 22\nPhone number: 7756731\nRole: Patrol");
      if (t1_stats_ready)
        JOptionPane.showMessageDialog(frame, "Teacher: Ms. Johnson\nAge: 32\nPhone number: 4567890\nGrade level taught: 2\nCertification: master's");
      if (t2_stats_ready)
        JOptionPane.showMessageDialog(frame, "Teacher: Mrs. Stelton\nAge: 50\nPhone number: 1234567\nGrade level taught: 6\nCertification: master's");
      if (k1_stats_ready)
        JOptionPane.showMessageDialog(frame, "Kid: Billy\nAge: 5\nPhone number: 2657865\nFavorite candy: KitKat");
      if (k2_stats_ready)
        JOptionPane.showMessageDialog(frame, "Kid: Johnny\nAge: 10\nPhone number: 8672435\nFavorite candy: Jawbreaker");
      if (k3_stats_ready)
        JOptionPane.showMessageDialog(frame, "Kid: Tom\nAge: 9\nPhone number: 5769843\nFavorite candy: Hersheys Chocolate");
      if (ch_stats_ready){
        String names = "";
        for (String s: occupants_CityHall){
          names += s+"\n";
        }
        JOptionPane.showMessageDialog(frame, "Spokane City Hall\nAddress: 46753\nOccupants:\n"+names);
      }
      if (s_stats_ready){
        String names2 = "";
        for (String s: occupants_School){
          names2 += s+"\n";
        }
        JOptionPane.showMessageDialog(frame, "Spokane Elementary\nAddress: 12345\nOccupants:\n"+names2);
      }
    }
    else {
      if (p1_X+15<180&&p1_X+15>120&&p1_Y+30<180&&p1_Y+30>100){
        p1_X = -100;
        p1_Y = -100;
        occupants_CityHall.add("Mr. Burtin");
      }
      if (p2_X+15<180&&p2_X+15>120&&p2_Y+30<180&&p2_Y+30>100){
        p2_X = -100;
        p2_Y = -100;
        occupants_CityHall.add("Mr. Higgins");
      }
      if (t1_X+25<380&&t1_X+25>310&&t1_Y+30<88&&t1_Y+30>18){
        t1_X = -100;
        t1_Y = -100;
        occupants_School.add("Ms. Johnson");
      }
      if (t2_X+25<380&&t2_X+25>310&&t2_Y+30<88&&t2_Y+30>18){
        t2_X = -100;
        t2_Y = -100;
        occupants_School.add("Mrs. Stelton");
      }
      if (k1_X+12<380&&k1_X+20>310&&k1_Y+12<88&&k1_Y+20>18){
        k1_X = -100;
        k1_Y = -100;
        occupants_School.add("Billy");
      }
      if (k2_X+12<380&&k2_X+20>310&&k2_Y+12<88&&k2_Y+20>18){
        k2_X = -100;
        k2_Y = -100;
        occupants_School.add("Johnny");
      }
      if (k3_X+12<380&&k3_X+20>310&&k3_Y+12<88&&k3_Y+20>18){
        k3_X = -100;
        k3_Y = -100;
        occupants_School.add("Tom");
      }
      repaint();
    }
    dragged = false;
    p1_drag_ready = false;
    p2_drag_ready = false;
    t1_drag_ready = false;
    t2_drag_ready = false;
    k1_drag_ready = false;
    k2_drag_ready = false;
    k3_drag_ready = false;

    p1_stats_ready = false;
    p2_stats_ready = false;
    t1_stats_ready = false;
    t2_stats_ready = false;
    k1_stats_ready = false;
    k2_stats_ready = false;
    k3_stats_ready = false;
    ch_stats_ready = false;
    s_stats_ready = false;
  }
  /**
  * Creates images by grabbing them from the browser and creates a frame and customizes it
  * @param args holds the list of arguments sent to the main method
  */
  public static void main(String[] args){
    /*
    ArrayList<Building> buildings = new ArrayList();

    ArrayList<Person> schoolppl = new ArrayList();
    schoolppl.add(new Teacher("Ms. Johnson", 32, 4567890, 2, "master's"));
    schoolppl.add(new Teacher("Mr. Stelton", 50, 1234567, 6, "master's"));
    schoolppl.add(new Kid("Billy", 5, 2657865, "KitKat"));
    schoolppl.add(new Kid("Johnny", 10, 8672435, "Jawbreaker"));
    schoolppl.add(new Kid("Tom", 9, 5769843, "Hersheys Chocolate"));
    School elementary = new School("Spokane Elementary", 12345, schoolppl);
    buildings.add(elementary);

    ArrayList<Person> cityHallppl = new ArrayList();
    cityHallppl.add(new Police("Mr. Burtin", 45, 5673452, Police.Role.Patrol));
    cityHallppl.add(new Police("Mr. Higgins", 22, 7756731, Police.Role.Patrol));
    CityHall hall = new CityHall("Spokane CityHall", 46753, cityHallppl);
    buildings.add(hall);
    */

    Image imgCityHall = null;
    Image imgSchool = null;
    Image imgPolice = null;
    Image imgTeacher = null;
    Image imgKid = null;
    Image imgBackground = null;

    try {
      imgCityHall = Toolkit.getDefaultToolkit().getImage(new URL("http://www.russ-lavery.com/photos/buffalocityhall.png"));
      imgCityHall = imgCityHall.getScaledInstance(60, 80, Image.SCALE_SMOOTH);
      imgSchool = Toolkit.getDefaultToolkit().getImage(new URL("https://i.ytimg.com/vi/s9iOtT2_vcI/maxresdefault.jpg"));
      imgSchool = imgSchool.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
      imgPolice = Toolkit.getDefaultToolkit().getImage(new URL("http://www.clipartguide.com/clipart_people/rad_O_SAFETY.GIF"));
      imgPolice = imgPolice.getScaledInstance(30, 60, Image.SCALE_SMOOTH);
      imgTeacher = Toolkit.getDefaultToolkit().getImage(new URL("http://images.clipartpanda.com/teacher-clip-art-Teacher2.png"));
      imgTeacher= imgTeacher.getScaledInstance(50, 60, Image.SCALE_SMOOTH);
      imgKid = Toolkit.getDefaultToolkit().getImage(new URL("http://vignette4.wikia.nocookie.net/the-animated-kid/images/4/49/The_animated_kid_full_picture.jpg/revision/latest?cb=20141030062931"));
      imgKid = imgKid.getScaledInstance(25, 40, Image.SCALE_SMOOTH);
      imgBackground = Toolkit.getDefaultToolkit().getImage(new URL("http://www.kansastravel.org/08falmouthchristmas1.JPG"));
    }
    catch(Exception ex){;}
    frame = new JFrame();
    frame.add(new CityGUI3(imgCityHall, imgSchool, imgPolice, imgTeacher, imgKid, imgBackground));
    frame.setSize(600, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }
}
