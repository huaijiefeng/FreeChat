package com.snail.freechat.data.contact;

import android.provider.ContactsContract;

/**
 * Created by fenghb on 2014/5/16.
 */
public class ContactData {


    public static class ContactQueryData extends BaseData {
        public static final String PHOTO_ID = ContactsContract.CommonDataKinds.Phone.PHOTO_ID;
        public static final String DISPLAY_NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
        public static final String SORT_KEY_PRIMARY = "contact_sort_key";
        public static final String CONTACT_NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    }

    private static class BaseData {
        public static final String ID = "_id";
    }

}
