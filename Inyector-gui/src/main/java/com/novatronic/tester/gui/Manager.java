/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 14/09/2010, 05:55:23 PM
 */
package com.novatronic.tester.gui;

import com.novatronic.formatter.FormatterFactory;
import com.novatronic.generator.FrameGenerator;
import com.novatronic.generator.FrameGeneratorFactory;
import com.novatronic.tester.domain.AcquirerConnection;
import com.novatronic.tester.engine.Engine;
import com.novatronic.tester.engine.EngineListener;
import com.novatronic.tester.engine.EngineMode;
import com.novatronic.tester.engine.TestResult;
import com.novatronic.tester.exception.TesterConnectionException;
import com.novatronic.tester.exception.TesterReportException;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.log4j.Logger;

/**
 *
 * @author ofernandez
 */
public class Manager extends javax.swing.JFrame implements ListSelectionListener, EngineListener {
    private static final Logger log = Logger.getLogger(Manager.class);
    private Engine engine;
    private boolean running = false;
    private TestResultTableModel testResultTableModel;
    private FrameGenerator generator;

//    private static final String LOG4J_CONFIG = "log4j.xml";

    /** Creates new form NewJFrame */
    public Manager() {
        try{
            initComponents();
//            DOMConfigurator.configure(LOG4J_CONFIG);
            this.engine = new Engine();
            this.engine.addEngineListener(this);
            this.generator = FrameGeneratorFactory.createFrameGenerator();
            this.generator.setFormatterFactory(new FormatterFactory());
        } catch(Exception ex){
            log.error("Error grave al intentar cargar los recursos para el "
                    + "Inyector", ex);
            this.message.setText("Error grave;" + ex.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jspAcquirers = new javax.swing.JScrollPane();
        acquirerTable = new javax.swing.JTable();
        execStepByStep = new javax.swing.JButton();
        start = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        jspResultTest = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        retrieveAcquirer = new javax.swing.JButton();
        createReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextPane();
        clear = new javax.swing.JButton();
        transferToTest = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        generateFrames = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tester");
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Adquirientes");

        jspAcquirers.setAutoscrolls(true);

        acquirerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "AcquirerName", "Nº Transacc.", "ConnectionMode", "ConnectionType", "Host", "IP", "Port", "ServeAppl", "UserName", "UserPassword"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspAcquirers.setViewportView(acquirerTable);

        execStepByStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fast-forward-icon_24x24.png"))); // NOI18N
        execStepByStep.setText("Paso a Paso");
        execStepByStep.setToolTipText("Ejecutar paso a paso todas las pruebas transferidas");
        execStepByStep.setEnabled(false);
        execStepByStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execStepByStepActionPerformed(evt);
            }
        });

        start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/play-icon_24x24.png"))); // NOI18N
        start.setText("Todos");
        start.setToolTipText("Ejecutar todas las pruebas transferidas");
        start.setEnabled(false);
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/pause-icon_24x24.png"))); // NOI18N
        pause.setText("Pausar");
        pause.setToolTipText("Pausar la ejecución actual");
        pause.setEnabled(false);
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/stop-icon_24x24.png"))); // NOI18N
        stop.setText("Detener");
        stop.setToolTipText("Detener la ejecución de la prueba");
        stop.setEnabled(false);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AcquirerName", "Nº Test", "TestFailled", "TestSucccesfull", "State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspResultTest.setViewportView(resultTable);

        retrieveAcquirer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search-database-icon_24x24.png"))); // NOI18N
        retrieveAcquirer.setText("Obtener Datos");
        retrieveAcquirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retrieveAcquirerActionPerformed(evt);
            }
        });

        createReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/note-edit-icon_24x24.png"))); // NOI18N
        createReport.setText("Generar Reporte");
        createReport.setEnabled(false);
        createReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReportActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Message"));

        message.setBackground(java.awt.SystemColor.control);
        message.setEditable(false);
        message.setForeground(java.awt.SystemColor.activeCaption);
        jScrollPane1.setViewportView(message);

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/note-remove-icon_24x24.png"))); // NOI18N
        clear.setText("Limpiar");
        clear.setEnabled(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        transferToTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/note-accept-icon_24x24.png"))); // NOI18N
        transferToTest.setText("Transferir");
        transferToTest.setEnabled(false);
        transferToTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferToTestActionPerformed(evt);
            }
        });

        resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/skip-forward-icon_24x24.png"))); // NOI18N
        resume.setText("Continuar");
        resume.setToolTipText("Continuar el tipo de prueba actual");
        resume.setEnabled(false);
        resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeActionPerformed(evt);
            }
        });

        generateFrames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/generateFrames_24x24.png"))); // NOI18N
        generateFrames.setText("Generar Tramas");
        generateFrames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateFramesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addComponent(jspAcquirers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                        .addComponent(generateFrames)
                        .addGap(18, 18, 18)
                        .addComponent(retrieveAcquirer))
                    .addComponent(transferToTest, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspResultTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createReport))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(execStepByStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pause)
                        .addGap(10, 10, 10)
                        .addComponent(resume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stop)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(retrieveAcquirer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generateFrames)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspAcquirers, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferToTest)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(execStepByStep)
                    .addComponent(start)
                    .addComponent(pause)
                    .addComponent(stop)
                    .addComponent(resume))
                .addGap(18, 18, 18)
                .addComponent(jspResultTest, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createReport)
                    .addComponent(clear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    private void retrieveAcquirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retrieveAcquirerActionPerformed
        /*0. Deshabilitando botones y limpiando tabla de adquirientes*/
        setButtonsState(true,false,false,false,false,false,false,false,false,false);
        this.clearTableTest();
        
        /* 1. Obtenemos los datos y actualizamos la tabla*/
        Thread searchAcquirers = new Thread() {

            @Override
            public void run() {
                message.setText("Consultando por Adquirientes ...");

                try{
                    /*1. Creamos los datos de la tabla*/
                    AcquirerConnectionTableModel acqTableModel = new AcquirerConnectionTableModel(
                            engine.retrieveAcquirerConnectionList());
                    acquirerTable = new JTable(acqTableModel);
                    acquirerTable.getSelectionModel().addListSelectionListener(getListSelectionListener());
                    jspAcquirers.setViewportView(acquirerTable);
                    acquirerTable.setFillsViewportHeight(true);
                    message.setText("Adquirientes obtenidos");
                } catch(Exception ex){
                    log.error("Error al obtener los adquirientes", ex);
                    message.setText("No fue posible obtener los adquirientes:"
                                    + ex.getMessage());
                } finally{
                    /*2. Habilitamos el boton nuevamente*/
                    setButtonsState(true, true, false, false, false, false,
                                    false, false, false, false);
                }
            }
        };
        searchAcquirers.start();

    }//GEN-LAST:event_retrieveAcquirerActionPerformed

    /**
     * 
     * @param generateFrames Estado del boton generateFrames
     * @param retrieveAdquiriente Estado del boton retrieveAdquiriente
     * @param transferToTest Estado del boton transferToTest
     * @param clear Estado del boton clear
     * @param start Estado del boton start
     * @param stepBystep Estado del boton stepBystep
     * @param pause Estado del boton pause
     * @param resume Estado del boton resume
     * @param stop Estado del boton stop
     * @param report Estado del boton report
     */
    private void setButtonsState(boolean generateFrames, boolean retrieveAdquiriente,
            boolean transferToTest, boolean clear, boolean start,
            boolean stepBystep, boolean pause, boolean resume, boolean stop,
            boolean report){
        this.generateFrames.setEnabled(generateFrames);
        this.retrieveAcquirer.setEnabled(retrieveAdquiriente);
        this.transferToTest.setEnabled(transferToTest);
        this.clear.setEnabled(clear);
        this.start.setEnabled(start);
        this.execStepByStep.setEnabled(stepBystep);
        this.pause.setEnabled(pause);
        this.resume.setEnabled(resume);
        this.stop.setEnabled(stop);
        this.createReport.setEnabled(report);
    }

    private void execStepByStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execStepByStepActionPerformed
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(false,false,false,false,false,false,false,false,true,false);

        this.running = true;

        this.message.setText("Ejecutando pruebas paso a paso ...");
        this.engine.start(this.testResultTableModel.getTestResultList(),
                this.testResultTableModel, true);
    }//GEN-LAST:event_execStepByStepActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(false,false,false,false,false,false,true,false,true,false);

        this.running = true;

        this.message.setText("Ejecutando todos las pruebas ...");
        this.engine.start(this.testResultTableModel.getTestResultList(),
                this.testResultTableModel, false);

    }//GEN-LAST:event_startActionPerformed
    
    private void transferToTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferToTestActionPerformed
        this.message.setText("Transfiriendo adquirientes para pruebas...");
        /*0. Habilitamos botones*/
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(true,true,true,true,true,true,false,false,false,false);

        /*1. Obtenemos la lista de seleccionados*/
        List<AcquirerConnection> acquirerConnectionList = this.engine.getAcquirerConnectionList();
        List<TestResult> testResults = new ArrayList<TestResult>();

        /*2. Creamos los objetos result*/
        for (int i = 0; i < acquirerTable.getSelectedRows().length; i++) {
            int rowNumber = acquirerTable.getSelectedRows()[i];
            AcquirerConnection acquirerConnection = acquirerConnectionList.get(rowNumber);
            TestResult testResult = new TestResult(
                    acquirerConnection.getAcquirerName(),
                    acquirerConnection.getNumberTransactions(),
                    0L,0L,acquirerConnection);
            testResults.add(testResult);
        }
        this.engine.setTestResultList(testResults);

        /*3. Agregamos los datos a la tabla de resultados*/
        this.testResultTableModel = new TestResultTableModel(testResults);
        resultTable = new JTable(testResultTableModel);
        this.jspResultTest.setViewportView(resultTable);
        acquirerTable.setFillsViewportHeight(true);

        this.message.setText("Adquirientes transferidos para test");
    }//GEN-LAST:event_transferToTestActionPerformed

    private void clearTableTest(){
        List<TestResult> testResults = new ArrayList<TestResult>();
        this.engine.setTestResultList(testResults);
        TestResultTableModel testResultTableModelTemp = new TestResultTableModel(testResults);
        resultTable = new JTable(testResultTableModelTemp);
        this.jspResultTest.setViewportView(resultTable);
        acquirerTable.setFillsViewportHeight(true);
    }

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        /* 1. Deshabilitamos los botones*/
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(true,true,true,false,false,false,false,false,false,false);
        
        /* 2. Limpiamos la tabla de test*/
        this.clearTableTest();
        this.message.setText("Se limpió el set de pruebas");
    }//GEN-LAST:event_clearActionPerformed

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(false,false,false,false,false,false,false,true,false,false);
        this.resume.setEnabled(true);
        this.pause.setEnabled(false);

        this.engine.pause();
        this.message.setText("Ejecución pausada");
    }//GEN-LAST:event_pauseActionPerformed

    private void resumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeActionPerformed
        if(this.engine.getExecutionMode() == EngineMode.STEP_BY_STEP){
            //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
            setButtonsState(false,false,false,false,false,false,false,false,true,false);
        } else{
            //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
            setButtonsState(false,false,false,false,false,false,true,false,true,false);
        }

        this.engine.resume();
        this.message.setText("Se continúa con la ejecución");
    }//GEN-LAST:event_resumeActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        this.message.setText("Enviando mensaje de parada");
        this.running = false;
        try{
            this.engine.stop();
            this.message.setText("Ejecución detenida");
        } catch(TesterConnectionException ex){
            log.error("Ejecucion detenida con errores",ex);
            this.message.setText("La ejecución se detuve de manera prematura");
        }
        setButtonsState(true,true,true,true,true,true,false,false,false,true);
        
    }//GEN-LAST:event_stopActionPerformed

    private void createReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReportActionPerformed
        try{
            String pathReport = this.engine.generateReport();
            this.message.setText("Reporte creado: " + pathReport);
        } catch(TesterReportException ex){
            log.error("No se pudo generar el reporte",ex);
            this.message.setText("No fue posible generar el reporte, se generó"
                    + " un problema al intentar crear el archivo");
        }
        
    }//GEN-LAST:event_createReportActionPerformed

    private void generateFramesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateFramesActionPerformed
        /*0. Deshabilitando el boton*/
        this.generateFrames.setEnabled(false);

        Thread generateFramesThread = new Thread(){
            @Override
            public void run(){
                try{
                    String path = generator.generateFrames();
                    message.setText("Transacciones generadas en:" + path);
                }catch(Exception ex){
                    log.error("Hubo un error al generar las transacciones", ex);
                    message.setText("Hubo un error al generar las transacciones:"
                            + ex.getMessage() + ".Causa:" + ex.getCause().getMessage());
                } finally{
                    generateFrames.setEnabled(true);
                }
            }
        };
        generateFramesThread.start();
    }//GEN-LAST:event_generateFramesActionPerformed

    private ListSelectionListener getListSelectionListener() {
        return this;
    }

    @Override
    public void engineStopped() {
        log.debug("Procesando EngineStop, Modo:"+this.engine.getExecutionMode());
        //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
        setButtonsState(true,true,true,true,true,true,false,false,false,true);
        this.running = false;
        this.message.setText("Motor interno envia ejecución detenida");
    }

    @Override
    public void engineStepFinished() {
        log.debug("Procesando StepFinished, Modo:"+this.engine.getExecutionMode());
        if (this.engine.getExecutionMode() == EngineMode.STEP_BY_STEP){
            //retrieveAdq,transfer,clear,start,step,pause,resume,stop,report
            setButtonsState(false,false,false,false,false,false,false,true,true,true);
        }
        this.message.setText("Motor interno envia ejecución fin de paso");
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        if ((acquirerTable.getSelectedRows().length > 0) && (!this.running)){
            this.transferToTest.setEnabled(true);
        } else {
            this.transferToTest.setEnabled(false);
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("resources/LogoNova.gif"));


        return retValue;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            log.error("No se pudo cargar el L&F", ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable acquirerTable;
    private javax.swing.JButton clear;
    private javax.swing.JButton createReport;
    private javax.swing.JButton execStepByStep;
    private javax.swing.JButton generateFrames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jspAcquirers;
    private javax.swing.JScrollPane jspResultTest;
    private javax.swing.JTextPane message;
    private javax.swing.JButton pause;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton resume;
    private javax.swing.JButton retrieveAcquirer;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    private javax.swing.JButton transferToTest;
    // End of variables declaration//GEN-END:variables


}