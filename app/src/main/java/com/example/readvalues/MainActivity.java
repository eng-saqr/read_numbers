package com.example.readvalues;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    TextView textView , textView2  ;
    TextToSpeech textToSpeech ;
    String Arabic , CHINA , English , GERMAN , Italian , France , JAPANESE ;
    static double value ;
    EditText editText ;
    SeekBar seekBar ;
    Spinner spinner ;
    float speed ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editText = findViewById(R.id.editTextNumber);

        spinner = findViewById(R.id.spinner);

        textView = findViewById(R.id.result);

        textView2 = findViewById(R.id.number);

        seekBar = findViewById(R.id.seekBar);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if ( status == TextToSpeech.SUCCESS ){
                    int R = textToSpeech.setLanguage(Locale.ENGLISH);
                    if ( R == TextToSpeech.LANG_MISSING_DATA || R == TextToSpeech.LANG_NOT_SUPPORTED ){
                        Toast.makeText(getApplicationContext() , "Language not supported " , Toast.LENGTH_LONG ).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext() , "Initialized failed " +status, Toast.LENGTH_LONG ).show();
                }
            }
        });

        ArrayAdapter arrayAdapter =  ArrayAdapter.createFromResource(this , R.array.language , R.layout.spinner_color ) ;

        arrayAdapter.setDropDownViewResource(R.layout.spinner_drop_down);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        editText.setHint(R.string.hint);

    }

    private String convertIntoWords(Double str,String language,String Country) {
        Locale local = new Locale(language, Country);
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(local, RuleBasedNumberFormat.SPELLOUT);
        return ruleBasedNumberFormat.format(str);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String number = editText.getText().toString() ;
        if ( position == 1 ) {

            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                Arabic = convertIntoWords(Double.valueOf(value), "ar", "EG");
                textView2.setText(editText.getText().toString());
                editText.setText("");
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView.setText(Arabic);
                textToSpeech.setLanguage(Locale.UK);
                textToSpeech.speak( Arabic , TextToSpeech.QUEUE_FLUSH , null ) ;
            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 2 ) {
            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                English = convertIntoWords(Double.valueOf(value), "en", "US");
                textView.setText(English);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.ENGLISH);
                textToSpeech.speak( English , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 3 ) {
            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                CHINA = convertIntoWords(Double.valueOf(value), "zh", "CHINA");
                textView.setText(CHINA);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.CHINA);
                textToSpeech.speak( CHINA , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 4 ) {
            if(number.trim().length() != 0 ) {
                value = Double.parseDouble(editText.getText().toString());
                Italian = convertIntoWords(Double.valueOf(value), "ita", "ITALIAN");
                textView.setText(Italian);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.ITALIAN);
                textToSpeech.speak( Italian , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 5 ) {

            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                GERMAN = convertIntoWords(Double.valueOf(value), "de", "GERMAN");
                textView.setText(GERMAN);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.GERMAN);
                textToSpeech.speak( GERMAN , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 6 ) {

            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                JAPANESE = convertIntoWords(Double.valueOf(value), "ja", "JAPANESE");
                textView.setText(JAPANESE);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.JAPANESE);
                textToSpeech.speak( JAPANESE , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }

        else if( position == 7  ) {

            if(number.trim().length() != 0 ) {

                value = Double.parseDouble(editText.getText().toString());
                France = convertIntoWords(Double.valueOf(value), "fr", "FRANCA");
                textView.setText(France);
                speed = (float) seekBar.getProgress() / 50 ;
                if ( speed < 0.1 ) speed = 0.1f ;
                textToSpeech.setSpeechRate(speed) ;
                textView2.setText(editText.getText().toString());
                editText.setText("");
                textToSpeech.setLanguage(Locale.FRANCE);
                textToSpeech.speak( France , TextToSpeech.QUEUE_FLUSH , null ) ;

            }
            else {
                editText.setError(getResources().getString(R.string.error_message));
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}