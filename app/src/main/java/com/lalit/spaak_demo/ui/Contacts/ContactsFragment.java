package com.lalit.spaak_demo.ui.Contacts;


import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lalit.spaak_demo.R;
import com.lalit.spaak_demo.di.component.ActivityComponent;
import com.lalit.spaak_demo.ui.Base.BaseFragment;
import com.lalit.spaak_demo.ui.Map.MapFragment;
import com.lalit.spaak_demo.ui.Map.MapMvpPresenter;
import com.lalit.spaak_demo.ui.Map.MapMvpView;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends BaseFragment implements ContactsMvpView {

    public static String TAG = "ContactsFragment";
    @Inject
    ContactsMvpPresenter<ContactsMvpView> mPresenter;

    RecyclerView recyclerView ;

    public ContactsFragment() {
        // Required empty public constructor
    }

    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mPresenter.onAttach(this);
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_contacts);


        return view;
    }

    @Override
    protected void setUp(View view) {

        ArrayList<String> contacts = new ArrayList<>();
        Cursor cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

            while (cursor.moveToNext()) {

               String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

               String phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


             contacts.add(name + " "  + ":" + " " + phonenumber);
            }

            cursor.close();

        ContactsAdapter mAdapter = new ContactsAdapter(contacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getBaseActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


}
