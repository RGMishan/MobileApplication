package com.example.practicefrag;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private Fragment2Listener listener;
    private EditText editText;
    private Button button_start;

    public interface  Fragment2Listener {
        void onInputBSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container, false);

        editText = v.findViewById(R.id.edit_text);
        button_start = v.findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CharSequence input = editText.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }

    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listener){
            listener = (Fragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString()
            + " must implement Fragment2Listener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }
}
