package com.lf.minhalivraria;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.lf.minhalivraria.model.buscape.Result;
import com.lf.minhalivraria.network.DownloadImageTask;
import com.lf.minhalivraria.network.NetworkImageCallback;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    Result result;
    Bitmap image;

    @Bind(R.id.imageViewBook)
    ImageView imageViewBook;

    @Bind(R.id.txtViewBookTitle)
    TextView txtViewBookTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        ButterKnife.bind(this);

        result = (Result) getIntent().getSerializableExtra("result");
        initView();

    }

    private void initView() {

        txtViewBookTitle.setText(result.getProduct().getProductname());
        getImage();
    }

    public void getImage() {


        if (result != null) {

            String imageUrl = result.getThumbnailUrl();

            if (!imageUrl.equals("")) {

                imageUrl = imageUrl.replace("\\/", "/");
                NetworkImageCallback callback = new NetworkImageCallback() {
                    @Override
                    public void process(Bitmap bitmapImage) {
                        image = bitmapImage;
                        imageViewBook.setImageBitmap(image);
                    }
                };

                new DownloadImageTask(callback).execute(imageUrl);

            }

        }
    }


}
