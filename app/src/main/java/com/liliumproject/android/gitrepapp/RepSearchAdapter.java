package com.liliumproject.android.gitrepapp;

import android.content.Context;
import android.view.ViewGroup;

import co.moonmonkeylabs.realmsearchview.RealmSearchAdapter;
import io.realm.Realm;
import io.realm.RealmViewHolder;

/**
 * Created by kt on 2017/07/23.
 */

class RepRecyclerViewAdapter
        extends RealmSearchAdapter<Rep, RepRecyclerViewAdapter.ViewHolder> {

    public RepRecyclerViewAdapter(
            Context context,
            Realm realm,
            String filterColumnName) {
        super(context, realm, filterColumnName);
    }

    public class ViewHolder extends RealmViewHolder {

        private final RepItemView blogItemView;

        public ViewHolder(RepItemView repItemView) {
            super(repItemView);
            this.blogItemView = repItemView;
        }
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        ViewHolder vh = new ViewHolder(new RepItemView(viewGroup.getContext()));
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final Rep blog = realmResults.get(position);
        viewHolder.blogItemView.bind(blog);
    }

    @Override
    public ViewHolder convertViewHolder(RealmViewHolder viewHolder) {
        return ViewHolder.class.cast(viewHolder);

    }
}