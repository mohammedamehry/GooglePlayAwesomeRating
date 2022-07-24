package amehry.amehrygoogleplayawesomerating;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

public class Amehry {
    public static boolean r1c=false,r2c=false,r3c=false,r4c=false,r5c=false;
    public static void ShowRating(Activity activity,boolean shouldReceiveFeedback,String FeedbackEmail){
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.rating);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button Submit = dialog.findViewById(R.id.Submit);
        Button Exit = dialog.findViewById(R.id.Exit);
        dialog.show();
        TextView RatingTxt = dialog.findViewById(R.id.RatingTxt);
        LinearLayout r1 = dialog.findViewById(R.id.r1);
        LinearLayout r2 = dialog.findViewById(R.id.r2);
        LinearLayout r3 = dialog.findViewById(R.id.r3);
        LinearLayout r4 = dialog.findViewById(R.id.r4);
        LinearLayout r5 = dialog.findViewById(R.id.r5);
        ImageView r1i = dialog.findViewById(R.id.r1i);
        ImageView r2i = dialog.findViewById(R.id.r2i);
        ImageView r3i = dialog.findViewById(R.id.r3i);
        ImageView r4i = dialog.findViewById(R.id.r4i);
        ImageView r5i = dialog.findViewById(R.id.r5i);
        r1.setOnClickListener(view -> {
            r1c= true;
            RatingTxt.setText("I Don't Like It");
            Submit.setVisibility(View.VISIBLE);
            r1i.setImageResource(R.drawable.rate1active);
            r2i.setImageResource(R.drawable.rate2inactive);
            r3i.setImageResource(R.drawable.rate3inactive);
            r4i.setImageResource(R.drawable.rate4inactive);
            r5i.setImageResource(R.drawable.rate5inactive);

        });
        r2.setOnClickListener(view -> {
            r2c= true;
            RatingTxt.setText("I Don't Like It");
            Submit.setVisibility(View.VISIBLE);
            r1i.setImageResource(R.drawable.rate1inactive);
            r2i.setImageResource(R.drawable.rate2active);
            r3i.setImageResource(R.drawable.rate3inactive);
            r4i.setImageResource(R.drawable.rate4inactive);
            r5i.setImageResource(R.drawable.rate5inactive);
        });
        r3.setOnClickListener(view -> {
            r3c= true;
            RatingTxt.setText("Hmmm, Improve The App");
            Submit.setVisibility(View.VISIBLE);
            r1i.setImageResource(R.drawable.rate1inactive);
            r2i.setImageResource(R.drawable.rate2inactive);
            r3i.setImageResource(R.drawable.rate3active);
            r4i.setImageResource(R.drawable.rate4inactive);
            r5i.setImageResource(R.drawable.rate5inactive);
        });
        r4.setOnClickListener(view -> {
            r4c= true;
            RatingTxt.setText("I like The App");
            r1i.setImageResource(R.drawable.rate1inactive);
            r2i.setImageResource(R.drawable.rate2inactive);
            r3i.setImageResource(R.drawable.rate3inactive);
            r4i.setImageResource(R.drawable.rate4active);
            r5i.setImageResource(R.drawable.rate5inactive);
        });
        r5.setOnClickListener(view -> {
            r5c= true;
            RatingTxt.setText("I Love The App");
            r1i.setImageResource(R.drawable.rate1inactive);
            r2i.setImageResource(R.drawable.rate2inactive);
            r3i.setImageResource(R.drawable.rate3inactive);
            r4i.setImageResource(R.drawable.rate4inactive);
            r5i.setImageResource(R.drawable.rate5active);
        });
        Submit.setOnClickListener(view -> {
            if (RatingTxt.getText().equals("I Love The App") || RatingTxt.getText().equals("I like The App")) {
                rateApp(activity);
                dialog.dismiss();
                r1c =false;
                r2c =false;
                r3c =false;
                r4c =false;
                r5c =false;
                Toast.makeText(activity, "Please Write a Review Now", Toast.LENGTH_LONG).show();
            } else if (!r1c&&!r2c&&!r3c&&!r4c&&!r5c){
                Toast.makeText(activity, "Please Select A Rating, Before You Submit the review", Toast.LENGTH_SHORT).show();
            }else {
                r1c =false;
                r2c =false;
                r3c =false;
                r4c =false;
                r5c =false;
                dialog.dismiss();
                if (!shouldReceiveFeedback){
                    Toast.makeText(activity, "Thank you, we hope you rate the app next time", Toast.LENGTH_SHORT).show();
                } else {
                    ShowFeedBack(activity,FeedbackEmail);
                }
            }
        });
        Exit.setOnClickListener(view -> {
            dialog.dismiss();
            r1c =false;
            r2c =false;
            r3c =false;
            r4c =false;
            r5c =false;
            Toast.makeText(activity, "Thank you, we hope you rate the app next time", Toast.LENGTH_SHORT).show();
        });
    }

    public static void ShowFeedBack(Activity activity,String Email){
        Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.feedback);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        Button Submit = dialog.findViewById(R.id.SubmitFeedback);
        Button Exit = dialog.findViewById(R.id.ExitFeedback);
        dialog.show();
        EditText Feedback = dialog.findViewById(R.id.Feedback);
        Submit.setOnClickListener(view -> {
            String[] TO = {Email};
            String[] CC = {Email};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for App (Package name : " +activity.getPackageName()+" )");
            emailIntent.putExtra(Intent.EXTRA_TEXT, Feedback.getText().toString());
            try {
                activity.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                Toast.makeText(activity, "Thank Your For Your Feedback", Toast.LENGTH_SHORT).show();

            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(activity, "No Email App Installed", Toast.LENGTH_SHORT).show();

            }
            dialog.dismiss();
        });
        Exit.setOnClickListener(view -> {
            dialog.dismiss();
            Toast.makeText(activity, "Thank you, we hope you rate the app next time", Toast.LENGTH_SHORT).show();
        });
    }
    public static void rateApp(Activity activity) {
        try {
            Intent rateIntent = rateIntentForUrl("market://details",activity);
            activity.startActivity(rateIntent);
        } catch (ActivityNotFoundException e) {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details",activity);
            activity.startActivity(rateIntent);
        }
    }

    public static Intent rateIntentForUrl(String url,Activity activity) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, activity.getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21) {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        } else {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;

    }
}
