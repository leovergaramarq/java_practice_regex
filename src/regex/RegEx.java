package regex;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    
    public static void main(String[] args) {
        /*
        LinkedList<String> DNIs=new LinkedList();
        DNIs.add("12345678");
        DNIs.add("12345678A");
        DNIs.add("12345678a");
        DNIs.add("12345678H");
        DNIs.add("12345678ñ");
        DNIs.add("12345678Ñ");
        DNIs.add("12345678aBc");
        DNIs.add("1234567aBc");
        DNIs.add("12345678aB");
        
        DNIs.forEach((DNI) -> {
            System.out.println(DNI+":\t"+validarDNI(DNI));
        });
        System.out.println("");
        
        LinkedList<String> nombres=new LinkedList();
        nombres.add("Juan");
        nombres.add("Juan Carlos");
        nombres.add("Juan Carlos Mendoza");
        nombres.add("Juan Carlos Mendoza Palacio");
        nombres.add("Francisco Antonio Machado Mota Castro Trincao");
        nombres.add("Juan ");
        nombres.add(" Juan");
        nombres.add("JuanCarlos");
        nombres.add("Ju");
        nombres.add("Ju Carlos");
        nombres.add("JuCarlos");
        nombres.add(" Johan Lapuerta");
        nombres.add(" Johan Lapuerta ");
        nombres.add("Johan Lapuerta ");
        
        for (String nombre : nombres) {
            System.out.println(nombre+": "+validarNombre(nombre));
        }
        
        System.out.println("");
        */
        LinkedList<String> expressions=new LinkedList();
        expressions.add("mun");
        expressions.add("hola");
        expressions.add("Hola");
        expressions.add(" ");
        expressions.add("[ghj][oiu][jkl][abc]");
        expressions.add("[gHj][oiu][jkl][abc]");
        expressions.add("Hola mundo Cruel");
        expressions.add("a m");
        expressions.add("[(a-z) | (0-9)]");
        expressions.add("[(a-z)|(0-9)]");
        expressions.add("[a-z0-9]");
        expressions.add("[^0-9]");
        expressions.add("[ab] [km]");
        expressions.add("a|b");
        expressions.add("[a|b]");
        expressions.add("a&b");
        expressions.add("[a&b]");
        expressions.add("h&o");
        expressions.add("^a");
        expressions.add(".");
        expressions.add("[m|s]undo");
        
        for(String e: expressions){
            System.out.println(e+": "+findCoincidence("Hola mundo cruel!", e));
        }
        
    }
    
    static boolean validarDNI(String DNI){
        //  "" (:v)
        //  ^$ (inicio, fin)
        //  [] (rango)
        //  {} (veces)
        //  + ({1,})
        //  * ({0,})
        //  ? (opcional)
        //  ^ (not)
        return DNI.matches("^[0-9]{8}([(A-Z)|(a-z)]{1,2})?$");
    }
    
    static boolean validarNombre(String nombre){
        return nombre.matches("^[A-Z][a-z]+([ ][A-Z][a-z]+)+$");
    }
    
    static boolean findCoincidence(String cadena, String input){
        Pattern pattern=Pattern.compile(input);
        Matcher matcher=pattern.matcher(cadena);
        
        return matcher.find();
    }
}