package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class QuienesSomos extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        // Crear el contenedor principal
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(20));

        // Crear los textos
        Text titulo = new Text("Quiénes somos:");
        titulo.setFont(new Font("Arial", 36)); // Tamaño grande para el título
        titulo.setTextAlignment(TextAlignment.CENTER);

        Text descripcion = new Text(
                "En Prime-Wheels, somos más que una agencia de autos; somos tu socio en el camino hacia la "
                        + "movilidad de tus sueños.\n\n Desde nuestros inicios, nos hemos comprometido a ofrecer vehículos de calidad, soluciones "
                        + "innovadoras y un servicio excepcional.\n\n"
                        + "Nuestro objetivo es ayudarte a encontrar el auto perfecto que se adapte a tu estilo de vida, "
                        + "presupuesto y necesidades. Con un equipo apasionado y experto, te guiamos en cada paso del proceso, "
                        + "garantizando transparencia y confianza.\n\n"
                        + "Ya sea que busques un auto compacto, un sedán elegante o una SUV robusta, en Prime-Wheels "
                        + "encontrarás opciones que combinan diseño, tecnología y rendimiento.\nVen y descubre la diferencia de ser parte "
                        + "de la familia Prime-Wheels: donde tu satisfacción es nuestra mayor meta."
        );
        descripcion.setFont(new Font("Arial", 30)); // Tamaño moderado para el texto descriptivo
        descripcion.setTextAlignment(TextAlignment.JUSTIFY);
        descripcion.setWrappingWidth(1000); // Ajusta el ancho del texto

        // Colocar elementos en el BorderPane
        BorderPane.setAlignment(titulo, Pos.CENTER);
        borderPane.setTop(titulo);
        borderPane.setCenter(descripcion);

        // Crear la escena y configurarla
        Scene scene = new Scene(borderPane, 1024, 768);
        stage.setMaximized(true);
        stage.setTitle("Quiénes Somos");
        stage.setScene(scene);
        stage.show();
    }
}
