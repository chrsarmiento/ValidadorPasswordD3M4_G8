package com.desafiolatam.desafio3passwordm4;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.desafiolatam.desafio3passwordm4.databinding.FragmentFirstBinding;
import com.google.android.material.textfield.TextInputEditText;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private TextInputEditText password;

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container,false);
        //return inflater.inflate(R.layout.fragment_first, container, false);
        View view = binding.getRoot();

        password = binding.passwordEditText;
        button = binding.validateButton;

        button.setEnabled(false);

        registrarListener();

        return view;
    }

    private void registrarListener(){
        binding.validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_firstFragment_to_secondFragment);
            }
        });

        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String password = charSequence.toString();
                if (password.length() >=  5 && !password.toLowerCase().equals(password))
                {
                    binding.validateButton.setEnabled(true);
                }
                else{
                    binding.validateButton.setEnabled(false);
                }
             }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}