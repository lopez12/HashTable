package hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application{
	
	private Button btnAgregar;
	private Button btnBuscar;
	private Button btnEliminar;
	private Button btnModificar;
	private Button btnLimpiar;
	private TextField tfNombre;
	private TextField tfApellidos;
	private TextField tfDireccion;
	private TextField tfTelefono1;
	private TextField tfTelefono2;
	private StackPane layout;
	private GridPane pane;
	
	public static void main(String...args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Directorio");
		layout = new StackPane();
		agregarBotones();
		agregarCajasTexto();
		agregarManejadores();
		agregarPanel();
		Scene scene = new Scene(layout, 350, 180);
		layout.getChildren().add(pane);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public void agregarBotones(){
		btnAgregar = new Button();
		btnAgregar.setText("Agregar");
		btnAgregar.setPrefSize(80, 20);
		btnBuscar = new Button();
		btnBuscar.setText("Buscar");
		btnBuscar.setPrefSize(80, 20);
		btnEliminar = new Button();
		btnEliminar.setText("Eliminar");
		btnEliminar.setPrefSize(80, 20);
		btnModificar = new Button();
		btnModificar.setText("Modificar");
		btnModificar.setPrefSize(80, 20);
		btnLimpiar = new Button();
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setPrefSize(80, 20);
	}
	
	public void agregarCajasTexto(){
		tfNombre = new TextField();
		tfApellidos = new TextField();
		tfDireccion = new TextField();
		tfTelefono1 = new TextField();
		tfTelefono2 = new TextField();
		
		tfNombre.setPromptText("Ingresa tu nombre.");
		tfApellidos.setPromptText("Ingresa tu apellido.");
		tfDireccion.setPromptText("Ingresa tu direccion.");
		tfTelefono1.setPromptText("Ingresa tu telefono primario.");
		tfTelefono2.setPromptText("Ingresa tu telefono secundario");
	}
	
	public void agregarPanel(){
		//Creating a GridPane container
		pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(5);
		pane.setHgap(5);
		
		tfNombre.setPrefColumnCount(10);
		GridPane.setConstraints(tfNombre, 0, 0);
		pane.getChildren().add(tfNombre);
		
		GridPane.setConstraints(tfApellidos, 0, 1);
		pane.getChildren().add(tfApellidos);

		tfDireccion.setPrefColumnCount(20);
		GridPane.setConstraints(tfDireccion, 0, 2);
		pane.getChildren().add(tfDireccion);
		
		tfTelefono1.setPrefColumnCount(10);
		GridPane.setConstraints(tfTelefono1, 0, 3);
		pane.getChildren().add(tfTelefono1);
		
		tfTelefono2.setPrefColumnCount(10);
		GridPane.setConstraints(tfTelefono2, 0, 4);
		pane.getChildren().add(tfTelefono2);
		
		GridPane.setConstraints(btnAgregar, 1, 0);
		pane.getChildren().add(btnAgregar);

		GridPane.setConstraints(btnBuscar, 1, 1);
		pane.getChildren().add(btnBuscar);
		
		GridPane.setConstraints(btnModificar, 1, 2);
		pane.getChildren().add(btnModificar);
		
		GridPane.setConstraints(btnEliminar, 1, 3);
		pane.getChildren().add(btnEliminar);
		
		GridPane.setConstraints(btnLimpiar, 1, 4);
		pane.getChildren().add(btnLimpiar);		
	}
	
	public void agregarManejadores(){
		btnAgregar.setOnAction(e -> {
			//TODO Implementar algoritmo para agregar
			Persona p = new Persona(tfNombre.getText(),tfApellidos.getText(),tfDireccion.getText(),
					tfTelefono1.getText(),tfTelefono2.getText());
			//TODO change key
			String key = HashTable.generarHash(tfNombre.getText() +  tfApellidos.getText());
			HashTable.agregar(key, p);
			mostrarAlerta(Alert.AlertType.INFORMATION, StageStyle.UTILITY, "Info", 
					"Agregado!", tfNombre.getText() + " " + tfApellidos.getText() + " es parte del directorio!");
		});
		btnBuscar.setOnAction(e -> {
			//TODO Implementar algoritmo de busqueda
			System.out.println("Buscando...");
			Persona p = new Persona();
			p.setNombre(tfNombre.getText());
			p.setApellido(tfApellidos.getText());
			p.setDireccion(tfDireccion.getText());
			p.setTelefono1(tfTelefono1.getText());
			p.setTelefono2(tfTelefono2.getText());
			String key = HashTable.generarHash(tfNombre.getText() +  tfApellidos.getText());
			Persona persona = HashTable.buscar(key, p);
			if(persona == null){
				mostrarAlerta(Alert.AlertType.WARNING, StageStyle.UTILITY, "Warning", "No encontrado!", 
						tfNombre.getText() + " " + tfApellidos.getText() + " no es parte del directorio!");
			}else{
				mostrarAlerta(Alert.AlertType.INFORMATION, StageStyle.UTILITY, "Info", tfNombre.getText() + " " 
						+ tfApellidos.getText(),"Direccion: " + tfDireccion.getText() + "\n" + "Telefono 1: " + 
						tfTelefono1.getText() + "\n" + "Telefono 2: " + tfTelefono2.getText());
			}
		});
		btnModificar.setOnAction(e -> {
			//TODO Implementar algoritmo de modificacion
			System.out.println("Modificando...");
		});
		btnEliminar.setOnAction(e -> {
			Persona p = new Persona();
			p.setNombre(tfNombre.getText());
			p.setApellido(tfApellidos.getText());
			p.setDireccion(tfDireccion.getText());
			p.setTelefono1(tfTelefono1.getText());
			p.setTelefono2(tfTelefono2.getText());
			String key = HashTable.generarHash(tfNombre.getText() +  tfApellidos.getText());
			boolean removido = HashTable.remover(key, p);
			if(removido){
				mostrarAlerta(Alert.AlertType.INFORMATION, StageStyle.UTILITY, "Info", "Eliminado!",
						tfNombre.getText() + " " + tfApellidos.getText() + " ya no es parte del directorio!");
			}else{
				mostrarAlerta(Alert.AlertType.WARNING, StageStyle.UTILITY, "Warning", "No fue posible eliminar!", 
						tfNombre.getText() + " " + tfApellidos.getText() + " no es parte del directorio!");
			}
		});
		btnLimpiar.setOnAction(e -> {
			tfNombre.setText("");
			tfApellidos.setText("");
			tfTelefono1.setText("");
			tfTelefono2.setText("");
			tfDireccion.setText("");
		});
		
	}
	
	public void mostrarAlerta(Alert.AlertType type, StageStyle style, String title, String header, String content){
		Alert alert = new Alert(type);
		alert.initStyle(style);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		
		alert.showAndWait();
	}
	

}
