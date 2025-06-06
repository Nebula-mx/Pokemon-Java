package com.pokemon.model.pokemon;

import com.pokemon.model.pokemon.abstractTypesClasses.AbstractPokemon;
import java.io.*;

public class Guardado {
    public static void guardarEquipo(AbstractPokemon[] equipo, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(equipo);
            System.out.println("¡Partida guardada en " + rutaArchivo + "!");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static AbstractPokemon[] cargarEquipo(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            return (AbstractPokemon[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return null;
        }
    }
}
