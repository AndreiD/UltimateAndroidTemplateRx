package com.androidadvance.ultimateandroidtemplaterx.ui.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidadvance.ultimateandroidtemplaterx.R;
import com.androidadvance.ultimateandroidtemplaterx.data.model.Character;
import com.androidadvance.ultimateandroidtemplaterx.ui.activity.CharacterActivity;
import com.androidadvance.ultimateandroidtemplaterx.util.skyicons.SunView;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

@LayoutId(R.layout.item_days)
public class CharacterHolder extends ItemViewHolder<Character> {

    @ViewId(R.id.container_character)
    View container_character;

    @ViewId(R.id.text_day_name)
    TextView mNameText;

    @ViewId(R.id.text_description)
    TextView text_description;

    @ViewId(R.id.framelayout_condition_holder)
    FrameLayout framelayout_condition_holder;


    public CharacterHolder(View view) {
        super(view);
    }

    @Override
    public void onSetValues(Character character, PositionInfo positionInfo) {
        mNameText.setText(character.name);
        int filmCount = character.films.size();
        String description = getContext().getString(R.string.text_films_description, filmCount);
        text_description.setText(filmCount == 0 ? getContext().getString(R.string.text_no_description) : description);


        LinearLayout layout = new LinearLayout(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);

        SunView windView = new SunView(getContext());


        layout.addView(windView);
        framelayout_condition_holder.addView(layout);

    }

    @Override
    public void onSetListeners() {
//        mViewText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getContext().startActivity(CharacterActivity.getStartIntent(getContext(), getItem()));
//            }
//        });

        container_character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(CharacterActivity.getStartIntent(getContext(), getItem()));
            }
        });

//        mTabText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getContext().startActivity(DetailActivity.getStartIntent(getContext(), getItem()));
//            }
//        });
    }

    private String getImageUrl(String name) {
        // Ugly, but the API doesn't provide images - so this is just for example image loading
        switch (name.toLowerCase()) {
            case "luke skywalker":
                return "http://img3.wikia.nocookie.net/__cb20091030151422/starwars/images/d/d9/Luke-rotjpromo.jpg";
            case "c-3po":
                return "http://img2.wikia.nocookie.net/__cb20131005124036/starwars/images/thumb/5/51/C-3PO_EP3.png/400px-C-3PO_EP3.png";
            case "r2-d2":
                return "http://img1.wikia.nocookie.net/__cb20090524204255/starwars/images/thumb/1/1a/R2d2.jpg/400px-R2d2.jpg";
            case "darth vader":
                return "http://img2.wikia.nocookie.net/__cb20130621175844/starwars/images/thumb/6/6f/Anakin_Skywalker_RotS.png/400px-Anakin_Skywalker_RotS.png";
            default:
                return "http://img2.wikia.nocookie.net/__cb20130221005853/starwars/images/thumb/9/9d/DSI_hdapproach.png/400px-DSI_hdapproach.png";
        }
    }
}