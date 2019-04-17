package com.lalit.spaak_demo.ui.SelectImage;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.di.component.ActivityComponent;
import com.lalit.spaak_demo.ui.Base.BaseFragment;
import com.lalit.spaak_demo.ui.ImageList.ImageListFragment;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpPresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpView;

import java.io.IOException;

import javax.inject.Inject;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectImageFragment extends BaseFragment implements SelectImageMvpView {

    public static String TAG = "SelectImageFragment";
    @Inject
    SelectImageMvpPresenter<SelectImageMvpView> mPresenter;

    Button select_image , upload;
    ImageView selected_image ;


    public SelectImageFragment() {
        // Required empty public constructor
    }

    public static SelectImageFragment newInstance() {
        SelectImageFragment fragment = new SelectImageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_image, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        select_image = view.findViewById(R.id.btn_choose_image);
        upload = view.findViewById(R.id.btn_upload);
        selected_image = view.findViewById(R.id.img_selected_image);

       select_image.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(galleryIntent, 1000);
           }
       });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }

//    @OnClick(R.id.nav_back_btn)
//    void onNavBackClick() {
//        getBaseActivity().onFragmentDetached(TAG);
//    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onSelectImage() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super method removed
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                Uri returnUri = data.getData();

                Log.e("URL:- " ,""+returnUri.getPath());
                Bitmap bitmapImage = null;
                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                selected_image.setImageBitmap(bitmapImage);
            }
        }
    }
}
