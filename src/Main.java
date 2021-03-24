
/**
 * @author Lahiru Rajamanthri
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Process_View theView = new Process_View();
		Process_Model theModel = new Process_Model();
		Process_Controller theController = new Process_Controller(theView, theModel);
		
		theView.setVisible(true);	     
	}  
			
}
