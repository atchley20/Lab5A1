package edu.jsu.mcis.cs408.lab5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    private String addText;
    private TextView delID;
    private int inc = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);

    }

    public void getAllMemos(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);
    }
    public void addMemo(View v) {
        addText = findViewById(R.id.memoText).toString();
        Memo m = new Memo(addText);
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.addMemo(m);
        getAllMemos(v);
    }
    public void delMemo(View v) {
        int id = Integer.parseInt(delID.getText().toString());
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        db.delMemo(id);
    }
}