package edu.nku.csc456.fall2015.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.nku.csc456.fall2015.Csc456Application;
import edu.nku.csc456.fall2015.R;
import edu.nku.csc456.fall2015.model.Chapter;
import edu.nku.csc456.fall2015.service.Csc456ApiService;
import edu.nku.csc456.fall2015.ui.adapter.ChaptersAdapter;
import edu.nku.csc456.fall2015.ui.presenter.ChaptersFragment;
import edu.nku.csc456.fall2015.ui.presenter.ChaptersListPresenter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ChaptersActivity extends AppCompatActivity {

    private static final String LOG_TAG = ChaptersActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, ChaptersFragment.newInstance())
                .commit();

        Csc456Application application = (Csc456Application) getApplication();
        Tracker tracker = application.getDefaultTracker();

        Log.i(LOG_TAG, "Sending screen view analytic event for chapters list");
        tracker.setScreenName("Chapter List");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
