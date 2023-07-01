
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import proyecto2.HistorialABB;
import proyecto2.ReservacionesABB;
import proyecto2.HuespedesTD;
import proyecto2.Cliente;
import proyecto2.Reservacion;

public class Proyecto2GUI extends javax.swing.JFrame {
    
    static HistorialABB historial = new HistorialABB();
    static ReservacionesABB reservaciones = new ReservacionesABB();
    static HuespedesTD huespedes = new HuespedesTD();
    
    public Proyecto2GUI() {      
        cargarArchivo();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public static void cargarArchivo() {
        // Abrir excel para leer la hoja
        File myFile = new File("./src/bookings/Booking_hotel.xlsx");
        
        try {
            FileInputStream fis = new FileInputStream(myFile);
            XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
            DataFormatter dataFormatter = new DataFormatter();
            
            Cell cell;
            
            XSSFSheet hojaActual = myWorkBook.getSheetAt(0);
            for(Row fila : hojaActual) {
                cell = fila.getCell(0);
                String ci = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(1);
                String primer_nombre = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(2);
                String segundo_nombre = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(3);
                String email = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(4);
                String genero = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(5); 
                String tipo_hab = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(6); 
                String celular = dataFormatter.formatCellValue(cell);
                
                cell = fila.getCell(7); 
                String llegada = dataFormatter.formatCellValue(cell);  
                
                cell = fila.getCell(8); 
                String salida = dataFormatter.formatCellValue(cell);  
                
                if(!ci.equals("ci")){
                    reservaciones.insertarReservacion(ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, llegada, salida);
                }
                    
            } 
            
            hojaActual = myWorkBook.getSheetAt(1);
            for(Row fila : hojaActual) {
                cell = fila.getCell(0);
                String num_hab = dataFormatter.formatCellValue(cell);
                
                cell = fila.getCell(1);
                String tipo_hab = dataFormatter.formatCellValue(cell);
                
                cell = fila.getCell(2);
                String piso = dataFormatter.formatCellValue(cell);
   
                if(!num_hab.equals("num_hab")){
                    historial.insertarHabitacion(Integer.parseInt(num_hab), tipo_hab, piso);
                }
            } 
            
            int hab = 0;
            hojaActual = myWorkBook.getSheetAt(2);
            for(Row fila : hojaActual) {
                cell = fila.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                String num_hab = dataFormatter.formatCellValue(cell);
                
                Boolean checked_in;
                if(num_hab.equals("")){
                    checked_in = false;
                } else {
                    checked_in = true;
                }

                cell = fila.getCell(1);
                String primer_nombre = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(2);
                String apellido = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(3);
                String email = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(4);
                String genero = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(5); 
                String celular = dataFormatter.formatCellValue(cell);
                
                cell = fila.getCell(6); 
                String llegada = dataFormatter.formatCellValue(cell);
                
                if(!num_hab.equals("num_hab") && checked_in){
                    historial.ocuparHabitacion( Integer.parseInt(num_hab));
                    huespedes.insertar(hab, "No disponible", primer_nombre, apellido, email, genero, celular, llegada);
                }
                
                hab++;
            } 
            
            hojaActual = myWorkBook.getSheetAt(3);
            for(Row fila : hojaActual) {

                cell = fila.getCell(0);
                String ci = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(1);
                String primer_nombre = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(2);
                String apellido = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(3);
                String email = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(4);
                String genero = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(5); 
                String llegada = dataFormatter.formatCellValue(cell);

                cell = fila.getCell(6); 
                String num_hab = dataFormatter.formatCellValue(cell);  
                
                if(!num_hab.equals("num_hab")){
                    historial.insertarRegistro(Integer.parseInt(num_hab), ci, primer_nombre, apellido, email, genero, llegada);
                }
            } 
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historialArea = new javax.swing.JTextArea();
        numHabText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cedulaText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservacionArea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        nombreHospedado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        numHabText3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ciHospedado1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numHabText4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nombreHospedado2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        numHabText5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Clientes Hospedados");

        jLabel3.setText("<html> Ingrese el número de habitación:  </html>");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Historial de la habitación");

        jLabel5.setText("<html> Ingrese el nombre y apellido del cliente para verificar en que habitación se encuentra:  </html> ");

        historialArea.setEditable(false);
        historialArea.setColumns(20);
        historialArea.setRows(5);
        jScrollPane1.setViewportView(historialArea);

        numHabText.setAutoscrolls(false);
        numHabText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numHabTextActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Búsqueda de reservación");

        jLabel7.setText(" Ingrese la cédula del cliente:");

        cedulaText.setAutoscrolls(false);
        cedulaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedulaTextActionPerformed(evt);
            }
        });

        reservacionArea.setEditable(false);
        reservacionArea.setColumns(20);
        reservacionArea.setRows(5);
        jScrollPane2.setViewportView(reservacionArea);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nombreHospedado.setAutoscrolls(false);
        nombreHospedado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreHospedadoActionPerformed(evt);
            }
        });

        jLabel8.setText("Habitación:");

        numHabText3.setEditable(false);
        numHabText3.setAutoscrolls(false);
        numHabText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numHabText3ActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombre y Apellido:");

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Check In");

        jLabel12.setText("<html> Ingrese la cédula del cliente con reservación para asignarle su habitación:  </html> ");

        jLabel13.setText("Cédula:");

        ciHospedado1.setAutoscrolls(false);
        ciHospedado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciHospedado1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Habitación:");

        numHabText4.setEditable(false);
        numHabText4.setAutoscrolls(false);
        numHabText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numHabText4ActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Check Out");

        jLabel16.setText("<html> Ingrese el nombre y apellido del cliente para liberar su habitación:  </html> ");

        jLabel17.setText("Nombre y Apellido:");

        nombreHospedado2.setAutoscrolls(false);
        nombreHospedado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreHospedado2ActionPerformed(evt);
            }
        });

        jLabel18.setText("Resultado:");

        numHabText5.setEditable(false);
        numHabText5.setAutoscrolls(false);
        numHabText5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numHabText5ActionPerformed(evt);
            }
        });

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numHabText, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                            .addGap(285, 285, 285)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ciHospedado1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numHabText4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(195, 195, 195)
                                            .addComponent(jButton3))
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel15)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nombreHospedado, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel8)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numHabText3))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(jButton1)
                                    .addGap(86, 86, 86)
                                    .addComponent(jScrollPane1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6)
                                                .addComponent(cedulaText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(jButton2)))
                                    .addGap(15, 15, 15)
                                    .addComponent(jScrollPane2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(145, 145, 145)))
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel16)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nombreHospedado2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numHabText5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jButton5)))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addComponent(jSeparator4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreHospedado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHabText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ciHospedado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHabText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreHospedado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHabText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(numHabText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(cedulaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numHabTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numHabTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numHabTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String numHab = numHabText.getText();
        try { 
            String historialHab = historial.obtenerHistorico(Integer.parseInt(numHab));
            historialArea.setText(historialHab);
        } catch(Exception e){
            historialArea.setText("El valor introducido no es un número.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cedulaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedulaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedulaTextActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String ci = cedulaText.getText();
        String info = reservaciones.obtenerInfoReservacion(ci);
        reservacionArea.setText(info);
        cedulaText.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombreHospedadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreHospedadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreHospedadoActionPerformed

    private void numHabText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numHabText3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numHabText3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String llave = nombreHospedado.getText().replaceAll(" ", "");
        int num_hab = huespedes.obtenerNumHab(llave);
        if(num_hab == -1){
            numHabText3.setText("No es un huésped.");
        } else {
            numHabText3.setText(Integer.toString(num_hab));
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ciHospedado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciHospedado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciHospedado1ActionPerformed

    private void numHabText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numHabText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numHabText4ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String ci = ciHospedado1.getText().replaceAll(" ", "");
        Reservacion r = reservaciones.obtenerReservacion(ci);
        if(r == null){
            numHabText4.setText("No tiene reservación.");
        } else {
            reservaciones.eliminarReservacion(ci);
            int num_hab = historial.obtenerHabitacionLibre(r.getTipoHab());
            historial.ocuparHabitacion(num_hab);
            huespedes.insertar(num_hab, r.getCi(), r.getNombre(), r.getApellido(), r.getEmail(), r.getGenero(), r.getCelular(), r.getLlegada());
            numHabText4.setText( Integer.toString(num_hab));
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nombreHospedado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreHospedado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreHospedado2ActionPerformed

    private void numHabText5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numHabText5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numHabText5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String llave = nombreHospedado2.getText().replaceAll(" ", "");
        Cliente c = huespedes.obtenerCliente(llave);
        if(c == null){
            numHabText5.setText("No es un huésped.");
        } else {
            int num_hab = huespedes.eliminar(llave);
            historial.liberarHabitacion(num_hab);
            numHabText5.setText("Se liberó la habitación " + Integer.toString(num_hab) + ".");
            historial.insertarRegistro(num_hab, c.ci, c.primer_nombre, c.apellido, c.email, c.genero, c.llegada);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Proyecto2GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto2GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto2GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto2GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyecto2GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedulaText;
    private javax.swing.JTextField ciHospedado1;
    private javax.swing.JTextArea historialArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField nombreHospedado;
    private javax.swing.JTextField nombreHospedado2;
    private javax.swing.JTextField numHabText;
    private javax.swing.JTextField numHabText3;
    private javax.swing.JTextField numHabText4;
    private javax.swing.JTextField numHabText5;
    private javax.swing.JTextArea reservacionArea;
    // End of variables declaration//GEN-END:variables
}
