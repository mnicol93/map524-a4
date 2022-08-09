package com.example.movies_marc_mnicolas_oliva.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_marc_mnicolas_oliva.R;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentNowPlayingBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNowPlaying#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNowPlaying extends Fragment {

    private FragmentNowPlayingBinding binding;

    public FragmentNowPlaying() {
        // Required empty public constructor
        super(R.layout.fragment_now_playing);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNowPlayingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment FragmentNowPlaying.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static FragmentNowPlaying newInstance(String param1, String param2) {
//        FragmentNowPlaying fragment = new FragmentNowPlaying();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

}