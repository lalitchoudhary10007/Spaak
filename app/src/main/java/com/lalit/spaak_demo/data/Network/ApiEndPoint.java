

package com.lalit.spaak_demo.data.Network;
import com.lalit.spaak_demo.BuildConfig;

public final class ApiEndPoint {



    public static final String ENDPOINT_LOGIIN = BuildConfig.BASE_URL
            + "users/login";

    public static final String ENDPOINT_UPLOADIMAGE = BuildConfig.BASE_URL
            + "gallery";

    public static final String ENDPOINT_GETALLIMAGE = BuildConfig.BASE_URL
            + "gallery/";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
