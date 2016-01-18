package com.sprint_two.ronanclancy.slaughtered;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by afinn on 1/18/2016.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    MainActivity mainActivity;
    NavigationView navigationView;
    Toolbar toolbar;

    public MainActivityTest() {
        super(MainActivity.class);

    }

    protected void setUp() throws Exception{
        super.setUp();
        mainActivity = getActivity();
    }

    public void testNavView(){
        navigationView = (NavigationView) mainActivity.findViewById(R.id.nav_view);
        assertNotNull(navigationView);
    }

    public void testToolBar(){
        toolbar = (Toolbar) mainActivity.findViewById(R.id.toolbar);
        assertNotNull(toolbar);
        assertEquals(mainActivity.getResources().getString(R.string.toolbar_home_frag_title), toolbar.getTitle());
    }

    public void testMain(){
        assertEquals(mainActivity.getResources().getString(R.string.app_name), mainActivity.getTitle());
    }
}
