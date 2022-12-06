import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.lang.Math;

public class Main extends Application 
{ 

    static int factorial(int a)
    {
      if (a == 0)
      {
        return 1;
      }
      else 
      {
        return (a * factorial(a-1));
      }
    }
  
  @Override
  public void start(Stage primaryStage) {
    
    TextField num1;
    TextField num2;
    Button divide;
    Button multiply;
    Button add;
    Button subtract;
    Button clear;
    Button factorial;
    Button exp;
    Label ans;
    Scene scene;
    Scene scene2;
    
    num1 = new TextField();
    num2 = new TextField();

    ans = new Label("?");
    divide = new Button("/");
    multiply = new Button("*");
    add = new Button("+");
    subtract = new Button("-");
    factorial = new Button("!");
    exp = new Button("^");
    clear = new Button("clear");

    clear.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        num1.setText("");
        num2.setText("");
        ans.setText("?");
      }
    });

    add.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        double n1;
        double n2;
        double output;
        
        n1 = Double.parseDouble(num1.getText());
        n2 = Double.parseDouble(num2.getText());
        output = n1 + n2;
        ans.setText("" + output);
      }
    });

    subtract.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        double n1;
        double n2;
        double output;
        
        n1 = Double.parseDouble(num1.getText());
        n2 = Double.parseDouble(num2.getText());
        output = n1 - n2;
        ans.setText("" + output);
      }
    });

    multiply.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        double n1;
        double n2;
        double output;
        
        n1 = Double.parseDouble(num1.getText());
        n2 = Double.parseDouble(num2.getText());
        output = n1 * n2;
        ans.setText("" + output);
      }
    });

    divide.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent e) {
        double n1;
        double n2;
        double output;
        
        n1 = Double.parseDouble(num1.getText());
        n2 = Double.parseDouble(num2.getText());

        if (n2 == 0)
        {
          ans.setText("Cannot divide by 0");
        }
        else
        {
          output = n1 / n2;
          ans.setText("" + output);
        }
      }
    });
    
    factorial.setOnAction(new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent e) {
        double n1;
        double output;

        n1 = Double.parseDouble(num1.getText());

        if (n1 % 1 == 0) 
    		{ 
          int i1 = (int) n1;
    			output = factorial(i1);
          ans.setText("" + output);
    		}
        else
        {
          ans.setText("Input must be integer");
        }
      }
    });

    exp.setOnAction(new EventHandler<ActionEvent>(){
      @Override public void handle(ActionEvent e) {
        double n1;
        double n2;
        double output;

        n1 = Double.parseDouble(num1.getText());
        n2 = Double.parseDouble(num2.getText());

        if (n1 % 1 == 0 && n2 % 1 == 0) 
    		{ 
          int i1 = (int) n1;
          int i2 = (int) n2;
    			output = Math.pow(i1, i2);
          ans.setText(Double.toString(output));
    		}
        else
        {
          ans.setText("Inputs must be integer");
        }
      }
    });
    
    GridPane gp = new GridPane();
    gp.setAlignment(Pos.CENTER);

    gp.setHgap(10);
    gp.setVgap(10);

    gp.add(add, 0, 0);
    gp.add(subtract, 1, 0);
    gp.add(factorial, 2, 0);
    gp.add(multiply, 0, 1);
    gp.add(divide, 1, 1);
    gp.add(exp, 2, 1);
    gp.add(clear, 0, 4, 2, 1);

    gp.add(num1, 0, 2);
    gp.add(num2, 1, 2);
    gp.add(ans, 0, 3, 2, 1);

    add.setPrefWidth(70);
    subtract.setPrefWidth(70);
    multiply.setPrefWidth(70);
    divide.setPrefWidth(70);
    factorial.setPrefWidth(70);
    exp.setPrefWidth(70);
    num1.setPrefWidth(70);
    num2.setPrefWidth(70);
    clear.setPrefWidth(150);
    ans.setPrefWidth(150);

    scene = new Scene(gp, 300, 250);
    
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
   
  public static void main(String[] args) {
    launch(args);
  }
} 
