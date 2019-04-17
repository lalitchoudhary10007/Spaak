

package com.lalit.spaak_demo.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;


import com.lalit.spaak_demo.di.ActivityContext;
import com.lalit.spaak_demo.di.PerActivity;
import com.lalit.spaak_demo.ui.Contacts.ContactsMvpPresenter;
import com.lalit.spaak_demo.ui.Contacts.ContactsMvpView;
import com.lalit.spaak_demo.ui.Contacts.ContactsPresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpPresenter;
import com.lalit.spaak_demo.ui.ImageList.ImageListMvpView;
import com.lalit.spaak_demo.ui.ImageList.ImageListPresenter;
import com.lalit.spaak_demo.ui.Login.LoginMvpPresenter;
import com.lalit.spaak_demo.ui.Login.LoginMvpView;
import com.lalit.spaak_demo.ui.Login.LoginPresenter;
import com.lalit.spaak_demo.ui.Main.MainMvpPresenter;
import com.lalit.spaak_demo.ui.Main.MainMvpView;
import com.lalit.spaak_demo.ui.Main.MainPresenter;
import com.lalit.spaak_demo.ui.Map.MapMvpPresenter;
import com.lalit.spaak_demo.ui.Map.MapMvpView;
import com.lalit.spaak_demo.ui.Map.MapPresenter;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpPresenter;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageMvpView;
import com.lalit.spaak_demo.ui.SelectImage.SelectImagePresenter;
import com.lalit.spaak_demo.ui.Splash.SplashMvpPresenter;
import com.lalit.spaak_demo.ui.Splash.SplashMvpView;
import com.lalit.spaak_demo.ui.Splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

//    @Provides
//    CompositeDisposable provideCompositeDisposable() {
//        return new CompositeDisposable();
//    }
//
//    @Provides
//    SchedulerProvider provideSchedulerProvider() {
//        return new AppSchedulerProvider();
//    }

    @PerActivity
    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    ImageListMvpPresenter<ImageListMvpView> provideImageListPresenter(
            ImageListPresenter<ImageListMvpView> presenter) {
        return presenter;
    }

    @Provides
    SelectImageMvpPresenter<SelectImageMvpView> provideSelectImagePresenter(
            SelectImagePresenter<SelectImageMvpView> presenter) {
        return presenter;
    }

    @Provides
    ContactsMvpPresenter<ContactsMvpView> provideContactPresenter(
            ContactsPresenter<ContactsMvpView> presenter) {
        return presenter;
    }

    @Provides
    MapMvpPresenter<MapMvpView> providemapPresenter(
            MapPresenter<MapMvpView> presenter) {
        return presenter;
    }

}
