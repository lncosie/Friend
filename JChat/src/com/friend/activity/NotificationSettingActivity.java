package com.friend.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.friend.R;
import com.friend.Listener.OnChangedListener;
import com.friend.view.SlipButton;

public class NotificationSettingActivity extends BaseActivity implements OnChangedListener{

    private ImageButton mReturnBtn;
    private TextView mTitle;
    private ImageButton mMenuBtn;
	SlipButton mNotificationBtn;
    SlipButton mSoundBtn;
    SlipButton mVibrateBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification_setting);

        mReturnBtn = (ImageButton) findViewById(R.id.return_btn);
        mTitle = (TextView) findViewById(R.id.title);
        mMenuBtn = (ImageButton) findViewById(R.id.right_btn);
		mNotificationBtn = (SlipButton) findViewById(R.id.notification_switch);
        mSoundBtn = (SlipButton) findViewById(R.id.sound_switch);
        mVibrateBtn = (SlipButton) findViewById(R.id.vibrate_switch);

        mReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTitle.setText(this.getString(R.string.new_msg_remind_hit));
        mMenuBtn.setVisibility(View.GONE);
		mNotificationBtn.setOnChangedListener(R.id.notification_switch, this);
		mNotificationBtn.setChecked(false);
        mSoundBtn.setOnChangedListener(R.id.sound_switch, this);
        mSoundBtn.setChecked(false);
        mVibrateBtn.setOnChangedListener(R.id.vibrate_switch, this);
        mVibrateBtn.setChecked(false);
	}

	@Override
	public void OnChanged(int id, boolean CheckState) {
        switch (id){
            case R.id.notification_switch:
                if(CheckState){
                    Toast.makeText(NotificationSettingActivity.this, "notification switch is open!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(NotificationSettingActivity.this, "notification switch is closed!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.sound_switch:
                if(CheckState){
                    Toast.makeText(NotificationSettingActivity.this, "sound switch is opened!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(NotificationSettingActivity.this, "sound switch is closed!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.vibrate_switch:
                if(CheckState){
                    Toast.makeText(NotificationSettingActivity.this, "vibrate switch is opened!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(NotificationSettingActivity.this, "vibrate switch is closed!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
	}

}
