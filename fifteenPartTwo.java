//Jordan Ashe 6-7-21

import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.scene.input.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;


public class fifteenPartTwo extends Application {
	@Override
	public void start(Stage primaryStage){
		Pane pane = new Pane();
		Scene scene = new Scene(pane,400,300);
		
		Rectangle rec = new Rectangle(0,0,25,50);
		rec.setFill(Color.GREEN);
		
		Polygon pent = new Polygon();
		pent.getPoints().addAll(new Double[]{        
			200.0, 50.0, 
			100.0, 150.0, 
			140.0, 250.0,
			260.0, 250.0,  
			300.0, 150.0,
		});
		pent.setFill(Color.WHITE);
		pent.setStroke(Color.BLACK);
		
		pane.getChildren().add(pent);
		pane.getChildren().add(rec);
		
		// path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pent);
		pt.setNode(rec);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play(); 
		
		//fade transition
		FadeTransition ft = new FadeTransition(Duration.millis(3000), pent);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play(); // Start animation
		
		pent.setOnMousePressed(e -> {
			if (e.getButton()==MouseButton.SECONDARY){
				pt.pause();
				ft.pause();
			}
			else{
				pt.play();
				ft.play();
			}
		});
		
		primaryStage.setTitle("15_2"); // Set the stage title
		primaryStage.setScene(scene); 
		primaryStage.setResizable(false); //dont resize screen
		primaryStage.show();
	}
}

