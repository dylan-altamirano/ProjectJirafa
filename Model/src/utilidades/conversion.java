package utilidades;

public class conversion {
    
    
    public conversion() {
    }
    /**
     *Esta funcion permite insertar escapes antes de los guiones en las 
     * cadenas de texto para evitar errores al aceptar estas cadenas.
     * @param cadena
     * @return
     */
    public static String replaceCharactersBeforeDashes(String cadena){
        
       StringBuilder sb = new StringBuilder();
       
       for (int i=0; i<cadena.length(); i++) {
            
            if (cadena.equalsIgnoreCase("-")) {
                sb.append("\\").append(cadena.charAt(i));
            }else{
                sb.append(cadena.charAt(i));
            }
        }
        
        
        return sb.toString();
    }
    
}
