package jg.robolibs.assetsmanager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import jg.robolibs.assets.AssetsManager;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        CrossCoreAssetsManagerLoader.init(new AssetsManager(getApplicationContext()));
        final TextView counterTextView = (TextView) findViewById(R.id.counterTextView);
        final Button counterButton = (Button) findViewById(R.id.counterButton);

        counterButton.setOnClickListener((view) -> {
            try {
                String files[] = CrossCoreAssetsManagerLoader.getInstance().getAssetsManager().list("./assets/");
                for (String file : files) {
                    System.out.println("File -> " + file);
                }
                counterTextView.setText(String.format("There are %d files.", files != null ? files.length : 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
