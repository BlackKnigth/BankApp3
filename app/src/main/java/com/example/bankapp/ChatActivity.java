package com.example.bankapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private static int MAX_MSG_LENGTH = 150;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("messages");
    ArrayList<ChatMessage> messages = new ArrayList<>();
    ImageButton send_btn;
    EditText editText;
    RecyclerView msgRecycler;
    int userID=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);
        editText = findViewById(R.id.msgField);
        send_btn = findViewById(R.id.send_btn);
        msgRecycler = findViewById(R.id.messages_recycler);
        final DataAdapter dataAdapter = new DataAdapter(this, messages);
        msgRecycler.setAdapter(dataAdapter);
        msgRecycler.setLayoutManager(new LinearLayoutManager(this));

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                //Field is empty
                if (text.equals("")) {
                    Toast.makeText(getApplicationContext(), "Введите сообщение.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Split message
                if (text.length() <= MAX_MSG_LENGTH)
                    ref.push().setValue(new ChatMessage(userID, text));
                else {
                    for (String textPart : text.split("(?<=\\G.{4})")) {
                        ref.push().setValue(new ChatMessage(userID, textPart));
                    }
                }
                editText.setText("");
            }
        });

        ref.addChildEventListener(new ChildEventListener() {
            //Get message from db
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                messages.add(dataSnapshot.getValue(ChatMessage.class));
                dataAdapter.notifyDataSetChanged();
                msgRecycler.smoothScrollToPosition(messages.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

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
