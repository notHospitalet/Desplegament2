package com.Adrian;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        File json = new File("./src/main/resources/json/archivo.json");
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("src/main/resources/archivos/config.ini")) {
            props.load(fis);

            String nomConfig = props.getProperty("nombre");
            String temaConfig = props.getProperty("tema");

            ObjectMapper mapper = new ObjectMapper();
            Cine cine = mapper.readValue(json, Cine.class);

            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setPrefix("templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode(TemplateMode.HTML);
            resolver.setCharacterEncoding("UTF-8");

            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(resolver);

            Context context = new Context();
            context.setVariable("nombre", nomConfig);
            context.setVariable("tema", temaConfig);
            context.setVariable("cine", cine.getGeneros());

            String writeIndex = templateEngine.process("indice", context);
            System.out.println(writeIndex);
            escribirHTML(writeIndex, "src/main/resources/generados/index.html");

            List<Genero> generos = cine.getGeneros();
            for (Genero genero : generos) {
                context.setVariable("genero", genero);
                String generoTemplate = templateEngine.process("genero", context);
                String generoFile = "src/main/resources/generados/generos/" + genero.getNombre().replaceAll("\\s+", "_") + ".html";
                escribirHTML(generoTemplate, generoFile);

                for (Pelicula pelicula : genero.getPeliculas()) {
                    context.setVariable("pelicula", pelicula);
                    context.setVariable("genero", genero);
                    String peliculaTemplate = templateEngine.process("pelicula", context);
                    String peliculaFile = "src/main/resources/generados/peliculas/" + pelicula.getTitulo().replaceAll("\\s+", "_") + ".html";
                    escribirHTML(peliculaTemplate, peliculaFile);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirHTML(String html, String fileName) {
        File file = new File(fileName);
        file.getParentFile().mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}