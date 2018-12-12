package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.utils;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

@SuppressWarnings("unused")
class FragmentUtils {

    private FragmentUtils() {
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @IdRes int parentResId, @NonNull Fragment fragment, @NonNull String tag) {
        fragmentManager.beginTransaction().replace(parentResId, fragment, tag).commit();
    }

}
