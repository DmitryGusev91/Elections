package View;
//NAME: Dmitry Gusev
//ID:316923200
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Show {
	protected Text txt1;
	protected Text txt2;
	
	
public Show(Stage stage,String str) {
	Group root=new Group();
	txt1=new Text();
	txt1.setFont(new Font(20));
	txt2=new Text();
	txt2.setFont(new Font(50));
	
	
	txt2.setText(str+" Information");
	VBox vb=new VBox();
	vb.getChildren().addAll(txt2,txt1);
	VBox.setMargin(txt2,new Insets(50,0,0,100));
	VBox.setMargin(txt1,new Insets(50,0,0,10));
	root.getChildren().add(vb);
	Scene scene=new Scene(root,800,1000);
	stage.setScene(scene);
	stage.show();
	
}
public void updateText(String str) {
	txt1.setText(str);
}}