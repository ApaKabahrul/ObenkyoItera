package itera.obenkyoitera;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TranslateActivity extends AppCompatActivity {

    TextView langCode_1;
    TextView langCode_2;

    TextView inputText;
    TextView resultTr;

    String languagePair;

    Context context = this;

    AsyncTask<String, Void, String> translationResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        langCode_1 =(TextView)findViewById(R.id.lang_1);
        langCode_2 =(TextView)findViewById(R.id.lang_2);

        inputText = (EditText)findViewById(R.id.data);
        resultTr = (TextView)findViewById(R.id.result);

        langCode_1.setText(R.string.ID);
        langCode_2.setText(R.string.JA);

        //String textToBeTranslated = "Saya"; //String yang akan ditranslate
        languagePair = "id-ja";

        //Executing the translation function

        //Translate(textToBeTranslated,languagePair);
    }

    void Translate(String textToBeTranslated,String languagePair){
        TranslatorBackgroundTask translatorBackgroundTask= new TranslatorBackgroundTask(context);
        translationResult = translatorBackgroundTask.execute(textToBeTranslated,languagePair); // Returns the translated text as a String
        Log.d("Translation Result", String.valueOf(translationResult)); // Logs the result in Android Monitor
    }

    public void tukar(View view) {
        if (langCode_1.getText().toString().equals("Bahasa Indonesia") ){
            langCode_2.setText(R.string.ID);
           langCode_1.setText(R.string.JA);
            languagePair = "ja-id";
        }
        else {
            langCode_2.setText(R.string.JA);
            langCode_1.setText(R.string.ID);
            languagePair = "id-ja";
        }
    }

    public void doTranslation(View view) {
        String abc = inputText.getText().toString();
        Translate(abc,languagePair);
    }
}
