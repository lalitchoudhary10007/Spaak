package com.lalit.spaak_demo.ui.Map;

import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.ui.Base.BasePresenter;
import com.lalit.spaak_demo.ui.Contacts.ContactsMvpPresenter;
import com.lalit.spaak_demo.ui.Contacts.ContactsMvpView;

import javax.inject.Inject;

public class MapPresenter<V extends MapMvpView> extends BasePresenter<V> implements MapMvpPresenter<V> {

    @Inject
    public MapPresenter(DataManager dataManager) {
        super(dataManager);
    }


}
