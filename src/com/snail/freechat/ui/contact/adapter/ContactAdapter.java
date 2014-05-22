package com.snail.freechat.ui.contact.adapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.snail.freechat.R;
import com.snail.freechat.core.contact.loadphoto.ContactPhotoManager;
import com.snail.freechat.data.contact.ContactData;
import com.snail.freechat.ui.widget.circleimage.CornerImageViewCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenghb on 2014/5/16.
 */
public class ContactAdapter extends ResourceCursorAdapter {
    private static final String TAG = "ContactAdapter";

    private final ContactPhotoManager mContactPhotoManager;


    public ContactAdapter(Context context, int layout, Cursor c) {
        super(context, layout, c, false);
        mContactPhotoManager = ContactPhotoManager.getInstance(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = super.newView(context, cursor, parent);
        ViewHolder holder = new ViewHolder();
        holder.contactIcon = (CornerImageViewCircle) view.findViewById(R.id.contact_icon);
        holder.contactName = (TextView) view.findViewById(R.id.contact_name);
        holder.contactNumber = (TextView) view.findViewById(R.id.contact_number);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder mHolder = (ViewHolder) view.getTag();
        mHolder.contactName.setText(cursor.getString(cursor.getColumnIndex(ContactData.ContactQueryData.DISPLAY_NAME)));
        mHolder.contactNumber.setText(cursor.getString(cursor.getColumnIndex(ContactData.ContactQueryData.CONTACT_NUMBER)));

        //if the photo id is 0,load default icon
        long photoId = cursor.getLong(cursor.getColumnIndex(ContactData.ContactQueryData.PHOTO_ID));
        if (photoId == 0)
            mHolder.contactIcon.setImageResource(R.drawable.ic_launcher);
        else
            mContactPhotoManager.loadThumbnail(mHolder.contactIcon, photoId, false);
    }

    private final class ViewHolder {
        CornerImageViewCircle contactIcon;
        TextView contactName;
        TextView contactNumber;
    }
}


