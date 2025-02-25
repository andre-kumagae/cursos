package academy.devdojo.maratonajava.javacore.Rdatas.test;

import academy.devdojo.maratonajava.javacore.Gassociacao.dominio.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
//      Objeto > string = formatter
        LocalDate localDate = LocalDate.now();
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("s1 = " + s1);
//      string > objeto = parse
        LocalDate parseBasicIso = LocalDate.parse("20250203", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("parseBasicIso = " + parseBasicIso);

        String s2 = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println("s2 = " + s2);
        LocalDate parseIsoDate = LocalDate.parse(s2, DateTimeFormatter.ISO_DATE);
        System.out.println("parseIsoDate = " + parseIsoDate);

        String s3 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("s3 = " + s3);
        LocalDate parseIsoLocalDate = LocalDate.parse(s3, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("parseIsoLocalDate = " + parseIsoLocalDate);
//      metodo para padrão de data diferente
        DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String DataBrString = localDate.format(formatoBr);
        System.out.println("DataBrString = " + DataBrString);
//      aceita localizacao tbm
        DateTimeFormatter formatoUs = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.US);
        String DatauString = localDate.format(formatoUs);
        System.out.println("DatauString = " + DatauString);


    }
}
