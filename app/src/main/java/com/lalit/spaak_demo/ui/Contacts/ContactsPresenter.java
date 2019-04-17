package com.lalit.spaak_demo.ui.Contacts;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpPresenter;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpView;

import javax.inject.Inject;

public class ContactsPresenter<V extends ContactsMvpView> extends BasePresenter<V> implements ContactsMvpPresenter<V> {

    @Inject
    public ContactsPresenter(DataManager dataManager) {
        super(dataManager);
    }


}
