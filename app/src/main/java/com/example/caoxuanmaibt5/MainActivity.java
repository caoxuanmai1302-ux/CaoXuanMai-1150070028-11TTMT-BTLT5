package com.example.caoxuanmaibt5;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode, btnZoomOutXml,
            btnZoomOutCode, btnRotateXml, btnRotateCode, btnMoveXml, btnMoveCode,
            btnSlideUpXml, btnSlideUpCode, btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;
    private Button btnNextActivity, btnOpenPager;
    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsByIds();
        initVariables();

        // XML
        handleClickAnimationXml(btnFadeInXml,  R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml,   R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml,  R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml,  R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml,    R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml,  R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        // CODE
        handleClickAnimationCode(btnFadeInCode,  buildFadeIn());
        handleClickAnimationCode(btnFadeOutCode, buildFadeOut());
        handleClickAnimationCode(btnBlinkCode,   buildBlink());
        handleClickAnimationCode(btnZoomInCode,  buildZoom(1f, 3f));
        handleClickAnimationCode(btnZoomOutCode, buildZoom(1f, .5f));
        handleClickAnimationCode(btnRotateCode,  buildRotate());
        handleClickAnimationCode(btnMoveCode,    buildMove());
        handleClickAnimationCode(btnSlideUpCode, buildSlideUp());
        handleClickAnimationCode(btnBounceCode,  buildBounce());
        handleClickAnimationCode(btnCombineCode, buildCombine());

        btnNextActivity.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        btnOpenPager.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SlideActivity.class));
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        });
    }

    private void findViewsByIds() {
        ivUitLogo     = findViewById(R.id.iv_uit_logo);
        btnFadeInXml  = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode= findViewById(R.id.btn_fade_out_code);
        btnBlinkXml   = findViewById(R.id.btn_blink_xml);
        btnBlinkCode  = findViewById(R.id.btn_blink_code);
        btnZoomInXml  = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode= findViewById(R.id.btn_zoom_out_code);
        btnRotateXml  = findViewById(R.id.btn_rotate_xml);
        btnRotateCode = findViewById(R.id.btn_rotate_code);
        btnMoveXml    = findViewById(R.id.btn_move_xml);
        btnMoveCode   = findViewById(R.id.btn_move_code);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode= findViewById(R.id.btn_slide_up_code);
        btnBounceXml  = findViewById(R.id.btn_bounce_xml);
        btnBounceCode = findViewById(R.id.btn_bounce_code);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
        btnCombineCode= findViewById(R.id.btn_combine_code);
        btnNextActivity = findViewById(R.id.btn_next_activity);
        btnOpenPager    = findViewById(R.id.btn_open_pager);
    }

    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {}
            @Override public void onAnimationEnd(Animation animation) {}
            @Override public void onAnimationRepeat(Animation animation) {}
        };
    }

    private void handleClickAnimationXml(Button btn, int animId) {
        btn.setOnClickListener(v -> {
            Animation a = AnimationUtils.loadAnimation(getApplicationContext(), animId);
            a.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(a);
        });
    }

    private void handleClickAnimationCode(Button btn, final Animation animation) {
        btn.setOnClickListener(v -> ivUitLogo.startAnimation(animation));
    }

    // ===== CODE builders =====
    private Animation buildFadeIn() {
        AlphaAnimation a = new AlphaAnimation(0f, 1f);
        a.setDuration(1000); a.setFillAfter(true); a.setAnimationListener(animationListener);
        return a;
    }
    private Animation buildFadeOut() {
        AlphaAnimation a = new AlphaAnimation(1f, 0f);
        a.setDuration(1000); a.setFillAfter(true); a.setAnimationListener(animationListener);
        return a;
    }
    private Animation buildBlink() {
        AlphaAnimation a = new AlphaAnimation(0f, 1f);
        a.setDuration(300); a.setRepeatMode(Animation.REVERSE); a.setRepeatCount(3);
        a.setAnimationListener(animationListener);
        return a;
    }
    private Animation buildZoom(float from, float to) {
        ScaleAnimation s = new ScaleAnimation(from, to, from, to,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        s.setDuration(1000); s.setFillAfter(true); s.setAnimationListener(animationListener);
        return s;
    }
    private Animation buildRotate() {
        RotateAnimation r = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        r.setDuration(600); r.setRepeatMode(Animation.RESTART); r.setRepeatCount(2);
        r.setAnimationListener(animationListener);
        return r;
    }
    private Animation buildMove() {
        TranslateAnimation t = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, .75f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f);
        t.setDuration(800); t.setFillAfter(true); t.setAnimationListener(animationListener);
        return t;
    }
    private Animation buildSlideUp() {
        ScaleAnimation s = new ScaleAnimation(1f, 1f, 1f, 0f,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        s.setDuration(500); s.setFillAfter(true); s.setAnimationListener(animationListener);
        return s;
    }
    private Animation buildBounce() {
        ScaleAnimation s = new ScaleAnimation(1f, 1f, 0f, 1f,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        s.setDuration(500); s.setInterpolator(new BounceInterpolator());
        s.setFillAfter(true); s.setAnimationListener(animationListener);
        return s;
    }
    private Animation buildCombine() {
        AnimationSet set = new AnimationSet(true);
        set.setInterpolator(new LinearInterpolator());

        ScaleAnimation s = new ScaleAnimation(1f, 3f, 1f, 3f,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        s.setDuration(4000);
        set.addAnimation(s);

        RotateAnimation r = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        r.setDuration(500); r.setRepeatCount(2); r.setRepeatMode(Animation.RESTART);
        set.addAnimation(r);

        set.setFillAfter(true); set.setAnimationListener(animationListener);
        return set;
    }
}