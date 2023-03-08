package youngkyu.chung.Lab5;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;


import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private AutoCompleteTextView autoCompleteTextView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] email = getResources().getStringArray(R.array.email);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(),android.R.layout.select_dialog_item, email);
        AutoCompleteTextView textView=(AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        textView.setThreshold(1);
        textView.setAdapter(adapter);

        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        Button button = view.findViewById(R.id.bt_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = autoCompleteTextView.getText().toString().trim();
                String nodata = "NO DATA";
                SettingsFragment settingsFragment = new SettingsFragment();

                Bundle bundle = new Bundle();
                if(email.isEmpty()){
                    autoCompleteTextView.setError("Email is required.");



                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    autoCompleteTextView.setError("Invalid email format.");


                }else{
                    bundle.putString("email",email);
                    settingsFragment.setArguments(bundle);
                    ViewPager2 vp2 = (ViewPager2) getActivity().findViewById(R.id.viewPager2);
                    ViewPager2Adapter vpa = (ViewPager2Adapter) vp2.getAdapter();
                    vpa.replaceFragment(1, settingsFragment);
                    vp2.setCurrentItem(1);



                }
                autoCompleteTextView.setText("");
            }
        });

        return view;
    }
}