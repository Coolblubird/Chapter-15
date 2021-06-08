import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyEvent;

public class fifteenDashThree extends Application {
	@Override 
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		Circle circ = new Circle(100,100,20);
		Button btn1 = new Button("Up:");
		btn1.setFocusTraversable(false);
		Button btn2 = new Button("Down:");
		btn2.setFocusTraversable(false);
		Button btn3 = new Button("Left:");
		btn3.setFocusTraversable(false);
		Button btn4 = new Button("Right:");
		btn4.setFocusTraversable(false);
		hbox.getChildren().addAll(btn1,btn2,btn3,btn4);
		btn1.setOnAction(e -> {
			if (circ.getCenterY() > 50){
				circ.setCenterY(circ.getCenterY() - 10); 
			}
		});
		btn2.setOnAction(e -> {
			if (circ.getCenterY() < 220){
				circ.setCenterY(circ.getCenterY() + 10); 
			} 
		});
		btn3.setOnAction(e -> {
			if (circ.getCenterX() > 30){
				circ.setCenterX(circ.getCenterX() - 10); 
			}  
		});
		btn4.setOnAction(e -> {
			if (circ.getCenterX() < 190){
				circ.setCenterX(circ.getCenterX() + 10); 
			}  
		});
		
		circ.setOnKeyPressed(e -> {          
			switch (e.getCode()) {
				case DOWN: 
					if (circ.getCenterY() < 220){
						circ.setCenterY(circ.getCenterY() + 10); 
					} 
					break;
				case UP:  
					if (circ.getCenterY() > 50){
						circ.setCenterY(circ.getCenterY() - 10); 
					}  
					break;
				case LEFT: 
					if (circ.getCenterX() > 30){
						circ.setCenterX(circ.getCenterX() - 10); 
					}
					break;
				case RIGHT: 
					if (circ.getCenterX() < 190){
						circ.setCenterX(circ.getCenterX() + 10); 
					}  
			}
		});		
		pane.getChildren().addAll(hbox,circ);

		// Create  scene
		Scene scene = new Scene(pane, 215, 250);
		primaryStage.setTitle("15_03"); 
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false); //dont resize screen
		primaryStage.show(); // final init
		circ.requestFocus();
	}
}