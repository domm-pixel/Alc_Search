package com.sample.alc.Mnt;

import android.app.Activity;

import java.util.ArrayList;

public class Util {
    private static String TAG = Util.class.getSimpleName();

    private static ArrayList<Activity> m_activityManagedList = new ArrayList<Activity>();
    public static void removeActivityAll() {

        for (Activity activity : m_activityManagedList) {
            activity.finish();
        }
        m_activityManagedList.clear();
    }

    public static void addActivity(Activity currentActivity) {
        ArrayList<Activity> removedActivityList = new ArrayList<Activity>();

        /**
         * 동일한 activity가 존재하는지 검색
         */
        for (Activity savedActivity : m_activityManagedList) {

            String[] savedActivityName = savedActivity.toString().split("@");
            String[] currentActivityName = currentActivity.toString().split("@");
            /**
             * 제거할 activity 찾기
             */
            if (savedActivityName[0].equals(currentActivityName[0])) {
                removedActivityList.add(savedActivity);
            }
        }

        for (Activity removedActivity : removedActivityList) {
            removedActivity.finish();
        }

        /**
         * activity 추가
         */
        m_activityManagedList.add(currentActivity);
    }

}
