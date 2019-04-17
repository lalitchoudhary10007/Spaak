package com.lalit.spaak_demo.ui.Map;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.di.component.ActivityComponent;
import com.lalit.spaak_demo.ui.Base.BaseFragment;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageFragment;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpPresenter;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends BaseFragment implements MapMvpView {

    public static String TAG = "MapFragment";
    @Inject
    MapMvpPresenter<MapMvpView> mPresenter;


    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {

    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

}
