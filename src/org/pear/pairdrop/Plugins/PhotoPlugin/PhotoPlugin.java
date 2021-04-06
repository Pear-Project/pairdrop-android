/*
 * SPDX-FileCopyrightText: 2019 Nicolas Fella <nicolas.fella@gmx.de>
 *
 * SPDX-License-Identifier: GPL-2.0-only OR GPL-3.0-only OR LicenseRef-KDE-Accepted-GPL
 */

package org.pear.pairdrop.Plugins.PhotoPlugin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import org.pear.pairdrop.Helpers.FilesHelper;
import org.pear.pairdrop.NetworkPacket;
import org.pear.pairdrop.Plugins.Plugin;
import org.pear.pairdrop.Plugins.PluginFactory;
import org.pear.pairdrop_tp.R;

import androidx.core.content.ContextCompat;

@PluginFactory.LoadablePlugin
public class PhotoPlugin extends Plugin {

    private final static String PACKET_TYPE_PHOTO = "kdeconnect.photo";
    private final static String PACKET_TYPE_PHOTO_REQUEST = "kdeconnect.photo.request";

    @Override
    public String getDisplayName() {
        return context.getResources().getString(R.string.take_picture);
    }

    @Override
    public String getDescription() {
        return context.getResources().getString(R.string.plugin_photo_desc);
    }

    @Override
    public boolean onPacketReceived(NetworkPacket np) {
        Intent intent = new Intent(context, PhotoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("deviceId", device.getDeviceId());
        context.startActivity(intent);
        return true;
    }

    void sendPhoto(Uri uri) {
        NetworkPacket np = FilesHelper.uriToNetworkPacket(context, uri, PACKET_TYPE_PHOTO);
        if (np != null) {
            device.sendPacket(np);
        }
    }

    @Override
    public boolean hasMainActivity() {
        return false;
    }

    @Override
    public boolean displayInContextMenu() {
        return false;
    }

    @Override
    public String[] getSupportedPacketTypes() {
        return new String[]{PACKET_TYPE_PHOTO_REQUEST};
    }

    @Override
    public String[] getOutgoingPacketTypes() {
        return new String[]{PACKET_TYPE_PHOTO};
    }

    @Override
    public Drawable getIcon() {
        return ContextCompat.getDrawable(context, R.drawable.ic_camera);
    }

    void sendCancel() {
        NetworkPacket np = new NetworkPacket(PACKET_TYPE_PHOTO);
        np.set("cancel", true);
        device.sendPacket(np);
    }
}
