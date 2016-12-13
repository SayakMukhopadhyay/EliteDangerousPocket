package com.kodeblox.elitedangerouspocket;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class LoadingFragment extends Fragment {

    private AnimatorSet animTriangle;

    private ImageView triangle1;
    private ImageView triangle2;
    private ImageView triangle3;
    private ImageView triangle4;
    private ImageView triangle5;
    private ImageView triangle6;
    private ImageView triangle7;
    private ImageView triangle8;
    private ImageView triangle9;
    private ImageView triangle10;
    private ImageView triangle11;
    private ImageView triangle12;
    private ImageView triangle13;
    private ImageView triangle14;
    private ImageView triangle15;
    private ImageView triangle16;
    private ImageView triangle17;
    private ImageView triangle18;
    private ImageView triangle19;
    private ImageView triangle20;
    private ImageView triangle21;
    private ImageView triangle22;
    private ImageView triangle23;
    private ImageView triangle24;

    public LoadingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loading, container, false);

        setImages(view);

        setAnimators();

        animTriangle.start();

        return view;
    }

    private void setImages(View view) {
        triangle1 = (ImageView) view.findViewById(R.id.imageView1);
        triangle2 = (ImageView) view.findViewById(R.id.imageView2);
        triangle3 = (ImageView) view.findViewById(R.id.imageView3);
        triangle4 = (ImageView) view.findViewById(R.id.imageView4);
        triangle5 = (ImageView) view.findViewById(R.id.imageView5);
        triangle6 = (ImageView) view.findViewById(R.id.imageView6);
        triangle7 = (ImageView) view.findViewById(R.id.imageView7);
        triangle8 = (ImageView) view.findViewById(R.id.imageView8);
        triangle9 = (ImageView) view.findViewById(R.id.imageView9);
        triangle10 = (ImageView) view.findViewById(R.id.imageView10);
        triangle11 = (ImageView) view.findViewById(R.id.imageView11);
        triangle12 = (ImageView) view.findViewById(R.id.imageView12);
        triangle13 = (ImageView) view.findViewById(R.id.imageView13);
        triangle14 = (ImageView) view.findViewById(R.id.imageView14);
        triangle15 = (ImageView) view.findViewById(R.id.imageView15);
        triangle16 = (ImageView) view.findViewById(R.id.imageView16);
        triangle17 = (ImageView) view.findViewById(R.id.imageView17);
        triangle18 = (ImageView) view.findViewById(R.id.imageView18);
        triangle19 = (ImageView) view.findViewById(R.id.imageView19);
        triangle20 = (ImageView) view.findViewById(R.id.imageView20);
        triangle21 = (ImageView) view.findViewById(R.id.imageView21);
        triangle22 = (ImageView) view.findViewById(R.id.imageView22);
        triangle23 = (ImageView) view.findViewById(R.id.imageView23);
        triangle24 = (ImageView) view.findViewById(R.id.imageView24);
    }

    private void setAnimators() {
        animTriangle = new AnimatorSet();
        animTriangle.play(doAnimation(triangle1, 70));
        animTriangle.play(doAnimation(triangle2, 140));
        animTriangle.play(doAnimation(triangle3, 0));
        animTriangle.play(doAnimation(triangle4, 70));
        animTriangle.play(doAnimation(triangle5, 227));
        animTriangle.play(doAnimation(triangle6, 307));
        animTriangle.play(doAnimation(triangle7, 197));
        animTriangle.play(doAnimation(triangle8, 227));
        animTriangle.play(doAnimation(triangle9, 403));
        animTriangle.play(doAnimation(triangle10, 473));
        animTriangle.play(doAnimation(triangle11, 403));
        animTriangle.play(doAnimation(triangle12, 373));
        animTriangle.play(doAnimation(triangle13, 500));
        animTriangle.play(doAnimation(triangle14, 640));
        animTriangle.play(doAnimation(triangle15, 570));
        animTriangle.play(doAnimation(triangle16, 570));
        animTriangle.play(doAnimation(triangle17, 697));
        animTriangle.play(doAnimation(triangle18, 807));
        animTriangle.play(doAnimation(triangle19, 747));
        animTriangle.play(doAnimation(triangle20, 747));
        animTriangle.play(doAnimation(triangle21, 904));
        animTriangle.play(doAnimation(triangle22, 974));
        animTriangle.play(doAnimation(triangle23, 904));
        animTriangle.play(doAnimation(triangle24, 874));
    }

    private ValueAnimator doAnimation(ImageView image, long delay) {
        ValueAnimator fadeAnim;

        fadeAnim = ObjectAnimator.ofFloat(image, "alpha", 1f, 0f);
        fadeAnim.setDuration(1000);
        fadeAnim.setStartDelay(delay);
        fadeAnim.setRepeatCount(ValueAnimator.INFINITE);
        fadeAnim.setRepeatMode(ValueAnimator.RESTART);

        return fadeAnim;
    }
}
