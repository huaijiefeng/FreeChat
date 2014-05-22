package com.snail.freechat.core.contact;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ResourceCursorAdapter;
import com.snail.freechat.data.contact.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fenghb on 2014/5/16.
 */
public class ContactQueryHandler extends AsyncQueryHandler {
    private static final String TAG = "ContactQueryHandler";

    public static final int CONTACT_LIST_QUERY_TOKEN = 1;
    private ResourceCursorAdapter adapter;

    public ContactQueryHandler(ContentResolver cr, ResourceCursorAdapter adapter) {
        super(cr);
        this.adapter = adapter;
    }


    @Override
    public void startQuery(int token, Object cookie, Uri uri, String[] projection, String selection, String[] selectionArgs, String orderBy) {
        super.startQuery(token, cookie, uri, projection, selection, selectionArgs, orderBy);
    }

    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        super.onQueryComplete(token, cookie, cursor);
        adapter.swapCursor(cursor);
    }
}

