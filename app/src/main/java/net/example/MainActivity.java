package net.example;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import net.huseyinturan.SideSheetBehavior.SideSheetCallback;
import net.huseyinturan.SideSheetBehavior;

public class MainActivity extends AppCompatActivity {
  private LinearLayout mSidebarLayout;
  private ImageButton mSidebarButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mSidebarLayout = findViewById(R.id.sidebarLayout);
    mSidebarButton = findViewById(R.id.btn_close_sidebar);

    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.from(mSidebarLayout);
    sideSheetBehavior.setHideable(false);
    sideSheetBehavior.setSideSheetCallback(new SideSheetCallback() {
      @Override
      public void onStateChanged(@NonNull View bottomSheet, int newState) {

      }

      @Override
      public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        float angle = 180 * slideOffset;
        mSidebarButton.animate().cancel();
        mSidebarButton
            .animate()
            .rotation(angle).start();
      }
    });
  }
}
