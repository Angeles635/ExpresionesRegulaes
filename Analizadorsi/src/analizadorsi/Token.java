package analizadorsi;

public class Token {
    
    public String valorString;
    public Tipos tipo;

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    enum Tipos{
NUMERO ("[0123456789]+"),
        OPERADOR ("[*|/|+|-]"),
        CONSTANTE("[\bpi\b\be\b]"),
        VARIABLE("[w,x,y,z]"),
        DESCONOCIDO ("[^wxyzpie0123456789*|/+\\\\-]+");
        
        public final String patron;
        
        Tipos(String s){
            this.patron = s;
        
        }//Cierra constructor Tipos
    }//Cierra enum Tipos
    
}