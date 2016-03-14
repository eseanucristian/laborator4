package lab04.pdsd.systems.cs.pub.ro.contactsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactsManagerActivity extends ActionBarActivity {


    private KeypadButtonClickListener buttonClickListener = new KeypadButtonClickListener();

    private class KeypadButtonClickListener implements View.OnClickListener {

        @Override
        @SuppressWarnings("all")
        public void onClick(View view) {

            if (view instanceof Button) {
                if (((Button) view).getId() == R.id.button) {

                    String addFields = ((Button) view).getText().toString();
                    String tmp = new String(addFields);


                    if (tmp.contains("Show")) {
                        EditText jobtitle = (EditText) findViewById(R.id.jobtitle);
                        jobtitle.setVisibility(View.VISIBLE);
                        EditText website = (EditText) findViewById(R.id.website);
                        website.setVisibility(View.VISIBLE);
                        EditText im = (EditText) findViewById(R.id.im);
                        im.setVisibility(View.VISIBLE);
                        EditText company = (EditText) findViewById(R.id.company);
                        company.setVisibility(View.VISIBLE);
                        addFields = addFields.replace("Show","Hide");
                        ((Button) view).setText(addFields.toCharArray(),0,addFields.length());
                    }else{
                        EditText jobtitle = (EditText) findViewById(R.id.jobtitle);
                        jobtitle.setVisibility(View.INVISIBLE);
                        EditText website = (EditText) findViewById(R.id.website);
                        website.setVisibility(View.INVISIBLE);
                        EditText im = (EditText) findViewById(R.id.im);
                        im.setVisibility(View.INVISIBLE);
                        EditText company = (EditText) findViewById(R.id.company);
                        company.setVisibility(View.INVISIBLE);
                        addFields = addFields.replace("Hide","Show");
                        ((Button) view).setText(addFields.toCharArray(),0,addFields.length());
                    }
                }
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);
        Button showadditional = (Button)findViewById(R.id.button);
        showadditional.setOnClickListener(buttonClickListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case 10:
                setResult(RESULT_OK, new Intent());
                finish();
                break;
        }
    }
}
