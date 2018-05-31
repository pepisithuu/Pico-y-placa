/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pico.y.placa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author jpena
 */
public class DatosConsulta {
    private String numero; /**/
    private String fecha; /*Formato DD/MM/AAAA*/
    private String hora; /*Formato HH:mm*/

    public DatosConsulta(String numero, String fecha, String hora) {
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String calculate() throws ParseException{        
        /*Obtener último dífito de la placa*/
        int nfinal = numero.length() - 1;
        
        /*Saber el día con la fecha*/
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatodia = new SimpleDateFormat("EEEE");
        Date d = formatofecha.parse(fecha);
        String dia = formatodia.format(d);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        
        /*Verificar hora*/
        boolean com = true;
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm");
        Date nhora = formatohora.parse(hora);
        Date primerahora = formatohora.parse("07:00");
        Date segundahora = formatohora.parse("09:00");
        Date tercerahora = formatohora.parse("16:00");
        Date cuartahora = formatohora.parse("19:30");
        
        String resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + " PUEDE CIRCULAR LIBREMENTE";
        
        if(nhora.getTime() < primerahora.getTime())
        {
            com = false;
        }
        if( nhora.getTime() > segundahora.getTime() && nhora.getTime() < tercerahora.getTime())
        {
            com = false;
        }
        if(nhora.getTime() > cuartahora.getTime())
        {
            com = false;
        }
        
        /*Comprobar circulación*/
        switch(dia){
            case "lunes":
                if (Integer.parseInt(""+numero.charAt(nfinal)) == 1 || Integer.parseInt(""+numero.charAt(nfinal)) == 2){
                    if(com == true){
                        resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + " NO PUEDE CIRCULAR LIBREMENTE";
                    }
                }
                break;
            case "martes":
                if (Integer.parseInt(""+numero.charAt(nfinal)) == 3 || Integer.parseInt(""+numero.charAt(nfinal)) == 4){
                    if(com == true){
                        resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + "  NO PUEDE CIRCULAR LIBREMENTE";
                    }
                }
                break;
            case "miércoles":
                if (Integer.parseInt(""+numero.charAt(nfinal)) == 5 || Integer.parseInt(""+numero.charAt(nfinal)) == 6){
                    if(com == true){
                        resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + " NO PUEDE CIRCULAR LIBREMENTE";
                    }
                }
                break;
            case "jueves":
                if (Integer.parseInt(""+numero.charAt(nfinal)) == 7 || Integer.parseInt(""+numero.charAt(nfinal)) == 8){
                    if(com == true){
                        resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + " NO PUEDE CIRCULAR LIBREMENTE";
                    }
                }
                break;
            case "viernes":
                if (Integer.parseInt(""+numero.charAt(nfinal)) == 9 || Integer.parseInt(""+numero.charAt(nfinal)) == 0){
                    if(com == true){
                        resultado = "El día " + dia + " " + c.get(Calendar.DAY_OF_MONTH) + " del mes " + c.get(Calendar.MONTH) + " NO PUEDE CIRCULAR LIBREMENTE";
                    }
                }
            break;
        }
        return resultado;
    }
    
}
