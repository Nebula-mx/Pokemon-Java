package pokemon;

//para ejecutar el programa usen el comando java -cp compiledFiles pokemon.Main

import pokemon.model.pokemon.instances.Bulbasaur;
import pokemon.model.pokemon.instances.Charmander;
import pokemon.model.pokemon.instances.Squirtle;
import pokemon.ui.application.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

package pokemon;

import pokemon.controller.Batalla;
import pokemon.model.pokemon.instances.Charmander;
import pokemon.model.pokemon.instances.Bulbasaur;
import pokemon.model.pokemon.instances.Squirtle;
import pokemon.utils.Guardado;
import javafx.application.Application;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Inicia JavaFX (tu código original)
        Application.launch(app.class, args);

        // Código nuevo: Menú de consola adicional
        iniciarMenuConsola();
    }

    private static void iniciarMenuConsola() {
        Charmander charmander = new Charmander();
        Bulbasaur bulbasaur = new Bulbasaur();
        Squirtle squirtle = new Squirtle();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ CONSOLA ---");
            System.out.println("1. Ver Pokémon");
            System.out.println("2. Batalla automática");
            System.out.println("3. Guardar partida");
            System.out.println("4. Salir");
            System.out.print("Elige: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    charmander.showInfo();
                    bulbasaur.showInfo();
                    squirtle.showInfo();
                    break;

                case 2:
                    Batalla.iniciar(charmander, squirtle);  // Ejemplo: Charmander vs Squirtle
                    break;

                case 3:
                    AbstractPokemon[] equipo = {charmander, bulbasaur, squirtle};
                    Guardado.guardarEquipo(equipo, "partida.dat");
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
