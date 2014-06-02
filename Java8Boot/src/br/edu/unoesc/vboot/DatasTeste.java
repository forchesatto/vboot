package br.edu.unoesc.vboot;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatasTeste {

	/**
	 * Fork de exemplos do livro de Java da casa do código.
	 * https://github.com/peas/java8
	 * @param args
	 */
	public static void main(String[] args) {
		//Antes do Java 8 - String para data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Calendar dataString = new GregorianCalendar();
			dataString.setTime(sdf.parse("31/12/2014"));
			System.out.println(dataString);
		} catch (ParseException e) {

		}

		//Depois do Java 8 - String para data
		LocalDate dataString = LocalDate.parse("31/12/2014",
				ofPattern("dd/MM/yyyy"));
		System.out.println(dataString);

		// incrementando um mês com LocalDate
		LocalDate mesQueVem2 = LocalDate.now().plusMonths(1);
		System.out.println(mesQueVem2);
		
		// decrementando um mês com LocalDate
		LocalDate anoPassado = LocalDate.now().minusYears(1);
		System.out.println(anoPassado);

		// LocalDateTime
		LocalDateTime agora = LocalDateTime.now(); //Hora
		System.out.println(agora);

		// construindo um LocalDateTime a partir de um LocalDate
		LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);
		System.out.println(hojeAoMeioDia);
		
		// construindo um LocalDateTime pela junção de um LocalDate com
		LocalTime agora3 = LocalTime.now();
		LocalDate hoje = LocalDate.now();
		LocalDateTime dataEhora = hoje.atTime(agora3);
		System.out.println(dataEhora);

		// comparações entre datas com os métodos *is*

		LocalDate amanha = LocalDate.now().plusDays(1);

		System.out.println(hoje.isBefore(amanha));
		System.out.println(hoje.isAfter(amanha));
		System.out.println(hoje.isEqual(amanha));

		// diferença de dias com ChronoUnit

		LocalDate agora4 = LocalDate.now();
		LocalDate outraData2 = LocalDate.of(1989, Month.JANUARY, 25);
		long dias2 = ChronoUnit.DAYS.between(outraData2, agora4);

		// diferença de meses e anos

		long meses = ChronoUnit.MONTHS.between(outraData2, agora4);
		long anos = ChronoUnit.YEARS.between(outraData2, agora4);
		System.out.printf("%s dias, %s meses e %s anos", dias2, meses, anos);

		// periodo entre duas datas

		LocalDate outraData3 = LocalDate.of(1989, Month.JANUARY, 25);
		Period periodo = Period.between(outraData3, agora4);
		System.out.printf("%s dias, %s meses e %s anos", periodo.getDays(),
				periodo.getMonths(), periodo.getYears());
	}
}
