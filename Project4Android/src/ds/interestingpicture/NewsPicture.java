package ds.interestingpicture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/*
   Because this application needs access to the Internet, you need to add the appropriate permissions to the Android manifest file. 
   Open the AndroidManifest.xml file and add the following as a child of the <manifest> element:
   <uses-permission android:name="android.permission.INTERNET" />
 */
/**
 * 
 * @author Bilei Huang 
 *  NewsPicture which is the activity  
 * 
 */

public class NewsPicture extends Activity {
    @Override
    /**
     * 
     * @param savedInstanceState start the view!
     * 
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
         * The click listener will need a reference to this object, so that upon successfully finding a picture from Flickr, it 
         * can callback to this object with the resulting picture Bitmap.  The "this" of the OnClick will be the OnClickListener, not
         * this InterestingPicture. 
         */
        final NewsPicture np = this;
        
        
        Button submitButton = (Button)findViewById(R.id.submit);

      	// Add a listener to the send button
        submitButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View viewParam) {
        		System.out.println(6);
        		String searchTerm = ((EditText)findViewById(R.id.searchTerm)).getText().toString();
        		GetNewsPic gp = new GetNewsPic();
        		gp.search(searchTerm, np); // Done asynchronously in another thread.  It calls ip.pictureReady() in this thread when complete.
        	}
        });
    }
    
    //when the picture is ready  show it
    /**
     * 
     * @param picture  get the bitmap and show it
     * 
     */
    public void pictureReady(Bitmap picture) {
    	System.out.println(8);
		ImageView pictureView = (ImageView)findViewById(R.id.mypic);
		TextView searchView = (EditText)findViewById(R.id.searchTerm);
		if (picture != null) {
			
    		pictureView.setImageBitmap(picture);
    		pictureView.setVisibility(View.VISIBLE);
    	} else {
    		pictureView.setImageResource(R.drawable.icon);
    		pictureView.setVisibility(View.INVISIBLE);
    	}
		searchView.setText("");
		pictureView.invalidate();
    }
}