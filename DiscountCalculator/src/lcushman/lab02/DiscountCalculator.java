package lcushman.lab02;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/** The style of the ActionListener used to implement this version implements 
the ActionListener in the activity. This avoids the extra class load and object 
allocation.
More Info: <a href="http://developer.android.com/guide/topics/ui/ui-events.html">
Android Developers - UI Events
</a>**/
public class DiscountCalculator extends Activity implements OnEditorActionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discount_calculator);
		
		// Both edit fields utilize the same onEditorAction, which simply means, 
		// if either field is edited, the result TextView will be updated.
		final EditText price_View = (EditText) findViewById(R.id.price_decimalField);
		price_View.setOnEditorActionListener(this);
		
		final EditText discount_View = (EditText) findViewById(R.id.discount_decimalField);
		discount_View.setOnEditorActionListener(this);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discount_calculator, menu);
		return true;
	}
	
	
	@Override
	public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
		try {
			// Get the string held in the price EditText View
			String price_String = ((EditText) findViewById(R.id.price_decimalField)).getText().toString();
			float price = Float.parseFloat(price_String);

			// Get the string held in the discount EditText View
			String discount_string = ((EditText) findViewById(R.id.discount_decimalField)).getText().toString();
			float discount = Float.parseFloat(discount_string); // v is the view
			
			Float result = (price - price*discount/100.0f); // Calculate what you pay 
			
			// format the float to two decimal places
			String result_2dp = new DecimalFormat("##.00").format(result);
			((TextView) findViewById(R.id.result_textView)).setText('$' + result_2dp);
		} catch (Exception e) {
			((TextView) findViewById(R.id.result_textView)).setText("--");
		}
		InputMethodManager imm = (InputMethodManager)getSystemService(
			      Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
		return false; // This will cause the keyboard to hide when 'Done' is clicked
	}
}
