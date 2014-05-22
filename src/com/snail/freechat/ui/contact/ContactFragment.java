package com.snail.freechat.ui.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.*;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.snail.freechat.R;
import com.snail.freechat.core.contact.ContactQueryHandler;
import com.snail.freechat.data.contact.ContactData;
import com.snail.freechat.ui.contact.adapter.ContactAdapter;
import com.snail.freechat.ui.widget.slideexpandable.ActionSlideExpandableListView;
import com.snail.freechat.ui.widget.slideexpandable.SlideExpandableListAdapter;

import java.util.Calendar;
import java.util.List;

/**
 * Created by fenghb on 2014/5/15.
 */
public class ContactFragment extends Fragment {

    //view
    private ListView contactListView;

    //adapter
    private ContactAdapter mContactAdapter;

    //context
    private Context mContext;

    //query handler
    private ContactQueryHandler mQueryHandler;

    //projection
    private String[] projection = new String[]{
            ContactData.ContactQueryData.ID,
            ContactData.ContactQueryData.PHOTO_ID,
            ContactData.ContactQueryData.DISPLAY_NAME,
            ContactData.ContactQueryData.CONTACT_NUMBER
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_contact, null);
        contactListView = (ListView) mView.findViewById(R.id.contact_list);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContactAdapter = new ContactAdapter(mContext, R.layout.item_contact_list, null);
        contactListView.setAdapter(mContactAdapter);
        mQueryHandler = new ContactQueryHandler(mContext.getContentResolver(),
                mContactAdapter
        );
        mQueryHandler.startQuery(ContactQueryHandler.CONTACT_LIST_QUERY_TOKEN,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection,
                null,
                null,
                null
        );
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}

