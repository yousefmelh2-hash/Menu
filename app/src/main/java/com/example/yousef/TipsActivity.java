package com.example.yousef;

import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.Gravity;
import android.widget.PopupWindow;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TipsActivity extends BaseMenuActivity {
    private TextView tvTip;
    private View tipsArea;
    private View popupAnchor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        initComponents();
        tipsArea.setOnTouchListener((v, event) -> {

            if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

                popupAnchor.setX(v.getX() + event.getX()-100);
                popupAnchor.setY(v.getY() + event.getY()-200);

                showTipMenu(popupAnchor);
            }

            return true;
        });

    }

    private void initComponents() {
        tvTip = findViewById(R.id.tvTips);
        popupAnchor=findViewById(R.id.view);
        tipsArea = findViewById(R.id.tipsArea);
    }

    private void showTipMenu(View anchor) {

        PopupMenu popup = new PopupMenu(this, anchor);

        popup.inflate(R.menu.tips_popup_menu);

        popup.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.tip_plan) {
                tvTip.setText("Math");
                return true;
            }

            if (item.getItemId() == R.id.tip_break) {
                tvTip.setText("15 mins");
                return true;
            }

            if (item.getItemId() == R.id.tip_review) {
                tvTip.setText("Leonardo da Vinci was a scientist");
                return true;
            }

            return false;
        });

        popup.show();
    }
}