package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.utils;

import android.text.TextUtils;
import android.util.Patterns;

class ValidationUtils {

    private ValidationUtils() {
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private static boolean isValidPhone(String phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) && Patterns.PHONE.matcher(phoneNumber).matches();
    }

    private static boolean isValidUrl(String url) {
        return !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches();
    }

    private static boolean isValidText(String name){
        return !TextUtils.isEmpty(name);
    }

    public static boolean isValidForm(String email,String phoneNumber, String url, String name,String address){
        return !(isValidEmail(email)&& isValidText(name)&&isValidPhone(phoneNumber)&&isValidUrl(url)&& isValidText(address));
    }

}
