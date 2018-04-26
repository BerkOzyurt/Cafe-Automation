package coffeetest;

public class Hakkinda extends javax.swing.JFrame {

    public Hakkinda() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kapama = new javax.swing.JLabel();
        Arkaplan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Kapama.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Kapama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KapamaMouseClicked(evt);
            }
        });
        getContentPane().add(Kapama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 40, 50));

        Arkaplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resimler/hakkinda.png"))); // NOI18N
        getContentPane().add(Arkaplan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1067, 531));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void KapamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KapamaMouseClicked
        this.dispose();
    }//GEN-LAST:event_KapamaMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hakkinda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Arkaplan;
    private javax.swing.JLabel Kapama;
    // End of variables declaration//GEN-END:variables
}
