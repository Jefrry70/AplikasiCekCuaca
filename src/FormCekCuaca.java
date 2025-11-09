import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.json.*;

public class FormCekCuaca extends javax.swing.JFrame {
    
    DefaultTableModel model;
    String apiKey = "19d8fdac9b483d44edb2946a9c739795";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormCekCuaca.class.getName());

    public FormCekCuaca() {
        initComponents();
        model = new DefaultTableModel(new String[]{"Kota", "Cuaca", "Suhu (°C)"}, 0);
        tabelFavorit.setModel(model);
        cmbKota.addItem("Jakarta");
        cmbKota.addItem("Bandung");
        cmbKota.addItem("Surabaya");
    }

    private void getWeatherData(String kota) {
    try {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" 
                + kota + "&appid=" + apiKey + "&units=metric";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        StringBuilder response;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        JSONObject json = new JSONObject(response.toString());
        String cuaca = json.getJSONArray("weather").getJSONObject(0).getString("main");
        double suhu = json.getJSONObject("main").getDouble("temp");

        lblCuaca.setText("Cuaca: " + cuaca + " | Suhu: " + suhu + "°C");

        // Ganti gambar sesuai kondisi
        if (cuaca.contains("Cloud")) {
            lblGambar.setIcon(new ImageIcon(getClass().getResource("/icons/cloudy.png")));
        } else if (cuaca.contains("Rain")) {
            lblGambar.setIcon(new ImageIcon(getClass().getResource("/icons/rainy.png")));
        } else {
            lblGambar.setIcon(new ImageIcon(getClass().getResource("/icons/sunny.png")));
        }

    } catch (IOException | JSONException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengambil data cuaca: " + e.getMessage());
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbKota = new javax.swing.JComboBox<>();
        btnCekCuaca = new javax.swing.JButton();
        lblCuaca = new javax.swing.JLabel();
        lblGambar = new javax.swing.JLabel();
        btnTambahFavorit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelFavorit = new javax.swing.JTable();
        btnSimpanCSV = new javax.swing.JButton();
        btnMuatData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aplikasi Cek Cuaca Sederhana");

        btnCekCuaca.setText("Cek Cuaca");
        btnCekCuaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekCuacaActionPerformed(evt);
            }
        });

        btnTambahFavorit.setText("Favorit");
        btnTambahFavorit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahFavoritActionPerformed(evt);
            }
        });

        tabelFavorit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelFavorit);

        btnSimpanCSV.setText("Simpan CSV");
        btnSimpanCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanCSVActionPerformed(evt);
            }
        });

        btnMuatData.setText("Muat Data");
        btnMuatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuatDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbKota, 0, 149, Short.MAX_VALUE)
                                    .addComponent(lblCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCekCuaca)
                                    .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnSimpanCSV)
                .addGap(38, 38, 38)
                .addComponent(btnTambahFavorit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnMuatData)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekCuaca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGambar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lblCuaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanCSV)
                    .addComponent(btnMuatData)
                    .addComponent(btnTambahFavorit))
                .addContainerGap(203, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekCuacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekCuacaActionPerformed
       String kota = cmbKota.getSelectedItem().toString();
    getWeatherData(kota);
    }//GEN-LAST:event_btnCekCuacaActionPerformed

    private void btnTambahFavoritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahFavoritActionPerformed
       String kota = cmbKota.getSelectedItem().toString();
    String cuaca = lblCuaca.getText();
    model.addRow(new Object[]{kota, cuaca, ""});
    }//GEN-LAST:event_btnTambahFavoritActionPerformed

    private void btnSimpanCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanCSVActionPerformed
       try (FileWriter writer = new FileWriter("favorit.csv")) {
        for (int i = 0; i < model.getRowCount(); i++) {
            writer.write(model.getValueAt(i, 0) + "," +
                         model.getValueAt(i, 1) + "\n");
        }
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke favorit.csv");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
    }
    }//GEN-LAST:event_btnSimpanCSVActionPerformed

    private void btnMuatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuatDataActionPerformed
       try (BufferedReader br = new BufferedReader(new FileReader("favorit.csv"))) {
        String line;
        model.setRowCount(0);
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            model.addRow(data);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
    }
    }//GEN-LAST:event_btnMuatDataActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormCekCuaca().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekCuaca;
    private javax.swing.JButton btnMuatData;
    private javax.swing.JButton btnSimpanCSV;
    private javax.swing.JButton btnTambahFavorit;
    private javax.swing.JComboBox<String> cmbKota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCuaca;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JTable tabelFavorit;
    // End of variables declaration//GEN-END:variables
}