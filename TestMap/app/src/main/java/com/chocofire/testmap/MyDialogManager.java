package com.chocofire.testmap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyDialogManager {

    private Dialog dialog;
    private OnUserSelect mOnDialogSelect;

    public MyDialogManager setOnDialogSelect(OnUserSelect onDialogSelect){
        mOnDialogSelect = onDialogSelect;
        return this;
    }

    public interface OnUserSelect {
        void onclick(boolean isOk);
    }

    public MyDialogManager MyCustomDialog(Activity activity,String title) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_choice);
        dialog.setCancelable(true);

        Button ok = (Button) dialog.findViewById(R.id.di_bt_ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOnDialogSelect.onclick(true);
                dialog.cancel();
            }
        });

        Button cancel = (Button) dialog.findViewById(R.id.di_bt_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOnDialogSelect.onclick(false);
                dialog.cancel();
            }
        });

        TextView textView = (TextView) dialog.findViewById(R.id.di_choice_title);
        textView.setText(title);

//        dialog.show();
        return this;
    }

    public void showMyCustomDialog(){
        dialog.show();
    }
}
