# CoordinatorLayout
CoordinatorLayout的简单使用
-------
1 滑动隐藏效果
####
效果图为：
####
![](https://github.com/18380460383/CoordinatorLayout/raw/master/(zhaoxi.net).gif)  
```java
布局（部分）：
<android.support.design.widget.CoordinatorLayout android:id="@+id/main_content"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true">

    <android.support.design.widget.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:fitsSystemWindows="true">

        <android.support.design.widget.CollapsingToolbarLayout
            android:id="@+id/collapsing_toolbar"
            android:layout_width="match_parent"
            android:layout_height="256dp"
            android:fitsSystemWindows="true"
            android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
            app:contentScrim="?attr/colorPrimary"
            app:expandedTitleTextAppearance="@style/CollapsingToolbarTitleStyle.About"
            app:layout_scrollFlags="scroll|exitUntilCollapsed">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="256dp"
                android:background="@color/colorPrimary"
                android:gravity="center"
                android:orientation="vertical">

                <ImageView
                    android:layout_width="96dp"
                    android:layout_height="96dp"
                    android:layout_marginTop="24dp"
                    android:src="@mipmap/ic_launcher" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:gravity="center"
                    android:text="@string/app_name"
                    android:textColor="@android:color/white"
                    android:textSize="18sp" />

                <TextView
                    android:id="@+id/tv_version"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:text="1.0"
                    android:textColor="@android:color/white"
                    android:textSize="14sp" />
            </LinearLayout>

            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:layout_collapseMode="pin"
                app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />

        </android.support.design.widget.CollapsingToolbarLayout>

    </android.support.design.widget.AppBarLayout>

    <android.support.v4.widget.NestedScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:overScrollMode="never"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"

        >

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:padding="8dp">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="帮助"
                android:textColor="@color/colorPrimary"
                android:textSize="14sp" />

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:padding="8dp">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:autoLink="web"
                    android:text="介绍"
                    android:textColor="#fF0"
                    android:textIsSelectable="true"
                    android:textSize="14sp" />

            </RelativeLayout>

    </android.support.v4.widget.NestedScrollView>

</android.support.design.widget.CoordinatorLayout>
```
```java
toolbar的操作：
 setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout.setTitle("关于");
```
2 移动圆球而Button反向移动效果
-----
效果为：
![](https://github.com/18380460383/CoordinatorLayout/raw/master/(zhaoxi.net) (1).gif)  
```java
布局为：
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
   >
    <Button android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="150dp"
        android:layout_marginTop="20dp"
        android:gravity="center"
        android:background="#FFCC00"
        android:text="Hello"
        app:layout_behavior="com.test.ui.MyBehavior" />
    <com.test.ui.TempView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:translationX="50dp"
        android:translationY="50dp"
        android:tag="10" />
</android.support.design.widget.CoordinatorLayout>
```
说明
---
上面两种效果是CoordinatorLayout的一点简单使用，使用CoordinatorLayout的核心在于behavior的自定义，通过自定义Behavior可以去实现我们想要的效果！
