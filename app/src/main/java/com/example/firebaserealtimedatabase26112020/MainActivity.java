package com.example.firebaserealtimedatabase26112020;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Gửi dữ liệu dạng chuỗi
//        android : "Khóa học android KG 26112020" (child)
//        myRef.child("android").setValue("Khóa học android KG 26112020").addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        //2 : Gửi dữ liệu dạng map
//        HashMap<String , String> map = new HashMap<>();
//        map.put("xe2banh","xe đạp");
//        map.put("xe3banh","xe ba gác");
//        map.put("xe4banh","xe hơi");

//        myRef.child("phuongtien").setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        // 3 : Gửi dữ liệu object
//        myRef.child("sinhvien").setValue(new Sinhvien("Nguyen Van Teo",22)).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        // 4 : Gửi mảng sinh viên
//        ArrayList<Sinhvien> sinhviens = new ArrayList<>();
//        sinhviens.add(new Sinhvien("Nguyen Van A",20));
//        sinhviens.add(new Sinhvien("Nguyen Van B",21));
//        sinhviens.add(new Sinhvien("Nguyen Van C",22));
//        sinhviens.add(new Sinhvien("Nguyen Van D",23));
//        sinhviens.add(new Sinhvien("Nguyen Van E",24));
//        myRef.child("danhsach").setValue(sinhviens).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        myRef.child("danhsach").push().setValue(new Sinhvien("Nguyen Van F",25)).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // 1 : Đọc dữ liệu dang string
//        myRef.child("android").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue().toString();
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue().toString();
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        // 2 : Lay dữ liệu dạng hashmap
//        myRef.child("phuongtien").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//               HashMap<String, String> map = (HashMap<String, String>) dataSnapshot.getValue();
//               Log.d("BBB",map.toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //3 : Lay du lieu dang object
//        myRef.child("sinhvien").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                Sinhvien sinhvien = (Sinhvien) dataSnapshot.getValue(Sinhvien.class);
//                Log.d("BBB",sinhvien.toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        myRef.child("danhsach").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Sinhvien sinhvien = dataSnapshot.getValue(Sinhvien.class);
                Log.d("BBB",dataSnapshot.getKey());
                Log.d("BBB",sinhvien.getName());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Sinhvien sinhvien = dataSnapshot.getValue(Sinhvien.class);
                Log.d("BBB",dataSnapshot.getKey());
                Log.d("BBB",sinhvien.getName());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
