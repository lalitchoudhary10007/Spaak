

package com.lalit.spaak_demo.di.component;
import com.lalit.spaak_demo.ui.Contacts.ContactsFragment;
import com.lalit.spaak_demo.ui.ImageList.ImageListFragment;
import com.lalit.spaak_demo.ui.Main.MainActivity;
import com.lalit.spaak_demo.di.PerActivity;
import com.lalit.spaak_demo.di.module.ActivityModule;
import com.lalit.spaak_demo.ui.Login.LoginActivity;
import com.lalit.spaak_demo.ui.Map.MapFragment;
import com.lalit.spaak_demo.ui.SelectImage.SelectImageFragment;
import com.lalit.spaak_demo.ui.Splash.SplashActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity mainActivity);

    void inject(LoginActivity activity);

    void inject(ImageListFragment fragment);

    void inject(SelectImageFragment fragment);

    void inject(MapFragment fragment);

    void inject(ContactsFragment fragment);
}
