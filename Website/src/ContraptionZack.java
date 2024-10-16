import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.image.Image;




public class ContraptionZack extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage theStage) 
   {
       theStage.setTitle( "Canvas Example" );
            
       Group root = new Group();
       Scene theScene = new Scene( root );
       theStage.setScene( theScene );
            
       Canvas canvas = new Canvas( 400, 200 );
       root.getChildren().add( canvas );
            
       GraphicsContext gc = canvas.getGraphicsContext2D();
            
       gc.setFill( Color.RED );
       gc.setStroke( Color.BLACK );
       gc.setLineWidth(2);
       Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
       gc.setFont( theFont );
       gc.fillText( "Hello, World!", 60, 50 );
       gc.strokeText( "Hello, World!", 60, 50 );
        
       Image earth = new Image( "earth.png" );
       gc.drawImage( earth, 180, 100 );
            
       theStage.show();
   }
}