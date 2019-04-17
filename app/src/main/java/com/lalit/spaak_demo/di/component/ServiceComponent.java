

package com.lalit.spaak_demo.di.component;



import com.lalit.spaak_demo.di.PerService;
import com.lalit.spaak_demo.di.module.ServiceModule;

import dagger.Component;


@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

//    void inject(SyncService service);

}
