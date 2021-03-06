



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;


import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dani
 */
public class VentanaPaint extends javax.swing.JFrame {

    
    
    
    
    /**
     * Creates new form VentanaPaint
     */
    //creamos una variable de tipo linea para guardar la linea que dibuja el usuario.
    private Line2D.Double linea = new Line2D.Double();
     //creamos una variable de tipo circulo para guardar el circulo que dibuja el usuario.
    private Ellipse2D.Double circulo;
     //creamos una variable de tipo rectangulo para guardar el rectangulo que dibuja el usuario.
    private Rectangle2D.Double rectangulo;
   

   
    //en una variable de tipo BufferedImage puedo almacenar una imagen.
    private BufferedImage buffer;
    //variables de posicion
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double inicioX;
    private double inicioY;
    
    
    //determina si la figura se rellena o no
    private int relleno;
    
    
    //almacena el color seleccionado
    Color colorSeleccionado = Color.black;
    //imagenes de los cursores goma y lapiz
    private Image img,img2;
    private Cursor cursorLapiz,cursorGoma;
    //determina el tipo de cursor correspondiente en cada caso
    int seleccionCursor = 0;
    //determina la forma geometrica o estilo de pintado que se va a efectuar
    int opcionForma = 0;
    //usado para determinar el tipo de trazo
    String estados = "";
    
 
    private Graphics2D g4;
    private Graphics2D g2;
     
    public VentanaPaint() {
       //variables de tipo linea, rectangulo y circulo
       linea = new Line2D.Double();
        circulo = new Ellipse2D.Double();
        rectangulo = new Rectangle2D.Double();

        //inicializacion del buffer
         buffer = null;
       //ponemos las imagenes del cursor con sus correspondientes cursores
        img = Toolkit.getDefaultToolkit().createImage("src/1423070099_editor_pencil_pen_edit_write-32.png");
        cursorLapiz = Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(0, 25), "img");
        img2 = Toolkit.getDefaultToolkit().createImage("src/1423069882_eraser.png");
        cursorGoma = Toolkit.getDefaultToolkit().createCustomCursor(img2, new Point(0, 25), "img2");
       
        
        initComponents();
       
       
        //variables que miden el tamaño del jPanel
        int anchoPanel = jPanel1.getWidth();
        int altoPanel = jPanel1.getHeight();

        //enlazo el buffer al jPanel 
        buffer = (BufferedImage) jPanel1.createImage(anchoPanel, altoPanel);
        
        Graphics2D g3 = buffer.createGraphics();
        
        //le damos color blanco al Panel
        g3.setColor(Color.white);
        g3.fillRect(0, 0, anchoPanel, altoPanel);
        
        g2 = (Graphics2D) jPanel1.getGraphics();
        g4 = (Graphics2D) buffer.getGraphics();
        
        
    }
    
    @Override
    public void paint(Graphics g) {
        //llamo al paintComponents de la clase jFrame para qie se pinten bien los objetos de la aplicacion
        super.paintComponents(g);

       // a continuación apunto al jPanel
        Graphics2D g2 = (Graphics2D) jPanel1.getGraphics();

       // pinto el buffer sobre el jPanel
       g2.drawImage(buffer, 0, 0, null);
       
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        BotonAceptarColor = new javax.swing.JButton();
        BotonCancelarColor = new javax.swing.JButton();
        jDialog2 = new javax.swing.JDialog();
        SliderAncho = new javax.swing.JSlider();
        BotonOKAncho = new javax.swing.JButton();
        BotonCancelarAncho = new javax.swing.JButton();
        BotonAplicarAncho = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jDialog3 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        BotonColor = new javax.swing.JButton();
        BolorLapiz = new javax.swing.JButton();
        BotonCuadrado = new javax.swing.JButton();
        BotonGrosor = new javax.swing.JButton();
        BotonLinea = new javax.swing.JButton();
        BotonNuevo = new javax.swing.JButton();
        BotonCirculo = new javax.swing.JButton();
        estado = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        BotonGoma = new javax.swing.JButton();
        BotonGuardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        jDialog1.setResizable(false);
        jDialog1.setType(java.awt.Window.Type.UTILITY);

        BotonAceptarColor.setText("Aceptar");
        BotonAceptarColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonAceptarColorMousePressed(evt);
            }
        });

        BotonCancelarColor.setText("Cancelar");
        BotonCancelarColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCancelarColorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(BotonAceptarColor)
                        .addGap(18, 18, 18)
                        .addComponent(BotonCancelarColor)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelarColor)
                    .addComponent(BotonAceptarColor)))
        );

        jDialog2.setTitle("tipo");
        jDialog2.setMinimumSize(new java.awt.Dimension(510, 220));
        jDialog2.setResizable(false);

        SliderAncho.setMajorTickSpacing(5);
        SliderAncho.setMaximum(50);
        SliderAncho.setMinorTickSpacing(1);
        SliderAncho.setPaintLabels(true);
        SliderAncho.setPaintTicks(true);
        SliderAncho.setSnapToTicks(true);
        SliderAncho.setValue(5);

        BotonOKAncho.setText("ok");
        BotonOKAncho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonOKAnchoMousePressed(evt);
            }
        });

        BotonCancelarAncho.setText("Cancelar");
        BotonCancelarAncho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCancelarAnchoMousePressed(evt);
            }
        });

        BotonAplicarAncho.setText("Aplicar");
        BotonAplicarAncho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonAplicarAnchoMousePressed(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setName(""); // NOI18N

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SliderAncho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(BotonAplicarAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCancelarAncho))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonOKAncho)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(SliderAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonOKAncho)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelarAncho)
                    .addComponent(BotonAplicarAncho))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setPreferredSize(new java.awt.Dimension(778, 400));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 3, 770, 660));

        BotonColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsz_1rsz_1423068917_color.png"))); // NOI18N
        BotonColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonColorMousePressed(evt);
            }
        });
        getContentPane().add(BotonColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 180, 40, 40));

        BolorLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423070099_editor_pencil_pen_edit_write-32.png"))); // NOI18N
        BolorLapiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BolorLapizMousePressed(evt);
            }
        });
        getContentPane().add(BolorLapiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 40, 40));

        BotonCuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423068527_ic_crop_square_48px-32.png"))); // NOI18N
        BotonCuadrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCuadradoMousePressed(evt);
            }
        });
        getContentPane().add(BotonCuadrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 80, 40, 40));

        BotonGrosor.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        BotonGrosor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423069442_line_width.png"))); // NOI18N
        BotonGrosor.setText("Grosor");
        BotonGrosor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonGrosor.setMaximumSize(new java.awt.Dimension(97, 73));
        BotonGrosor.setMinimumSize(new java.awt.Dimension(97, 73));
        BotonGrosor.setPreferredSize(new java.awt.Dimension(97, 73));
        BotonGrosor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonGrosor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGrosorMousePressed(evt);
            }
        });
        getContentPane().add(BotonGrosor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 230, 90, 80));

        BotonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423069711_line.png"))); // NOI18N
        BotonLinea.setMaximumSize(new java.awt.Dimension(65, 41));
        BotonLinea.setMinimumSize(new java.awt.Dimension(65, 41));
        BotonLinea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonLineaMousePressed(evt);
            }
        });
        getContentPane().add(BotonLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 40, 40));

        BotonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423489881_new10-32.png"))); // NOI18N
        BotonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonNuevoMousePressed(evt);
            }
        });
        getContentPane().add(BotonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 370, 40, 40));

        BotonCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423068469_check-circle-outline-blank-24.png"))); // NOI18N
        BotonCirculo.setMaximumSize(new java.awt.Dimension(65, 41));
        BotonCirculo.setMinimumSize(new java.awt.Dimension(65, 41));
        BotonCirculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonCirculoMousePressed(evt);
            }
        });
        getContentPane().add(BotonCirculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 40, 40));

        estado.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Liso", "Punteada", "Rayada", "Mixta" }));
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 320, 90, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 360, 100, 10));

        BotonGoma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423069882_eraser.png"))); // NOI18N
        BotonGoma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGomaMousePressed(evt);
            }
        });
        getContentPane().add(BotonGoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 130, 40, 40));

        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423489857_save.png"))); // NOI18N
        BotonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BotonGuardarMousePressed(evt);
            }
        });
        getContentPane().add(BotonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 370, 40, 40));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 100, 10));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423068527_ic_crop_square_48px-32.png"))); // NOI18N
        jButton1.setText("Rellenar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 90, 65));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       
        
      //cuando es una linea
      if(opcionForma==0){
          //se toma el punto inicial
        linea.x1 =evt.getX();
        linea.y1 =evt.getY();
      }
      //cuando la opcion es libre o goma
         if( opcionForma==1 || opcionForma==4){
             //se toma el punto inicial
          x1 =evt.getX();
          y1 =evt.getY();
      }
        //cuando la opcion es un circulo
        if(opcionForma==2){
                circulo.x = evt.getX();
                circulo.y = evt.getY();
                // se toma el centro del circulo
                inicioX = circulo.x;
                inicioY = circulo.y;
       }
        //cuando la opcion es un rectangulo
        if(opcionForma==3){
            //se toma la esquina superior izquierda, o inferior derecha
        inicioX = evt.getX();
                inicioY = evt.getY();
                rectangulo.x = inicioX;
                rectangulo.y = inicioY;
        }
        
        
        
    }//GEN-LAST:event_jPanel1MousePressed
     
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
     
        

      //borro el jPanel con lo que hay en el buffer
        //esto se hace para que no se pinte por donde pasa la figura
        g2.drawImage(buffer, 0, 0, null);
        
        
       
      
       
       
        
       
        
         //*para hacer linea discontinua
        String stringLinea = (estado.getSelectedItem().toString());
        //cuando la linea elegida es Lisa
        if (stringLinea.equals("Liso")){
         //se usa para darle el grosor deseado a la linea, segun el valor del Slider
         g2.setStroke(new BasicStroke(SliderAncho.getValue()));
        }
         //cuando la linea elegida es Mixta
        if(stringLinea.equals("Mixta")){
            //datos de como se quiere que se pinte la linea
            float dash[] = {21.0f,9.0f,3.0f,9.0f};
            g2.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
      
       
        }
         //cuando la linea elegida es Punteada
        if(stringLinea.equals("Punteada")){
            float dash[] = {5.0f,5.0f};
            g2.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
        
        
        }
         //cuando la linea elegida es Rayada
        if(stringLinea.equals("Rayada")){
            float dash[] = {21.0f,9.0f};
            g2.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
       
        }
        //*
         
        //se selecciona el color
         g2.setColor(colorSeleccionado);
         
         //---------LINEA----------
         
         //cuando la forma es igual a linea
        if(opcionForma==0){
            //se toman los dos puntos en los que se encuentra el cursor 
        linea.x2 =evt.getX();
        linea.y2 =evt.getY();
        //se pinta la linea
        g2.draw(linea);
       }
        
         //---------LIBRE Y GOMA----------
        //cuando la forma es igual a libre o goma
       if(opcionForma==1 || opcionForma==4){
           //cuando es goma, se le ajusta el color y el tamaño
          if (opcionForma==4){
              g4.setStroke(new BasicStroke(SliderAncho.getValue()+20));
            g4.setColor(Color.WHITE);
           }else{
            //devuelve el color y ancho que se tenia escogido 
              g4.setColor(colorSeleccionado);
                g4.setStroke(new BasicStroke(SliderAncho.getValue()));
          }
            //se toma la posicion del cursor
                x2 = evt.getX();
                y2 = evt.getY();
                //cuando x1 no es igual a x2 o y1 no es igual a y2
                //significa que ha movido el cursor
                if (x1 != x2 || y1 != y2) {
                    g4.drawLine(x1, y1, x2, y2);
                    //se iguala para luego poder volver a comprobar el if
                    y1 = y2;
                    x1 = x2;
                }
       }
        //---------CIRCULO----------
       if(opcionForma==2){
       double radio,d1,d2;
                d1 = evt.getX() - inicioX;
                if (d1 < 0) {
                    d1 = inicioX - evt.getX();
                }
                d2 = evt.getY() - inicioY;
                if (d2 < 0) {
                    d2 = inicioY - evt.getY();
                }
                radio = pow(d1, 2) + pow(d2, 2);
                if (radio < 0) {
                    radio = radio * -1;
                }
                radio = sqrt(radio);
                circulo.x = inicioX - radio;
                circulo.y = inicioY - radio;
                circulo.height = radio * 2;
                circulo.width = circulo.height;
                g2.draw(circulo);
       }
         //---------RECTANGULO----------
       if(opcionForma==3){
        if (evt.getX() > inicioX) {
            rectangulo.width = evt.getX() - rectangulo.x;
        } else {
            rectangulo.x = evt.getX();
            rectangulo.width = inicioX - rectangulo.x;
        }
        if (evt.getY() > inicioY) {
            rectangulo.height = evt.getY() - inicioY;
        } else {
            rectangulo.y = evt.getY();
            rectangulo.height = inicioY - rectangulo.y;
        }
        g2.draw(rectangulo);
        }
        
        
        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
         
        //*para hacer linea discontinua
         String stringLinea = (estado.getSelectedItem().toString());
         //cuando la linea elegida es Lisa
        if (stringLinea.equals("Liso")){
            //se usa para darle el grosor deseado a la linea, segun el valor del Slider
         g4.setStroke(new BasicStroke(SliderAncho.getValue()));
        }
        //cuando la linea elegida es Mixta
        if(stringLinea.equals("Mixta")){
            float dash[] = {21.0f,9.0f,3.0f,9.0f};
        g4.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
        }
        //cuando la linea elegida es Punteada
        if(stringLinea.equals("Punteada")){
            float dash[] = {5.0f,5.0f};
        g4.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
        }
        //cuando la linea elegida es Rayada
        if(stringLinea.equals("Rayada")){
            float dash[] = {21.0f,9.0f};
        g4.setStroke(new BasicStroke(SliderAncho.getValue(),BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f, dash,0.0f));
        }
        //se selecciona el color 
        g4.setColor(colorSeleccionado);
        //*
        
        
        
        //---------LINEA----------
        if(opcionForma==0){
        //se pinta la linea
       g4.draw(linea);
        
        }
        //---------LIBRE Y GOMA----------
        if(opcionForma==1 || opcionForma==4){
            //cuando es goma, se le ajusta el color y el tamaño
           if (opcionForma==4){
            g4.setColor(Color.WHITE);
           }else{//devuelve el color que se tenia escogido 
               g4.setColor(colorSeleccionado);
           } 
           //se pinta la linea
         g4.drawLine(evt.getX(), evt.getY(), evt.getX(), evt.getY());
         
        }
        //---------CIRCULO----------
         if(opcionForma==2){
       g4.draw(circulo);
       //en el caso de que el relleno sea 1, se rellena la figura
       //PD:lo he puesto solo en el Mouse released porque me parece que queda mejor
       if(relleno==1){
          g4.fill(circulo);
         }
       }
         //---------RECTANGULO----------
         if(opcionForma==3){
         g4.draw(rectangulo);
         //en el caso de que el relleno sea 1, se rellena la figura
         //PD:lo he puesto solo en el Mouse released porque me parece que queda mejor
         if(relleno==1){
          g4.fill(rectangulo);
          
         }
         
        }
         
        
        
        
        
       //vuelvo a apuntar al jPanel
       g2 = (Graphics2D) jPanel1.getGraphics();
       
       
       //borro el jPanel con lo que hay en el buffer
       g2.drawImage(buffer, 0, 0, null);
       	
        
         
    }//GEN-LAST:event_jPanel1MouseReleased

    private void BotonColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonColorMousePressed
      //hacemos visible el jDialog1
        jDialog1.setVisible(true);
    }//GEN-LAST:event_BotonColorMousePressed

    private void BotonAceptarColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAceptarColorMousePressed
      // selecciona color de la paleta
        colorSeleccionado = jColorChooser1.getColor();
        //hacemos invisible el jDialog1
       jDialog1.setVisible(false);
    }//GEN-LAST:event_BotonAceptarColorMousePressed

    private void BotonCancelarColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCancelarColorMousePressed
       //hacemos invisible el jDialog1
        jDialog1.setVisible(false);
    }//GEN-LAST:event_BotonCancelarColorMousePressed

    private void BotonGrosorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGrosorMousePressed
       //hacemos visible el jDialog2
        jDialog2.setVisible(true);
       
       
    }//GEN-LAST:event_BotonGrosorMousePressed

    private void BotonOKAnchoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOKAnchoMousePressed
          //usado para darle el valor encontrado en el textField al Slider
        int anchoLinea = Integer.parseInt(jTextField1.getText());
      SliderAncho.setValue(anchoLinea);
    }//GEN-LAST:event_BotonOKAnchoMousePressed

    private void BotonCancelarAnchoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCancelarAnchoMousePressed
        //hacemos invisible el jDialog2
        jDialog2.setVisible(false);
    }//GEN-LAST:event_BotonCancelarAnchoMousePressed

    private void BotonAplicarAnchoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAplicarAnchoMousePressed
          //hacemos invisible el jDialog2
        jDialog2.setVisible(false);
        
    }//GEN-LAST:event_BotonAplicarAnchoMousePressed

    private void BotonGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGuardarMousePressed
     int seleccion = jFileChooser1.showSaveDialog(this);
        jFileChooser1.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = jFileChooser1.getSelectedFile();
            
            try {
                ImageIO.write(buffer, "png", jFileChooser1.getSelectedFile());
               
            } catch (IOException ex) {
                Logger.getLogger(VentanaPaint.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Save as file: ");
        }
    }//GEN-LAST:event_BotonGuardarMousePressed

    private void BotonNuevoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonNuevoMousePressed
        int ancho = jPanel1.getWidth();
        int alto = jPanel1.getHeight();
        
        //se colorea un rectangulo del tamaño del jPanel1 de color blanco para borrarlo todo
         g4.setColor(Color.white);
	g4.fillRect(0, 0, ancho, alto);
        g2 = (Graphics2D) jPanel1.getGraphics();
        g2.drawImage(buffer, 0, 0, null);
    }//GEN-LAST:event_BotonNuevoMousePressed

    private void BolorLapizMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BolorLapizMousePressed
       //se le otorga 1 para que el cursor cambie a la forma lapiz
        seleccionCursor = 1;
        //se otorga 1 para que pinte dibujo libre
        opcionForma = 1;
    }//GEN-LAST:event_BolorLapizMousePressed

    private void BotonCuadradoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCuadradoMousePressed
       //cursor por defecto
        seleccionCursor = 0;  
        //rectangulos
        opcionForma=3;
    }//GEN-LAST:event_BotonCuadradoMousePressed

    private void BotonGomaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonGomaMousePressed
      //se le otorga 2 para que el cursor cambie a la forma goma
        seleccionCursor = 2; 
        //se otorga 4 para hacerlo tipo goma
       opcionForma=4;
    }//GEN-LAST:event_BotonGomaMousePressed

    private void BotonLineaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLineaMousePressed
      //cursor por defecto
        seleccionCursor = 0; 
        //linea
       opcionForma = 0;
    }//GEN-LAST:event_BotonLineaMousePressed

    private void BotonCirculoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCirculoMousePressed
        //cursor por defecto
        seleccionCursor = 0; 
        //circulo
        opcionForma = 2;
    }//GEN-LAST:event_BotonCirculoMousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
      //boton que rellena las figuras
        //cuando es 1 se devuelve 0 y cuando es 0 se devuelve 1,
        //esto se hace para que el mismo boton active y desactive el relleno
        if(relleno==1){
       relleno=0;
       //imagen del boton (vacio)
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423068527_ic_crop_square_48px-32.png")));
       }else{
        relleno = 1;
        //imagen del boton (relleno)
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1423068527_ic_crop_square_48px-322.0.png")));
       }
    }//GEN-LAST:event_jButton1MousePressed

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
      //cuando sale del jPanel se pone la flecha como cursor
        setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
      
        switch (seleccionCursor){
           //cursor por defecto
           case 0:setCursor(Cursor.CROSSHAIR_CURSOR);break;
           //cursor lapiz
           case 1:setCursor(cursorLapiz);break;
           //cursor goma
           case 2:setCursor(cursorGoma);break;
           
       }
      
       
    }//GEN-LAST:event_jPanel1MouseEntered

    
   
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BolorLapiz;
    private javax.swing.JButton BotonAceptarColor;
    private javax.swing.JButton BotonAplicarAncho;
    private javax.swing.JButton BotonCancelarAncho;
    private javax.swing.JButton BotonCancelarColor;
    private javax.swing.JButton BotonCirculo;
    private javax.swing.JButton BotonColor;
    private javax.swing.JButton BotonCuadrado;
    private javax.swing.JButton BotonGoma;
    private javax.swing.JButton BotonGrosor;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonLinea;
    private javax.swing.JButton BotonNuevo;
    private javax.swing.JButton BotonOKAncho;
    private javax.swing.JSlider SliderAncho;
    public static javax.swing.JComboBox estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
