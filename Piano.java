import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

/*
Authors: Jose Gil, Santos Huchin, Luis Lopez.
Project: PianoRMI.
Course: Distributed Systems.
Undergraduate Program: Computer Systems Engineering.
University: Universidad Autonoma de Campeche.
All rights reserved.
*/

public class Piano extends JFrame {
    //Declaracion de diversos componentes
    private JButton gatilloTocarCualquierCancion;
    private JButton cancion1, cancion2, cancion3, cancion4, cancion5, cancion6;
    private JButton do5, re5, mi5, fa5, sol5, la5, si5, do6, re6, mi6, fa6, sol6, la6, si6, do7;
    private JButton doSost5, reSost5, faSost5, solSost5, laSost5, doSost6, reSost6, faSost6, solSost6, laSost6;
    private MyLayeredPane background;
    private pianoSonido sound;

    private AudioInputStream audioInputStream;
    private Clip clip;

    private Timer reloj, reloj2;
    private int x, y, v, w;
    private boolean temp;
    private Random rand ;
    private float r, g, b;
    private Color randomColor;

    private JButton [] melodia;
    private int [] silencios, blanqueamiento;
    private CancionesInterface repertorio;
    
    private MyPanel mitadInferior, interior1, interior2, interior2sub1, interior2sub2, interior2sub3, interior1sub1, interior1sub2;
    private JScrollPane interior2Desplazamiento;
    private JTextArea reproductor;
    
    private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;

    public Piano() {
        setContentPane(new JLabel(crearImageIcon("IconosAplicacion/fondo.jpg")));
        //Inicializacion de algunos atributos de clase
        x = 1;//
        y = 2;
        v = 1;//
        w = 2;
        temp = true;
        try {
		Registry registry = LocateRegistry.getRegistry();
            repertorio = (CancionesInterface) registry.lookup("RepertorioService");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        rand = new Random();
        icon1 = crearImageIcon("IconosAplicacion/cancion1.jpg");
        icon2 = crearImageIcon("IconosAplicacion/cancion2.jpg");
        icon3 = crearImageIcon("IconosAplicacion/cancion3.jpg");
        icon4 = crearImageIcon("IconosAplicacion/cancion4.jpg");
        icon5 = crearImageIcon("IconosAplicacion/cancion5.jpg");
        icon6 = crearImageIcon("IconosAplicacion/cancion6.jpg");
        //Inicializacion de los atributos de la ventana
        setTitle("Aplicacion de Piano");
        setSize(1050, 730);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        crearContenido();
        setVisible(true);
    }

    private void crearContenido() {
        //Contenedor de los botones (teclas del piano)
        background = new MyLayeredPane("IconosAplicacion/fondo1.jpg");
        background.setPreferredSize(new Dimension(990, 310));
        background.setBorder(BorderFactory.createLineBorder(new Color(145, 143, 131)));
        background.setLayout(null);
        //Boton oculto que toca cualquier tema a partir de los arreglos que contienen sus notas y silencios
        gatilloTocarCualquierCancion = new JButton();
        gatilloTocarCualquierCancion.setVisible(false);
        //Creacion y posicionamiento de cada tecla del piano (botones)  
        do5 = new JButton("Do5");
        do5.setBounds(0, 110, 66, 200);
        do5.setBackground(Color.WHITE);
        re5 = new JButton("Re5");
        re5.setBounds(66, 110, 66, 200);
        re5.setBackground(Color.WHITE);
        mi5 = new JButton("Mi5");
        mi5.setBounds(132, 110, 66, 200);
        mi5.setBackground(Color.WHITE);
        fa5 = new JButton("Fa5");
        fa5.setBounds(198, 110, 66, 200);
        fa5.setBackground(Color.WHITE);
        sol5 = new JButton("Sol5");
        sol5.setBounds(264, 110, 66, 200);
        sol5.setBackground(Color.WHITE);
        la5 = new JButton("La5");
        la5.setBounds(330, 110, 66, 200);
        la5.setBackground(Color.WHITE);
        si5 = new JButton("Si5");
        si5.setBounds(396, 110, 66, 200);
        si5.setBackground(Color.WHITE);
        do6 = new JButton("Do6");
        do6.setBounds(462, 110, 66, 200);
        do6.setBackground(Color.WHITE);
        re6 = new JButton("Re6");
        re6.setBounds(528, 110, 66, 200);
        re6.setBackground(Color.WHITE);
        mi6 = new JButton("Mi6");
        mi6.setBounds(594, 110, 66, 200);
        mi6.setBackground(Color.WHITE);
        fa6 = new JButton("Fa6");
        fa6.setBounds(660, 110, 66, 200);
        fa6.setBackground(Color.WHITE);
        sol6 = new JButton("Sol6");
        sol6.setBounds(726, 110, 66, 200);
        sol6.setBackground(Color.WHITE);
        la6 = new JButton("La6");
        la6.setBounds(792, 110, 66, 200);
        la6.setBackground(Color.WHITE);
        si6 = new JButton("Si6");
        si6.setBounds(858, 110, 66, 200);
        si6.setBackground(Color.WHITE);
        do7 = new JButton("Do7");
        do7.setBounds(924, 110, 66, 200);
        do7.setBackground(Color.WHITE);

        doSost5 = new JButton();
        doSost5.setBounds(48, 110, 36, 120);
        doSost5.setBackground(Color.BLACK);
        reSost5 = new JButton();
        reSost5.setBounds(116, 110, 36, 120);
        reSost5.setBackground(Color.BLACK);
        faSost5 = new JButton();
        faSost5.setBounds(246, 110, 36, 120);
        faSost5.setBackground(Color.BLACK);
        solSost5 = new JButton();
        solSost5.setBounds(312, 110, 36, 120);
        solSost5.setBackground(Color.BLACK);
        laSost5 = new JButton();
        laSost5.setBounds(378, 110, 36, 120);
        laSost5.setBackground(Color.BLACK);
        doSost6 = new JButton();
        doSost6.setBounds(510, 110, 36, 120);
        doSost6.setBackground(Color.BLACK);
        reSost6 = new JButton();
        reSost6.setBounds(576, 110, 36, 120);
        reSost6.setBackground(Color.BLACK);
        faSost6 = new JButton();
        faSost6.setBounds(708, 110, 36, 120);
        faSost6.setBackground(Color.BLACK);
        solSost6 = new JButton();
        solSost6.setBounds(774, 110, 36, 120);
        solSost6.setBackground(Color.BLACK);
        laSost6 = new JButton();
        laSost6.setBounds(840, 110, 36, 120);
        laSost6.setBackground(Color.BLACK);
        //Botones para tocar canciones
        cancion1 = new JButton(icon1);
        cancion1.setPreferredSize(new Dimension(180, 86));
        cancion2 = new JButton(icon2);
        cancion2.setPreferredSize(new Dimension(180, 86));
        cancion3 = new JButton(icon3);
        cancion3.setPreferredSize(new Dimension(180, 86));
        cancion4 = new JButton(icon4);
        cancion4.setPreferredSize(new Dimension(180, 86));
        cancion5 = new JButton(icon5);
        cancion5.setPreferredSize(new Dimension(180, 86));
        cancion6 = new JButton(icon6);
        cancion6.setPreferredSize(new Dimension(180, 86));
        
       
        ActionListener prepararCancion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
		try {
                if (actionEvent.getSource() == cancion1) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion1());
                    silencios = repertorio.getSilencios1();
                    blanqueamiento = repertorio.getSilencios1();
                    reproductor.setText("'\n'Tema:\n\nHimno a la Alegria\n\nAutor:\n\nLudwig van Beethoven");
                } else if (actionEvent.getSource() == cancion2) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion2());
                    silencios = repertorio.getSilencios2();
                    blanqueamiento = repertorio.getSilencios2();
                    reproductor.setText("'\n'Tema:\n\nSenorita\n\nArtista:\n\nShawn Mendes & Camila Cabello");
                } else if (actionEvent.getSource() == cancion3) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion3());
                    silencios = repertorio.getSilencios3();
                    blanqueamiento = repertorio.getSilencios3();
                    reproductor.setText("'\n'Tema:\n\nLas Mananitas\n\nAutor:\n\nTradicional Mexicano");
                } else if (actionEvent.getSource() == cancion4) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion4());
                    silencios = repertorio.getSilencios4();
                    blanqueamiento = repertorio.getSilencios4();
                    reproductor.setText("'\n'Tema:\n\nTitanic\n\nAutor:\n\nJames Horner");
                } else if (actionEvent.getSource() == cancion5) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion5());
                    silencios = repertorio.getSilencios5();
                    blanqueamiento = repertorio.getSilencios5();
                    reproductor.setText("'\n'Tema:\n\nYellow Submarine\n\nArtista:\n\nThe Beatles");
                } else if (actionEvent.getSource() == cancion6) {
                    melodia = casteoArregloStringJButton(repertorio.getCancion6());
                    silencios = repertorio.getSilencios6();
                    blanqueamiento = repertorio.getSilencios6();
                    reproductor.setText("'\n'Tema:\n\nEl Pregonero\n\nAutor:\n\nTradicional Campechano");
                }
		
        	} catch (Exception ex) {
            		System.out.println("Error: " + ex.getMessage());
        	}
                gatilloTocarCualquierCancion.doClick();
            }
        };
        cancion1.addActionListener(prepararCancion);
        cancion2.addActionListener(prepararCancion);
        cancion3.addActionListener(prepararCancion);
        cancion4.addActionListener(prepararCancion);
        cancion5.addActionListener(prepararCancion);
        cancion6.addActionListener(prepararCancion);
        ActionListener tocarCancion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reloj.start();
                r = rand.nextFloat();
                g = rand.nextFloat();
                b = rand.nextFloat();
                randomColor =  new Color(r, g, b);
                melodia[x].setBackground(randomColor);
                melodia[x].doClick();
                if (x == silencios.length) {
                    x = 0;
                    y = 1;
                    reloj.stop();
                }
                x++;
                if (y < silencios.length) {
                    reloj.setDelay(silencios[y]);
                    y++;
                }
            }
        };
        reloj = new Timer(0,tocarCancion);
        reloj.setInitialDelay(500);

        ActionListener blanquearTeclas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reloj2.start();
                if (temp == true) {
                    cancion1.setEnabled(false);
                    cancion2.setEnabled(false);
                    cancion3.setEnabled(false);
                    cancion4.setEnabled(false);
                    cancion5.setEnabled(false);
                    cancion6.setEnabled(false);
                    temp = false;
                } else {
                    if ((melodia[v] == doSost5) || (melodia[v] == reSost5) || (melodia[v] == faSost5) || (melodia[v] == solSost5) || (melodia[v] == laSost5)
                            || (melodia[v] == doSost6) || (melodia[v] == reSost6) || (melodia[v] == faSost6) || (melodia[v] == solSost6) || (melodia[v] == laSost6)) {
                        melodia[v].setBackground(Color.BLACK);
                    } else {
                        melodia[v].setBackground(Color.WHITE);
                    }
                    if (v == blanqueamiento.length) {
                        v = 0;
                        w = 1;
                        temp = true;
                        cancion1.setEnabled(true);
                        cancion2.setEnabled(true);
                        cancion3.setEnabled(true);
                        cancion4.setEnabled(true);
                        cancion5.setEnabled(true);
                        cancion6.setEnabled(true);
                        reproductor.setText("");
                        reloj2.stop();
                    }
                    v++;
                    if (w < blanqueamiento.length) {
                        reloj2.setDelay(blanqueamiento[w]);
                        w++;
                    }
                }
            }
        };
        reloj2 = new Timer(500, blanquearTeclas);
        reloj2.setInitialDelay(300);
        //Boton oculto que toca cualquiera de los temas, utiliza el primer listener para emitir la secuencia de sonidos y el segundo para devolver el color blanco de las teclas del piano
        gatilloTocarCualquierCancion.addActionListener(tocarCancion);
        gatilloTocarCualquierCancion.addActionListener(blanquearTeclas);
        //Asignacion de listeners a cada boton (tecla del piano)
        sound = new pianoSonido();
        do5.addActionListener(sound);
        re5.addActionListener(sound);
        mi5.addActionListener(sound);
        fa5.addActionListener(sound);
        sol5.addActionListener(sound);
        la5.addActionListener(sound);
        si5.addActionListener(sound);
        do6.addActionListener(sound);
        re6.addActionListener(sound);
        mi6.addActionListener(sound);
        fa6.addActionListener(sound);
        sol6.addActionListener(sound);
        la6.addActionListener(sound);
        si6.addActionListener(sound);
        do7.addActionListener(sound);
        doSost5.addActionListener(sound);
        reSost5.addActionListener(sound);
        faSost5.addActionListener(sound);
        solSost5.addActionListener(sound);
        laSost5.addActionListener(sound);
        doSost6.addActionListener(sound);
        reSost6.addActionListener(sound);
        faSost6.addActionListener(sound);
        solSost6.addActionListener(sound);
        laSost6.addActionListener(sound);

        //Inclusion de los botones (teclas del piano) en el contenedor
        background.add(do5, 0, -1);
        background.add(re5, 0, -1);
        background.add(mi5, 0, -1);
        background.add(fa5, 0, -1);
        background.add(sol5, 0, -1);
        background.add(la5, 0, -1);
        background.add(si5, 0, -1);
        background.add(do6, 0, -1);
        background.add(re6, 0, -1);
        background.add(mi6, 0, -1);
        background.add(fa6, 0, -1);
        background.add(sol6, 0, -1);
        background.add(la6, 0, -1);
        background.add(si6, 0, -1);
        background.add(do7, 0, -1);

        background.add(doSost5, 1, -1);
        background.add(reSost5, 1, -1);
        background.add(faSost5, 1, -1);
        background.add(solSost5, 1, -1);
        background.add(laSost5, 1, -1);
        background.add(doSost6, 1, -1);
        background.add(reSost6, 1, -1);
        background.add(faSost6, 1, -1);
        background.add(solSost6, 1, -1);
        background.add(laSost6, 1, -1);
        //Inclusion del contenedor con el piano en el jframe raiz
        add(background);
        crearParteInferior();
        add(mitadInferior);
        
    }
    
    //Metodos privados
    
    private ImageIcon crearImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se encontró la imagen en: " + path);
            return null;
        }
    }
    
    private void crearParteInferior() {
        mitadInferior = new MyPanel("IconosAplicacion/fondo2.jpg");
        mitadInferior.setPreferredSize(new Dimension(990, 360));
        mitadInferior.setBorder(BorderFactory.createBevelBorder(1));
        
        interior1 = new MyPanel("IconosAplicacion/fondo3.jpg");
        interior1.setPreferredSize(new Dimension(320, 345));
        interior1.setBorder(BorderFactory.createEtchedBorder(1));
        
        interior1sub1 = new MyPanel("IconosAplicacion/fondo31.jpg");
        interior1sub1.setPreferredSize(new Dimension(315, 165));
        
        interior1sub2 = new MyPanel("IconosAplicacion/fondo3.jpg");
        interior1sub2.setPreferredSize(new Dimension(315, 165));
        
        reproductor = new JTextArea(9, 25);
        reproductor.setEditable(false);
        reproductor.setLineWrap(true);
        reproductor.setWrapStyleWord(true);
        
        interior2 = new MyPanel("IconosAplicacion/fondo4.jpg");
        interior2.setPreferredSize(new Dimension(630, 390));
        interior2.setBorder(BorderFactory.createEtchedBorder(1));
        
        interior2sub1 = new MyPanel("IconosAplicacion/fondo5.jpg");
        interior2sub1.setLayout(new BorderLayout());
        interior2sub1.setPreferredSize(new Dimension(550, 120));
        interior2sub1.setBorder(BorderFactory.createTitledBorder("Nivel: PRINCIPIANTE"));
        interior2sub2 = new MyPanel("IconosAplicacion/fondo6.jpg");
        interior2sub2.setLayout(new BorderLayout());
        interior2sub2.setPreferredSize(new Dimension(550, 120));
        interior2sub2.setBorder(BorderFactory.createTitledBorder("Nivel: MEDIO"));
        interior2sub3 = new MyPanel("IconosAplicacion/fondo7.jpg");
        interior2sub3.setLayout(new BorderLayout());
        interior2sub3.setPreferredSize(new Dimension(550, 120));
        interior2sub3.setBorder(BorderFactory.createTitledBorder("Nivel: AVANZADO"));
        
        interior1sub2.add(gatilloTocarCualquierCancion);
        interior1sub2.add(reproductor);
        
        interior2sub1.add(cancion1, BorderLayout.WEST);
        interior2sub1.add(cancion3, BorderLayout.EAST);
        interior2sub2.add(cancion5, BorderLayout.WEST);
        interior2sub2.add(cancion2, BorderLayout.EAST);
        interior2sub3.add(cancion4, BorderLayout.WEST);
        interior2sub3.add(cancion6, BorderLayout.EAST);
        
        interior1.add(interior1sub1);
        interior1.add(interior1sub2);
        
        interior2.add(interior2sub1);
        interior2.add(interior2sub2);
        interior2.add(interior2sub3);
        
        interior2Desplazamiento = new JScrollPane(interior2);
        interior2Desplazamiento.setPreferredSize(new Dimension(650, 345));
        
        mitadInferior.add(interior1);
        mitadInferior.add(interior2Desplazamiento);
    }

    private JButton recuperarBoton(String cadenaParaBoton) {
        switch (cadenaParaBoton) {
            case "do5": return do5;
            case "re5": return re5;
            case "mi5": return mi5;
            case "fa5": return fa5;
            case "sol5": return sol5;
            case "la5": return la5;
            case "si5": return si5;
            case "do6": return do6;
            case "re6": return re6;
            case "mi6": return mi6;
            case "fa6": return fa6;
            case "sol6": return sol6;
            case "la6": return la6;
            case "si6": return si6;
            case "do7": return do7;
            case "doSost5": return doSost5;
            case "reSost5": return reSost5;
            case "faSost5": return faSost5;
            case "solSost5": return solSost5;
            case "laSost5": return laSost5;
            case "doSost6": return doSost6;
            case "reSost6": return reSost6;
            case "faSost6": return faSost6;
            case "solSost6": return solSost6;
            case "laSost6": return laSost6;
        }
        return null;
    }

    private JButton [] casteoArregloStringJButton (String [] arregloACastear) {
        JButton [] arregloCasteado = new JButton [arregloACastear.length];
        for (int i = 0; i < arregloACastear.length; i++) {
            arregloCasteado[i] = recuperarBoton(arregloACastear[i]);
        }
        return arregloCasteado;
    }

    //Clases privadas
    
    private class pianoSonido implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String nombreNota = "";
            //Se busca el archivo de audio dependiendo de la tecla de piano presionada
            if (actionEvent.getSource() == do5) {
                nombreNota = "do5";
            } else if (actionEvent.getSource() == re5) {
                nombreNota = "re5";
            } else if (actionEvent.getSource() == mi5) {
                nombreNota = "mi5";
            } else if (actionEvent.getSource() == fa5) {
                nombreNota = "fa5";
            } else if (actionEvent.getSource() == sol5) {
                nombreNota = "sol5";
            } else if (actionEvent.getSource() == la5) {
                nombreNota = "la5";
            } else if (actionEvent.getSource() == si5) {
                nombreNota = "si5";
            } else if (actionEvent.getSource() == do6) {
                nombreNota = "do6";
            } else if (actionEvent.getSource() == re6) {
                nombreNota = "re6";
            } else if (actionEvent.getSource() == mi6) {
                nombreNota = "mi6";
            } else if (actionEvent.getSource() == fa6) {
                nombreNota = "fa6";
            } else if (actionEvent.getSource() == sol6) {
                nombreNota = "sol6";
            } else if (actionEvent.getSource() == la6) {
                nombreNota = "la6";
            } else if (actionEvent.getSource() == si6) {
                nombreNota = "si6";
            } else if (actionEvent.getSource() == do7) {
                nombreNota = "do7";
            } else if (actionEvent.getSource() == doSost5) {
                nombreNota = "doSost5";
            } else if (actionEvent.getSource() == reSost5) {
                nombreNota = "reSost5";
            } else if (actionEvent.getSource() == faSost5) {
                nombreNota = "faSost5";
            } else if (actionEvent.getSource() == solSost5) {
                nombreNota = "solSost5";
            } else if (actionEvent.getSource() == laSost5) {
                nombreNota = "laSost5";
            } else if (actionEvent.getSource() == doSost6) {
                nombreNota = "doSost6";
            } else if (actionEvent.getSource() == reSost6) {
                nombreNota = "reSost6";
            } else if (actionEvent.getSource() == faSost6) {
                nombreNota = "faSost6";
            } else if (actionEvent.getSource() == solSost6) {
                nombreNota = "solSost6";
            } else if (actionEvent.getSource() == laSost6) {
                nombreNota = "laSost6";
            } else {}
            try {//Se reproduce el archivo de audio
                audioInputStream = AudioSystem.getAudioInputStream(new File("wav/" + nombreNota + ".wav"));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
       
    private class MyPanel extends JPanel{
        private Image img;
        
        public MyPanel(String r) {
            this.img = crearImageIcon(r).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, this);    
        }
    }
    
    private class MyLayeredPane extends JLayeredPane{
        private Image img;
        
        public MyLayeredPane(String r) {
            this.img = crearImageIcon(r).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, this);    
        }
    }
    
    //Metodo main
    
    public static void main(String[] args) {
        new Piano();
    }
}