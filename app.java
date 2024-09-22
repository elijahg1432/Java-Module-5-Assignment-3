//program created by elijah gonzalez, septemer 22nd 2024

//first we must import the nececessary javafx utilities
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//where all of the magic is done, in the class named app. by the by, i kept them all app because i have a template and i dont want to keep remaking it everytime.
//either or, this class will make a circle that the user can slide bars that represent different colors and opacities
public class app extends Application {

    //we set our inital red and green value
    private int redValue = 0;
    private int greenValue = 0;

    //we also set blue, but set it to 255, so it shows up blue.
    private int blueValue = 255; 

    //we also have an opacitiy value, which we set to one, which is full opacity
    private double opacityValue = 1.0; 

    //we have to create our stage to display our gui too
    @Override
    public void start(Stage primaryStage) {

        //this pane will hold our scroll bars and the circle to test the colors on
        Pane pane = new Pane();
        
        ///we create our circle at 200, 150, with a radius of 50px
        Circle circle = new Circle(200, 150, 50);

        //we fill the circle with these specific colors, which were initially definied at line 17
        circle.setFill(Color.rgb(redValue, greenValue, blueValue)); 

        //we do the same with our opacity value
        circle.setOpacity(opacityValue); 
        
        //we create a new scroll bar with the red value we will be using for our circle. we repeat this process a couple times 
        ScrollBar redBar = new ScrollBar();

        //we set the minimum red color value, which is 0
        redBar.setMin(0);  
        
        //we set the max red color value, which is 255
        redBar.setMax(255); 

        //we have our intial red value
        redBar.setValue(redValue);  

        //then, we set the X position of the scrollbar
        redBar.setLayoutX(100);  

        //next, we set the Y position of our scrollbar. these will be different which each bar, so they are not overlapping each other.
        redBar.setLayoutY(250);  

        //then we set our width
        redBar.setPrefWidth(200); 

        //we create a label for the bar as well, which is red.
        Text redLabel = new Text(20, 265, "Red");

        //we do all the same with blue as we did with red, but for blue
        ScrollBar blueBar = new ScrollBar();
        blueBar.setMin(0);  
        blueBar.setMax(255); 
        blueBar.setValue(blueValue); 
        blueBar.setLayoutX(100);  

        //though we change the Y position, so that the bars are not overlapping
        blueBar.setLayoutY(275);  
        blueBar.setPrefWidth(200); 

        //we set the position and label, as well blue
        Text blueLabel = new Text(20, 290, "Blue");

        //we do all the same, one last time, but with green.
        ScrollBar greenBar = new ScrollBar();
        greenBar.setMin(0);  
        greenBar.setMax(255);  
        greenBar.setValue(greenValue);  
        greenBar.setLayoutX(100);  
        greenBar.setLayoutY(300);  
        greenBar.setPrefWidth(200); 
        Text greenLabel = new Text(20, 315, "Green");

        //this time we have to create a bar for opacity, which is similar, but with a couple key differences.
        ScrollBar opacityBar = new ScrollBar();

        //we still set our min to 0, which is fully transparent.
        opacityBar.setMin(0);

        //however, we set max instead to 1, instead of 255, which makes it fully visible
        opacityBar.setMax(1); 
        
        //everything else is handled the same
        opacityBar.setValue(opacityValue);  
        opacityBar.setLayoutX(100); 
        opacityBar.setLayoutY(325);
        opacityBar.setPrefWidth(200);  
        Text opacityLabel = new Text(20, 340, "Opacity");

        //this is where we change red's value based off of where the red bar is in the scroll bar.
        redBar.valueProperty().addListener((obs, oldValue, newValue) -> {

            //once the bar is changed, the red value is updated.
            redValue = newValue.intValue();  
            
            //then we set the new color
            circle.setFill(Color.rgb(redValue, greenValue, blueValue)); 
        });

        //we do the same with blue...
        blueBar.valueProperty().addListener((obs, oldValue, newValue) -> {
            blueValue = newValue.intValue();  
            circle.setFill(Color.rgb(redValue, greenValue, blueValue)); 
        });

        //and green.
        greenBar.valueProperty().addListener((obs, oldValue, newValue) -> {
            greenValue = newValue.intValue(); 
            circle.setFill(Color.rgb(redValue, greenValue, blueValue)); 
        });

        //opacitiy is set similarily, except
        opacityBar.valueProperty().addListener((obs, oldValue, newValue) -> {

            //we use a double value instead
            opacityValue = newValue.doubleValue();  
            circle.setOpacity(opacityValue);  
        });

        //we add everything from above to the pane
        pane.getChildren().addAll(circle, redBar, blueBar, greenBar, opacityBar, redLabel, blueLabel, greenLabel, opacityLabel);

        //we set up our scene now, too.
        Scene scene = new Scene(pane, 400, 370); 

        //and title it something appropriate
        primaryStage.setTitle("Adjust circle colors and opacity with scroll bars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //then we run the java fx application 
    public static void main(String[] args) {
        launch(args); 
    }
}
