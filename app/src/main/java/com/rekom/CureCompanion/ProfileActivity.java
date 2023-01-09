package com.rekom.CureCompanion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    EditText mviewusername, mviewemail, mviewdomicile;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    Button mmovetoupdateprofile;

    FirebaseFirestore firebaseFirestore;

    private String name;
    private Uri imagePath;
    private String ImageUriAccessToken;
    private CardView mGetUserImage;
    private static int PICK_IMAGE=123;

    ImageView mviewuserimageinimageview;

    StorageReference storageReference;

    private String ImageURIacessToken;

    androidx.appcompat.widget.Toolbar mtoolbarofviewprofile;
    ImageButton mbackbuttonofviewprofile;

    FirebaseStorage firebaseStorage;

    ProgressBar mProgressBarSetProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mviewuserimageinimageview = findViewById(R.id.viewuserimageinimageview);
        mviewusername = findViewById(R.id.viewusername);
//        mviewemail = findViewById(R.id.viewemail);
//        mviewdomicile = findViewById(R.id.viewdomicile);
//        mtoolbarofviewprofile = findViewById(R.id.toolbarofviewprofile);
//        mbackbuttonofviewprofile = findViewById(R.id.backbuttonofviewprofile);
        mmovetoupdateprofile=findViewById(R.id.moveouttupdateprofile);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        mProgressBarSetProfile = findViewById(R.id.progress_bar);
        mGetUserImage = findViewById(R.id.viewuserimage);

//        setSupportActionBar(mtoolbarofviewprofile);
//        mbackbuttonofviewprofile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(ProfileActivity.this, chatActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//            }
//        });

        storageReference = firebaseStorage.getReference();
        storageReference.child("Images").child(firebaseAuth.getUid()).child("Profile Pic").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                ImageURIacessToken = uri.toString();
                Picasso.get().load(uri).into(mviewuserimageinimageview);
            }
        });

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfileModel muserprofile = snapshot.getValue(UserProfileModel.class);
//                mviewusername.setText(muserprofile.getUsername());
//                mviewemail.setText(muserprofile.getEmail());
//                mviewdomicile.setText(muserprofile.getDomicile());
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Failed To Fetch", Toast.LENGTH_SHORT).show();
            }
        });

        mGetUserImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE);
            }
        });

        mmovetoupdateprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=mviewusername.getText().toString();
                if(name.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please Insert Yor Name", Toast.LENGTH_SHORT).show();
                }
                else if(imagePath==null)
                {
                    Toast.makeText(getApplicationContext(), "Please Insert Your Picture Profile", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mProgressBarSetProfile.setVisibility(View.VISIBLE);
                    sendDataFormNewUser();
                    mProgressBarSetProfile.setVisibility(View.INVISIBLE);
                    Intent intent=new Intent(ProfileActivity.this, chatActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        DocumentReference documentReference=firebaseFirestore.collection( "Users" ).document(firebaseAuth.getUid());
        documentReference.update( "status","Offline").addOnSuccessListener( new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText( getApplicationContext(),"Now Users is Offline",Toast.LENGTH_SHORT).show();
            }
        } );

    }

    private void sendDataFormNewUser()
    {
        sendDataToRealTimeDatabase();

    }

    private void sendDataToRealTimeDatabase()
    {
        name=mviewusername.getText().toString().trim();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());

        UserProfileModel muserProfileModel =new UserProfileModel(name,firebaseAuth.getUid());
        databaseReference.setValue(muserProfileModel);
        Toast.makeText(getApplicationContext(), "User Profile Added Succesfully", Toast.LENGTH_SHORT).show();
        sendImageStorage();
    }

    private void sendImageStorage()
    {
        StorageReference imageref=storageReference.child("Images").child(firebaseAuth.getUid()).child("Profile Pic");

        //Image Compression

        Bitmap bitmap=null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 25,byteArrayOutputStream);
        byte[] data= byteArrayOutputStream.toByteArray();

        //putting image to storage

        UploadTask uploadTask=imageref.putBytes(data);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        ImageUriAccessToken=uri.toString();
                        Toast.makeText(getApplicationContext(), "URI get success", Toast.LENGTH_SHORT).show();
                        sendDataToCloudFireStore();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "URI get Failed", Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(getApplicationContext(), "Image is Uplaoded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Image Not Uploaded", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void sendDataToCloudFireStore() {

        DocumentReference documentReference=firebaseFirestore.collection("Users").document(FirebaseAuth.getInstance().getUid());
        Map<String , Object> userdata = new HashMap<>();
        userdata.put("name", name);
        userdata.put("image", ImageUriAccessToken);
        userdata.put("uid",firebaseAuth.getUid());
        userdata.put("status","Online");

        documentReference.set(userdata).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Data on Cloud Firestore send succesfully", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        DocumentReference documentReference=firebaseFirestore.collection( "Users" ).document(firebaseAuth.getUid());
        documentReference.update( "status","Online").addOnSuccessListener( new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText( getApplicationContext(),"Now Users is Online",Toast.LENGTH_SHORT).show();
            }
        } );
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ProfileActivity.this, chatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}