package com.example.chatapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    //✨✨✨
    //처음부터 arrayList 를 초기화해줘야지, 버튼 클릭할때마다 초기화하면 채팅 누적이 안됨
    private final ArrayList<DataItem> dataList = new ArrayList<>();
    ImageView sendBtn;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.sendBtn);
        editText = findViewById(R.id.editText);

        sendBtn.setOnClickListener(view -> {
            String text = editText.getText().toString().trim();
            if (text.matches(" ")) {
                sendBtn.setEnabled(false);
            } else {
                dataList.add(new DataItem(text, "사용자2", Code.ViewType.RIGHT_CONTENT));
                editText.setText("");

                if (text.contains("안녕")) {
                    dataList.add(new DataItem("안녕하세요😀 당신의 친구, 예안입니다.", "AI", Code.ViewType.LEFT_CONTENT));
                } else if (text.contains("어디")) {
                    dataList.add(new DataItem("당신의 핸드폰 안에서 살고 있어요!", "AI", Code.ViewType.LEFT_CONTENT));
                } else if (text.contains("이름")) {
                    dataList.add(new DataItem("제 이름은 예안이에요!", "AI", Code.ViewType.LEFT_CONTENT));
                } else if (text.contains("몇살")) {
                    dataList.add(new DataItem("24살입니다.", "AI", Code.ViewType.LEFT_CONTENT));
                } else if (text.contains("시발") || text.contains("개새끼") || text.contains("좇") || text.contains("죽어")) {
                    dataList.add(new DataItem("나쁜 말은 하지 말아주세요😤", "AI", Code.ViewType.LEFT_CONTENT));
                } else {
                    dataList.add(new DataItem("무슨 말을 하는지 모르겠어요.", "AI", Code.ViewType.LEFT_CONTENT));
                }

                RecyclerView recyclerv = findViewById(R.id.recyvlerv);
                LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
                recyclerv.setLayoutManager(manager);
                recyclerv.setAdapter(new Adapter(dataList));
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                manager.setStackFromEnd(true);
                manager.setSmoothScrollbarEnabled(false);
                manager.scrollToPosition(dataList.size() - 1);
            }


        });


    }

}

