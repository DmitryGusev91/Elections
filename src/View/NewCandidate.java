package View;
//NAME: Dmitry Gusev
//ID:316923200
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewCandidate extends NewVoter{
	private Text txt;
	private TextField tfPartyName; 
	
	
public NewCandidate(Stage stage) {
	super(stage);
	txt=new Text("Party name: ");
	txt.setFont(new Font(20));
	tfPartyName=new TextField();
	HBox hb=new HBox();
	setTextField(tfPartyName, txt, hb);
	vb.getChildren().add(hb);
	submit.setLayoutY(450);

}

public String getPartyName() {
	return tfPartyName.getText();
}
}
