package com.akoele.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeFiles {
    public static void main(String... args){
        Path path = Path.of("files/employe.txt");

        LocalDate dateDebut = LocalDate.parse("2023-11-01");
        LocalDate dateFin = LocalDate.parse("2024-03-12");

        List<Map<LocalDate, Double>> salaires = new ArrayList<>();
        Map<LocalDate, Double> salairesMap = new HashMap<>();

        if(Files.exists(path)){
            try(BufferedReader reader = Files.newBufferedReader(path)) {
                String line = reader.readLine();
                while (line != null){
                    System.out.println("Line "+ line);

                    String[] elements = line.split(";");

                    LocalDate date = LocalDate.parse(elements[1]);
                    Double montant = Double.parseDouble(elements[2]);

                    salairesMap.put(date,montant);
                    salaires.add(salairesMap);


                    line = reader.readLine();


                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        double montantTotal = salaires.stream()
                .flatMap(map -> map.entrySet().stream()) // Aplatir les Maps en un seul Stream
                .filter(map -> map.getKey().isAfter(dateDebut) && map.getKey().isBefore(dateFin)) // Filtrer par date de début
                .map(entry -> entry.getValue()) // Extraire les montants
                .collect(Collectors.summingDouble(montant -> montant)); // Sommer les montants
        System.out.println(montantTotal);
    }


}
