package lcushman.lab02;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DiscountCalculator extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_discount_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.discount_calculator, menu);
		return true;
	}
	
	
	
}
