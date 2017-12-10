package com.mukulpathak.healthgraph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScreenShot.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScreenShot#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScreenShot extends Fragment {
    private static final String URL_PARAM = "url";
    private String url;

    public ScreenShot() {
    }

    public static ScreenShot newInstance(String url) {
        ScreenShot fragment = new ScreenShot();
        Bundle args = new Bundle();
        args.putString(URL_PARAM, url);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.sdvImage)
    SimpleDraweeView sdvImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(URL_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screen_shot, container, false);
        ButterKnife.bind(this, view);
        sdvImage.setImageURI(url);
        return view;
    }
}
