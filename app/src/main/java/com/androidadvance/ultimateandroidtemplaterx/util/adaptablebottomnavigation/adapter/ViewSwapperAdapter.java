package com.androidadvance.ultimateandroidtemplaterx.util.adaptablebottomnavigation.adapter;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.androidadvance.ultimateandroidtemplaterx.util.adaptablebottomnavigation.view.ViewSwapper;

/**
 * Base class providing the adapter to populate pages inside of
 * a {@link ViewSwapper}.  You will most likely want to use a more
 * specific implementation of this, such as
 * {@link android.support.v4.app.FragmentPagerAdapter} or
 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
 * <p>
 * <p>When you implement a PagerAdapter, you must override the following methods
 * at minimum:</p>
 * <ul>
 * <li>{@link #instantiateItem(ViewGroup, int)}</li>
 * <li>{@link #destroyItem(ViewGroup, int, Object)}</li>
 * <li>{@link #getCount()}</li>
 * <li>{@link #isViewFromObject(View, Object)}</li>
 * </ul>
 * <p>
 * <p>PagerAdapter is more general than the adapters used for
 * {@link android.widget.AdapterView AdapterViews}. Instead of providing a
 * View recycling mechanism directly ViewPager uses callbacks to indicate the
 * steps taken during an update. A PagerAdapter may implement a form of View
 * recycling if desired or use a more sophisticated method of managing page
 * Views such as Fragment transactions where each page is represented by its
 * own Fragment.</p>
 * <p>
 * <p>ViewPager associates each page with a key Object instead of working with
 * Views directly. This key is used to track and uniquely identify a given page
 * independent of its position in the adapter. A call to the PagerAdapter method
 * {@link #startUpdate(ViewGroup)} indicates that the contents of the ViewPager
 * are about to change. One or more calls to {@link #instantiateItem(ViewGroup, int)}
 * and/or {@link #destroyItem(ViewGroup, int, Object)} will follow, and the end
 * of an update will be signaled by a call to {@link #finishUpdate(ViewGroup)}.
 * By the time {@link #finishUpdate(ViewGroup) finishUpdate} returns the views
 * associated with the key objects returned by
 * {@link #instantiateItem(ViewGroup, int) instantiateItem} should be added to
 * the parent ViewGroup passed to these methods and the views associated with
 * the keys passed to {@link #destroyItem(ViewGroup, int, Object) destroyItem}
 * should be removed. The method {@link #isViewFromObject(View, Object)} identifies
 * whether a page View is associated with a given key object.</p>
 * <p>
 * <p>A very simple PagerAdapter may choose to use the page Views themselves
 * as key objects, returning them from {@link #instantiateItem(ViewGroup, int)}
 * after creation and adding them to the parent ViewGroup. A matching
 * {@link #destroyItem(ViewGroup, int, Object)} implementation would remove the
 * View from the parent ViewGroup and {@link #isViewFromObject(View, Object)}
 * could be implemented as <code>return view == object;</code>.</p>
 * <p>
 * <p>PagerAdapter supports data set changes. Data set changes must occur on the
 * main thread and must end with a call to {@link #notifyDataSetChanged()} similar
 * to AdapterView adapters derived from {@link android.widget.BaseAdapter}. A data
 * set change may involve pages being added, removed, or changing position. The
 * ViewPager will keep the current page active provided the adapter implements
 * the method {@link #getItemPosition(Object)}.</p>
 */
public abstract class ViewSwapperAdapter {
    private final DataSetObservable observable = new DataSetObservable();
    private DataSetObserver viewSwapperObserver;

    public static final int POSITION_UNCHANGED = -1;
    public static final int POSITION_NONE = -2;

    /**
     * Return the number of views available.
     */
    public abstract int getCount();

    /**
     * Called when a change in the shown pages is going to start being made.
     *
     * @param container The containing View which is displaying this adapter's
     *                  page views.
     */
    public void startUpdate(ViewGroup container) {
        startUpdate((View) container);
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    public Object instantiateItem(ViewGroup container, int position) {
        return instantiateItem((View) container, position);
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position to be removed.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     */
    public void destroyItem(ViewGroup container, int position, Object object) {
        destroyItem((View) container, position, object);
    }

    /**
     * Clear the state for a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position to be removed.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     */
    public void clearItem(ViewGroup container, int position, Object object) {
        destroyItem((View) container, position, object);
    }

    /**
     * Called to inform the adapter of which item is currently considered to
     * be the "primary", that is the one show to the user as the current page.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position that is now the primary.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     */
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        setPrimaryItem((View) container, position, object);
    }

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     *
     * @param container The containing View which is displaying this adapter's
     *                  page views.
     */
    public void finishUpdate(ViewGroup container) {
        finishUpdate((View) container);
    }

    /**
     * Called when a change in the shown pages is going to start being made.
     *
     * @param container The containing View which is displaying this adapter's
     *                  page views.
     * @deprecated Use {@link #startUpdate(ViewGroup)}
     */
    @Deprecated
    public void startUpdate(View container) {
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     * @deprecated Use {@link #instantiateItem(ViewGroup, int)}
     */
    @Deprecated
    public Object instantiateItem(View container, int position) {
        throw new UnsupportedOperationException(
                "Required method instantiateItem was not overridden");
    }

    /**
     * Remove a page for the given position.  The adapter is responsible
     * for removing the view from its container, although it only must ensure
     * this is done by the time it returns from {@link #finishUpdate(View)}.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position to be removed.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     * @deprecated Use {@link #destroyItem(ViewGroup, int, Object)}
     */
    @Deprecated
    public void destroyItem(View container, int position, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /**
     * Called to inform the adapter of which item is currently considered to
     * be the "primary", that is the one show to the user as the current page.
     *
     * @param container The containing View from which the page will be removed.
     * @param position  The page position that is now the primary.
     * @param object    The same object that was returned by
     *                  {@link #instantiateItem(View, int)}.
     * @deprecated Use {@link #setPrimaryItem(ViewGroup, int, Object)}
     */
    @Deprecated
    public void setPrimaryItem(View container, int position, Object object) {
    }

    /**
     * Called when the a change in the shown pages has been completed.  At this
     * point you must ensure that all of the pages have actually been added or
     * removed from the container as appropriate.
     *
     * @param container The containing View which is displaying this adapter's
     *                  page views.
     * @deprecated Use {@link #finishUpdate(ViewGroup)}
     */
    @Deprecated
    public void finishUpdate(View container) {
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view   Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    public abstract boolean isViewFromObject(View view, Object object);

    /**
     * Save any instance state associated with this adapter and its pages that should be
     * restored if the current UI state needs to be reconstructed.
     *
     * @return Saved state for this adapter
     */
    public Parcelable saveState() {
        return null;
    }

    /**
     * Restore any instance state associated with this adapter and its pages
     * that was previously saved by {@link #saveState()}.
     *
     * @param state  State previously saved by a call to {@link #saveState()}
     * @param loader A ClassLoader that should be used to instantiate any restored objects
     */
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    /**
     * Called when the host view is attempting to determine if an item's position
     * has changed. Returns {@link #POSITION_UNCHANGED} if the position of the given
     * item has not changed or {@link #POSITION_NONE} if the item is no longer present
     * in the adapter.
     * <p>
     * <p>The default implementation assumes that items will never
     * change position and always returns {@link #POSITION_UNCHANGED}.
     *
     * @param object Object representing an item, previously returned by a call to
     *               {@link #instantiateItem(View, int)}.
     * @return object's new position index from [0, {@link #getCount()}),
     * {@link #POSITION_UNCHANGED} if the object's position has not changed,
     * or {@link #POSITION_NONE} if the item is no longer present.
     */
    public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }

    /**
     * This method should be called by the application if the data backing this adapter has changed
     * and associated views should update.
     */
    public void notifyDataSetChanged() {
        synchronized (this) {
            if (viewSwapperObserver != null) {
                viewSwapperObserver.onChanged();
            }
        }
        observable.notifyChanged();
    }

    /**
     * Register an observer to receive callbacks related to the adapter's data changing.
     *
     * @param observer The {@link DataSetObserver} which will receive callbacks.
     */
    public void registerDataSetObserver(DataSetObserver observer) {
        observable.registerObserver(observer);
    }

    /**
     * Unregister an observer from callbacks related to the adapter's data changing.
     *
     * @param observer The {@link DataSetObserver} which will be unregistered.
     */
    public void unregisterDataSetObserver(DataSetObserver observer) {
        observable.unregisterObserver(observer);
    }

    public void setViewSwapperObserver(DataSetObserver observer) {
        synchronized (this) {
            viewSwapperObserver = observer;
        }
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    public CharSequence getViewTitle(int position) {
        return null;
    }

}