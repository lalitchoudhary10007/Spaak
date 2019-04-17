

package com.lalit.spaak_demo.data.Network;
import com.lalit.spaak_demo.BuildConfig;

public final class ApiEndPoint {


    public static final String ENDPOINT_DIET_DATA = BuildConfig.BASE_URL
            + "dummy/";


    public static final String ENDPOINT_LOGIIN = BuildConfig.BASE_URL
            + "login/mindorks";


    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
