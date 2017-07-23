package com.liliumproject.android.gitrepapp;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kt on 2017/07/23.
 */

public class RepItemView  extends RelativeLayout {



    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;




    public RepItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.rep_item_view, this);
        ButterKnife.bind(this);
    }

    public void bind(Rep rep) {
        title.setText(rep.getTitle());
        description.setText(rep.getContent());
        }
}

