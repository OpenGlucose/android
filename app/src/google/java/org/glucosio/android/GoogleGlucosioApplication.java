package org.glucosio.android;

import android.support.annotation.NonNull;

import org.glucosio.android.analytics.Analytics;
import org.glucosio.android.analytics.GoogleAnalytics;
import org.glucosio.android.backup.Backup;
import org.glucosio.android.backup.GoogleDriveBackup;
import org.glucosio.android.invitation.GoogleInvitation;
import org.glucosio.android.invitations.Invitation;

public class GoogleGlucosioApplication extends GlucosioApplication {
    private Analytics analytics;

    @Override
    @NonNull
    public Backup getBackup() {
        return new GoogleDriveBackup();
    }

    @Override
    @NonNull
    public Analytics getAnalytics() {
        if (analytics == null) {
            analytics = new GoogleAnalytics();
            analytics.init(this);
        }

        return analytics;
    }

    @Override
    @NonNull
    public Invitation getInvitation() {
        return new GoogleInvitation();
    }
}
