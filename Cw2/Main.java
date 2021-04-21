/** 
 * 
 * @author Jade
 * This is the main class for the virtual pet
 * This project was created by: 
 * Jade Sumner 24237892
 * Harrison Bell 24533025
 * Lahiru Rajamanthri 24247537
 * Luke Reading 24600849
 */
public class Main {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		Process_View theView = new Process_View();
		Process_Model theModel = new Process_Model();
		Process_Controller theController = new Process_Controller(theView, theModel); // what is this
		theView.setVisible(true);	     
	}  
			
}
