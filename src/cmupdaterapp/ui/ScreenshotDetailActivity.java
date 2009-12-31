package cmupdaterapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenshotDetailActivity extends Activity
{
	private int mCurrentPhotoIndex = 0;
    private int[] mPhotoIds = new int[] { R.drawable.apply_later,
            R.drawable.background, R.drawable.check_now, R.drawable.loading,
            R.drawable.experimental, R.drawable.download};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screenshots_detail);
		showPhoto(mCurrentPhotoIndex);

        // Handle clicks on the 'Next' button.
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCurrentPhotoIndex = (mCurrentPhotoIndex + 1)
                        % mPhotoIds.length;
                showPhoto(mCurrentPhotoIndex);
            }
        });
	}
	
	private void showPhoto(int photoIndex) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(mPhotoIds[photoIndex]);

        TextView statusText = (TextView) findViewById(R.id.status_text);
        statusText.setText(String.format("%d/%d", photoIndex + 1,
                mPhotoIds.length));
    }
}