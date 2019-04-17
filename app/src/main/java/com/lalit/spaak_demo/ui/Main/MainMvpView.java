package com.lalit.spaak_demo.ui.Main;

import com.lalit.spaak_demo.ui.Base.MvpView;

public interface MainMvpView extends MvpView {

   void OpenImageListFragment();

   void OpenAddImageFragment();

   void OpenMapFragment();

   void OpenContactsFragment();

   void closeNavigationDrawer();

   void lockDrawer();

   void unlockDrawer();

}
