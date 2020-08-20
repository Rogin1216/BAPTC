package com.example.baptc.ui.ui.home;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.baptc.Common.LoginSignup.Login;
import com.example.baptc.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {

    public static final String TAG = "TAG";
    TextView header_fullname, profile_date, profile_idnum, profile_fullname, profile_email, profile_phonenum, profile_address;
    CircleImageView profile_image;
    Uri imageUri;

    String user_idnum, user_fname, user_email, user_date, user_phoneNo, _PhoneNum, user_add;
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        firebaseAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        _PhoneNum = firebaseAuth.getCurrentUser().getPhoneNumber();

        //Local
        StorageReference profileRef = storageReference.child("users/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profile_image);
            }
        });

        //Hooks
        profile_date = view.findViewById(R.id.profile_date);
        profile_fullname = view.findViewById(R.id.profile_fullname);
        profile_email = view.findViewById(R.id.profile_email);
        profile_phonenum = view.findViewById(R.id.profile_phonenum);
        profile_address = view.findViewById(R.id.profile_add);
        header_fullname = view.findViewById(R.id.header_fullname);
//        header_idnum = view.findViewById(R.id.header_idnum);
        profile_idnum = view.findViewById(R.id.profile_idnum);
//        crop_counter = view.findViewById(R.id.crop_counter);
        profile_image = view.findViewById(R.id.profile_image);

        //Show Data
        showAllData();

//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(firebaseAuth.getCurrentUser().getPhoneNumber());
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                mID = snapshot.child("idnum").getValue().toString();
//                mFName = snapshot.child("fullname").getValue().toString();
//                mPhone = snapshot.child("phoneNo").getValue().toString();
//                mEmail = snapshot.child("email").getValue().toString();
//                header_fullname.setText(mFName);
//                profile_idnum.setText(mID);
//                profile_fullname.getEditText().setText(mFName);
//                profile_email.getEditText().setText(mEmail);
//                profile_phonenum.getEditText().setText(mPhone);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });

//        OUT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity().getApplicationContext(), Login.class));
//                getActivity().finish();
//            }
//        });

//        UPDATE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (isPhoneNOChanged() || isEmailChanged()) {
//                    Toast.makeText(getActivity(), "Data has been updated", Toast.LENGTH_SHORT).show();
//
//                } else {
//                    Toast.makeText(getActivity(), "Data is the same can't update", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return view;

    }

//    private boolean isPhoneNOChanged() {
//        if (!user_phoneNo.equals(profile_phonenum.getEditText().getText().toString())) {
//            databaseReference.child(_PhoneNum).child("fullname").setValue(profile_phonenum.getEditText().getText().toString());
//            user_phoneNo = profile_phonenum.getEditText().getText().toString();
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private boolean isEmailChanged() {
//        if (!user_email.equals(profile_email.getEditText().getText().toString())) {
//            databaseReference.child(_PhoneNum).child("email").setValue(profile_email.getEditText().getText().toString());
//            user_email = profile_email.getEditText().getText().toString();
//            return true;
//        } else {
//            return false;
//        }
//    }

    private void showAllData() {
        Intent intent = getActivity().getIntent();
        user_idnum = intent.getStringExtra("idnum");
        user_fname = intent.getStringExtra("fullname");
        user_email = intent.getStringExtra("email");
        user_date = intent.getStringExtra("date");
        user_phoneNo = intent.getStringExtra("phoneNo");
        user_add = intent.getStringExtra("address");

        header_fullname.setText(user_fname);
        profile_idnum.setText(user_idnum);
        profile_fullname.setText(user_fname);
        profile_email.setText(user_email);
        profile_date.setText(user_date);
        profile_phonenum.setText(user_phoneNo);
        profile_address.setText(user_add);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
//            profileImage.setImageURI(imageUri);
            uploadImage(imageUri);
        }
    }

    private void uploadImage(Uri imageUri) {
//        String randomKey = UUID.randomUUID().toString();
//        final StorageReference fileRef = storageReference.child("images/" + randomKey);

        final StorageReference fileRef = storageReference.child("users/" + firebaseAuth.getCurrentUser().getUid() + "/profile.jpg");

        final ProgressDialog pd = new ProgressDialog(getActivity());
        pd.setTitle("Uploading Image....");
        pd.show();

        fileRef.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        pd.dismiss();
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "Image Uploaded", Snackbar.LENGTH_LONG).show();
                        fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Picasso.get().load(uri).into(profile_image);

                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        pd.dismiss();
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progressPercent = (100.00 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                pd.setMessage("Percentage" + (int) progressPercent + "%");
            }
        });
    }

    private void choosePicture() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

}