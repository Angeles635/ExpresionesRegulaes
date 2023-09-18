package analizadorsi;

import analizadorsi.Token.Tipos; //impotacion del enum Tipo
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pruebas {
    
    public static void main(String[] args) {
        
    
        String entrada = "";
        
        ArrayList<Token> tokens = lex(entrada);
        
        Token enumerador = new Token();
        
        
        int number = 0;
        int opr = 0;
        int cons = 0;
        int var = 0;
        int desc = 0;
 
        
        for (Token token : tokens) {
            System.out.println(token.getTipo()+ " : " + token.getValorString());
           
            
            if (token.getTipo() == enumerador.tipo.NUMERO) {
                number++;
            }else if (token.getTipo() == enumerador.tipo.OPERADOR) {
                opr++;
            }else if (token.getTipo() == enumerador.tipo.CONSTANTE) {
                cons++;
            }else if (token.getTipo() == enumerador.tipo.VARIABLE) {
                var++;
            }else if (token.getTipo() == enumerador.tipo.DESCONOCIDO) {
                desc++;
            }
           
        }
        
        System.out.println("Hay: \n" + number + " NUMEROS\n" + opr +" OPERADORES\n"+ cons + " CONSTANTE\n" + var +" VARIABLES\n"+ desc +" DESCONOCIDOS\n");
        
    }
    
    public static ArrayList<Token> lex(String entrada){
    
        final ArrayList<Token> tokens = new ArrayList<>();
        final StringTokenizer st = new StringTokenizer(entrada );
        
        while (st.hasMoreTokens()) {  
            String palabra = st.nextToken();
            boolean bandera = false;
            
            for (Tipos tokenTipo : Tipos.values()) {// llamamos a la clase enum para compara los token
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
            
    
}