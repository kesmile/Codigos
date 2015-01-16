package com.test.kesmile.codigos.basedatos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.test.kesmile.codigos.R;

/**
 * Created by root on 16/01/15.
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_main_activity);
    }
}
