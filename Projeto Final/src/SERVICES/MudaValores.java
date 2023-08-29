package SERVICES;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.*;

public class MudaValores {



    public static String sexoAbreviado(String sexo){
        String sexoAbrev;
        switch (sexo){
            case "Masculino":
                sexoAbrev = "m";
                break;
            case "Feminino":
                sexoAbrev ="f";
                break;
            default:
                sexoAbrev = "";

        }
        return sexoAbrev;
    }

    public static String sexoCompleto(String sexo){
        String sexoString;
        switch (sexo){
            case "m":
                sexoString = "Masculino";
                break;
            case "f":
                sexoString = "Feminino";
                break;
            default:
                sexoString = "";

        }
        return sexoString;
    }

    public static LocalDate stringToLocalDate(String data){
        String[] dataSeparada = data.split("/");
        int dia,mes,ano;

        dia = Integer.parseInt(dataSeparada[0]);
        mes = Integer.parseInt(dataSeparada[1]);
        ano = Integer.parseInt(dataSeparada[2]);

        return LocalDate.of(ano,mes,dia);
    }

    public static java.sql.Date localDateToDate(LocalDate localDate){
        return java.sql.Date.valueOf(localDate);
    }


    public static LocalDate dateToLocalDate(Date data){
        return Date.valueOf(String.valueOf(data)).toLocalDate();
    }

    public static String localDateToString(LocalDate dat){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dat.format(formatador);
    }

    public static double precoToDouble(String preco){
        preco = preco.replaceAll(",",".");
        return Double.parseDouble(preco);
    }


}
