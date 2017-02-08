package css.cis3334.tipcalcrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements updateViewInterface {
    // Declare needed varaiable for widgets
    EditText etBill;
    TextView tvTotalTip;
    TextView tvTipPerPerson;
    CheckBox cbService;
    RadioButton rb1, rb2, rb3;
    CalculatorInterface tipCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (EditText) findViewById(R.id.editTextBill);
        tvTotalTip = (TextView) findViewById(R.id.textViewTotalTip);
        tvTipPerPerson = (TextView) findViewById(R.id.textViewTipPerPerson);
        cbService = (CheckBox) findViewById(R.id.checkBoxService);
        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        tipCalc = new TipCalculator(this);                  // instatiate the tip calculator
    }

    public void onClickButtonCalc(View view) {
        //This is a comment
        Double bill = Double.parseDouble( etBill.getText().toString() );
        int numPeople = 1;
        if (rb2.isChecked()) {
            numPeople = 2;
        } else if (rb3.isChecked()) {
            numPeople = 3;
        }
        tipCalc.calculate(bill, numPeople, cbService.isChecked());
    }

    @Override
    public void updateView(Double totalTip, Double tipPerPerson) {
        tvTotalTip.setText( "Total Tip: " + totalTip.toString());
        tvTipPerPerson.setText( "Tip per Person: " + tipPerPerson.toString());
    }
}
