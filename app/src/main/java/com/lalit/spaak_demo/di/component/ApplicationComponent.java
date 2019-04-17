

package com.lalit.spaak_demo.di.component;

import android.app.Application;
import android.content.Context;


import com.lalit.spaak_demo.SpaakApp;
import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.di.ApplicationContext;
import com.lalit.spaak_demo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SpaakApp app);

//    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}