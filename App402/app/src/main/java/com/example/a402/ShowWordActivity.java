package com.example.a402;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import edu.cmu.pocketsphinx.Assets;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.RecognitionListener;
import edu.cmu.pocketsphinx.SpeechRecognizer;
import edu.cmu.pocketsphinx.SpeechRecognizerSetup;
import pl.droidsonroids.gif.GifImageButton;

public class ShowWordActivity extends Activity implements RecognitionListener  {

    /* Named searches allow to quickly reconfigure the decoder */
    private static final String KAMYAK_SEARCH = "acoustic_model";

    /* Used to handle permission request */
    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1;

    private SpeechRecognizer recognizer;
    private HashMap<String, Integer> captions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Prepare the data for UI
        captions = new HashMap<>();
        captions.put(KAMYAK_SEARCH, R.string.kamyaks_caption);
        setContentView(R.layout.show_word);

        ((TextView) findViewById(R.id.test_level_at)).setText("แบบฝึกหัดชุดที่ "+(Main2Activity.currentLevel+1));
        ((TextView) findViewById(R.id.word_at)).setText("คำที่ "+(Main2Activity.currentWord+1));

        if(Main2Activity.currentLevel == 0){
            ((TextView) findViewById(R.id.give_word))
                    .setText(getResources()
                            .getStringArray(R.array.level_1)[Main2Activity.currentWord]);
        }
        else if(Main2Activity.currentLevel == 1){
            ((TextView) findViewById(R.id.give_word))
                    .setText(getResources()
                            .getStringArray(R.array.level_2)[Main2Activity.currentWord]);
        }
        else if(Main2Activity.currentLevel == 2){
            ((TextView) findViewById(R.id.give_word))
                    .setText(getResources()
                            .getStringArray(R.array.level_3)[Main2Activity.currentWord]);
        }

        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSIONS_REQUEST_RECORD_AUDIO);
            return;
        }

    }

    private static class SetupTask extends AsyncTask<Void, Void, Exception> {
        WeakReference<ShowWordActivity> activityReference;
        SetupTask(ShowWordActivity activity) {
            this.activityReference = new WeakReference<>(activity);
        }
        @Override
        protected Exception doInBackground(Void... params) {
            try {
                Assets assets = new Assets(activityReference.get());
                File assetDir = assets.syncAssets();
                activityReference.get().setupRecognizer(assetDir);
            } catch (IOException e) {
                return e;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Exception result) {
            if (result != null) {
                ((TextView) activityReference.get().findViewById(R.id.give_word))
                        .setText("Failed to init recognizer " + result);
            } else {
                activityReference.get().switchSearch(KAMYAK_SEARCH);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_RECORD_AUDIO) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Recognizer initialization is a time-consuming and it involves IO,
                // so we execute it in async task
                new SetupTask(this).execute();
            } else {
                finish();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (recognizer != null) {
            recognizer.cancel();
            recognizer.shutdown();
        }
    }

    /**
     * In partial result we get quick updates about current hypothesis. In
     * keyword spotting mode we can react here, in other modes we need to wait
     * for final result in onResult.
     */
    @Override
    public void onPartialResult(Hypothesis hypothesis) {
        if (hypothesis == null)
            return;

        String text = hypothesis.getHypstr();
    }

    @Override
    public void onResult(Hypothesis hypothesis) {
        if (hypothesis == null)
            return;

        String result[] = (hypothesis.getHypstr()).split(" ");
        while(result == null){
            switchSearch(KAMYAK_SEARCH);
        }

        String resultWord = result[0];
        //send to showpoint
        Intent intent = new Intent( ShowWordActivity.this, ShowPointActivity.class);
        intent.putExtra("resultWord", resultWord);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBeginningOfSpeech() {

    }

    /** We stop recognizer here to get a final result */
    @Override
    public void onEndOfSpeech() {
//        if (!recognizer.getSearchName().equals(KAMYAK_SEARCH))
//            switchSearch(KAMYAK_SEARCH);
        recognizer.stop();
    }

    private void switchSearch(String searchName) {
        // If we are not spotting, start listening with timeout (10000 ms or 10 seconds).
        if (searchName.equals(KAMYAK_SEARCH))
            recognizer.startListening(searchName);
        else
            recognizer.startListening(searchName, 10000);
    }

    private void setupRecognizer(File assetsDir) throws IOException {
        // The recognizer can be configured to perform multiple searches
        // of different kind and switch between them

        recognizer = SpeechRecognizerSetup.defaultSetup()
                .setAcousticModel(new File(assetsDir, "acoustic_model.cd_cont_200new2"))
                .setDictionary(new File(assetsDir, "acoustic_model.dict"))
                .getRecognizer();
        recognizer.addListener(this);
        /* In your application you might not need to add all those searches.
          They are added here for demonstration. You can leave just one.
         */

        // Create grammar-based search for digit recognition
        File grammar = new File(assetsDir, "acoustic_model.gram");
        recognizer.addGrammarSearch("acoustic_model", grammar);
    }

    @Override
    public void onError(Exception error) {
        ((TextView) findViewById(R.id.give_word)).setText(error.getMessage());
    }

    @Override
    public void onTimeout() {
        switchSearch(KAMYAK_SEARCH);
    }

    public void say(View view){
        ((GifImageButton) findViewById(R.id.animation)).setBackgroundResource(R.drawable.microphone3);
        new SetupTask(this).execute();
    }

    public void home(View view){
        Main2Activity.currentWord = 0;
        Intent intent = new Intent( ShowWordActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }

}
