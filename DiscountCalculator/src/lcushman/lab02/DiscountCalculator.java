package lcushman.lab02;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class DiscountCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discount_calculator);
		
		final EditText discount_View = (EditText) findViewById(R.id.discount_decimalField);
		discount_View.setOnEditorActionListener(new OnEditorActionListener(){
			
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				try {
					//get the string from the text box
					float discount = Float.parseFloat(v.getText().toString());
					String price_String = ((EditText) findViewById(R.id.price_decimalField)).getText().toString();
					float price = Float.parseFloat(price_String);
					
					Float result = (price - price*discount/100.0f); 
					// format the float to two decimal places
					String result_2dp = new DecimalFormat("##.00").format(result);
					((TextView) findViewById(R.id.result_textView)).setText('$' + result_2dp);
					//((EditText) findViewById(R.id.discount_decimalField)).requestFocus();
					
					
				} catch (Exception e) {
					((TextView) findViewById(R.id.result_textView)).setText("NOPE!");
					
				}
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discount_calculator, menu);
		return true;
	}
	
	
	
}
