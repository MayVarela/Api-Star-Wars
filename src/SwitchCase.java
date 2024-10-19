import java.io.IOException;

public class SwitchCase extends ListaDePeliculas {
    public void peliculaStarWar() {
try {

    var peliculaSeleccionada = 0;
    ApiPeliculasStarWars consulta = new ApiPeliculasStarWars();
    GeneradorDeArchivo generador = new GeneradorDeArchivo();
    Pelicula pelicula = null;
    while (peliculaSeleccionada != 9) {
        System.out.println(listaPeliculas);
        peliculaSeleccionada = Integer.valueOf(lectura.nextLine());
        pelicula = consulta.datosApi(peliculaSeleccionada);
        generador.guardarJson(pelicula);

        switch (peliculaSeleccionada) {
            case 1: case 2: case 3: case 4: case 5: case 6:
                System.out.println(pelicula);
                break;
            case 9:
                System.out.println("...");
                System.out.println("Gracias por su visita");
                break;
            default:
                System.out.println("Opcion no disponible");
        }
    }
} catch (NumberFormatException e){
    System.out.println("El programa solo admite el numero de una de las opciones de peliculas "+e.getMessage());
}
catch (RuntimeException | IOException e){
    System.out.println(e.getMessage());
    System.out.println("Entrada erronea, porfavor reinicia el programa y asegurate de escribir una de las opciones.");
}
    }
}