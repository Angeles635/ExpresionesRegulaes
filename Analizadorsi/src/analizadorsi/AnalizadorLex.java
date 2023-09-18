package analizadorsi;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class AnalizadorLex extends javax.swing.JFrame {

    //Ingresa y devuelve el valor en la interfaz grafica
    public AnalizadorLex() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);

        LookAndFeel aparienciaOriginal = UIManager.getLookAndFeel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtingresar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtConteo = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ANALIZADOR LEXICO");

        txtingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtingresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ingrese la expresión:");

        btnAnalizar.setBackground(new java.awt.Color(255, 102, 102));
        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane1.setViewportView(txtResult);

        txtConteo.setColumns(20);
        txtConteo.setRows(5);
        jScrollPane3.setViewportView(txtConteo);

        jLabel3.setText("Resultado");

        jLabel4.setText("Conteo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(txtingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtingresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(44, 44, 44)
                .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtingresarActionPerformed

    }//GEN-LAST:event_txtingresarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        String entrada = txtingresar.getText();
        Pruebas.lex(entrada);
        ArrayList<Token> tokens = lex(entrada);

        Token enumerador = new Token();

        int number = 0;
        int opr = 0;
        int cons = 0;
        int var = 0;
        int desc = 0;

        String result = "";
        for (Token token : tokens) {
            result = result + token.getTipo() + " : " + token.getValorString() + "\n";

            if (token.getTipo() == enumerador.tipo.NUMERO) {
                number++;
            } else if (token.getTipo() == enumerador.tipo.OPERADOR) {
                opr++;
            } else if (token.getTipo() == enumerador.tipo.CONSTANTE) {
                cons++;
            } else if (token.getTipo() == enumerador.tipo.VARIABLE) {
                var++;
            } else if (token.getTipo() == enumerador.tipo.DESCONOCIDO) {
                desc++;
            }

        }
        this.txtResult.setText(result);
        this.txtConteo.setText("\n" + number + " NUMEROS\n" + opr + " OPERADORES\n" + cons + " CONSTANTE\n" + var + " VARIABLES\n" + desc + " DESCONOCIDOS\n");


    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args
     */
    public static void imain(String args[]) {

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalizadorLex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalizadorLex().setVisible(true);
            }
        });
    }

    public static ArrayList<Token> lex(String entrada) {

        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(entrada);

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean bandera = false;

            for (Token.Tipos tokenTipo : Token.Tipos.values()) {// llamamos a la clase enum para compara los token
                Pattern patron = Pattern.compile(tokenTipo.patron);//asignamos el patron a buscar 
                Matcher busqueda = patron.matcher(palabra);//buscamos el patron (de la clase enum) en la palabra

                if (busqueda.find()) {
                    Token token = new Token();

                    token.setTipo(tokenTipo);
                    token.setValorString(palabra);
                    tokens.add(token);
                    bandera = true;

                }//Cierra if

            }// Cierra for
            if (!bandera) {
                throw new RuntimeException("Token Invalido");
            }
        }// Cierra while

        return tokens;
    }//cierra ArrayList

    public static void main(String args[]) {
        try {
            // Establecer la apariencia
            UIManager.setLookAndFeel(new BernsteinLookAndFeel());

            /* Resto del código para el look and feel Nimbus sigue aquí */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AnalizadorLex().setVisible(true);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtConteo;
    private javax.swing.JTextArea txtResult;
    private javax.swing.JTextField txtingresar;
    // End of variables declaration//GEN-END:variables
}
