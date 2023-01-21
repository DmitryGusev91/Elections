package View;
//NAME: Dmitry Gusev
//ID:316923200
import java.util.List;
import java.util.Random;

import id316923200.ListOfParties;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Results {
	private Group root;
	private int red,green,blue;

		
public Results(Stage stage,List<Integer>list,int day,int month,int year,ListOfParties partyList) {
	root=new Group();
	
	Text txt=new Text("The Results Of Election "+day+"\\"+month+"\\"+year+" ARE :");
	txt.setFont(new Font(40));
	Text txt1=new Text("Thatnk you for participating in my little project");
	txt1.setFont(new Font(20));
	HBox hb1=new HBox();

	

	for(int i=0;i<partyList.getSize();i++) {
		Rectangle rect=new Rectangle(50+i*30,50,50,list.get(i)*50);
		
		Text txt2=new Text(partyList.getObject(i).getName());
		
		Random r = new Random();
		red = r.nextInt(256);
		green = r.nextInt(256);
		blue = r.nextInt(256);
		
		rect.setFill(Color.rgb(red, green, blue));
		VBox vb1=new VBox();
		vb1.getChildren().addAll(txt2,rect);
		
		hb1.getChildren().add(vb1);
		hb1.setAlignment(Pos.CENTER_LEFT);
		HBox.setMargin(vb1, new Insets(0,20,10,20));
	

	}
	
	
	
	VBox vb=new VBox();
	vb.getChildren().addAll(txt,hb1,txt1);
	VBox.setMargin(hb1, new Insets(70,10,10,10));
	VBox.setMargin(txt1, new Insets(50,10,10,10));
	
	root.getChildren().addAll(vb);
	Scene scene = new Scene(root, 800, 600);
	stage.setScene(scene);
	stage.show();
}
}
