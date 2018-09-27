package hr.algebra.algebraanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.algebra.algebraanimation.anim.ViewAnimation;

public class MainActivity extends AppCompatActivity {


    private AnimationDrawable frameAnimation;

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnStartAnim)
    public void btnStartAnim() {
        animateBalloon();
        // animateScale();
        // animateTranslateAlpha();
        // animateRotate();
        // animateView();
    }

    private void animateView(){
        String[] listItems = new String[]{"Mouse", "Keyboard", "Monitor", "Cooler",
                "Notebook", "USB Stick", "Phone", "Desk", "Chair"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setLayoutAnimation(null);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        listView.startAnimation(new ViewAnimation());
    }

    private void animateRotate() {
        String[] listItems = new String[]{"Mouse", "Keyboard", "Monitor", "Cooler",
                "Notebook", "USB Stick", "Phone", "Desk", "Chair"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void animateScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_scale);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.startAnimation(animation);
    }

    private void animateTranslateAlpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_translate_alpha);
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.startAnimation(animation);
    }

    private void animateBalloon() {
        imageView.setBackgroundResource(R.drawable.animation_frame);
        frameAnimation = (AnimationDrawable) imageView.getBackground();

        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.start();
        }
    }
}
