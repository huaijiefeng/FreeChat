package com.snail.freechat.ui.widget.slideexpandable;

import android.content.Context;
import android.util.AttributeSet;

/**
 * A more specific expandable listview in which the expandable area
 * consist of some buttons which are context actions for the item itself.
 * <p/>
 * It handles event binding for those buttons and allow for adding
 * a listener that will be invoked if one of those buttons are pressed.
 *
 * @author tjerk
 * @date 6/26/12 7:01 PM
 */
public class ActionSlideExpandableListView extends SlideExpandableListView {

    public ActionSlideExpandableListView(Context context) {
        super(context);
        init();
    }

    public ActionSlideExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ActionSlideExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setVerticalFadingEdgeEnabled(false);
    }
}
