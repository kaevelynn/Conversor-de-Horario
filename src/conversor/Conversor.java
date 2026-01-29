package conversor;
// System.out.println("Retorna Valor : " + String.valueOf(numero));

/* CHARTA
 * String nomeCurso = "JAVA";

if(nomeCurso.charAt(1) == ‘A’) {
    System.out.println(“O caractere A está na posição 1”);
}
 */

public class Conversor {
    public static String ConverterHorario(String horario) {

        try {
            horario = horario.toUpperCase();
            horario = horario.trim();
            if (horario.contains("AM") || horario.contains("PM")) {
                // conversão de 12 para 24
                String retiraPmAm = horario.replace("AM", "").replace("PM", "").trim();

                String[] partes = retiraPmAm.split(":");
                int hora = Integer.parseInt(partes[0]);
                int minuto = Integer.parseInt(partes[1]);
                int segundo = Integer.parseInt(partes[2]);

                if (hora < 0 || hora > 12 || minuto < 0 || minuto > 59 || segundo < 00 || segundo > 59) {
                    return "Erro: Horario invalido";

                }

                // USANDO FOR - MÉDIO
                if (horario.contains("PM")) {

                    for (int i = 1; i <= 12; i++) {

                        if (hora == i) {
                            hora += 12;
                            if (hora < 12) {
                                System.err.println("Hora invalida, mude a opção (HORA)");
                            }
                            if (hora == 24) {
                                hora = 00;
                            }
                        }
                    }
                }
                if (horario.contains("AM")) {

                    for (int i = 1; i <= 12; i++) {

                        if (hora == i) {
                            hora += 0;
                        }
                    }
                }

                String convertido = String.format("%02d:%02d:%02d", hora, minuto, segundo);
                System.out.println("Horário convertid:" + convertido);
                return convertido;

            } else {
                String[] partes = horario.split(":");

                int hora = Integer.parseInt(partes[0]);
                int minuto = Integer.parseInt(partes[1]);
                int segundo = Integer.parseInt(partes[2]);

                String periodo = "";// peridoo

                for (int i = 13; i <= 23; i++) {// foda

                    if (hora == i) {
                        hora -= 12;
                        periodo = "PM";
                    }
                }
                if (hora == 12) {
                    periodo = "PM";// bug de merda
                }

                if (hora == 0) {
                    hora = 12;
                    periodo = "AM";
                }

                for (int i = 1; i <= 11; i++) {
                    if (hora == i) {
                        periodo = "AM";
                    }
                }

                String convertido = String.format("%02d:%02d:%02d %s", hora, minuto, segundo, periodo);
                System.out.println("Horário convertid:" + convertido);
                return convertido;

                // conversao de 24 para 12

            }
        } catch (Exception e) {
            System.out.println("erro na conversao");
            return "Erro ao converter: " + e.getMessage();
        }
    }

}
