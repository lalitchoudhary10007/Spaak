

package com.lalit.spaak_demo.di.module;

import android.app.Application;
import android.content.Context;


import com.lalit.spaak_demo.BuildConfig;
import com.lalit.spaak_demo.data.AppDataManager;
import com.lalit.spaak_demo.data.DataManager;
import com.lalit.spaak_demo.data.Network.ApiHeader;
import com.lalit.spaak_demo.data.Network.ApiHelper;
import com.lalit.spaak_demo.data.Network.AppApiHelper;
import com.lalit.spaak_demo.data.db.AppDbHelper;
import com.lalit.spaak_demo.data.db.DbHelper;
import com.lalit.spaak_demo.data.prefs.AppPreferencesHelper;
import com.lalit.spaak_demo.data.prefs.PreferencesHelper;
import com.lalit.spaak_demo.di.ApiInfo;
import com.lalit.spaak_demo.di.ApplicationContext;
import com.lalit.spaak_demo.di.DatabaseInfo;
import com.lalit.spaak_demo.di.PreferenceInfo;
import com.lalit.spaak_demo.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return "";
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                (long) 123,
               ""
                );
    }


}
