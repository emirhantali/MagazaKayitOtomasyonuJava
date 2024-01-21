import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Emirhan
 */
public class Siparişler extends javax.swing.JFrame {
    DefaultTableModel model;
    DefaultTableModel model1;
   
    public Siparişler() {
        initComponents();
        populateTable();
        populateTable1();
        addComboBoxListener();
        
       
            
    }
    
    
    public void populateStokNoComboBox() throws SQLException {
   
    cmbGetStokNo.removeAllItems(); 
    Connection connection = null;
    Dbhelper dbhelper = new Dbhelper();
    Statement statement = null;
    ResultSet resultSet;

    try {
        connection = dbhelper.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT StokNo FROM Ürünler");

        while (resultSet.next()) {
            int stokNo = resultSet.getInt("StokNo");
            cmbGetStokNo.addItem(String.valueOf(stokNo));
            
            
            
            
        }

    } catch (SQLException exception) {
        dbhelper.showErrorMessage(exception);
    } finally {
        statement.close();
        connection.close();
    }
}
    
    
    

    public void populateTable(){
   
    model = (DefaultTableModel) tblSiparisler.getModel();
    model.setRowCount(0);
    
        try {
            ArrayList<Siparisler> siparisler = getSiparisler();
           
            for (Siparisler siparisler1 : siparisler) {
                Object[] row = {siparisler1.getStokNo1(),
                    siparisler1.getÜrünAdi1(),
                    siparisler1.getBeden1(),
                    siparisler1.getRenk1(),
                    siparisler1.getCinsiyet1(),
                    siparisler1.getSiparisAdedi()};
                model.addRow(row);
            }
            
            
            populateStokNoComboBox();
        } catch (SQLException ex) {
          
        }
    
    
    
    }
    
    
    
    
    
    
    
     public ArrayList<Siparisler> getSiparisler() throws SQLException{
    
        Connection connection = null;
        Dbhelper dbhelper = new Dbhelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Siparisler> siparisler = null;
        
        try {
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select StokNo,ÜrünAdi,Beden,Renk,Cinsiyet,SiparisAdedi from Siparisler");
            siparisler = new ArrayList<Siparisler>();
            while (resultSet.next()) {                
                siparisler.add(new Siparisler(resultSet.getInt("StokNo"),
                        resultSet.getString("ÜrünAdi"),
                        resultSet.getString("Beden"),
                        resultSet.getString("Renk"),
                        resultSet.getString("Cinsiyet"),
                        resultSet.getInt("SiparisAdedi")));
            }
            
        } catch (SQLException exception) {
            
            dbhelper.showErrorMessage(exception);
        }finally{
        
        statement.close();
        connection.close();
        
        }
        return siparisler;
        
        
    }
     
 
    
    
   
    
    public void populateTable1(){
   
    model1 = (DefaultTableModel)tblUrunler.getModel();
    model1.setRowCount(0);
    
        try {
            ArrayList<Urunler> urunler = getUrunler();
           
            for (Urunler urunler1 : urunler) {
                Object[] row = {urunler1.getStokNo(),
                    urunler1.getÜrünAdi(),
                    urunler1.getBeden(),
                    urunler1.getRenk(),
                    urunler1.getCinsiyet(),
                    urunler1.getStokAdedi()};
                model1.addRow(row);
            }
            
        } catch (SQLException ex) {
          
        }
    
    
    
    }
    
    
    
    
    
    public ArrayList<Urunler> getUrunler() throws SQLException{
    
        Connection connection = null;
        Dbhelper dbhelper = new Dbhelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Urunler> urunler = null;
        
        try {
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select StokNo,ÜrünAdi,Beden,Renk,Cinsiyet,StokAdedi from Ürünler");
            urunler = new ArrayList<Urunler>();
            while (resultSet.next()) {                
                urunler.add(new Urunler(resultSet.getInt("StokNo"),
                        resultSet.getString("ÜrünAdi"),
                        resultSet.getString("Beden"),
                        resultSet.getString("Renk"),
                        resultSet.getString("Cinsiyet"),
                        resultSet.getInt("StokAdedi")));
            }
            
        } catch (SQLException exception) {
            
            dbhelper.showErrorMessage(exception);
        }finally{
        
        statement.close();
        connection.close();
        
        }
        return urunler;
        
        
    }
     
     
     
    
  

    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGeriDön = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSiparisler = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUrunler = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbGetStokNo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCinsiyet = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSiparişVer = new javax.swing.JTextField();
        btnSiparişVer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnGeriDön.setBackground(new java.awt.Color(102, 102, 102));
        btnGeriDön.setForeground(new java.awt.Color(255, 255, 255));
        btnGeriDön.setText("GERİ DÖN");
        btnGeriDön.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriDönActionPerformed(evt);
            }
        });

        tblSiparisler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StokNo", "ÜrünAdi", "Beden", "Renk", "Cinsiyet", "SiparisAdedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSiparisler);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("ARA:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        tblUrunler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StokNo", "ÜrünAdi", "Beden", "Renk", "Cinsiyet", "StokAdedi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblUrunler);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("SİPARİŞLER");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("ÜRÜNLER");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("STOKNO :");

        cmbGetStokNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGetStokNoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("ÜRÜN ADI :");

        txtName.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("BEDEN :");

        txtSize.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Renk :");

        txtColor.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Cinsiyet");

        txtCinsiyet.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Sipariş Adedi :");

        btnSiparişVer.setBackground(new java.awt.Color(102, 102, 102));
        btnSiparişVer.setForeground(new java.awt.Color(255, 255, 255));
        btnSiparişVer.setText("SİPARİŞ VER");
        btnSiparişVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiparişVerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("SİPARİŞ VER");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(btnSiparişVer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbGetStokNo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtSiparişVer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addComponent(txtCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGetStokNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSiparişVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSiparişVer)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(26, 26, 26)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGeriDön, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(395, 395, 395))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGeriDön)
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeriDönActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriDönActionPerformed
       AnaForm anaForm = new AnaForm();
        
        this.setVisible(false);
        
        anaForm.setVisible(true);
    }//GEN-LAST:event_btnGeriDönActionPerformed

    private void btnSiparişVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiparişVerActionPerformed

         try {
        
        String secilenStokNo = (String) cmbGetStokNo.getSelectedItem();

       
        String urunAdi = txtName.getText();
        String beden = txtSize.getText();
        String renk = txtColor.getText();
        String cinsiyet = txtCinsiyet.getText();
        int siparisAdedi = Integer.parseInt(txtSiparişVer.getText());

       
        siparisEkle(secilenStokNo, urunAdi, beden, renk, cinsiyet, siparisAdedi);

        
        populateTable();
        populateTable1();
    } catch (SQLException ex) {
        
        ex.printStackTrace(); 
    }


        
        
        
        
        
    }//GEN-LAST:event_btnSiparişVerActionPerformed

    private void cmbGetStokNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGetStokNoActionPerformed
       
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_cmbGetStokNoActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(model);
        
        tblSiparisler.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void addComboBoxListener() {
        
        cmbGetStokNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    String selectedStokNo = (String) cmbGetStokNo.getSelectedItem();
                    fetchAndSetDetails(selectedStokNo);
                } catch (SQLException ex) {
                    
                }
            }
        });
    }
    
    
     private void fetchAndSetDetails(String stokNo) throws SQLException {
        Connection connection = null;
        Dbhelper dbhelper = new Dbhelper();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            String query = "SELECT ÜrünAdi, Beden, Renk, Cinsiyet FROM Ürünler WHERE StokNo = " + stokNo;
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                // Set the values in the text fields
                txtName.setText(resultSet.getString("ÜrünAdi"));
                txtSize.setText(resultSet.getString("Beden"));
                txtColor.setText(resultSet.getString("Renk"));
                txtCinsiyet.setText(resultSet.getString("Cinsiyet"));
            }
        } catch (SQLException exception) {
            dbhelper.showErrorMessage(exception);
        } finally {
            // Close resources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
   

// ...

private void siparisEkle(String stokNo, String urunAdi, String beden, String renk, String cinsiyet, int siparisAdedi) throws SQLException {
    Connection connection = null;
    Dbhelper dbhelper = new Dbhelper();
    PreparedStatement insertStatement = null;
    PreparedStatement updateStatement = null;
    ResultSet resultSet = null;

    try {
        connection = dbhelper.getConnection();
        connection.setAutoCommit(false);

      
        String checkStockQuery = "SELECT StokAdedi FROM Ürünler WHERE StokNo = ?";
        PreparedStatement checkStockStatement = connection.prepareStatement(checkStockQuery);
        checkStockStatement.setString(1, stokNo);
        resultSet = checkStockStatement.executeQuery();

        if (resultSet.next()) {
            int currentStock = resultSet.getInt("StokAdedi");
            if (currentStock < siparisAdedi) {
                // Stoklar tükendi
                JOptionPane.showMessageDialog(this, "Stoklar tükendi. Sipariş verilemiyor.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

       
        String insertQuery = "INSERT INTO Siparisler (StokNo, ÜrünAdi, Beden, Renk, Cinsiyet, SiparisAdedi) VALUES (?, ?, ?, ?, ?, ?)";
        insertStatement = connection.prepareStatement(insertQuery);

        insertStatement.setString(1, stokNo);
        insertStatement.setString(2, urunAdi);
        insertStatement.setString(3, beden);
        insertStatement.setString(4, renk);
        insertStatement.setString(5, cinsiyet);
        insertStatement.setInt(6, siparisAdedi);

        insertStatement.executeUpdate();

      
        String updateQuery = "UPDATE Ürünler SET StokAdedi = StokAdedi - ? WHERE StokNo = ?";
        updateStatement = connection.prepareStatement(updateQuery);

        updateStatement.setInt(1, siparisAdedi);
        updateStatement.setString(2, stokNo);

        updateStatement.executeUpdate();

        connection.commit();
    } catch (SQLException exception) {
        if (connection != null) {
            connection.rollback();
        }
        dbhelper.showErrorMessage(exception);
    } finally {
        if (connection != null) {
            connection.setAutoCommit(true);
        }
        if (insertStatement != null) {
            insertStatement.close();
        }
        if (updateStatement != null) {
            updateStatement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}


    
    
    
    
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
            java.util.logging.Logger.getLogger(Siparişler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Siparişler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Siparişler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Siparişler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Siparişler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeriDön;
    private javax.swing.JButton btnSiparişVer;
    private javax.swing.JComboBox<String> cmbGetStokNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSiparisler;
    private javax.swing.JTable tblUrunler;
    private javax.swing.JTextField txtCinsiyet;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSiparişVer;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
