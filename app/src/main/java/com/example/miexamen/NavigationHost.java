package com.example.miexamen;

import androidx.fragment.app.Fragment;

public interface NavigationHost {
    void navigateTo(Fragment fragment,boolean addToBackstack);
}
